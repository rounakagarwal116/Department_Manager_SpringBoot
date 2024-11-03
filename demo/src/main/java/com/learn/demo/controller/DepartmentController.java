package com.learn.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.demo.entity.Department;
import com.learn.demo.error.DepartmentNotFoundException;
import com.learn.demo.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartMent(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        logger.info("inside fetch API");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long dpId)throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(dpId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long dpId) {
        departmentService.deleteDepartmentById(dpId);
        return "Deletion Success ";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartMent(@RequestBody Department department, @PathVariable("id") Long departmentId) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String name) {
        return departmentService.fetchDepartmentByName(name);
    }
}
