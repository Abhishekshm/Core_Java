package com.atm;

import java.util.ArrayList;
import java.util.Scanner;

import com.atmUser.User;

public class Atm {

	ArrayList<User> atmUsers = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void adduser() {
		User user1 = new User();
		System.out.println("Enter your Name");
		user1.setUserName(sc.next());
		System.out.println("Enetr your Account Number");
		user1.setUserAccountNo(sc.nextInt());
		System.out.println("Enter your ammount");
		user1.setAmmount(sc.nextDouble());
		System.out.println("Enter your ATM Pin");
		user1.setAtmPin(sc.nextInt());
		atmUsers.add(user1);
		System.out.println("Account created Successfully");
		System.out.println();
		System.out.println(atmUsers);
	}

	public void deposit(int accountNo) {
		System.out.println("------------------------");
		System.out.println();

		User user = null;
		for (User u : atmUsers) {
			if (u.getUserAccountNo() == accountNo) {
				user = u;

			}
			if (user != null) {
				System.out.println("Enetr Atm Pin");
				int atmPin = sc.nextInt();
				if (user.getAtmPin() == atmPin) {
					System.out.println("Enter Your Ammount to deposit");
					double ammount = sc.nextDouble();
					user.setAmmount(user.getAmmount() + ammount);
					System.out.println("--------Diposit Successfully------");
					System.out.println();
					System.out.println("------------------------------");
				} else {
					System.out.println("Incorrect Atm pin");
				}
			}

//			else {
//				System.out.println("Please check the Account no and try again after some time");
//			}
		}
	}
	
	
	
	public void withdraw(int accountNo) {
		System.out.println("-------------------------------");
		System.out.println();

		User user = null;
		for (User u : atmUsers) {
			if (u.getUserAccountNo() == accountNo) {
				user = u;

			}
			if (user != null) {
				System.out.println("Enetr Atm Pin");
				int atmPin = sc.nextInt();
				if (user.getAtmPin() == atmPin) {
					System.out.println("Enter Your Ammount to withdraw");
					double ammount = sc.nextDouble();
					user.setAmmount(user.getAmmount() - ammount);
					System.out.println("--------Withdraw Successfully------");
					System.out.println();
					System.out.println("--------------------------------");
				} else {
					System.out.println("Incorrect Atm pin");
				}
			}

//			else {
//				System.out.println("Please check the Account no and try again after some time");
//			}
		}
	}
	
	
	public void checkBalance(int accountNo) {
		System.out.println("---------------------------------------");
		System.out.println();

		User user = null;
		for (User u : atmUsers) {
			if (u.getUserAccountNo() == accountNo) {
				user = u;

			}
			if (user != null) {
				System.out.println("Enetr Atm Pin");
				int atmPin = sc.nextInt();
				if (user.getAtmPin() == atmPin) {
					System.out.println("Your Account blalance is :- "+user.getAmmount());
					System.out.println();
					System.out.println("----------------------------------------");
				} else {
					System.out.println("Incorrect Atm pin");
				}
			}

//			else {
//				System.out.println("Please check the Account no and try again after some time");
//			}
		}
	}
}
