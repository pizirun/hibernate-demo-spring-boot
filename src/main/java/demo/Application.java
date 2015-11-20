package demo;

import demo.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger logger = LogManager.getLogger(Application.class);

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("ManageEmployee start ...");

        /* Add few employee records in database */
        Long empId1 = employeeService.addEmployee("Zara", "Ali", 1000);
        Long empId2 = employeeService.addEmployee("Daisy", "Das", 5000);
        Long empId3 = employeeService.addEmployee("John", "Paul", 10000);

        /* List down all the employees */
        employeeService.listEmployees();

        /* Update employee's records */
        employeeService.updateEmployee(empId1, 5000);

        /* Delete an employee from the database */
        employeeService.deleteEmployee(empId2);

        /* List down new list of the employees */
        employeeService.listEmployees();

        logger.info("closing the SessionFactory ...");

        logger.info("ManageEmployee successfully End.");
    }

}
