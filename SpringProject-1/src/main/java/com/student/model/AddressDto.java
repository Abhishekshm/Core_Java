package com.student.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

	private int addressId;
	@NotNull
	@Size(min=1)
	private String city;
	
	@NotNull
	@Size(min=1)
	private String state;
	
	@NotNull
	@Size(min =1,max =6)
	private int pincode;
	

}
