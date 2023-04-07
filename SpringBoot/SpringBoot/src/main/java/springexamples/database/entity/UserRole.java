package springexamples.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "user_roles")
public class UserRole {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	// this is the foreign key
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "role_name")
	private String roleName;


}
