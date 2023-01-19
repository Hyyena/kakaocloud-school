package gmail.sjtxm0320.aopandsecurity.service;

import gmail.sjtxm0320.aopandsecurity.domaiin.Employee;

public interface EmployeeService {
    Employee createEmployee(String empId, String firstName, String secondName);
}
