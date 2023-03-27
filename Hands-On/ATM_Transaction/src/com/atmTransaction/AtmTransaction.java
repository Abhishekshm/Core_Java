package com.atmTransaction;

import java.util.Scanner;

import com.atm.Atm;

public class AtmTransaction {

	
	public static void atmFunctions() {
		System.out.println();
		System.out.println();
		System.out.println("-----Welcome coustomer----");
		
		System.out.println();
		System.out.println("1.  Create your Account");
		System.out.println("2.  Deposit");
		System.out.println("3.  Withdraw");
		System.out.println("4.  Check Balance");
		System.out.println("5.  Exit");
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Atm atm =new Atm();
		int choice ;
		try {
		
		do {
			
			atmFunctions();
			choice=sc.nextInt();
			
			switch (choice) {
			
			case 1:
				atm.adduser();
				break;
				
			case 2:
				System.out.println("Enter your Account No");
				int accountNo = sc.nextInt();
				atm.deposit(accountNo);
				break;
				
			case 3:
				System.out.println("Enter your Account No");
				int accountNo1 = sc.nextInt();
				atm.withdraw(accountNo1);
				break;
				
			case 4:
				System.out.println("Enter your Account No");
				int accountNo2 = sc.nextInt();
				atm.checkBalance(accountNo2);
				break;
				
			case 5:
				System.exit(0);
				break;
				
			default : System.out.println("Wrong Input");
			}
		}while(choice!=5);
		sc.close();
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
	}
}
