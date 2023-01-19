package gmail.sjtxm0320.aopandsecurity.domaiin;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Employee {
    private String empId;
    private String firstName;
    private String secondName;
}
