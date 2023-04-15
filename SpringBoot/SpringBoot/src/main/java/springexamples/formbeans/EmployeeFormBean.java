package springexamples.formbeans;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import springexamples.validation.EmailUnique;

@Getter
@Setter
@ToString
public class EmployeeFormBean {
    private Integer id;
    @NotEmpty(message="First name is required.")
    @Length(max=40, message="First Name cannot be longer than 40 characters.")
    private String firstName;
    @NotEmpty(message="Last name is required.")
    private String lastName;
    @NotEmpty(message="Email address is required.")
    @Length(max=30, message="Email cannot be longer than 30 characters.")
    @Pattern(regexp=".+@.+\\.[a-z]+", message = "Invalid email format.")
    @EmailUnique(message="Email already exists in database.")
    private String email;
    private String jobTitle;
    private String extension;
    @Max(value=100, message="You cannot have more than 100 vacation hours.")
    @Min(value=0, message="You cannot have less than 0 vacation hours.")
    private Integer vacationHours;
    private Integer officeId;
    private String profileImage;

}
