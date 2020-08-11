import java.util.*;
public class StaffMenu {
    public static Staff[] s;


   	public void adminStaffMenu()
   	{  Scanner scanner = new Scanner(System.in);
   		int choice;
   		String clrBuf;
   		do
   		{
       	System.out.println("\nOptions");
       	System.out.println("-------");
    	System.out.println("Staff Page");
       	System.out.println("1) View");
       	System.out.println("2) Add");
       	System.out.println("3) Edit");
       	System.out.println("4) Delete");
       	System.out.println("5) Exit");

   		System.out.print("Enter Option : ");
 		 choice = scanner.nextInt();

 		while(choice < 1 ||choice > 5)
 		{
 			System.out.println("Invalid option, please try again.");
    		System.out.print("Enter Option : ");
 			choice = scanner.nextInt();
 		}

		    	if(choice==1)
		    	{

		    		System.out.println("\n*******************");
         			System.out.println("*  STAFF DETAILS  *");
             		System.out.println("*******************\n");
		    		System.out.println("NO STAFF ID   NAME            GENDER    DOB             START DATE      POSITION        SALARY(RM)");
		    		System.out.println("-- ---------- --------------- --------- --------------- --------------- --------------- ----------");

		    		for(int i=0; i < s.length ; i++)
		    		{
		    			if(s[i]!=null)
		    			{
		    				System.out.printf("%2d %-10s %-15s %-6s    %-15s %-15s %-15s %-10.2f \n",
		    				(i+1),s[i].getStaffID(),s[i].getStaffName(),s[i].getGender(),s[i].getDOB(), s[i].getStartDate(), s[i].getPosition(), s[i].getSalary());
		    			}
		    		}



		    	}
		    	else if (choice==2)
		    	{
		    		for(int i = 0 ; i < s.length ; i++)
		    		{
		    			if(s[i] == null){
		    				s[i] = new Staff();
		    				clrBuf = scanner.nextLine();
		    				int num=Staff.getNum();
		    				String staffID=null;
		    				if(num<10)
		    				{
		    					System.out.println("Current ID: "+"S00"+num);
		    			    	staffID = String.format("S00"+num);
		    				}
				            else if(num>=10)
		                    {
		                    	System.out.println("Current ID: "+"S0"+num);
				    			staffID = String.format("S0"+num);
		                    }

							clrBuf = scanner.nextLine();
		    				System.out.print("Enter Name: ");
		    				String staffName = scanner.nextLine();
		  			  		System.out.print("Enter Gender (M/F) : ");
		   			 		char staffGender = scanner.nextLine().charAt(0);
		   			 		staffGender=Character.toUpperCase(staffGender);
		   			 		while(staffGender!='M'&&staffGender!='F')
		   			 		{

		   			 			System.out.println("Input Invalid !");
		   			 			System.out.print("Enter Gender (M/F) : ");
		   			 			staffGender = scanner.nextLine().charAt(0);
		   			 			staffGender=Character.toUpperCase(staffGender);

		   			 		}


		    				System.out.print("Enter DOB (DD-MM-YYYY) : ");
		    				String DOB = scanner.next();
		    				System.out.print("Enter Start Date (DD-MM-YYYY) : ");
		    				String startDate = scanner.next();
		    				clrBuf = scanner.nextLine();
		    				System.out.print("Enter Position: ");
		    				String position = scanner.nextLine();
		    				System.out.print("Enter Salary Per month: ");
		    				double salary = scanner.nextDouble();

		    				s[i] = new Staff(staffID,staffName,staffGender,DOB,startDate,position,salary);

		    				System.out.println("\nThe new staff you add is ");
		    				System.out.println("Staff ID = " + s[i].getStaffID());
		    				System.out.println("Staff Name = " + s[i].getStaffName());
		    				System.out.println("Staff Gender = "+ s[i].getGender());
		    				System.out.println("Staff DOB = " + s[i].getDOB());
		    				System.out.println("Staff Start Work Date = "+ s[i].getStartDate());
		    				System.out.println("Staff Position = "+ s[i].getPosition());
		    				System.out.println("Staff Salary = "+ s[i].getSalary());
		    				break;
		    				}
		    		}
		    	}


		    	else if (choice==3)
		    	{
		    		int number=1;
		    		int ans;
		    		int choose;



		    		System.out.println("NO STAFF ID   NAME            GENDER    DOB             START DATE      POSITION        SALARY(RM)");
		    		System.out.println("-- ---------- --------------- --------- --------------- --------------- --------------- ----------");

		    		for(int i=0; i < s.length ; i++)
		    		{
		    			if(s[i]!=null)
		    			{
		    				System.out.printf("%2d %-10s %-15s %-6s    %-15s %-15s %-15s %-10.2f \n",
		    				(i+1),s[i].getStaffID(),s[i].getStaffName(),s[i].getGender(),s[i].getDOB(), s[i].getStartDate(), s[i].getPosition(), s[i].getSalary());
		    			}
		    		}


		    		System.out.println("Which staff you want to edit (Enter No)? ");
		    		ans=scanner.nextInt();
		    		System.out.println(ans+" " + s[ans-1].toString());

					do{
		    		System.out.println("1.Edit staff ID");
		    		System.out.println("2.Edit staff name");
		    		System.out.println("3.Edit staff gender");
		    		System.out.println("4.Edit staff DOB");
		    		System.out.println("5.Edit staff start work date");
		    		System.out.println("6.Edit staff position");
		    		System.out.println("7.Edit staff salary");
		    		System.out.println("8.Exit");


		    			System.out.print("Enter Option : ");
		    			choose=scanner.nextInt();


   						if(choose == 1){
   							clrBuf = scanner.nextLine();
   							System.out.print("Enter new ID >");
   							String newID = scanner.nextLine();
   							s[ans-1].setStaffID(newID);
   						}
   						if(choose == 2){
   							clrBuf = scanner.nextLine();
   							System.out.print("Enter new name >");
   							String newName = scanner.nextLine();
   							s[ans-1].setStaffName(newName);
   						}

   						else if(choose == 3){
   							clrBuf = scanner.nextLine();
   							System.out.print("Enter new gender (M/F) >");
   							char newGender = scanner.nextLine().charAt(0);
		   			 		newGender=Character.toUpperCase(newGender);
		   			 		while(newGender!='M'&&newGender!='F')
		   			 		{
		   			 			System.out.println("Input Invalid !");
		   			 			System.out.print("Enter new gender (M/F)> ");
		   			 			newGender = scanner.nextLine().charAt(0);
		   			 			newGender=Character.toUpperCase(newGender);

		   			 		}
		   			 		s[ans-1].setGender(newGender);
   						}

   						else if(choose == 4){
   							clrBuf = scanner.nextLine();
   							System.out.print("Enter new DOB (DD-MM-YYYY) >");
   							String newDOB = scanner.nextLine();
   							s[ans-1].setDOB(newDOB);
   						}

   						else if(choose == 5){
   							clrBuf = scanner.nextLine();
   							System.out.print("Enter new Start Work date (DD-MM-YYYY) >");
   							String newStartDate = scanner.nextLine();
   							s[ans-1].setStartDate(newStartDate);
   						}

   						else if(choose == 6){
   							clrBuf = scanner.nextLine();
   							System.out.print("Enter new position >");
   							String newPosition = scanner.nextLine();
   							s[ans-1].setPosition(newPosition);
   						}

   						else if(choose == 7){
   							clrBuf = scanner.nextLine();
   							System.out.print("Enter new salary >");
   							double newSalary = scanner.nextDouble();
   							s[ans-1].setSalary(newSalary);
   						}

   						else if(choose == 8){
   							break;
   						}

   						if(choose < 1 ||choose > 8)
    					System.out.println("Invalid option, please try again.");
   						}while(choose!=8);

					System.out.println("New :\n" + s[ans-1].toString());
		    	}







		    	else if (choice==4)
		    	{
					int number=1;
		    		int ans;





		    		System.out.println("NO STAFF ID   NAME            GENDER    DOB             START DATE      POSITION        SALARY(RM)");
		    		System.out.println("-- ---------- --------------- --------- --------------- --------------- --------------- ----------");

		    		for(int i=0; i < s.length ; i++)
		    		{
		    			if(s[i]!=null)
		    			{
		    				System.out.printf("%2d %-10s %-15s %-6s    %-15s %-15s %-15s %-10.2f \n",
		    				(i+1),s[i].getStaffID(),s[i].getStaffName(),s[i].getGender(),s[i].getDOB(), s[i].getStartDate(), s[i].getPosition(), s[i].getSalary());
		    				number++;
		    			}
		    		}
		    		System.out.println("Which staff you want to delete ? ");
		    		ans=scanner.nextInt();
		    		System.out.println(ans+" " + s[ans-1].toString());

					System.out.println("Do you confirm to delete this staff (Y/N)?");
					clrBuf=scanner.nextLine();
					char confirm = scanner.nextLine().charAt(0);

					if(confirm == 'Y'||confirm == 'y'){

					//User[] u=UserMenu.u;
			    	//if()

					s[ans-1] = null;
					Staff[] temp=new Staff[100];
					int x=0;
			  		for(int i=0;i<number-1;i++)
			    	{
						if(x>=s.length)
			    		{
				    		temp[i]=null;
				    		break;
				    	}

			       		else if(s[x]!=null)
			       		{
			    			temp[i]=s[x];

			       		}
			    		else
			    		{
				    		temp[i]=s[x+1];
				    		x++;
				    	}

				    	x++;
			    	}

			    	s=temp;



		   		}
		    	else
		    	{
		    		System.out.println("Thank you");
		    	}
		    	}

		    	else if (choice==5)
		    	{
		    		System.out.println("Thanks you, have a nice day.");
		    	}
		    	else
	    			System.out.println("Invalid input");

	    	}while(choice!=5);







    }
	public void normalStaffMenu()
   		{
    		Scanner scanner = new Scanner(System.in);

    		int choice;
   			String clrBuf;
   			do
   			{
       		System.out.println("\nOptions");
       		System.out.println("-------");
    		System.out.println("Staff Page");
       		System.out.println("1) View");
       		System.out.println("2) Exit");


   			System.out.print("Enter Option : ");
 			choice = scanner.nextInt();

 			while(choice < 1 ||choice > 2)
 			{
 				System.out.println("Invalid option, please try again.");
    			System.out.print("Enter Option : ");
 				choice = scanner.nextInt();
 			}


   		 	if (choice==1)
			{

    		System.out.println("\n*******************");
    		System.out.println("*  STAFF DETAILS  *");
			System.out.println("*******************\n");
			System.out.println("NO NAME            GENDER      DOB               START DATE      POSITION");
			System.out.println("-- --------------- ------   ---------------   --------------- ---------------");


				for (int i = 0; i < s.length; i++)
        		{
        			if(s[i]!=null)
		    		{
		    			System.out.printf("%2d %-15s %-5s  %-15s %-15s %-15s \n",(i+1),s[i].getStaffName(),s[i].getGender(), s[i].getDOB(),s[i].getStartDate(), s[i].getPosition());

		    		}
		   	 	}
			}

		    else if (choice==2)
		    {
		    	System.out.println("Thanks you, have a nice day.");
		    }
		    else
	    		System.out.println("Invalid input");

	   }while(choice!=2);
   		}

}
