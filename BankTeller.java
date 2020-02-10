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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 * This class models the BankTeller data type
 * 
 * @author Zhengjia
 *
 */
public class BankTeller extends Object {

  /**
   * ArrayList named accounts
   */
  private ArrayList<BankAccount> accounts;

  /**
   * Creates a new BankTeller object with an empty list of accounts
   */
  public BankTeller() {
    accounts = new ArrayList<>();
  }

  /**
   * Adds newAccount to the list of accounts of this BankTeller
   * 
   * @param newAccount - a new account to add
   * @throws java.lang.IllegalStateException if the accountID of newAccount is used by another
   *         account already added to the list of accounts
   * @throws java.lang.IllegalArgumentException if newAccount is null
   */
  public void addBankAccount(BankAccount newAccount) {
    for (int i = 0; i < accounts.size(); i++) {
      if (newAccount.equals(accounts.get(i))) {
        throw new IllegalStateException("account already existed");
      }
    }
    if (newAccount.getID() == null) {
      throw new IllegalArgumentException("null account");
    }
    accounts.add(newAccount);
  }

  /**
   * Returns the bank account that has exactly the provided identifier.
   * 
   * @param id - a string that represents an identifier of a bank account
   * @return a reference to the bank account whose account identifier has an exact match with the
   *         provided string
   * @throws java.util.NoSuchElementException if no account in this bankTeller's accounts list has
   *         the provided id
   */
  public BankAccount findAccount(String id) throws NoSuchElementException {
    for (int i = 0; i < accounts.size(); i++) {
      if (accounts.get(i).getID().equals(id)) {
        return accounts.get(i);
      }
    }
    throw new NoSuchElementException("no such account found");
  }

  /**
   * Adds a new transaction to the account's list of transactions. When added, a withdrawal or
   * deposit transaction should change the account's balance
   * 
   * @param transaction - to add
   * @param account     - bank account
   * @throws java.util.zip.DataFormatException if the format of the transaction is not correct
   * @throws java.lang.NullPointerException if account is null
   */
  public void addTransaction(String transaction, BankAccount account) throws DataFormatException {

    int value = 0;
    String[] trans = transaction.trim().split(" ");

    if ((trans[0].equals("1") || trans[0].equals("0")) == false) {
      throw new DataFormatException("the format of the transcation is incorrect");
    }
    try {
      value = Integer.valueOf(trans[1]);
    } catch (NumberFormatException e) {
      throw new DataFormatException("the format of the transcation is incorrect");
    }
    if (account == null) {
      throw new NullPointerException("null account");
    }

    if (trans[0].equals("0")) {
      account.withdraw(value);
    } else if (trans[0].equals("1")) {
      account.deposit(value);
    }
  }

  /**
   * Loads a set of transactions from a provided file object.
   * 
   * @param file    - a java.io.File object referring to a file that contains a set of transactions,
   *                each in one line
   * @param account - a reference to a BankAccount object
   * @throws java.io.FileNotFoundException - if the file object does not correspond to an actual
   *         file within the file system.
   * @throws java.lang.NullPointerException - if account is null
   */
  public void loadTransactions(File file, BankAccount account) throws FileNotFoundException {
    if (account == null) {
      throw new NullPointerException("null account");
      // check whether the account is null
    }
    if (file.exists() == false)
      throw new FileNotFoundException("file does not exist");
    // check whether the file exists

    Scanner fin = new Scanner(file);
    // read the file

    while (fin.hasNextLine()) {
      try {
        addTransaction(fin.nextLine(), account);
      } catch (DataFormatException e) {
        // if the line is mistakenly formatted, go to the next line
      }
    }
    fin.close();
    // close the file
  }

  /**
   * Accessor Returns the total number of accounts created so far
   * 
   * @return the total number of accounts added to this BankTeller
   */
  public int getAccountsCount() {
    return accounts.size();
  }


  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
