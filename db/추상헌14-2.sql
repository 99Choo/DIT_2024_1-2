--11�� ����
--7. emp ���̺�� ������ emp06 ���̺� �����
create table emp06
as
select * from emp;

select * from emp06;
--8. ������� �ּ� �޿����� ���� �޿��� �޴� ������ �̸��� �޿��� ���� �˻��ϱ�
select ename,sal,job
from emp
where sal > any (select sal
                 from emp
                 where job = '����');
                 

select ename,sal,job
from emp
where sal > any (select min(sal)
                 from emp
                 where job = '����');
-- 9. ��õ�� ��ġ�� �μ��� �Ҽӵ� �������� �޿��� 100�λ��ϴ� ������ �ۼ��ϱ�
UPDATE emp06
SET sal = sal + 100
WHERE deptno = (
    SELECT deptno
    FROM dept
    WHERE loc = '��õ');
    
select * from emp06;
--10. emp06 ���̺��� �渮�ο� �Ҽӵ� ����鸸 �����ϴ� SQL ���� �ϼ��Ͻÿ�.
delete from emp06
where deptno = ( select deptno
                 from dept
                 where dname = '�渮��');

select * from emp06;
--���ĺ��� emp ���̺� �̿��ϱ�
--11. �̹����� ���� �μ����� �ٹ��ϴ� ����� �̸��� �μ� ��ȣ�� ����Ͻÿ�
select ename,deptno
from emp
where deptno = ( select deptno
                 from emp
                 where ename = '�̹���')
and ename <> '�̹���';

--12. �̹����� ������ ������ ���� ����� ����Ͻÿ�
select ename,job
from emp
where job    = ( select job
                 from emp
                 where ename = '�̹���')
and ename <> '�̹���';

--13. �̹����� �޿��� �����ϰų� �� ���� �޴� ������ �޿��� ���.
select ename, sal
from emp
where sal   >= ( select sal
                 from emp
                 where ename = '�̹���')
and ename <> '�̹���';

--14 ��õ���� �ٹ��ϴ� ����� �̸�, �μ� ��ȣ�� ���
select ename,deptno
from emp
where deptno =( select deptno
                from dept
                where loc = '��õ');
--15. ���ӻ���� ���켺�� ����� �̸��� �޿��� ���
select ename,sal,mgr
from emp
where mgr = (   select empno
                from emp
                where ename = '���켺');

--16. �μ����� ���� �޿��� ���� �޴� ����� ����(��� ��ȣ, �̸�, �޿�, �μ���ȣ)�� ���
select empno, ename, sal, deptno 
from emp
where sal in (   select max(sal)
                from emp
                group by deptno)
order by deptno;

select empno, ename, sal, deptno 
from emp e
where sal = (   select max(sal)
                from emp 
                where deptno = e.deptno)
order by deptno;
--17. ������ ������ ����� ���� �μ��� �μ� ��ȣ�� �μ���� ������ ���
select deptno, dname, loc
from dept
where deptno in (   select deptno
                    from emp
                    where job = '����');

--18. ���庸�� �޿��� ���� �޴� ������� �̸��� �޿��� ������ ����ϵ�, ������ ������� ���� ��.
select ename, sal, job
from emp
where sal > ( select max(sal)
              from emp
              where job ='����');
