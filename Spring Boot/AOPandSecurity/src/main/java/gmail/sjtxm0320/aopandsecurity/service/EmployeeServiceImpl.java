package gmail.sjtxm0320.aopandsecurity.service;

import org.springframework.stereotype.Service;

import gmail.sjtxm0320.aopandsecurity.domaiin.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee createEmployee(String empId, String firstName, String secondName) {
        Employee emp = Employee.builder().empId(empId).firstName(firstName).secondName(secondName).build();

        return emp;
    }
}
