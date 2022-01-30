select d.name as Department, e.name as Employee, e.salary as Salary
from Employee e, Department d
where e.departmentId = d.id
and e.salary in (select max(salary) from Employee where departmentId = d.id);