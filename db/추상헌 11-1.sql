-- 9장 데이터 무결성을 위한 제약조건
CREATE TABLE dept04 (
    deptno NUMBER(2) PRIMARY KEY,
    dname VARCHAR2(13) NOT NULL,
    loc VARCHAR2(14)
);

-- `desc dept04;` 부분은 제거합니다. 

INSERT INTO dept04
VALUES(10, '기획부', '서울');

INSERT INTO dept04
VALUES(20, '생산부', '인천');

CREATE TABLE emp04 (
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(20) NOT NULL,
    job VARCHAR2(20),
    hiredate DATE,
    deptno NUMBER(2) REFERENCES dept04(deptno)
);

INSERT INTO emp04
VALUES(1000, '김사랑', '사원', SYSDATE, 10);

INSERT INTO emp04
VALUES(1001, '한예슬', '사원', SYSDATE, 20);

SELECT * FROM emp04;

CREATE TABLE dept05 (
    deptno NUMBER(2) CONSTRAINT dept05_deptno_pk PRIMARY KEY,
    dname VARCHAR2(13) CONSTRAINT dept05_dname_nn NOT NULL,
    loc VARCHAR2(14)
);

INSERT INTO dept05
VALUES(10, '기획부', '서울');

-- 마지막 줄에서 `dept04`를 `dept05`로 수정합니다.
INSERT INTO dept05
VALUES(20, '생산부', '인천');

CREATE TABLE emp05 (
    empno NUMBER(4) constraint emp05_empno_pk PRIMARY KEY,
    ename VARCHAR2(20) constraint emp05_ename_nn NOT NULL,
    job VARCHAR2(20),
    hiredate DATE,
    deptno NUMBER(2) constraint emp05_deptno_fk REFERENCES dept04(deptno)
    );
