-- 9�� ������ ���Ἲ�� ���� ��������
CREATE TABLE dept04 (
    deptno NUMBER(2) PRIMARY KEY,
    dname VARCHAR2(13) NOT NULL,
    loc VARCHAR2(14)
);

-- `desc dept04;` �κ��� �����մϴ�. 

INSERT INTO dept04
VALUES(10, '��ȹ��', '����');

INSERT INTO dept04
VALUES(20, '�����', '��õ');

CREATE TABLE emp04 (
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(20) NOT NULL,
    job VARCHAR2(20),
    hiredate DATE,
    deptno NUMBER(2) REFERENCES dept04(deptno)
);

INSERT INTO emp04
VALUES(1000, '����', '���', SYSDATE, 10);

INSERT INTO emp04
VALUES(1001, '�ѿ���', '���', SYSDATE, 20);

SELECT * FROM emp04;

CREATE TABLE dept05 (
    deptno NUMBER(2) CONSTRAINT dept05_deptno_pk PRIMARY KEY,
    dname VARCHAR2(13) CONSTRAINT dept05_dname_nn NOT NULL,
    loc VARCHAR2(14)
);

INSERT INTO dept05
VALUES(10, '��ȹ��', '����');

-- ������ �ٿ��� `dept04`�� `dept05`�� �����մϴ�.
INSERT INTO dept05
VALUES(20, '�����', '��õ');

CREATE TABLE emp05 (
    empno NUMBER(4) constraint emp05_empno_pk PRIMARY KEY,
    ename VARCHAR2(20) constraint emp05_ename_nn NOT NULL,
    job VARCHAR2(20),
    hiredate DATE,
    deptno NUMBER(2) constraint emp05_deptno_fk REFERENCES dept04(deptno)
    );
