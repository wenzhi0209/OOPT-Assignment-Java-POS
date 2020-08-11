import java.util.*;
public class ReportMenu {


	public static void menu(int reportType)
	{
		SalesReport rs1=new SalesReport();
		MembershipReport mb1=new MembershipReport();
		ProductReport pr1=new ProductReport();
		StaffReport sr1=new StaffReport();
		boolean endMenu=false;
		if(reportType==1)
		{
			int ans;
			Scanner scan = new Scanner(System.in);

			while(endMenu==false)
			{
				CScreen.clear();
		    	System.out.println("Please choose the report need to produce :");
		    	System.out.println("1. Sales Report");
		    	System.out.println("2. Membership Report");
		    	System.out.println("3. Product Report");
		    	System.out.println("4. Staff Report");
		    	System.out.printf("5. Exit \n\n");
		    	System.out.print("Your choose : ");
		    	ans = scan.nextInt();
		    	// inside this class if i choose  1 then call *sales report(class)*
		    	if(ans==1)
		    	{
		    		rs1.getReport();
		    	}
		    	else if(ans==2)
		    	{
					mb1.getReport();
		    	}
		    	else if(ans==3)
		    	{
					pr1.getReport();
		    	}
		    	else if(ans==4)
		    	{
		    		sr1.getReport();
		    	}
		    	else if(ans==5)
		    	{
		    		endMenu=true;
		    	}
	    	}
		}

		else if(reportType==2)
		{
			int ans;
			Scanner scan = new Scanner(System.in);


			while(endMenu==false)
			{
				CScreen.clear();
		    	System.out.println("Please choose the report need to produce :");
		    	System.out.println("1. Product Report");
		    	System.out.println("2. Daily Sales Report");
		    	System.out.printf("3. Exit \n\n");
		    	System.out.print("Your choose : ");
		    	ans = scan.nextInt();
		    	// inside this class if i choose  1 then call *sales report(class)*
		    	if(ans==1)
		    	{
		    		pr1.getReport();
		    	}

		    	if(ans==2)
		    	{
		    		rs1.getDailyReport();
		    	}

		    	else if(ans==3)
		    	{
		    		endMenu=true;
		    	}
	    	}
		}




	}
}
