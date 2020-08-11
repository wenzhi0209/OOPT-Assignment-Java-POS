import java.util.*;
public class UserMenu {

	public static User[] u;
	private Staff[] s=new Staff[StaffMenu.s.length];//for check each staff each acc
	int ans;
	Scanner scan = new Scanner(System.in);
	String clrBuf;

	public void menu()
	{
		s=StaffMenu.s;
		boolean endMenu=false;
		char type;

			while(endMenu==false)
			{
				CScreen.clear();
		    	System.out.println("USER CONTROL MENU :");
		    	System.out.println("1. View user");
		    	System.out.println("2. Add user");
		    	System.out.println("3. Edit user");
		    	System.out.println("4. Delete user");
		    	System.out.printf("5. Exit \n\n");
		    	System.out.print("Your choose : ");
		    	ans = scan.nextInt();
		    	// inside this class if i choose  1 then call *sales report(class)*
		    	if(ans==1)
		    	{
		    		int no=1;
		    		for(int i=0;i<u.length;i++)
		    		{
		    			if(u[i]!= null)
		    			{
		    				System.out.println(no+"  "+u[i].toString());
		    				no++;
		    			}
		    		}

		    	}
		    	else if(ans==2)
		    	{
		    		int ans2;
		    		System.out.println("Which type of user will be add in ?");
		    		System.out.println("1. MANAGER ");
		    		System.out.println("2. STAFF  ");
		    		ans2=scan.nextInt();
		    		if(ans2==1)
		    		{
		    			type='A';
						clrBuf=scan.nextLine();
			    		System.out.print("Please enter your admin ID : ");
			    		String adminID=scan.nextLine();

			    		System.out.print("Please enter your password : ");
			    		String adminPassword=scan.nextLine();


			    		boolean isAdmin=User.validatePassword(type,u,adminID,adminPassword);
			    		if(isAdmin!=false)
			    		{
			    			addMenu(1);
			    		}
		    		}
		    		else if(ans2==2)
		    		{
		    			addMenu(2);
		    		}



		    	}
		    	else if(ans==3)
		    	{
		    		int no=1;
		    		for(int i=0;i<u.length;i++)
		    		{
		    			if(u[i]!= null)
		    			{
		    				System.out.println(no+"  "+u[i].toString());
		    				no++;
		    			}
		    		}

		    		int ans2;
		    		System.out.println("Which user you need to edit (1-"+(no-1)+") ?");
		    		ans2=scan.nextInt();

		    		System.out.println(u[ans2-1]);

		    		if(u[ans2-1].getID().charAt(0)=='M')
		    		{
		    			System.out.println("You will need an Admin account to edit User(manager) ");
		    			type='A';
						clrBuf=scan.nextLine();
			    		System.out.print("Please enter your Admin ID : ");
			    		String adminID=scan.nextLine();

			    		System.out.print("Please enter your password : ");
			    		String adminPassword=scan.nextLine();


			    		boolean validation=User.validatePassword(type,u,adminID,adminPassword);
			    		if(validation==true)
			    		{
			    			System.out.println(u[ans2-1] + "  Password : "+u[ans2-1].getPassword());
			    			System.out.println("\n Which Part need to edit ?");
			    			System.out.println("1.USER ID ");
			    			System.out.println("2.Password");
			    			int ans3=scan.nextInt();
			    			if(ans3==1)
			    			{
			    				clrBuf=scan.nextLine();
			    				System.out.printf("Please enter the NEW ID : ");
			    				String s=scan.nextLine();
			    				u[ans2-1].setID(s);
			    			}
			    			else if(ans3==2)
			    			{
			    				clrBuf=scan.nextLine();
			    				System.out.printf("Please enter the NEW Password : ");
			    				String s=scan.nextLine();
			    				u[ans2-1].setPassword(s);
			    			}
			    		}
		    		}

		    		else if(u[ans2-1].getID().charAt(0)=='S')
		    		{
		    			System.out.println("You will need an Admin/Manager account to edit User(Staff) ");
		    			type='M';
						clrBuf=scan.nextLine();
			    		System.out.print("Please enter your Admin/Manager ID : ");
			    		String adminID=scan.nextLine();

			    		System.out.print("Please enter your password : ");
			    		String adminPassword=scan.nextLine();


			    		boolean validation=User.validatePassword(type,u,adminID,adminPassword);
			    		if(validation==true)
			    		{
			    			System.out.println(u[ans2-1] + "  Password : "+u[ans2-1].getPassword());
			    			System.out.println("\n Which Part need to edit ?");
			    			System.out.println("1.USER ID ");
			    			System.out.println("2.Password");
			    			int ans3=scan.nextInt();
			    			if(ans3==1)
			    			{
			    				boolean isSame;
			    				String newID;
		    					do
								{
									isSame=false;
									clrBuf=scan.nextLine();
							    	System.out.printf("Please enter NEW ID : ");
									newID=scan.next();
								    for(int i=0;i<u.length;i++)
									 {
									 	if(u[i]!=null)
									 	{
									 		if(newID.equals(u[ans2-1].getID()))//allow enter back old id
									 			break;

									 		else if(newID.equals(u[i].getID()))
									 		{
									 			isSame=true;
									 			break;
									 		}
									 	}
									 }
									 if(isSame==true)
									 	System.out.println("This ID is not valid,please enter again...");
								}while(isSame==true);
		    					u[ans2-1].setID(newID);
		    					System.out.println("SET DONE");


			    			}
			    			else if(ans3==2)
			    			{
			    				clrBuf=scan.nextLine();
			    				System.out.printf("Please enter the NEW Password : ");
			    				String s=scan.nextLine();
			    				u[ans2-1].setPassword(s);
			    				System.out.println("SET DONE");
			    			}
			    		}
		    		}
		    		else
		    			System.out.println("You are not able to edit this User !!!");





		    	}
		    	else if(ans==4)
		    	{
		    		int no=1;
		    		for(int i=0;i<u.length;i++)
		    		{
		    			if(u[i]!= null)
		    			{
		    				System.out.println(no+"  "+u[i].toString());
		    				no++;
		    			}
		    		}

		    		int ans2;
		    		System.out.println("Which user need to DELETE (1-"+(no-1)+") ?");
		    		ans2=scan.nextInt();

		    		System.out.println(u[ans2-1]);

		    		if(u[ans2-1].getID().charAt(0)=='M')
		    		{
		    			System.out.println("You will need an Admin account to DELETE User(manager) ");
		    			type='A';
						clrBuf=scan.nextLine();
			    		System.out.print("Please enter your Admin ID : ");
			    		String adminID=scan.nextLine();

			    		System.out.print("Please enter your password : ");
			    		String adminPassword=scan.nextLine();


			    		boolean validation=User.validatePassword(type,u,adminID,adminPassword);
			    		if(validation==true)
			    		{
			    			u[ans2-1] = null;
			    			System.out.println("User DELETED");
			    			User[] temp=new User[100];
							int x=0;
					  		for(int i=0;i<no-1;i++)
					    	{
								if(x>=s.length)
					    		{
						    		temp[i]=null;
						    		break;
						    	}

					       		else if(u[x]!=null)
					       		{
					    			temp[i]=u[x];

					       		}
					    		else
					    		{
						    		temp[i]=u[x+1];
						    		x++;
						    	}

						    	x++;
					    	}

					    	u=temp;
			    		}
		    		}

		    		else if(u[ans2-1].getID().charAt(0)=='S')
		    		{
		    			System.out.println("You will need an Admin/Manager account to edit User(Staff) ");
		    			type='M';
						clrBuf=scan.nextLine();
			    		System.out.print("Please enter your Admin/Manager ID : ");
			    		String adminID=scan.nextLine();

			    		System.out.print("Please enter your password : ");
			    		String adminPassword=scan.nextLine();


			    		boolean validation=User.validatePassword(type,u,adminID,adminPassword);
			    		if(validation==true)
			    		{
			    			u[ans2-1] = null;
			    			System.out.println("User DELETED");
			    			User[] temp=new User[100];
							int x=0;
					  		for(int i=0;i<no-1;i++)
					    	{
								if(x>=s.length)
					    		{
						    		temp[i]=null;
						    		break;
						    	}

					       		else if(u[x]!=null)
					       		{
					    			temp[i]=u[x];

					       		}
					    		else
					    		{
						    		temp[i]=u[x+1];
						    		x++;
						    	}

						    	x++;
					    	}

					    	u=temp;
			    		}
		    		}

		    	}
		    	else if(ans==5)
		    	{
		    		endMenu=true;
		    	}
	    	}
	}

	private void addMenu(int type)
	{
		String name2=null;//pass real staff name
		String id;

			clrBuf=scan.nextLine();
		    System.out.printf("Please enter Employee Name : ");
		    String name=scan.nextLine();

			if(type==1)
			{
			do
			{
				clrBuf=scan.nextLine();
		    	System.out.printf("Please enter ID : ");
				 id=scan.nextLine();
			}while(id.charAt(0)!='M');
			}

			else
			{
			do
			{
				clrBuf=scan.nextLine();
		    	System.out.printf("Please enter ID : ");
				id=scan.nextLine();
			}
		    while(id.charAt(0)!='S');
			}

			boolean validation=false;
			String nameS=null;
			String idU=null;
			String nameU=null;


			for(int i=0;i<s.length;i++)
			{
				if(s[i]!=null)
				{
				 nameS =s[i].getStaffName();//from staff
				 name2 =nameS;
			 	 nameS =nameS.toUpperCase();
				}
				if(u[i]!=null)
				{
				 nameU =u[i].getName();//from user
				 nameU =nameU.toUpperCase();
				 idU=u[i].getID();
				}

				name=name.toUpperCase();

				if(name.equals(nameU)==true)
				{
					validation=false;
					System.out.println("this employee already is a user.");
				}
					else if(name.equals(nameS)==true&&id.equals(idU)==false)
					{
						if(s[i].getPosition().equals("Executive"))
						{
							if(id.charAt(0)=='S')
								validation=true;
						}
						else if(s[i].getPosition().equals("Manager"))
						{
							if(id.charAt(0)=='M')
								validation=true;
						}
						else
							validation=false;

						break;
					}

				}


					if(validation==true)
					{
						System.out.printf("Please enter Password : ");
						String password=scan.nextLine();
						u[User.getNum()]=new User(id,password,name2);
						System.out.println("Succesfully, user created");

					}
					else
					{
						System.out.println("Fail Create User.Did not have specify employee.");
						System.out.println("This also might be your user ID already exits or user type not valid");
					}

	}
}
