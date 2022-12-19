select *
from student;

select *
from student
where age > 20
  and age < 23;

select *
from student
where age < student.id;

select *
from student
ORDER BY age;