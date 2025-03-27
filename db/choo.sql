select e.ename, e.hiredate, d.dname
from emp e join dept d
on e.deptno = d.deptno
where d.dname = '경리부';

select e.ename, e.sal, d.loc
from emp e join dept d
on e.deptno = d.deptno
where d.loc = '인천';

select *
from emp;

select *
from emp, dept;

select *
from emp, dept
where emp.deptno = dept.deptno;