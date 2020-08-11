/**
 * @(#)Assignment.java
 *
 * Assignment application
 *
 * @author
 * @version 1.00 2019/7/7
 */
 import java.util.*;
 import java.text.*;


public class Assignment {

public static int d = 0;

    public static void main(String[] args) {

	    Member[] m = new Member[10];
	    m[0]= new Member("F001", "John", "01/03/1998", "21/01/2015", "0191234567", 2000);
	    m[1]= new Member("F002", "Jane", "01/08/1998", "22/05/2019", "0191234567", 500);
	    m[2]= new Member("F003", "Mames", "01/07/1998", "01/04/2011", "0191234567", 3000);
	    m[3]= new Member("F004", "Aunior", "01/05/1998", "20/12/2016", "0191234567", 1500);

	    Product[] p = new Product[1000];

    	p[0] = new Product("Shirt A",789,30.90,"SHA0000",50.90,211);
		p[1] = new Product("Shirt B",801,35.90,"SHB0000",56.90,99);
		p[2] = new Product("Blouse A",712,40.90,"BLA0000",62.90,88);
		p[3] = new Product("Blouse B",623,45.90,"BLB0000",68.90,77);
		p[4] = new Product("Pants A",534,50.90,"PAA0000",74.90,66);
		p[5] = new Product("Pants B",445,55.90,"PAB0000",80.90,55);
		p[6] = new Product("Dress A",356,60.90,"DRA0000",86.90,44);
		p[7] = new Product("Dress B",267,65.90,"DRB0000",92.90,33);
		p[8] = new Product("Jeans A",178,70.90,"JEA0000",98.90,22);
		p[9] = new Product("Jeans B",89,75.90,"JEB0000",104.90,11);


		Staff[] s = new Staff[100];
 		s[0] = new Staff("S001","Alex Ong", 'M', "10-04-1990", "01-01-2017", "Manager", 4000);
 		s[1] = new Staff("S002","Kent Ng", 'M', "15-02-2000", "01-05-2017", "Executive", 3000);
 		s[2] = new Staff("S003","Calvin Chong",'M', "15-09-2000", "01-02-2018", "Executive", 2500);
 		s[3] = new Staff("S004","Yuke Wong", 'F', "19-03-1997", "01-04-2018", "Executive", 2500);
 		s[4] = new Staff("S005","Fang Lim", 'F', "07-03-1996", "01-05-2018", "Executive", 2500);

		User[] user= new User[100];
    	user[0]= new User("A001","A27062000","HAN SHEN");
    	user[1]= new User("M001","12345678","Alex Ong");
    	user[2]= new User("S001","S09022000","Kent Ng");

    	ProductSell[] ps = new ProductSell[1000];
		ps[0] = new ProductSell("SHA0000","Shirt A",111,50.90,stringToDate("29-07-2019"));
		ps[1] = new ProductSell("SHB0000","Shirt B",99,56.90,stringToDate("29-07-2019"));
		ps[2] = new ProductSell("BLA0000","Blouse A",88,62.90,stringToDate("29-07-2019"));
		ps[3] = new ProductSell("BLB0000","Blouse B",77,68.90,stringToDate("30-07-2019"));
		ps[4] = new ProductSell("PAA0000","Pants A",66,74.90,stringToDate("30-07-2019"));
		ps[5] = new ProductSell("PAB0000","Pants B",55,80.90,stringToDate("30-07-2019"));
		ps[6] = new ProductSell("DRA0000","Dress A",44,86.90,stringToDate("31-07-2019"));
		ps[7] = new ProductSell("DRB0000","Dress B",33,92.90,stringToDate("31-07-2019"));
		ps[8] = new ProductSell("JEA0000","Jeans A",22,98.90,stringToDate("31-07-2019"));
		ps[9] = new ProductSell("JEB0000","Jeans B",11,104.90,stringToDate("01-08-2019"));
		ps[10] = new ProductSell("SHA0000","Shirt A",100,50.90,stringToDate("01-08-2019"));

       MemberMenu.m=m;//JANG JUE
       //let other class get these Product array list
		AddProduct.p = p;
		DeleteProduct.p = p;
		EditProduct.p = p;
		IncomingGoods.p = p;
		PointOfSale.p = p;
		ViewProductDetail.p = p;
       //WEI MING
       StaffMenu.s=s;//JIA KENT
       UserMenu.u=user;//for control user
	   PointOfSale.p = p;
       PointOfSale.ps = ps;
	   ProductSell.ps = ps;

    	Scanner scan=new Scanner(System.in);
    	int signIn;
    	int choice;
    	boolean endUser;
    	boolean endPro=false;//for exit whole system
    	String clrBuf;

		boolean validation;
    	String id;
    	String password;
    	char type;

    	MemberMenu mMenu=new MemberMenu();
    	StaffMenu sMenu=new StaffMenu();
    	UserMenu uMenu=new UserMenu();
    	ProductMenu pMenu = new ProductMenu();



//use while loop to replace all doWhile loop instead to use system

    	while (endPro==false)
    	{
    		endUser=false;
	    	System.out.println("Sign in as :");
	    	System.out.println("1.Manager");
	    	System.out.println("2.Normal staff");
	    	System.out.println("3.Exit");
	    	System.out.print("Please enter your choice : ");
	    	signIn = scan.nextInt();



//
			if(signIn==1)//put in all task can do by administrator
	    	{
	    		type='M';
				clrBuf=scan.nextLine();
	    		System.out.print("Please enter your ID : ");
	    		id=scan.nextLine();

	    		System.out.print("Please enter your password : ");
	    		password=scan.nextLine();


	    		validation=User.validatePassword(type,user,id,password);
	    		if(validation!=false)
	    		{

		    		while(endUser==false&&validation==true)
		    		{
		    			CScreen.clear();
		    			System.out.println("Welcome administrator.");
			    		System.out.println("Continue to :");
					    System.out.println("1.Product");
					    System.out.println("2.Staff");
					    System.out.println("3.Member");
					    System.out.println("4.Report");
					    System.out.println("5.User");
			    		System.out.println("6.Exit");
			    		System.out.print("Please enter your choice : ");
			    		choice= scan.nextInt();

			    		if(choice==1)
			    		{
			    			//call product funtion choose menu (administrator);
			    			//show the menu see by administrator
			    			pMenu.adminProductMenu();
			    		}
			    		else if (choice==2)
			    		{
			    			//call staff funtion choose menu (administrator);
			    			//show the menu see by administrator
			    			sMenu.adminStaffMenu();

			    		}
			    		else if (choice==3)
			    		{
			    			mMenu.adminMenu();
			    			//call member function choose menu (administrator);
			    			//show the menu see by administrator

			    		}

			    		else if (choice==4)
			    		{
			    			//call report funtion choose menu(administrator);
			    			//show the menu see by administrator
			    			ReportMenu.menu(1);
			    		}
			    		else if (choice==5)
			    		{
			    			uMenu.menu();
			    		}

			    		else if (choice==6)
			    		{
			    			System.out.println("Thanks you, have a nice day. \n\n\n");
			    		    endUser=true;
			    		}
			    		else
		    				System.out.println("Invalid input");

		    		}
	    		}
	    		else
	    			System.out.println("Your user ID or password is not valid \n\n");

	    	}
	    	else if(signIn==2)//put in all task can do by staff
	    	{

	    		type='S';//between only at here
				clrBuf=scan.nextLine();
	    		System.out.print("Please enter your ID : ");
	    		id=scan.nextLine();

	    		System.out.print("Please enter your password : ");
	    		password=scan.nextLine();//


	    		validation=User.validatePassword(type,user,id,password);
	    		if(validation==false)
	    			System.out.println("Your user ID or password is not valid \n\n");

				else
				{
		    		while(endUser==false)
		    		{
			    		System.out.println("Welcome staff.");
			    		System.out.println("Continue to :");
		   				System.out.println("1.Product");
					    System.out.println("2.Staff");
					    System.out.println("3.Member");
					    System.out.println("4.Report");
					    System.out.println("5.Exit");
			    		System.out.print("Please enter your choice : ");
			    		choice= scan.nextInt();
			    		if(choice==1)
				    	{
				    	//call product funtion choose menu (staff);
				    	//show the menu see by staff
				    	pMenu.staffProductMenu();
				    	}
				    	else if (choice==2)
				    	{
				    			//call staff funtion choose menu (staff);
				    				//show the menu see by staff
				    		sMenu.normalStaffMenu();
				    	}
				    	else if (choice==3)
				    	{
				    		//call member function choose menu (staff);
				    			//show the menu see by staff
				    		mMenu.staffMenu();
				    	}

				    	else if (choice==4)
				    	{
				    		// example call report menu
				    		//i call my report menu out first with *report.java(class)*
				    		//staff only can view daily sales and product report
				    		ReportMenu.menu(2);


				    	}

				    	else if (choice==5)
				    	{

				    		System.out.println("Thanks you, have a nice day. \n\n\n");
				    		endUser=true;

				    	}
				    	else
			    			System.out.println("Invalid input \n");

		    		}
				}

	    	}
	    //
	    	else if(signIn==3)
	    	{	System.out.println("\n\n\n Thanks you, have a nice day. ");
	    		endPro=true;

	    	}
	    	else
	    		System.out.println("Invalid input \n");

    	}
    }//

    public static void test(Date s)
    {
    	SimpleDateFormat formatter;
    	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    	System.out.println(format.format(s));
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


}
