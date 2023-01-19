package gmail.sjtxm0320.aopandsecurity.controller;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gmail.sjtxm0320.aopandsecurity.domaiin.Employee;
import gmail.sjtxm0320.aopandsecurity.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/add/employee")
    public ResponseEntity<Employee> addEmployee(@RequestParam("empId") String empId,
        @RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName) {
        Employee employee = employeeService.createEmployee(empId, firstName, secondName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(employee, headers, HttpStatus.OK);
    }
}
