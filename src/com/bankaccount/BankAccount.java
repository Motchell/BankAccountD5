package com.bankaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccount {
	private String numAccount;
	private double currentAccountBalance;
	private double savingsAccountBalance;
	private static double createdAccounts;
	private static double totalBalance;
	
    private static final List<BankAccount> accounts = new ArrayList<>();
	
	@SuppressWarnings("static-access")
	public BankAccount() {
		this.numAccount = randomGenerate();
		this.currentAccountBalance = 0;
		this.savingsAccountBalance = 0;
		this.createdAccounts++;
        accounts.add(this);
	}
	
	private String randomGenerate() {
		Random rand = new Random();
		String randomNumAcc = "";
		
		do {
			for(int i=0;i<10;i++) {
				int randomNum = rand.nextInt(9)+1;
				randomNumAcc += Integer.toString(randomNum);
			}
		}while(accountValidate(randomNumAcc)==false);
		
		return randomNumAcc;
	}
	
	public boolean accountValidate(String accNum) {
		/*
		 * acá genero un stream de los objetos tipo BankAccount que está creados, verifico que ninguno 
		 * de los items anteriores sea igual al nuevo generado iterando y devolviendo un boolean en false
		 * en caso de que ocurra 
		 */
		return getAccounts().stream().noneMatch(i -> accNum == i.numAccount);
	}
	
	public void deposit(double amount, char option) {
		switch (String.valueOf(option).toUpperCase()) {
	    case "A":
	    	if(amount>0) {
		    	this.currentAccountBalance += amount;
		    	totalBalance += amount;
		    	System.out.println("nuevo monto (depósito):" + this.currentAccountBalance);
		        break;
	    	}
	    case "B":
	    	if(amount>0) {
		    	this.savingsAccountBalance += amount;
		    	totalBalance += amount;
		    	System.out.println("nuevo monto (depósito): " + this.savingsAccountBalance);
		        break;
	    	}
	    default:
	    	System.out.println("Acción no válida");
		}
	}
	
	public void withdraw(double amount, char option) {
		switch (String.valueOf(option).toUpperCase()) {
	    case "A":
	    	if(this.currentAccountBalance>=amount) {
		    	this.currentAccountBalance -= amount;
		    	totalBalance -= amount;
		    	System.out.println("nuevo monto (retiro): " + this.currentAccountBalance);
		        break;
	    	}
	    case "B":
	    	if(this.savingsAccountBalance>=amount) {
		    	this.savingsAccountBalance -= amount;
		    	totalBalance -= amount;
		    	System.out.println("nuevo monto (retiro): " + this.savingsAccountBalance);
		        break;
	    	}
	    default:
	    	System.out.println("Acción no válida");
		}
	}
	
	public void getBalance() {
		System.out.println("Tu saldo en tu cuenta corriente es de: " + this.currentAccountBalance);
		System.out.println("Tu saldo en tu cuenta de ahorros es de: " + this.savingsAccountBalance);
		System.out.println("Tu saldo total es de: " + (this.getCurrentAccountBalance()+this.getSavingsAccountBalance()));
	}

	public String getNumAccount() {
		return numAccount;
	}

	public double getCurrentAccountBalance() {
		return currentAccountBalance;
	}

	public double getSavingsAccountBalance() {
		return savingsAccountBalance;
	}
	
	public static double getTotalBalance() {
		return totalBalance;
	}
	
	public static double getCreatedAccounts() {
		return createdAccounts;
	}
	
	public static List<BankAccount> getAccounts() {
        return accounts;
    }
	
}
