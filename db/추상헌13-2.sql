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


--11.사원테이블과 부서 테이블을 조인하여 사원이름과 부서번호와 부서명을 출력하도록 ANSI JOIN
select  e.ename, d.deptno ,d.dname
from emp e join dept d
on e.deptno = d.deptno;

--12.경리부 부서 소속 사원의 이름과 입사일을 출력.
select  e.ename,e.hiredate
from emp e join dept d
on e.dname = d.deptno
where d.dname = '경리부';

--13.직급이 과장인 사원의 이름, 부서명을 출력.
select e.ename,d.dname
from emp e join dept d
on e.deptno = d.deptno
where e.job = '과장';

--14.직속상관이 감우성인 사원들의 이름과 직급을 출력하시오.
select work.ename, work.job
from emp work join emp manager
on work.mgr = manager.empno
where manager.ename='감우성';

--15.감우성과 동일한 근무지에서 근무하는 직원의 이름 검색하기.
select work.ename 직원,friend.ename 동료
from emp work join emp friend
on work.deptno = friend.deptno
where work.ename = '감우성'
and friend.ename <> '감우성';