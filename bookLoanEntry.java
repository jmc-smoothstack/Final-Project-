import java.util.Date;
import java.util.Calendar; 
import java.util.ArrayList; 
import java.text.*; 

public class bookLoanEntry{

	Format f = new SimpleDateFormat("MM/dd/yy");
	Calendar checkoutCal, dueCal; 
	Date due, checkout; 
	public int userCardNumber; 
	public String bookTitle; 

	//Contructor 
	bookLoanEntry(int userCardNumber, String bookTitle){

      	checkoutCal = Calendar.getInstance(); //users current date 
      	dueCal = Calendar.getInstance();
      	dueCal.add(Calendar.DAY_OF_MONTH, 7); //7 days are added to Calendar() object to represent the books due date
      	checkout = checkoutCal.getTime();
      	due = dueCal.getTime();
      	//indentifiers 
      	this.bookTitle = bookTitle;   
      	this.userCardNumber = userCardNumber; 

	}

	//returns the check out date for book in formatt mm/dd/yy
	public String checkoutDateToString(){
		return(f.format(checkout));
	}

	//returns the check out date for book in formatt mm/dd/yy
	public String dueDateToString(){
		return(f.format(due));
	}
		
}