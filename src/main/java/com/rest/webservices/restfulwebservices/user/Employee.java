package com.rest.webservices.restfulwebservices.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

	Employee() {}
	
	@Id // Specifies the primary key
	private Integer id;
	
	private String name;
}
