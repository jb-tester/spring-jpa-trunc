package com.example.springjpaoracle;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface OrderRepository extends CrudRepository<Order, Integer> {

    // works ok in Hibernate 6 only
   @Query("select date_trunc(year, o.creationDate) from Order o " +
            "where date_trunc(minute, o.creationDate) = date_trunc(minute, current_timestamp)")
    List<String> hibernate6useDate_trunc1();

    // works ok in Hibernate 6 only
    @Query("select date_trunc(day, o.creationDate) from Order o")
    List<String> hibernate6useDate_trunc2();

    // works ok in Hibernate 5 only, see https://hibernate.atlassian.net/browse/HHH-15855
    @Query("select trunc(o.creationDate) from Order o where trunc(o.creationDate) = trunc(current_date)")
    List<String> hibernate5SingleArgTrunc();

    // works ok in Hibernate 5 only, see https://hibernate.atlassian.net/browse/HHH-15855
    // no errors are reported by IDEA if extra parenthesis are added around trunc(arg)
    @Query("select trunc(o.creationDate) from Order o where (trunc(current_date) - trunc(o.creationDate)) <= :arg")
    List<String> hibernate5SingleArgTrunc2(@Param("arg") Date arg);

    // works both in Hibernate 5,6
    @Query("select trunc(o.sum,1) from Order o where trunc(o.sum,1) > 3")
    List<String> hibernate56Numeric2ArgTrunc();

    // doesn't work in Hibernate 5,6 (valid for old hibernate versions)
    @Query("select trunc(o.id) from Order o where trunc(o.creationDate, 'year') = trunc(current_date, 'year')")
    List<String> hibernateOld();

}
