import java.util.*;
 import java.text.*;

public class PointOfSale {
	static Product[] p;
	static ProductSell[] ps;
	private Member[] m;
	private int count;//show the number beside the menu as the selection for the user
	private int number;//to know the not null array list dimension and assign new array list in the new array list
	private int selection;//the selection of the user in the menu
	private int updateQuantity;//get the update quantity which is deduct quantity from user
	private int option;//selection of the user to choose the method of making payment
	private int i;//array value of some array
	private int j;//solve the for loop
	private int x;//read the not null data from the ProductSell array list
	private int y;//array value that pass to new ProductSell array list
	private int z;//array value that print the result from ProductSell array list to the user
	private char yesNo;//get the option from the user whether have other transaction
	private char otherItem;//get the option from the user whether have other item

	//temporary array to store the data inside the ProductSell array list
	private String[] productID = new String[100];
	private String[] productName = new String[100];
	private int[] quantity = new int[100];
	private double[] productSellUnitPrice = new double[100];
	private double[] productPrice = new double[100];

	private double totalPrice;//the total amount of one customer transaction
	private double dailySellAmount;//total sales amount of one day
	private double customerPayment;//the cash of the customer paid
	private SimpleDateFormat formatter;
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    public void PointOfSale() {
    	m=MemberMenu.m;
    	Scanner scan = new Scanner(System.in);
    	Date currentDate = new Date(2019-1900,8-1,2+Assignment.d);//set current date as 02-08-2019
    	DeleteProduct dp = new DeleteProduct();
    	p = dp.p;
    	dailySellAmount = 0;

   		do{
			i = 0;
			do{
				do{
					//show the menu to user
					count = 1;
					System.out.println("No		Clothes type");
					System.out.println("--      ------------");
					do{
						//the menu will not show the null array list to user
						if(p[count-1] != null)
						{
							System.out.println(count + "        " + p[count-1].getProductDesc());
							count++;
						}
					}while(p[count-1] != null);

					//这个理try catch全部改完
					try{
						System.out.printf("\nWhich item purchase by customer? (1 to " + (count-1) + ") : ");
						selection = scan.nextInt();
					}
					catch(Exception selectionError){
						scan.next();
						selection = 0;
						System.out.println("");
					}

					if(selection < 1 || selection > count-1)
						System.out.println("Invalid option, please try again.");
				}while(selection < 1 || selection > count-1);

				//temporary array
				productName[i] = p[selection-1].getProductDesc();
				productID[i] = p[selection-1].getProdID();
				productSellUnitPrice[i] = p[selection-1].getSellUnitPrice();

				//这里整个do，try，catch改完
				do{
				do{
					try{
						System.out.printf("\nEnter the quantity : ");
						updateQuantity = scan.nextInt();
					}
					catch(Exception updateQuantityError){
						scan.next();
						updateQuantity = -1;
						System.out.println("");
					}
					if(updateQuantity <= 0){
						System.out.println("Invalid option, please try again");
					}
				}while(updateQuantity <= 0);
				if(updateQuantity > p[selection-1].getQty()){
						System.out.println("Error. Don't have enough stock to sell.");
					}
				}while(updateQuantity > p[selection-1].getQty());

				quantity[i] = updateQuantity;

				productPrice[i] = quantity[i] * p[selection-1].getSellUnitPrice();
				i++;

				p[selection-1].outQuantity(updateQuantity);

				System.out.println("Any other item? ( Y = Yes , other key = No )");
				otherItem = scan.next().charAt(0);

			}while(Character.toUpperCase(otherItem) == 'Y');
			totalPrice = 0;

			for(j = 0; j < i; j++)
			{
				totalPrice += productPrice[j];
			}


			boolean isMember=false;
			Member[] m=MemberMenu.m;
			String clr=scan.nextLine();
			char ansM;
			System.out.println("Is A member ? [y/n]");
			ansM=scan.nextLine().charAt(0);
			if(ansM=='y'||ansM=='Y')
			{
				 clr=scan.nextLine();
				System.out.println("Member ID :");
				String mID= scan.next();
				for(int i=0;i<m.length;i++)
				{
					if(m[i]!=null)
					{
						if(mID.equals(m[i].getID()))
						{
							isMember=true;
							break;
						}
					}

				}
			}
			if(isMember==true)
			{
				totalPrice=totalPrice*0.95;
			}


			//show the amount that customer need to paid
			System.out.printf("\n    Total                                RM%7.2f\n\n", totalPrice);

			do{
				//let the customer choose the payment method
				//这里整个try catch改完
				try{
					System.out.println("1. Pay by bank card method");
					System.out.println("2. Pay by cash method");
					System.out.printf("\nPlease choose your option : ");
					option = scan.nextInt();
				}

				catch(Exception optionError){
					scan.next();
					option = 0;
					System.out.println("");
				}

				if(option == 1){
					//print receipt
					System.out.println("Payment successfully!");
					totalPrice = 0;
					System.out.println("    Clothes Type          Quantity          Amount");
					System.out.println("-------------------------------------------------------");
					for(j = 0; j < i; j++)
					{
						System.out.printf("    %-10s            %8d       RM%7.2f\n", productName[j], quantity[j], productPrice[j]);
						totalPrice += productPrice[j];
					}


					System.out.printf("\n    Total                                RM%7.2f\n\n", totalPrice);
				}

				else if(option == 2){
					do{
						System.out.printf("\nPlease enter customer payment amount : ");
						customerPayment = scan.nextDouble();

						if(customerPayment < totalPrice){
							System.out.println("Error. Customer Payment is lower than the total product amount.");
						}
					}while(customerPayment < totalPrice);

					//print receipt
					totalPrice = 0;
					System.out.println("    Clothes Type          Quantity          Amount");
					System.out.println("-------------------------------------------------------");
					for(j = 0; j < i; j++)
					{
						System.out.printf("    %-10s            %8d       RM%7.2f\n", productName[j], quantity[j], productPrice[j]);
						totalPrice += productPrice[j];
					}
					System.out.printf("\n    Total                                RM%7.2f\n\n", totalPrice);
					System.out.printf("\n    Amount Paid                          RM%7.2f", customerPayment);
					System.out.printf("\n    Refund Amount                        RM%7.2f", customerPayment-totalPrice);
				}

				else{
					System.out.println("Invalid option, please try again.");
				}
			}while(option < 1 || option > 2);

			//calculation of the daily sales amount
			dailySellAmount += totalPrice;

			System.out.println("\n\nAnymore customer? ( Y = Yes , other key = No )");
			yesNo = scan.next().charAt(0);

			number = 0;
			x = 0;
			while(x < ps.length){
				if(ps[x] != null){
					//get to know the not null length of the ProductSell array list
					number++;
				}
				x++;
			}

			for(y = 0; y < i; y++){
				//assign the many temporary array into the ProductSell array list
				ps[number] = new ProductSell(productID[y], productName[y], quantity[y], productSellUnitPrice[y], currentDate);
				number++;
			}

		}while(Character.toUpperCase(yesNo) == 'Y');

		//print daily summary sales detail
		System.out.println(format.format(currentDate));
		System.out.printf("\nToday daily sales is RM%7.2f.\n", dailySellAmount);

		for(z = 0; z < number; z++){
			if(format.format(ps[z].getCurrentDate()).equals(format.format(currentDate)) == true){
				System.out.println(ps[z].getProductDesc() + " sold " + ps[z].getQuantitySold() + " item.");
			}
		}
		//update the date
		Assignment.d++;
    }

    public static void test(Date currentDate)
    {
    	SimpleDateFormat formatter;
    	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    	System.out.println(format.format(currentDate));
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