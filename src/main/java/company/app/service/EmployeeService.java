package company.app.service;

import company.app.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id);
    Employee updateEmployee(String id, Employee employee);
    void deleteEmployee(String id);
}