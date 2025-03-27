-- 10장 조인
-- 이문세의 부서명 구하기
select *
from emp
where ename='이문세';

select *
from dept;

-- Cross Join - 1:1대응
select *
from emp, dept;

-- Equl Join
select *
from emp, dept
where emp.deptno = dept.deptno;


--select e.ename, d.dname d.deptno
select ename, dname
from emp e,dept d
where e.deptno = d.deptno
and e.ename='이문세';

--Non-Equl Join 
select * from emp;

--직원들의 급여 등급 구하기
select e.ename, e.sal, s.grade 급여등급
from emp e,salgrade s
where e.sal between losal and hisal
--order by 3 desc; -- 내림차순
order by 3;

select e.ename, e.sal, s.grade 급여등급
from emp e,salgrade s
where e.sal >= s.losal and e.sal <= s.hisal
--order by 3 desc; -- 내림차순
order by 3;

-- 직원 이름, 급여, 급여등급, 부서명 검색하기
select e.ename, e.sal, s.grade, d.dname
from emp e, salgrade s, dept d
where e.sal between s.losal and s.hisal
and e.deptno = d.deptno
and e.ename = '이문세';

--Self Join
select * from emp;

select e.ename 직원, m.ename 직속상관
from emp e, emp m
where e.mgr = m.empno
order by e.empno;

--ANSI(미국표준연구소) Join
--ANSI Cross Join
select *
from emp cross join dept;

--ANSI Inner Join 기본은 inner join
select ename, dname
from emp e join dept d
on e.deptno = d.deptno
where e.ename='이문세';

select e.ename, e.sal, s.grade, d.dname
from emp e join salgrade s
on e.sal between s.losal and s.hisal
join dept d
on e.deptno = d.deptno
where e.ename = '이문세';

--ANSI Outer Join , null값까지 포함
select *
from emp cross join dept;

select * from emp;


select e.ename 직원, m.ename 직속상관
from emp e left outer join emp m
on e.mgr = m.empno
order by e.empno;

--미션 
--1. 경리부에서 근무하는 사원의 이름과 입사일을 출력해 봅시다.
select e.ename, e.hiredate, d.dname
from emp e join dept d
on e.deptno = d.deptno
where d.dname = '경리부';
--2. ANSI JOIN을 사용하여 인천에서 근무하는 사원의 이름과 급여를 출력해 봅시다.
select e.ename, e.sal, d.loc
from emp e join dept d
on e.deptno = d.deptno
where d.loc = '인천';