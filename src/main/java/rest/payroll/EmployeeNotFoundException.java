package rest.payroll;

public class EmployeeNotFoundException extends RuntimeException {

    // When an employee is looked up but not found

    public EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
