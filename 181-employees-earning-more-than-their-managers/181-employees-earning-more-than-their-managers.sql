# Write your MySQL query statement below
select A.name as Employee from 
Employee as A, Employee as B
where A.managerId = B.id and A.salary > B.salary;