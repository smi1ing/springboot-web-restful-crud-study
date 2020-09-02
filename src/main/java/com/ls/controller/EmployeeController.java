package com.ls.controller;


import com.ls.dao.DepartmentDao;
import com.ls.dao.EmployeeDao;
import com.ls.entities.Department;
import com.ls.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询所有员工,返回列表页面
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放到请求域中
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    /**
     * 来到员工添加页面
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查询出所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //跳转到添加页面
        return "emp/add";
    }

    /**
     * 添加员工
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //新增员工信息
        employeeDao.save(employee);
        //重定向到员工列表页面
        return "redirect:/emps";
    }

    /**
     * 查出当前员工信息，跳转到员工编辑页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //页面要显示所有的用户列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //返回修改页面
        return "emp/edit";
    }


    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
