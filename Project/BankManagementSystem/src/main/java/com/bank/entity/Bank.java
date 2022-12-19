package com.bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name= "bank")
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name= "bank_name", unique = true,length = 50)
	private String bankName;
	@Column(name= "branch_name", unique = true,length = 50)
	private String branchName;
	@Column(name= "branch_location",length = 30)
	private String branchLocation;
	@Column(name= "IFSC_Code", unique = true,length = 20)
	private String ifscCode;
	@Builder
	public Bank(String bankName, String branchName, String branchLocation, String ifscCode) {
		super();
		this.bankName = bankName;
		this.branchName = branchName;
		this.branchLocation = branchLocation;
		this.ifscCode = ifscCode;
	}
	
	
}
