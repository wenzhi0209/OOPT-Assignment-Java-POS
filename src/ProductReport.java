import java.util.*;
public class ProductReport extends Report {

	private Product[] p=new Product[AddProduct.p.length];
	private Product[] p2;

	public void getReport()
	{
		int count=0;
	 	System.arraycopy(AddProduct.p,0,p,0,AddProduct.p.length);
	 	p2= AddProduct.p;
	 	System.out.printf("\n\n\n\n %-20s \n",super.getCompanyName());
	 	System.out.println(" "+super.getDate());
	 	System.out.println(" Product Report ");
	 	System.out.printf(" %-3s %-10s %-20s %-12s %-12s %-10s \n","No.","Product_ID","Product Description","Cost_Price","Sale_Price","Qty left");
	 	System.out.println(" ----------------------------------------------------------------------------------------------");

	 	for(int i=0;i<p.length;i++)
	 	{
	 		if(p[i]!=null)
	 		{
	 			System.out.printf("%-3d %-10s %-20s %-12s %-12s %-10s \n",(count+1),p[i].getProdID(),p[i].getProductDesc(),p[i].getUnitPrice(),p[i].getSellUnitPrice(),p[i].getQty());
	 			count++;
	 		}
	 	}
	 	System.out.println("\n\n Product should reorder (Quantity less than 200)");
	 	System.out.println(" ----------------------------------------------------------------------------------------------");

	 	for(int i=0;i<p.length;i++)
	 	{
	 		if(p[i]!=null)
	 		{
	 			if(p[i].getQty()<=200)
	 			{
	 				System.out.printf(" %-10s %-20s \n",p[i].getProdID(),p[i].getProductDesc());
	 			}

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
	 				System.out.println(" Product Report ");
	 				System.out.printf(" %-10s %-20s %-12s %-12s %-10s \n","Product_ID","Product Description","Cost_Price","Sale_Price","Qty left");
	 				System.out.println(" ----------------------------------------------------------------------------------------------");

				 	for(int i=0;i<p.length;i++)
	 				{
	 				if(p[i]!=null)
	 				{
	 					System.out.printf(" %-10s %-20s %-12s %-12s %-10s \n",p[i].getProdID(),p[i].getProductDesc(),p[i].getUnitPrice(),p[i].getSellUnitPrice(),p[i].getQty());
	 				}
	 				}

				 	System.out.printf("\n\n %s \n\n","-----------END OF REPORT-----------");
				 	System.arraycopy(p2,0,p,0,p2.length);

		 		}
			}while(ans!='N');

	}

		private void reportChange(int count){
	 		int choose;//for menu
	 		int choice;//for action
		 	System.out.println("Change display of report");
		 	System.out.println("1. Order by Name ");
		 	System.out.println("2. Order by Quantity left");
		 	System.out.println("3. Specify product report");
		 	System.out.println("4 or Other key back to original report...");
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
			 		System.out.println("Order by ID ");
			 		System.out.println("1. less TO more");
			 		System.out.println("2. more TO less");
			 		System.out.print("Please enter your choice : ");
			 		choice=scan.nextInt();
			 		if (choice==1)
			 			qtyxX(count);
			 		else if (choice==2)
			 			qtyXx(count);
		 		}while (choice!= 1 && choice !=2);
		 	}
		 	else if(choose==3)
		 	{
		 		specifyProductReport(count);
		 	}
		}

		private void namexX(int count)
		 {
	 		for (int i = 0; i < count; i++)
			{
				for (int j = i + 1; j < count; j++)
				{
					int a;
					Product temp;
					a = p[i].compareTo(p[j]);
					if (a > 0)
					{
						temp = p[i];
						p[i] = p[j];
						p[j] = temp;
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
							Product temp;
							a = p[i].compareTo(p[j]);
							if (a < 0)
							{
								temp = p[i];
								p[i] = p[j];
								p[j] = temp;
							}
						}
				}

		 }

		  private void qtyxX(int count)
	 	{
	 		for (int i = 0; i < count; i++)
			{

				for (int j = i + 1; j < count; j++)
					{
						Product temp;
						if (p[i].getQty()>p[j].getQty())
						{
							temp = p[i];
							p[i] = p[j];
							p[j] = temp;
						}
					}



	 		}
	 }
	 //big to small point
	  private void qtyXx(int count)
	 {
	 		for (int i = 0; i < count; i++)
			{
				for (int j = i + 1; j < count; j++)
					{
						Product temp;
						if (p[i].getQty()<p[j].getQty())
						{
							temp = p[i];
							p[i] = p[j];
							p[j] = temp;
						}
					}

			}

	 }

	  private void specifyProductReport(int count)
	 {
	 	 Product[] target=new Product[AddProduct.p.length];// for specify report
	 	 clrBuf=scan.nextLine();
		 System.out.printf("Product ID : ");
		 	String choosen=scan.nextLine();
		 	for(int i=0;i<count;i++)
		 	{
			 		String pID=p[i].getProdID();
			 		choosen=choosen.toUpperCase();

			 		if(choosen.equals(pID)==true)
			 		{
			 			int j=0;
			 			target[j]=p[i];
			 			j++;
			 		}

		 	}
		 	p=target;
	 }

	 public String toString()
	 {
	 	return String.format("This is Product Report");
	 }



}
