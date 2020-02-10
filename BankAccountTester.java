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

import java.util.zip.DataFormatException;

/**
 * This class represents a tester for the BankAccount class's public behaviors
 * 
 * @author ZhengjiaMao
 *
 */
public class BankAccountTester {

  /**
   * empty Constructor
   */
  public BankAccountTester() {
  }

  /**
   * Checks whether the new account is created with the provided account id and balance. Checks only
   * one transactions /"1 " + the initial balance/
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBankAccountConstructorValidInitialBalance() {
    BankAccount validAccount = new BankAccount("123", 50000);
    if (validAccount.getID() != "123")
      return false;
    if (validAccount.getBalance() != 50000)
      return false;
    if (validAccount.getTransactionsCount() != 1)
      return false;
    if (validAccount.getMostRecentTransactions()[0].equals("1 50000") != true)
      return false;
    return true;
  }

  /**
   * checks whether the BankAccount constructor throws an IllegalArgumentException when it is passed
   * a balance smaller than 10
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBankAccountConstructorNotValidInitialBalance() {
    try {
      BankAccount invalidAccount1 = new BankAccount("124", 5);
    } catch (IllegalArgumentException e) {
      // move to the next test
    }
    try {
      BankAccount invalidAccount2 = new BankAccount("125", -1);
    } catch (IllegalArgumentException e) {
      // move to the next test
    }
    try {
      BankAccount invalidAccount3 = new BankAccount("122", 0);
    } catch (IllegalArgumentException e) {
      return true;
    }
    return false;
  }

  /**
   * Checks whether BankAccount.equals() method returns true when it compares a bank account to
   * another one having the same account identifier
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBankAccountEquals() {
    BankAccount equalAccount = new BankAccount("126", 50000);
    if (equalAccount.equals(new BankAccount("126", 70000)) != true)
      return false;
    if (equalAccount.equals(new BankAccount("126", 90000)) != true)
      return false;
    return true;
  }

  /**
   * Checks whether BankAccount.withdraw() method throws a DataFormatException when it is passed a
   * negative number or a number not multiple of 10. The account balance should not change after the
   * withdraw() method returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBankAccountWithdrawInvalidAmount() {
    BankAccount withdrawAccount1 = new BankAccount("127", 50000);
    try {
      withdrawAccount1.withdraw(-50);
    } catch (DataFormatException e) {
      if (withdrawAccount1.getBalance() != 50000)
        return false;
    }
    try {
      withdrawAccount1.withdraw(5);
    } catch (DataFormatException e) {
      if (withdrawAccount1.getBalance() != 50000)
        return false;
    }
    return true;
  }

  /**
   * Checks whether BankAccount.withdraw() method throws an IllegalStateException when it is passed
   * a number larger than the account's balance. The account balance should not change after that
   * withdraw() method call returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   * @throws IllegalStateException when it is passed a number larger than the account's balance
   */
  public static boolean testBankAccountWithdrawLargerOfBalanceAmount() {
    BankAccount withdrawAccount2 = new BankAccount("128", 50000);
    boolean result = false;
    try {
      try {
        withdrawAccount2.withdraw(100000);
      } catch (DataFormatException e) {
        result = false; //should not throw a DataFormatException
      }
    } catch (IllegalStateException e) {
      result = true;
      if (withdrawAccount2.getBalance() != 50000)
        result = false;
    }
    try {
      try {
        withdrawAccount2.withdraw(50010);
      } catch (DataFormatException e) {
        result = false; //should not throw a DataFormatException
      }
    } catch (IllegalStateException e) {
      result = true;
      if (withdrawAccount2.getBalance() != 50000)
        result = false;
    }
    
    return result;
  }

  /**
   * Checks whether BankAccount.withdraw() method returns without any exception when it is passed a
   * positive number smaller than the account's balance. The withdrawal amount should be subtracted
   * from the balance after the withdraw() method call returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBankAccountWithdrawValidAmount() {
    BankAccount withdrawAccount3 = new BankAccount("129", 50000);
    try {
      withdrawAccount3.withdraw(10000);
    } catch (IllegalStateException e) {
      return false;
    } catch (DataFormatException e) {
      return false;
    }
    if (withdrawAccount3.getBalance() != 40000) {
      return false;
    }
    return true;
  }

  /**
   * Checks whether BankAccount.deposit() method throws an IllegalArgumentException when it is
   * passed a negative number. The balance of the bank account should not change after the method
   * call returns
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBankAccountDepositNegativeAmount() {
    BankAccount depositAccount = new BankAccount("130", 50000);
    try {
      depositAccount.deposit(-500);
    } catch (IllegalArgumentException e) {
      if (depositAccount.getBalance() != 50000)
        return false;
    }
    try {
      depositAccount.deposit(-1);
    } catch (IllegalArgumentException e) {
      if (depositAccount.getBalance() != 50000)
        return false;
    }
    return true;
  }


  /**
   * Calls the different test methods
   * 
   * @param args input arguments
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(testBankAccountConstructorValidInitialBalance());
    System.out.println(testBankAccountConstructorNotValidInitialBalance());
    System.out.println(testBankAccountEquals());
    System.out.println(testBankAccountWithdrawInvalidAmount());
    System.out.println(testBankAccountWithdrawLargerOfBalanceAmount());
    System.out.println(testBankAccountWithdrawValidAmount());
    System.out.println(testBankAccountDepositNegativeAmount());
  }

}
