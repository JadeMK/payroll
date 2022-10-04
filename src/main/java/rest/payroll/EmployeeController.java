package rest.payroll;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// To wrap the current repository with a web layer -> Spring MVC

// indicates that the returned data will be written straight into the response body
@RestController
class EmployeeController {

    private final EmployeeRepository respository;

    // injected
    EmployeeController(EmployeeRepository respository) {
        this.respository = respository;
    }

    @GetMapping("/employees")
    List<Employee> all() {
        return respository.findAll();
    }

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {
        return respository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return respository.save(newEmployee);
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return respository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setId(newEmployee.getId());
                    return respository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return respository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        respository.deleteById(id);
    }
}

