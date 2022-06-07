package com.tz.mybatis.entity;

public class Admin implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private int deptId;

    private String name;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Admin [deptId=" + deptId + ", name=" + name + "]";
    }

}
