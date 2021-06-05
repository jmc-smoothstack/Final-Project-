import java.util.Scanner; 
import java.util.ArrayList; 
import java.util.*;
import java.util.Calendar; 
import java.io.*;

public class library{
	String name, address;
	//books[][] is the catalog of books in the libraries system.
	Vector <bookEntry> bookCatalog = new Vector<bookEntry>();
	//Vector of bookLoanEntry objects to track a library's loans 
	Vector <bookLoanEntry> bookLoans = new Vector<bookLoanEntry>();
	//Contructors 
	library(){}
	library(String name, String address){
		this.name = name; 
		this.address = address; 

		bookCatalog.add(new bookEntry("Lost Tribe by Sidney Sheldon", 5));
		bookCatalog.add(new bookEntry("The Haunting by Stepehen King",2));
		bookCatalog.add(new bookEntry("Microtrends by Mark Penn",3));

	}
	//createLoan() creates a new loan entry and adds it to Vector of loans 
	public void createLoan(int userCardNumber, String bookTitle){

		bookLoanEntry loan = new bookLoanEntry(userCardNumber, bookTitle);
		bookLoans.add(loan);
		//bookOut() subtracts 1 book from avaliable books
		bookOut(bookTitle);
		//subtract 1 copy from book inventory 
		for(int i = 0 ; i < bookCatalog.size() ; i++)
		{
			if(bookCatalog.get(i).title == bookTitle)
			{
				bookCatalog.get(i).copies -= 1;
			}
		}
		System.out.println("Loan successfully created");
	}
	//removes loan entry from Vector and adds copy back to inventory 
	public void returnBook(int cardNumber, String bt){
		int position = 0; //tracks poistion in Vector 
		for(bookLoanEntry loan : bookLoans)
		{
			if(loan.userCardNumber == cardNumber)
			{
				if(loan.bookTitle == bt)
				{
					break; 
				}
			}
			position +=1;
		}
		//removes bookLoanEntry() by position in Vector()
		bookLoans.remove(position);

		//adds copy back to inventory / raises availble copies for the specific book by 1 	
		for(int i = 0 ; i < bookCatalog.size() ; i++)
		{
			if(bookCatalog.get(i).title == bt){
				bookCatalog.get(i).copies += 1;
			}

		}
		System.out.println("Loan entry removed succesfully");
	}

	//addBooks() adds copies of a book to catalog 
	public void updateCopies(String bookTitle, int booksToAdd){
		for(int i = 0 ; i < bookCatalog.size() ; i++)
		{
			if(bookCatalog.get(i).title == bookTitle){ 
				bookCatalog.get(i).copies += booksToAdd;
				System.out.println("copies successfully updated - copies: " + bookCatalog.get(i).copies);
			}
		}
	}
	//get method to return Vector of book loans 
	public Vector<bookLoanEntry> getBookLoans(){
		return bookLoans;
	}
	//get method to return book Catalog 
	public Vector<bookEntry> getCatalog(){
		return bookCatalog; 
	}

	//bookOut is used to subtract 1 from avalible books in the ibraries inventory  
	public void bookOut(String bookTitle){
		for(int i = 0 ; i < bookCatalog.size() ; i++){
			//subtract book from inventory 
			if(bookCatalog.get(i).title == bookTitle){
				bookCatalog.get(i).copies -=1;
			}
		}
	}
	//print method to show all books (titles and copies) in book catalog 
	public int showBooks(){
		int c = 0; 
		for(int i = 0 ; i < bookCatalog.size() ; i++){
			System.out.println(bookCatalog.get(i).title + "  copies: " + bookCatalog.get(i).copies);
			c = i; 
		}
		//reutrns index for quit line 
		System.out.println(c+2+") Quit to previous");
		return c+2; 
	}
	//print method shows active loans 
	public void showLoans(){
		//checks if there is a loan in the loan array 
		if(bookLoans.size() > 0)
		{
			int c = 0; 
			for(bookLoanEntry loan : bookLoans)
			{
				System.out.println(c+1+") "+loan.userCardNumber + " " + loan.bookTitle);
				c+=1; 
			}
			System.out.println(c+2+") Quit to previous");
		}else{System.out.println("No loans in system");}
	}
	//set method to set / change  library name 
	public void setName(String s){
		name = s; 
		System.out.println("name successfully set");
	}
	//set method to set / change library address 
	public void setAddress(String s){
		address = s;
		System.out.println("address successfully set");
	}
	public static void main(String args[]){


	}
}
