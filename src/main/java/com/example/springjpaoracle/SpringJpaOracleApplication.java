package com.example.springjpaoracle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringJpaOracleApplication implements CommandLineRunner {

    private final OrderRepository orderRepository;

    public SpringJpaOracleApplication(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaOracleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        orderRepository.save(new Order(1L, 1.12F,"order1", new Date(),"created"));
        orderRepository.save(new Order(2L,2.99F,"order2", new Date(),"accepted"));
        orderRepository.save(new Order(3L,33.5F, "order3", new Date(),"created"));
        orderRepository.save(new Order(4L,445.77F, "order4", new Date(),"done"));
        orderRepository.save(new Order(5L,5F,"order5", new Date(),"declined"));

        // for all:
        for (String test0 : orderRepository.hibernate56Numeric2ArgTrunc()) {
            System.out.println("********* trunc with 2 numeric args *********************");
            System.out.println(test0);
            System.out.println("******************************");
        }
        // Only for Hibernate6:
        for (String test0 : orderRepository.hibernate6useDate_trunc1()) {
            System.out.println("********** date_trunc ********************");
            System.out.println(test0);
            System.out.println("******************************");
        }
        for (String test1 : orderRepository.hibernate6useDate_trunc2()) {
            System.out.println("*********** date_trunc *******************");
            System.out.println(test1);
            System.out.println("******************************");
        }


        // only for Hibernate 5:
        for (String test3 : orderRepository.hibernate5SingleArgTrunc()) {
            System.out.println("*********** trunc with single date arg *******************");
            System.out.println(test3);
            System.out.println("******************************");
        }
        for (String test5 : orderRepository.hibernate5SingleArgTrunc2(new Date())) {
            System.out.println("************ (trunc with single date arg) ******************");
            System.out.println(test5);
            System.out.println("******************************");
        }
         // doesn't work in both versions:
        // Attempt to use 2-argument trunc() function
       /* for (String test2 : orderRepository.hibernateOld()) {
            System.out.println("******************************");
            System.out.println(test2);
            System.out.println("******************************");
        }*/
    }
}
