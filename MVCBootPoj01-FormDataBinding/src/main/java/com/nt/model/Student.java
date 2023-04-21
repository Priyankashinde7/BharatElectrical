package com.nt.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private Integer studentno;
	private String studentname;
	private String studentadd;
	private Float avg;
	
	
	
}
