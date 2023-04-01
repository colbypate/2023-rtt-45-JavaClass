package springexamples.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springexamples.database.entity.Employee;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {
    //this is a JPA hibernate query

    @Query("FROM Employee e")
    List<Employee> getAllEmployees();
    Employee findById(Integer id);

    List<Employee> findByFirstNameContainingOrLastNameContainingIgnoreCase(String firstName, String lastName);

    //Employee createNewEmployee();

    @Query(value="select * from employees where firstname like %:firstName% or lastName like %:lastName% ;", nativeQuery = true)
    List<Employee> usingANativeQuery(String firstName, String lastName);

    @Query("select e from Employee e where e.firstName like %:firstName% or e.lastName like %:lastName% ")
    List<Employee> usingJPAQuery(String firstName, String lastName);



    List<Employee> findByFirstNameContainingIgnoreCase(String firstName);

    List<Employee> findByLastNameContainingIgnoreCase(String lastName);
}