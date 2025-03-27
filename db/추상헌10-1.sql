-- 7�� ���̺� ������ ����, ����, �����ϴ� DDL
-- ���̺� ������ ����� create table��
-- ��� ������ �����ϱ� ���� ���̺� ����
create table emp01(
    empno number(4),
    ename varchar2(14),
    sal number(7,3)
);

desc emp01;

-- ���̺� ������ �����ϴ� alter table ��
-- colum �߰�
alter table emp01
add (birth date, tel varchar2(10));

desc emp01;

-- �÷� ����
alter table emp01
modify ename varchar2(30);

-- �÷� ����
alter table emp01
drop column ename;

-- set unusedr
alter table emp01
set unused (sal);

--desc emp01;
--select * from emp01;

alter table emp01
drop unused columns;

-- ���̺���� �����ϴ� rename��
rename emp01 to emp02;

-- ���̺� ������ �����ϴ� drop table��

-- ��� �����͸� �����ϴ� truncate cable��
drop table emp02;

-- 7�� �̼�
-- 1. dept_mission ���̺��� �����Ͻÿ�.
create table dept_mission( 
    dno number(2),
    dname varchar2 (14),
    loc varchar2 (13)
);
desc dept_mission;

-- 2. emp_mission ���̺��� �����Ͻÿ�.
create table emp_mission(
    eno number (4),
    ename varchar2 (10),
    dno number(2)
);
desc emp_mission;

alter table emp_mission
modify (ename varchar2 (25));

desc emp_mission;

-- 4. emp_mission ���̺� ����
drop table emp_mission;
desc emp_mission;

-- 5. dept_mission ���̺��� dname �÷��� ����.
alter table dept_mission
drop column dname;
desc dept_mission;

-- 6 dept_mission ���̺��� LOC �÷��� UNUSED�� ǥ��.
alter table dept_mission
set unused (loc);
desc dept_mission;

-- 7. dept_mission ���̺��� UNUSED �÷��� �����Ͻÿ�.
alter table dept_mission
drop unused columns;
desc dept_mission;

-- 8. dept_mission department�� �̸����� �����Ͻÿ�
rename dept_mission to department;
desc dept_mission;
desc department;


--desc dept_mission;
--select * from dept_mission;