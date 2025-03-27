-- 10�� ����
-- �̹����� �μ��� ���ϱ�
select *
from emp
where ename='�̹���';

select *
from dept;

-- Cross Join - 1:1����
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
and e.ename='�̹���';

--Non-Equl Join 
select * from emp;

--�������� �޿� ��� ���ϱ�
select e.ename, e.sal, s.grade �޿����
from emp e,salgrade s
where e.sal between losal and hisal
--order by 3 desc; -- ��������
order by 3;

select e.ename, e.sal, s.grade �޿����
from emp e,salgrade s
where e.sal >= s.losal and e.sal <= s.hisal
--order by 3 desc; -- ��������
order by 3;

-- ���� �̸�, �޿�, �޿����, �μ��� �˻��ϱ�
select e.ename, e.sal, s.grade, d.dname
from emp e, salgrade s, dept d
where e.sal between s.losal and s.hisal
and e.deptno = d.deptno
and e.ename = '�̹���';

--Self Join
select * from emp;

select e.ename ����, m.ename ���ӻ��
from emp e, emp m
where e.mgr = m.empno
order by e.empno;

--ANSI(�̱�ǥ�ؿ�����) Join
--ANSI Cross Join
select *
from emp cross join dept;

--ANSI Inner Join �⺻�� inner join
select ename, dname
from emp e join dept d
on e.deptno = d.deptno
where e.ename='�̹���';

select e.ename, e.sal, s.grade, d.dname
from emp e join salgrade s
on e.sal between s.losal and s.hisal
join dept d
on e.deptno = d.deptno
where e.ename = '�̹���';

--ANSI Outer Join , null������ ����
select *
from emp cross join dept;

select * from emp;


select e.ename ����, m.ename ���ӻ��
from emp e left outer join emp m
on e.mgr = m.empno
order by e.empno;

--�̼� 
--1. �渮�ο��� �ٹ��ϴ� ����� �̸��� �Ի����� ����� ���ô�.
select e.ename, e.hiredate, d.dname
from emp e join dept d
on e.deptno = d.deptno
where d.dname = '�渮��';
--2. ANSI JOIN�� ����Ͽ� ��õ���� �ٹ��ϴ� ����� �̸��� �޿��� ����� ���ô�.
select e.ename, e.sal, d.loc
from emp e join dept d
on e.deptno = d.deptno
where d.loc = '��õ';