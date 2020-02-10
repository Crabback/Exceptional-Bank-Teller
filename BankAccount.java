//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P04 Exceptional Bank Teller
// Files: BankAccount.java
// Course: CS 300
//
// Author: Zhengjia Mao
// Email: zmao27@wisc.edu
// Lecturer's Name: Gary DAHL
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: NONE
// Partner Lecturer's Name: NONE
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _YES__ Write-up states that pair programming is allowed for this assignment.
// _YES__ We have both read and understand the course Pair Programming Policy.
// _YES__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: ULC tutors
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;
import java.util.zip.DataFormatException;

/**
 * This class models a very simple account at a bank
 * 
 * @author ZhengjiaMao
 *
 */
public class BankAccount extends java.lang.Object {

  /**
   * private parameters will be used in this class
   */
  private String id;
  private int balance;
  private ArrayList<String> transactions;

  /**
   * Constructor, Creates a new bank account with a given account identifier and an initial balance.
   * A deposit transaction /"1 " + initialBalance/ must be added to this account's list of
   * transactions
   * 
   * @param accountID      - this account's unique identifier
   * @param initialBalance - this account's initial balance
   * @throws java.lang.IllegalArgumentException if initBalance is less than 10
   */
  public BankAccount(String accountID, int initialBalance) {
    if (initialBalance < 10) {
      throw new IllegalArgumentException("initBalance is less than 10");
    }
    id = accountID;
    balance = initialBalance;
    transactions = new ArrayList<>();
    transactions.add("1 " + String.valueOf(balance));
  }

  /**
   * Gets the unique identifier of this account
   * 
   * @return the unique identifier of this account
   */
  public String getID() {
    return id;
  }

  /**
   * Gets the current balance of this bank account
   * 
   * @return the current balance of this bank account
   */
  public int getBalance() {
    return balance;
  }

  /**
   * Checks if an other bank account is equal to this one
   * 
   * @param other - another BankAccount object
   * @return true if this bankAccount's identifier equals the other bankAccount's identifier
   */
  public boolean equals(BankAccount other) {
    return (id == other.getID());
  }

  /**
   * This method deposits an amount to this bank account. It also adds the transaction /"1 " +
   * depositAmount/ to this account list of transactions and updates this bank account's balance.
   * 
   * @param depositAmount - the amount of money to deposit to this bank account
   * @throws java.lang.IllegalArgumentException if depositAmount is negative
   */
  public void deposit(int depositAmount) {
    if (depositAmount < 0)
      throw new IllegalArgumentException("depositAmount is negative");
    transactions.add("1 " + String.valueOf(depositAmount));
    balance += depositAmount;

  }

  /**
   * This method withdraws a specific amount of money. It also adds the transaction /"0 " +
   * withdrawalAmount/ to this accunt's list of transactions and updates this bank account's
   * balance.
   * 
   * @param withdrawAmount - the amount of money to withdraw from this bank account
   * @throws java.util.zip.DataFormatException if withdrawalAmount is negative or is not a multiple
   *         of 10
   * @throws java.lang.IllegalStateException if the withdrawalAmount is larger than this bank
   *         account's balance
   */
  public void withdraw(int withdrawAmount) throws DataFormatException {
    if (withdrawAmount < 0 || withdrawAmount % 10 != 0) {
      throw new DataFormatException(
          "The withdrawal amount cannot be negative and must be a multiple of 10");
    }
    if (withdrawAmount > balance) {
      throw new IllegalStateException("no enough balance");
    }
    transactions.add("0 " + String.valueOf(withdrawAmount));
    balance -= withdrawAmount;
  }

  /**
   * Gets the most recent FIVE transactions in an array of length 5. This array may contain null
   * references if the total number of transactions is less than 5.
   * 
   * @return the most recent transactions in an array that may contain up to 5 string references
   */
  public String[] getMostRecentTransactions() {
    String[] trans = new String[5];
    for (int i = 0; i < 5; i++) {
      if (getTransactionsCount() != 0 && (getTransactionsCount() - 1 - i) >= 0) {
        trans[i] = transactions.get(getTransactionsCount() - 1 - i);
      }
    }
    return trans;
  }

  /**
   * Gets the total number of transactions performed on this bank account, meaning the size of the
   * ArrayList of transactions of this bank account
   * 
   * @return the total number of transactions performed on this account
   */
  public int getTransactionsCount() {
    return transactions.size();
  }


  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
