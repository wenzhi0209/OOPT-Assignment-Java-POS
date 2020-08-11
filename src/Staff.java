import java.util.*;
import java.text.*;
public class Staff implements Comparable<Staff> {

    private String staffID;
    private String staffName;
    private char gender;
    private Date dateOfBirth;
    private Date startDate;
    private String position;
    private double salary;
    private static int num=0;

    private SimpleDateFormat formatter;
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    Date date =new Date();



		public Staff(){
			num++;
		};

	    public Staff(String staffID, String staffName, char gender, String dateOfBirth, String startDate, String position, double salary){
			this.staffID = staffID;
			this.staffName = staffName;
			this.gender = gender;
			this.dateOfBirth = stringToDate(dateOfBirth);
			this.startDate = stringToDate(startDate);
			this.position = position;
			this.salary = salary;
			num++;
		}

		public String getStaffID(){
			return this.staffID;
		}

		public String getStaffName(){
			return this.staffName;
		}

		public char getGender(){
			return this.gender;
		}

		public String getDOB(){
			return format.format(dateOfBirth);
		}

		public String getStartDate(){
			return format.format(startDate);
		}
		public Date getDStartDate(){
			return startDate;
		}

		public String getPosition(){
			return this.position;
		}

		public double getSalary(){
			return this.salary;
		}

		public static int getNum(){
			return num;
		}
		public void setStaffID(String staffID){
			this.staffID = staffID;
		}

		public void setStaffName(String staffName){
			this.staffName = staffName;
		}

		public void setGender(char gender){
			this.gender = gender;
		}

		public void setDOB(String dateOfBirth){
			Date date =new Date();
			date=stringToDate(dateOfBirth);
			this.dateOfBirth = date;

		}

		public void setStartDate(String startDate){
			Date date =new Date();
			date=stringToDate(startDate);
			this.startDate = date;
		}


		public void setPosition(String position){
			this.position = position;
		}



		public void setSalary(double salary){
			this.salary = salary;
		}

		public static Date stringToDate(String S)
	    {
	    	Date result=null;
	    	SimpleDateFormat formatter;
	    	try{

			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			result=format.parse(S);
	    	}
	    	catch(ParseException e)
	    	{
	    		e.printStackTrace();
	    	}

		return result;
	    }

		public String toString(){
			return String.format("Staff ID >%-10s\nStaff Name >%-15s\nStaff Gender >%-5s\nStaff DOB >%-15s\nStaff Start Date >%-15s\nStaff Position >%-15s\nStaff Salary >%-10s\n", staffID, staffName, gender, dateOfBirth, startDate, position, salary);
		}

    	public int compareTo(Staff s){
    		return this.getStaffName().compareTo(s.getStaffName());
    	}







}























