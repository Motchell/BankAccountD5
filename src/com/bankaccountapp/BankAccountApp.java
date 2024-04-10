package com.bankaccountapp;

import com.bankaccount.BankAccount;

public class BankAccountApp {

	public static void main(String[] args) {
		BankAccount user1 = new BankAccount();
		BankAccount user2 = new BankAccount();
		BankAccount user3 = new BankAccount();
		BankAccount user4 = new BankAccount();
		
		System.out.println(BankAccount.getCreatedAccounts());
		
		user1.deposit(110, 'B');
		user1.deposit(2500, 'A');
		
		user2.deposit(3000, 'B');
		user2.deposit(2500, 'A');
		
		System.out.println(BankAccount.getTotalBalance());
		
		user1.withdraw(200, 'B');
		user1.withdraw(2000, 'A');
		
		System.out.println(BankAccount.getTotalBalance());
		
		System.out.println(user1.getCurrentAccountBalance());
		System.out.println(user1.getSavingsAccountBalance());
		
		user1.getBalance();
		
	}
	
}
