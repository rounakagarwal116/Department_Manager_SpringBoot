package com.learn.demo.service;

import java.util.List;

import com.learn.demo.entity.Department;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long dpId);

    public void deleteDepartmentById(Long dpId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String name);

}
