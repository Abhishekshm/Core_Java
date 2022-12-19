package com.bank.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bank.entity.Bank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {

	private int accountNo;
	@NotNull
	@Size(min=2)
	private String accountHolderName;
	@NotNull
	@Size(min=5)
	private String panNo;	
	@NotNull
	@Size(min=5)
	private long aadharNo;
	@NotNull
	@Size(min=1)
	private double balance;
	@NotNull
	@Size(min=2)
	private String accountType;
	@NotNull
	@Size(min=10)
	private long phoneNo;
	@NotNull
	@Size(min=4)
	private int setPin;
	private Bank bank;
}
