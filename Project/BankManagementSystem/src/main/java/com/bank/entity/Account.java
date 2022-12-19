package com.bank.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name="account_details")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountNo;
	@Column(name = "account_name",length = 50)
	private String accountHolderName;
	@Column(unique = true,length = 20)
	private String panNo;
	@Column(unique = true,length = 20)
	private long aadharNo;
	@Column(unique = true,length = 20)
	private long phoneNo;
	@Column( nullable = false)
	private double balance;
	@Column( nullable = false ,length = 30)
	private String accountType;
	@Column(nullable = false , unique = true,length = 20)
	private int setPin;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("account")
	private Bank bank;

	@Builder
	public Account(String accountHolderName, String panNo, long aadharNo, long phoneNo, double balance,
			String accountType, int setPin) {
		super();
		this.accountHolderName = accountHolderName;
		this.panNo = panNo;
		this.aadharNo = aadharNo;
		this.phoneNo = phoneNo;
		this.balance = balance;
		this.accountType = accountType;
		this.setPin = setPin;
	}
	
	
	
	
	
}
