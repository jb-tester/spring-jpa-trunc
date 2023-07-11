# the JPA QL trunc() function is different in different Hibernate versions.
IDEA supports the very old version (as required in the IDEA-193366, that is fixed long time ago)

https://youtrack.jetbrains.com/issue/IDEA-193366 - fixed

Hibernate 5 -specific single-argument trunc() causes errors:
https://youtrack.jetbrains.com/issue/IDEA-321770 - fixed

Hibernate 6-specific date_trunc() function that is used actually since only trunc(numeric, numeric) is supported for now:
https://youtrack.jetbrains.com/issue/IDEA-321601 - fixed
