-- 7장 테이블 구조를 생성, 변경, 제거하는 DDL
-- 테이블 구조를 만드는 create table문
-- 사원 정보를 저장하기 위한 테이블 생성
create table emp01(
    empno number(4),
    ename varchar2(14),
    sal number(7,3)
);

desc emp01;

-- 테이블 구조를 변경하는 alter table 문
-- colum 추가
alter table emp01
add (birth date, tel varchar2(10));

desc emp01;

-- 컬럼 변경
alter table emp01
modify ename varchar2(30);

-- 컬럼 제거
alter table emp01
drop column ename;

-- set unusedr
alter table emp01
set unused (sal);

--desc emp01;
--select * from emp01;

alter table emp01
drop unused columns;

-- 테이블명을 변경하는 rename문
rename emp01 to emp02;

-- 테이블 구조를 제거하는 drop table문

-- 모든 데이터를 제거하는 truncate cable문
drop table emp02;

-- 7장 미션
-- 1. dept_mission 테이블을 생성하시오.
create table dept_mission( 
    dno number(2),
    dname varchar2 (14),
    loc varchar2 (13)
);
desc dept_mission;

-- 2. emp_mission 테이블을 생성하시오.
create table emp_mission(
    eno number (4),
    ename varchar2 (10),
    dno number(2)
);
desc emp_mission;

alter table emp_mission
modify (ename varchar2 (25));

desc emp_mission;

-- 4. emp_mission 테이블 제거
drop table emp_mission;
desc emp_mission;

-- 5. dept_mission 테이블에서 dname 컬럼을 제거.
alter table dept_mission
drop column dname;
desc dept_mission;

-- 6 dept_mission 테이블에서 LOC 컬럼을 UNUSED로 표시.
alter table dept_mission
set unused (loc);
desc dept_mission;

-- 7. dept_mission 테이블에서 UNUSED 컬럼을 제거하시오.
alter table dept_mission
drop unused columns;
desc dept_mission;

-- 8. dept_mission department란 이름으로 변경하시오
rename dept_mission to department;
desc dept_mission;
desc department;


--desc dept_mission;
--select * from dept_mission;