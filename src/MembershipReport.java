import java.util.*;
public class MembershipReport extends Report {

	private Member[] m=new Member[MemberMenu.m.length];
	private Member[] m2;



	 public MembershipReport(){
	 }


	 public void getReport()
	 {
	 	int count=0;
	 	System.arraycopy(MemberMenu.m,0,m,0,MemberMenu.m.length);
	 	m2= MemberMenu.m;
	 	System.out.printf("\n\n\n\n %-20s \n",super.getCompanyName());
	 	System.out.println(" "+super.getDate());
	 	System.out.println(" Membership Report ");
	 	System.out.printf(" %-10s %-10s %-15s %-12s %-12s %-6s \n","Member_ID","Name","Date_Of_Birth","Date_Join","Phone_No","Available Points");
	 	System.out.println("----------------------------------------------------------------------------------------------");
	 	for(int i=0;i<m.length;i++)
	 	{

	 		if(m[i]!=null)
	 		{
	 			System.out.printf(" %-10s %-10s %-15s %-12s %-12s %-6d \n",m[i].getID(),m[i].getName(),m[i].getDOB(),m[i].getDateJoin(),m[i].getPhoneNo(),m[i].getPoints());
	 			count++;
	 		}
	 	}

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
				 	System.out.println(" Membership Report ");
				 	System.out.printf(" %-10s %-10s %-15s %-12s %-12s %-6s \n","Member_ID","Name","Date_Of_Birth","Date_Join","Phone_No","Available Points");
				 	System.out.println("----------------------------------------------------------------------------------------------");
				 	for(int i=0;i<m.length;i++)
				 	{

				 		if(m[i]!=null)
				 		{
				 			System.out.printf(" %-10s %-10s %-15s %-12s %-12s %-6d \n",m[i].getID(),m[i].getName(),m[i].getDOB(),m[i].getDateJoin(),m[i].getPhoneNo(),m[i].getPoints());
				 		}
				 	}

				 	System.out.printf("\n\n %s \n\n","-----------END OF REPORT-----------");
				 	System.arraycopy(m2,0,m,0,m2.length);

		 		}
			}while(ans!='N');

	 }
//count for pass in array length
//for limit the each of the for loop run time
	private void reportChange(int count){
	 		int choose;//for menu
	 		int choice;//for action
		 		System.out.println("Change display of report");
		 		System.out.println("1. Order by Name ");
		 		System.out.println("2. Specify Birth Month ");
		 		System.out.println("3. Order by Available point");
		 		System.out.println("Enter 4 or Other get back original report...");
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
		 			specifyMonthReport(count);

		 		else if(choose==3)
		 		{
		 			do
		 			{
			 			System.out.println("Order by ID ");
			 			System.out.println("1. less TO more");
			 			System.out.println("2. more TO less");
			 			System.out.print("Please enter your choice : ");
			 			choice=scan.nextInt();
			 			if (choice==1)
			 				orderPointxX(count);
			 			else if (choice==2)
			 				orderPointXx(count);
		 			}while (choice!= 1 && choice !=2);
		 		}

	 		}



	 //small to big name
	 private void namexX(int count)
	 {
	 		for (int i = 0; i < count; i++)
			{
				for (int j = i + 1; j < count; j++)
					{
						int a;
						Member temp;
						a = m[i].compareTo(m[j]);
						if (a > 0)
						{
							temp = m[i];
							m[i] = m[j];
							m[j] = temp;
						}
					}
			}

	 }
	 //big to small name
  private void nameXx(int count)
	 {
	 		for (int i = 0; i < count; i++)
			{
				for (int j = i + 1; j < count; j++)
					{
						int a;
						Member temp;
						a = m[i].compareTo(m[j]);
						if (a < 0)
						{
							temp = m[i];
							m[i] = m[j];
							m[j] = temp;
						}
					}
			}

	 }
	 //pending wait for complete version of jangjue

	 private void specifyMonthReport(int count)
	 {
	 	 Member[] birthGroup=new Member[10];// for specify report
		 System.out.print("Member Birth Month in : ");
		 	int choosen=scan.nextInt();
		 	for(int i=0;i<count;i++)
		 	{
			 		String[] birth=m[i].getDOB().split("/");//get string
			 		int date=Integer.parseInt(birth[1]);//get month

			 		if(date==choosen)
			 		{
			 			int j=0;
			 			birthGroup[j]=m[i];
			 			j++;
			 		}

		 	}
		 	m=birthGroup;
	 }


	 // small to big point
	 private void orderPointxX(int count)
	 {
	 		for (int i = 0; i < count; i++)
			{

				for (int j = i + 1; j < count; j++)
					{
						Member temp;
						if (m[i].getPoints()>m[j].getPoints())
						{
							temp = m[i];
							m[i] = m[j];
							m[j] = temp;
						}
					}



	 		}
	 }
	 //big to small point
	  private void orderPointXx(int count)
	 {
	 		for (int i = 0; i < count; i++)
			{
				for (int j = i + 1; j < count; j++)
					{
						Member temp;
						if (m[i].getPoints()<m[j].getPoints())
						{
							temp = m[i];
							m[i] = m[j];
							m[j] = temp;
						}
					}

			}

	 }

	  public String toString()
	 {
	 	return String.format("This is Membership Report");
	 }


}
