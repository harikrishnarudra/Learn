package com.practice.leetcode.sql;

public class EmpDept {
    /**
     * emp  - deptid, name, sal
     * dept - deptid, deptname
     *
     *  emp
     *  1, surya,1L
     *  1, jagan, 2L
     *  1, jyothi, 3L
     *  2, xyz, 50k
     *  2, abc, 2L
     *
     *  dept
     *  1, b2b
     *  2, c2c
     *
     *  Output:
     *  b2b, 3L
     *  c2c, 2L
     *
     *  select deptname, max(sal) from emp left join dept on emp.deptId=dept.deptId group by deptname, sal
     */
}
