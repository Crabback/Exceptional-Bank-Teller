import java.io.File;
import java.io.FileNotFoundException;

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

/**
 * This class is a tester for the BankTeller class's public behaviors
 * 
 * @author ZhengjiaMao
 *
 */
public class BankTellerTester {

  public BankTellerTester() {
  }

  /**
   * Checks whether the constructor of BankTeller class creates a new BankTeller object with an
   * empty ArrayList of bank accounts.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBankTellerConstructor() {
    BankTeller tellerConstructor1 = new BankTeller();
    BankTeller tellerConstructor2 = new BankTeller();
    BankAccount validAccount = new BankAccount("123", 50000);
    tellerConstructor2.addBankAccount(validAccount);
    if (tellerConstructor1.getAccountsCount() != 0)
      return false;
    if (tellerConstructor2.getAccountsCount() != 1)
      return false;
    return true;
  }

  /**
   * Checks whether the BankTeller.addBankAccount() method throws an IllegalStateException when it
   * is passed a bank account with an identifier already used.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBankTellerAddBankAccountUsedIdentifier() {
    BankTeller tellerAddAccount = new BankTeller();
    BankAccount validAccount = new BankAccount("123", 50000);
    tellerAddAccount.addBankAccount(validAccount);
    try {
      tellerAddAccount.addBankAccount(validAccount);
    } catch (IllegalStateException e) {
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the BankTeller.loadTransactions() method that takes a File parameter
   * throws a FileNotFoundException, when it is passed a File object that does not correspond to an
   * actual file within the file system, and a non null reference of type BankAccount.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBankTellerLoadTransactionsFileNotFound() {
    File someRandFile = new File("this is the wrong file.txt");
    BankTeller tellerLoadTrans = new BankTeller();
    BankAccount validAccount = new BankAccount("123", 50000);
    try {
      tellerLoadTrans.loadTransactions(someRandFile, validAccount);
    } catch (FileNotFoundException e) {
      return true;
    }
    return false;

  }

  /**
   * Calls the test methods defined in this BankTellerTester class
   * 
   * @param args - input arguments
   */
  public static void main(java.lang.String[] args) {
    System.out.println(testBankTellerConstructor());
    System.out.println(testBankTellerAddBankAccountUsedIdentifier());
    System.out.println(testBankTellerLoadTransactionsFileNotFound());
  }


}
