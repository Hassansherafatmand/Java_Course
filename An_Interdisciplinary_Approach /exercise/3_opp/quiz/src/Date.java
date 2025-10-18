
public class Date {

	private int month;
	private int day;
	private int year;
	
	// constructors
	//------------------------------------------------------
	public Date() {
		this.month = 01;
		this.day = 01;
		this.year = 2000; 
	}
	
	public Date(int month, int day, int year) {	
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	// Getters and Setters of the field;
	//------------------------------------------------------
	public int getMonth() {	return month;}
	public void setMonth(int month) {this.month = month;}

	public int getDay() {return day;}
	public void setDay(int day) {this.day = day;}

	public int getYear() {return year;}
	public void setYear(int year) {	this.year = year;}

	
	// -------------------- Methods ---------------------------------------
	// -------------------- Leap Year Check --------------------
	private boolean isLeapYear() {
		if ( (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) )  return true;
		
		return false;
	}
	
	// -------------------- Convert Date to Total Days --------------------
	
	private int toDays() {
	    int[] daysInMonth = {0, 31,28,31,30,31,30,31,31,30,31,30,31};
	    int total = 0;

	    
	    // this irritation computes the total days for each year before the current year.
	    for (int y = 0; y < year; y++) {
	    	
	    	// checks each years if is a leap year or not.
	    	if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
	            total += 366; 
	        } else {
	            total += 365;  
	        }
	    }
	    
	    
	    if (isLeapYear()) {
	        daysInMonth[2] = 29;
	        
	    }

	    // add all full months before the current month
	    for (int i = 1; i < month; i++) {
	        total += daysInMonth[i];
	    }

	    // add days of the current month
	    total += day;

	    
	    return total;
	}	
	
	// -------------------- Compute Days Between --------------------
	public int daysBetween (Date secondDate) {
		
		int totalDaysDate1 = this.toDays();
		int totalDaysDate2 = secondDate.toDays();
		
		return Math.abs(totalDaysDate1 - totalDaysDate2);
	}
	
	
	// -------------------- Day of the Week --------------------
	 public String dayOfWeek() {
		
		 String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		 int indexReferenceDay = 6; // something like 0 = Sunday, 1 = Monday , etc
		 
		 int totalDays = this.toDays();  					  //System.out.println("totalDays: " + totalDays);
		 int refeneceDay = new Date(1, 1, 2000).toDays();	  //System.out.println("refeneceDay: " + refeneceDay);
		 
		 int difference = Math.abs(totalDays - refeneceDay);   //System.out.println("difference: " + difference);
		 
		 int indexDay = (indexReferenceDay +  difference) % 7; //System.out.println("indexDay: " + indexDay);
		 if (indexDay < 0) indexDay += 7;
		 
         return days[indexDay];
	 }
	 
	 
	
	 @Override
	 public String toString() {
	     return String.format("Date [month=%d, day=%d, year=%d]", month, day, year);
	 }
	

}
