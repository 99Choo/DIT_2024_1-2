--11장 퀴즈
--7. emp 테이블과 동일한 emp06 테이블 만들기
create table emp06
as
select * from emp;

select * from emp06;
--8. 과장들의 최소 급여보다 많은 급여를 받는 직원의 이름과 급여와 직급 검색하기
select ename,sal,job
from emp
where sal > any (select sal
                 from emp
                 where job = '과장');
                 

select ename,sal,job
from emp
where sal > any (select min(sal)
                 from emp
                 where job = '과장');
-- 9. 인천에 위치한 부서에 소속된 직원들의 급여를 100인상하는 쿼리문 작성하기
UPDATE emp06
SET sal = sal + 100
WHERE deptno = (
    SELECT deptno
    FROM dept
    WHERE loc = '인천');
    
select * from emp06;
--10. emp06 테이블에서 경리부에 소속된 사원들만 삭제하는 SQL 문을 완성하시오.
delete from emp06
where deptno = ( select deptno
                 from dept
                 where dname = '경리부');

select * from emp06;
--이후부터 emp 테이블 이용하기
--11. 이문세와 같은 부서에서 근무하는 사원의 이름과 부서 번호를 출력하시오
select ename,deptno
from emp
where deptno = ( select deptno
                 from emp
                 where ename = '이문세')
and ename <> '이문세';

--12. 이문세와 동일한 직급을 가진 사원을 출력하시오
select ename,job
from emp
where job    = ( select job
                 from emp
                 where ename = '이문세')
and ename <> '이문세';

--13. 이문세의 급여와 동일하거나 더 많이 받는 사원명과 급여를 출력.
select ename, sal
from emp
where sal   >= ( select sal
                 from emp
                 where ename = '이문세')
and ename <> '이문세';

--14 인천에서 근무하는 사원의 이름, 부서 번호를 출력
select ename,deptno
from emp
where deptno =( select deptno
                from dept
                where loc = '인천');
--15. 직속상관이 감우성이 사원의 이름과 급여를 출력
select ename,sal,mgr
from emp
where mgr = (   select empno
                from emp
                where ename = '감우성');

--16. 부서별로 가장 급여를 많이 받는 사원의 정보(사원 번호, 이름, 급여, 부서번호)를 출력
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
--17. 직급이 과장인 사원이 속한 부서의 부서 번호와 부서명과 지역을 출력
select deptno, dname, loc
from dept
where deptno in (   select deptno
                    from emp
                    where job = '과장');

--18. 과장보다 급여를 많이 받는 사원들의 이름과 급여와 직급을 출력하되, 과장은 출력하지 않을 것.
select ename, sal, job
from emp
where sal > ( select max(sal)
              from emp
              where job ='과장');
