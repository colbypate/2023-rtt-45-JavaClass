package jpa.entitymodels;



import java.util.List;

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
public class Student {

	@Column(name = "email")
	private String sEmail;

	@Column(name = "name")
	private String sName;

	@Column(name = "password")
	private String sPass;



}
