select name as "Employee"
from Employee A
where A.managerId is not null
and A.salary > (select salary from Employee B where B.id = A.managerId);