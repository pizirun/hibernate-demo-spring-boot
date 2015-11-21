/*
 *  Copyright (c) 2004-2015 乐视网（letv.com）. All rights reserved
 * 
 *  LETV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 */
package demo.service;

import demo.model.Employee;
import demo.dao.EmployeeDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author <a href="mailto:pizhigang@letv.com">pizhigang</a>
 */
@Component
@Transactional
public class EmployeeService {

    private static final Logger logger = LogManager.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * Method to CREATE an employee in
     *
     * @param fname the database
     * @param lname
     * @param salary
     * @return
     */
    public Long addEmployee(String fname, String lname, int salary) {

        Long employeeID = null;
        try {
            Employee employee = new Employee(fname, lname, salary);

            employeeID = employeeDao.save(employee).getId();
        } catch (Exception ex) {
            logger.error("Error creating the Employee: " + ex.toString());
        }

        return employeeID;
    }

    /**
     * Method to READ all the employees
     */
    public void listEmployees() {

        Iterable<Employee> employees = employeeDao.findAll();
        for (Employee e : employees) {
            System.out.print("Id: " + e.getId());
            System.out.print("First Name: " + e.getFirstName());
            System.out.print("  Last Name: " + e.getLastName());
            System.out.println("  Salary: " + e.getSalary());
        }
    }

    /**
     * Method to UPDATE salary for an employee
     *
     * @param employeeId
     * @param salary
     */
    public void updateEmployee(Long employeeId, int salary) {
        try {
            Employee e = employeeDao.findOne(employeeId);

            e.setSalary(salary);

            employeeDao.save(e);

        } catch (HibernateException e) {
            logger.error("Failed to update Employee: "+ employeeDao, e);
        }
    }

    /**
     * Method to DELETE an employee from the records
     *
     * @param employeeId
     */
    public void deleteEmployee(Long employeeId) {
        try {
            Employee e = employeeDao.findOne(employeeId);

            employeeDao.delete(e);

        } catch (HibernateException e) {
            logger.error("Failed to delete Employee: "+ employeeDao, e);
        }
    }
}
