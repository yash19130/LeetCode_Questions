select distinct(A.email) as "Email"
from Person A, Person B
where A.email = b.email
and A.id != B.id;