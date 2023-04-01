package springexamples.formbeans;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeFormBean {

    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
    private String extension;
    private Integer vacationHours;
    private Integer officeId;

}
