package company.app.controller;

import company.app.entity.Employee;
import company.app.service.EmployeeService;
import company.app.utils.response.PagingInfo;
import company.app.utils.response.WebResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<WebResponse<Employee>> createEmployee(@Valid @RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        WebResponse<Employee> response = WebResponse.<Employee>builder()
                .message("Employee created successfully")
                .data(createdEmployee)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<WebResponse<List<Employee>>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        PagingInfo pagingInfo = new PagingInfo(employees.size(), 1, 1, employees.size()); // Example paging info
        WebResponse<List<Employee>> response = WebResponse.<List<Employee>>builder()
                .message("All Employees Successfully Displayed")
                .data(employees)
                .paging(pagingInfo)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebResponse<Employee>> getEmployeeById(@PathVariable String id) {
        Employee employee = employeeService.getEmployeeById(id);
        WebResponse<Employee> response = WebResponse.<Employee>builder()
                .message("Employee ID successfully found")
                .data(employee)
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WebResponse<Employee>> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        WebResponse<Employee> response = WebResponse.<Employee>builder()
                .message("Employee updated successfully")
                .data(updatedEmployee)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WebResponse<Void>> deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        WebResponse<Void> response = WebResponse.<Void>builder()
                .message("Employee deleted successfully")
                .build();
        return ResponseEntity.ok(response);
    }
}
