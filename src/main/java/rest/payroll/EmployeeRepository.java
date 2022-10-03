package rest.payroll;

import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //  Create, Update, Delete, Find employee(s)
    //  (Only by declaring this interface, which extends JpaRepository)
}
