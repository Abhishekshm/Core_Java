package com.bank;
/*
 @AuthorName = Abhishek Sharma
 @ProjectName = Bank management System
 @Date = 19-12-22
 Description - Created a project where user can create account in different banks and do their transactions(withdraw,deposit,transfer)

 */

//imporitng classes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Main Application class
@SpringBootApplication
public class BankManagementSystemApplication {

	//main Method
	public static void main(String[] args) {
		SpringApplication.run(BankManagementSystemApplication.class, args);  //it will run our spring boot project
		System.out.println("--------Running------------");  //printing statement
	}

}
