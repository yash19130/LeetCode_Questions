select d.name as Department, e.name as Employee, e.salary as Salary
from Employee e, Department d
where e.departmentId = d.id
and (Salary = (select max(salary) from Employee where departmentId = d.id)
or Salary = 
(select distinct(salary) from Employee where departmentId = d.id 
 order by salary desc limit 1, 1)
or Salary = 
(select distinct(salary) from Employee where departmentId = d.id 
 order by salary desc limit 2, 1));