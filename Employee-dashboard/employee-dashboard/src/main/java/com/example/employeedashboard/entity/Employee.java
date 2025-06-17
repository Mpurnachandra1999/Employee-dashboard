package com.example.employeedashboard.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id // ✅ Correct import
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPID")
    private Long empid;

    @Column(name = "ENAME")
    private String ename;

    @Column(name ="SAL")
    private Double sal;

    @Column(name = "DEPTNAME")
    private String deptname;

    @Column(name = "HIREDATE")
    private Date hiredate;

    @Column(name = "COMMISSION")
    private Double commission;

    @Column(name = "DEPTNO")
    private Integer deptno;

    @Column(name = "MANAGER")
    private String manager;

    // ✅ Corrected setter method
    public Long getEmpid() {
        return empid;
    }

    public void setEmpid(Long empid) {
        this.empid = empid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
