-- 8�� ���̺��� ������ �߰�, ����,�����ϴ� DML
-- ���̺� ������ �߰��ϴ� insert��
-- �μ� ������ �����ϱ� ���� ���̺� ����
create table dept02(
    deptno number(2),
    dname varchar2(14),
    loc varchar2(13)
);

-- �渮�� �Է�
insert into dept02
values(10, '�渮��', '����');


-- �λ�� �Է�
insert into dept02 (deptno, loc, dname)
values(20, '��õ', '�λ��');


-- ������ �Է� - ��������� null �Է�
insert into dept02 
values(30, '������', null);

-- ����� �Է� - ��������� null �Է�
insert into dept02 
values(40, '�����', '');

-- ��ȹ�� �Է� - �Ͻ������� null �Է�
insert into dept02(deptno, dname)
values(50, '��ȹ��');

select * from dept02;

-- ������̺� �����ϱ�
create table emp02(
    empno number(4),
    ename varchar2(10),
    job varchar2(9),
    hirdate date,
    deptno number(2)
);

-- ��¥ ������ �Է��ϱ�
insert into emp02
values(1001, '����', '���', '2015/03/01', 20);

insert into emp02
values(1002, '�ѿ���', '�븮', to_date('2014, 05, 01' , 'YYYY, MM, DD'), 20);

insert into emp02
values(1003, '����ȣ', '����', sysdate, 30);

-- ���̺��� ������ �����ϴ� update��
update dept02 
set dname='�����'
where deptno=10;

select * from emp02;
select * from dept02;

update dept02
set dname='�����2', loc='�λ�',
where deptno=20;

select * from emp02;
select * from dept02;

-- ���̺��� ������ �����ϴ� delete��
--delete dept02
--where deptno=10;
delete emp02;

select * from emp02;
select * from dept02;

-Ʈ����� ����
commit;
rollback;

-- 1 employee03 ���̺� ���� Ȯ��
create table  employee03(
        empno number(4),
        ename varchar2(20),
        job varchar2(20),
        sal number(7,3)
);
-- 1-2
insert into employee03 (empno,ename,job,sal)
values(1000, '�ѿ��', '�·�', 100);
insert into employee03 (empno,ename,job,sal)
values(1001, '����', '�ǰ�', 150);
insert into employee03 (empno,ename,job,sal)
values(1002, '�ֽð�', '��������', 250);
insert into employee03 (empno,ename,job,sal)
values(1003, '���', null, 250);
insert into employee03 (empno,ename,job,sal)
values(1004, '��������', '', 200);

-- 1-3
update employee03
set sal = sal + 50
where sal < 200;

-- 2-1
delete employee03
where job is null;

desc employee03;
