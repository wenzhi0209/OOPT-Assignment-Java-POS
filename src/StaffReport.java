import java.util.*;
public class StaffReport extends Report {

	private Staff[] s=new Staff[StaffMenu.s.length];
	private Staff[] s2;

	public void getReport()
	{
		int count=0;
	 	System.arraycopy(StaffMenu.s,0,s,0,StaffMenu.s.length);
	 	s2= StaffMenu.s;
	 	System.out.printf("\n\n\n\n %-20s \n",super.getCompanyName());
	 	System.out.println(" "+super.getDate());
	 	System.out.println(" Product Report ");
	 	System.out.printf(" %-10s %-20s %-6s %-12s %-12s %-10s %-10s \n","Staff_ID","Staff_Name","Gender","Birth_Date","Start_Date","Position","Salary(RM)");
	 	System.out.println(" ----------------------------------------------------------------------------------------------");

	 	for(int i=0;i<s.length;i++)
	 	{
	 		if(s[i]!=null)
	 		{
	 			System.out.printf(" %-10s %-20s %-6s %-12s %-12s %-10s %-10s \n",s[i].getStaffID(),s[i].getStaffName(),s[i].getGender(),s[i].getDOB(),s[i].getStartDate(),s[i].getPosition(),s[i].getSalary());
	 			count++;
	 		}
	 	}
	 		System.out.println("\n\nTotal staff is "+Staff.getNum());
	 		System.out.printf("\n\n %s \n\n","-----------END OF REPORT-----------");

	 		char ans;
			do
			{
				System.out.println("Press enter to continue.......");
				clrBuf=scan.nextLine();
				System.out.print("Need to make change on report ? (Y/N) ");
		 		ans= scan.nextLine().charAt(0);
		 		ans=Character.toUpperCase(ans);
		 		if (ans=='Y')
			 	{
					reportChange(count);
					System.out.printf("\n\n\n\n %-20s \n",super.getCompanyName());
	 				System.out.println(" "+super.getDate());
	 				System.out.println(" Product Report ");
	 				System.out.printf(" %-10s %-20s %-6s %-12s %-12s %-10s -10s \n","Staff_ID","Staff_Name","Gender","Birth_Date","Start_Date","Position","Salary(RM)");
	 				System.out.println(" ----------------------------------------------------------------------------------------------");
				 	for(int i=0;i<s.length;i++)
	 				{
	 					if(s[i]!=null)
	 					{
	 						System.out.printf(" %-10s %-20s %-6s %-12s %-12s %-10s %-10s \n",s[i].getStaffID(),s[i].getStaffName(),s[i].getGender(),s[i].getDOB(),s[i].getStartDate(),s[i].getPosition(),s[i].getSalary());
	 					}
	 				}

				 	System.out.printf("\n\n %s \n\n","-----------END OF REPORT-----------");
				 	System.arraycopy(s2,0,s,0,s2.length);

		 		}
			}while(ans!='N');
	}
	private void reportChange(int count)
	{
	 		int choose;//for menu
	 		int choice;//for action
		 	System.out.println("Change display of report");
		 	System.out.println("1. Order by Name ");
		 	System.out.println("2. Order by Working years");
		 	System.out.println("3 or Other key back to original report...");
		 	System.out.print("Please enter your choice : ");
		 	choose=scan.nextInt();

		 	if(choose==1)
		 	{
		 		do
		 		{
			 		System.out.println("Order by Name ");
					System.out.println("1. A TO Z");
			 		System.out.println("2. Z TO A");
			 		System.out.print("Please enter your choice : ");
			 		choice=scan.nextInt();
			 		if (choice==1)
			 			namexX(count);
			 		else if (choice==2)
			 			nameXx(count);
		 		}while (choice!= 1 && choice !=2);
		 	}
		 	else if(choose==2)
		 	{
		 		do
		 		{
			 		System.out.println("Order by Working year ");
			 		System.out.println("1. less TO more");
			 		System.out.println("2. more TO less");
			 		System.out.print("Please enter your choice : ");
			 		choice=scan.nextInt();
			 		if (choice==1)
			 			yearWorkxX(count);
			 		else if (choice==2)
			 			yearWorkXx(count);
		 		}while (choice!= 1 && choice !=2);
		 	}
	}


	private void namexX(int count)
		 {
	 		for (int i = 0; i < count; i++)
			{
				for (int j = i + 1; j < count; j++)
				{
					int a;
					Staff temp;
					a = s[i].compareTo(s[j]);
					if (a > 0)
					{
						temp = s[i];
						s[i] = s[j];
						s[j] = temp;
					}
				}
			}
		}
	 //big to small id
	 	 private void nameXx(int count)
		 {
		 		for (int i = 0; i < count; i++)
				{
					for (int j = i + 1; j < count; j++)
						{
							int a;
							Staff temp;
							a = s[i].compareTo(s[j]);
							if (a < 0)
							{
								temp = s[i];
								s[i] = s[j];
								s[j] = temp;
							}
						}
				}

		 }

	private void yearWorkxX(int count)
	 {
	 		for (int i = 0; i < count; i++)
			{

				for (int j = i + 1; j < count; j++)
					{
						Staff temp;
						Date a=s[i].getDStartDate();
						Date b=s[j].getDStartDate();
						if (a.before(b))
						{
							temp = s[i];
							s[i] = s[j];
							s[j] = temp;
						}
					}



	 		}
	 }

	 private void yearWorkXx(int count)
	 {
	 		for (int i = 0; i < count; i++)
			{

				for (int j = i + 1; j < count; j++)
					{
						Staff temp;
						Date a=s[i].getDStartDate();
						Date b=s[j].getDStartDate();
						if (a.after(b))
						{
							temp = s[i];
							s[i] = s[j];
							s[j] = temp;
						}
					}



	 		}
	 }



	public String toString()
	 {
	 	return String.format("This is Staff Report");
	 }


}
