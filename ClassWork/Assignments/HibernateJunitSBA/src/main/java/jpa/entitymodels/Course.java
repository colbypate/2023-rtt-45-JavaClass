package jpa.entitymodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "student")
public class Course {

	@Column(name = "id")
	private String cId;

	@Column(name = "name")
	private String cName;

	@Column(name = "instructor")
	private String cInstructor;
}


