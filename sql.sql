-- emp 사원의 정보
-- dept 부서정보
-- salgrade 급여등급정보

select * from EMP order by empno asc
select * from DEPT order by deptno asc

-- 사원이름이 smith인 사람의 부서명은 뭘까요
select deptno from EMP where ename ='SMITH';
select dname from DEPT where deptno=20;
-- 서브쿼리문 쓰는 법
select dname from DEPT where deptno=(select deptno from emp where ename ='SMITH')

-- smith 사원의 상사의 이름은 뭘까요
select mgr from EMP where ename='SMITH'
select ename from EMP where empno=(select mgr from EMP where ename='SMITH')

-- 평균 급여보다 높은 급여를 받는 사람들의 이름과 월급
select avg(sal) from emp;

select ename, sal from emp
where sal > (select avg(sal) from emp)
order by sal asc

-- smith사원과 같은 job이면서 급여를 더 많이 받는 사람의 이름, 직종, 월급
select job from emp where ename='SMITH';
select sal from emp where ename='SMITH';

select ename, job, sal from emp
where job=(select job from emp where ename='SMITH') AND sal>(select sal from emp where ename='SMITH')

-- miller사원의 급여등급은 얼마
select * from SALGRADE;
select sal from emp where ename='MILLER';

select grade from SALGRADE
where 1300>=losal and 1300<=hisal

select grade from salgrade
where 1300 between losal and hisal

select grade from SALGRADE
where (select sal from emp where ename='MILLER')>=losal and (select sal from emp where ename='MILLER')<=hisal

select grade from salgrade
where (select sal from emp where ename='MILLER') between losal and hisal

-- king 사원과 같은 부서의 사원들 중에서 가장 급여를 적게 받는 사원의 급여등급은 얼마
select * from EMP

select deptno from emp where ename ='KING'

select sal from EMP where deptno=(select deptno from emp where ename ='KING')

-- from에 서브쿼리문 쓰기
select min(sal) from ((select sal from EMP where deptno=(select deptno from emp where ename ='KING')))

-- 1)
select grade from salgrade 
where (select min(sal) from ((select sal from EMP where deptno=(select deptno from emp where ename ='KING')))) 
between losal and hisal

-- 2)
select grade from salgrade 
where (select min(sal) from EMP where deptno=(select deptno from emp where ename ='KING')) 
between losal and hisal

-- 뉴욕에 근무하는 부서원들의 평균급여등급과 동일한 등급의 사원들의 정보
select * from DEPT
select * from SALGRADE

select * from EMP
where deptno=??

select avg(sal) from emp
where deptno=(select deptno from dept
where loc='NEW YORK')

select grade from salgrade
where (select avg(sal) from emp where deptno=
	(select deptno from dept where loc='NEW YORK')) 
between losal and hisal

-- 1)
select * from emp
where sal>=(select losal from salgrade 
	where (select avg(sal) from emp where deptno=(select deptno from dept where loc='NEW YORK')) 
	between losal and hisal) 
and sal<= (select hisal from salgrade
	where (select avg(sal) from emp where deptno=(select deptno from dept where loc='NEW YORK')) 
	between losal and hisal)

-- 2)
select * from emp
where sal between 
	(select losal from salgrade 
	where (select avg(sal) from emp where deptno=(select deptno from dept where loc='NEW YORK'))
	between losal and hisal)
and
	(select hisal from salgrade 
	where (select avg(sal) from emp where deptno=(select deptno from dept where loc='NEW YORK'))
	between losal and hisal)

-- 전체사원의 평균급여보다 많이 받는 사원들의 부서명과 지역명을 출력
select avg(sal) from emp

select deptno from emp where sal>(select avg(sal) from emp)
-- 여러개의 값이 나온다. 다중행 서브쿼리로 들어가야한다.

select dname, loc from dept where deptno in (10,20,30)

select dname, loc from dept where deptno in ((select deptno from emp
	where sal>(select avg(sal) from emp)))
	
-- 20번 부서 사원들의 급여보다 많이 받는 사람들
-- 1) min
select ename, sal from emp
	where sal>(select min(sal) from emp where deptno=20)
-- 2) any
-- 서브쿼리문 안의 값 중 어떤 것 중 sal가 큰 것을 고르겠다.
select ename, sal from emp
	where sal > any (select sal from emp where deptno=20)

-- ()의 값을 하나의 테이블로 보고 T로 보자
(select sum(sal) s, avg(sal) a from emp E) T 

select * from (select sum(sal) s, avg(sal) a from emp E) T 
	
select deptno, sum(sal) s, avg(sal) a from emp
group by deptno
having avg(sal) > 2000

select * from (select deptno, sum(sal) s, avg(sal) a from emp group by deptno) T
where a>2000

----------------------
-- 사원의 정보를 조회하고 싶을때 이름, 사번, 직종, 부서명, 지역명을 한꺼번에 출력하고 싶을때
select * from emp
select * from dept

select deptno from emp where ename='SMITH'
select dname, loc from dept where deptno=20

(select dname, loc from dept
where deptno=(select deptno from emp where ename='SMITH')) 

--join : 테이블을 합하기
select * from emp, dept

select count(empno) from emp
select count(deptno) from dept

-- oracle에서만 사용하는 전용 join문구
select * from emp, dept
where emp.deptno = dept.deptno

-- 표준 : ANSI join (오라클과 mysql에서 사용가능)
SELECT EMPNO,JOB,DNAME,LOC
FROM EMP E inner join DEPT D
ON E.DEPTNO = D.DEPTNO

SELECT E.DEPTNO
FROM EMP E inner join DEPT D
ON E.DEPTNO = D.DEPTNO
-- DEPTNO는 EMP테이블과 DEPT테이블에 모두 존재하므로 어디테이블의 컬럼인지 써줘야한다.

SELECT *
FROM EMP inner join DEPT
USING (DEPTNO)

-- 사원번호, 사원이름, 상사의 사원번호, 상사의 이름
select e1.empno, e1.ename, e1.mgr, e2.empno, e2.ename 
from emp e1 inner join emp e2
on e1.mgr = e2.empno
-- inner join은 null값을 제외한다. -> outer은 null을 포함하여 가져온다.

-- LEFT 테이블에 NULL이 있다 : LEFT OUTER JOIN
select e1.empno, e1.ename, e1.mgr, e2.empno, e2.ename 
from emp e1 FULL OUTER join emp e2
on e1.mgr = e2.empno

