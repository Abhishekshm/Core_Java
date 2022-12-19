package com.bank.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankDto {

	
	private int id;
	@NotNull
	@Size(min=2)
	private String bankName;
	@NotNull
	@Size(min=2)
	private String branchName;
	@NotNull
	@Size(min=2)
	private String branchLocation;
	@NotNull
	@Size(min=4)
	private String ifscCode;


}
