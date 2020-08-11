import java.util.*;
public class EditProduct {

	static Product[] p;
	private int counter;//show the number beside the menu as the selection for the user
	private int selection;//the selection of the user in the menu
	private String prodID;//get the product ID from the user for do the validation
	private int i;//solve the while loop
	private int j;//solve the while loop
	private int k;//counter for the chance of entering the product ID
	private int choose;//the selection of the user in the menu
	private String clearBuff;//solve the nextLine problem
	//store the old data element
	private String oldName;
	private String oldID;
	private int oldQuantity;
	private double oldUnitPrice;
	private double oldSellUnitPrice;
	//get the new data element form the user
	private String newName;
	private String newID;
	private int newQuantity;
	private double newUnitPrice;
	private double newSellUnitPrice;

    public void EditProduct() {
    	Scanner scan = new Scanner(System.in);
    	DeleteProduct dp = new DeleteProduct();

    	p = dp.p;

    	counter = 1;
    	//show menu to user
		do{
			//这里整个try catch改完
			try{
			System.out.println("No		Clothes type");
			System.out.println("--      ------------");
			i = 0;

			//the menu will not show the null array list to user
			while(i < p.length){
				if(p[counter-1] != null)
				{
					System.out.println(counter + "        " + p[counter-1].getProductDesc());
					counter++;
				}
				i++;
			}
				System.out.printf("Which of the product you want to modify (1 to " + (counter-1) + ") :");
				selection = scan.nextInt();
			}
			catch(Exception selectionError){
				scan.next();
				selection = 0;
				System.out.println("");
			}

			if(selection < 1 || selection > counter-1)
				System.out.println("Invalid option, please try again.");
		}while(selection < 1 || selection > counter-1);

		System.out.printf("\nPlease enter product ID of the product you choose above :");
		prodID = scan.next();
		//validation about the product ID
		if(p[selection-1].getProdID().equals(prodID) == false)
		{
			j = 0;
			k = 3;
			while(j < 3){
				System.out.println("Your product ID does not match with the product, you still " + k + " chance.");
				System.out.printf("\nEnter Product ID :");
				prodID = scan.next();
				if(p[selection-1].getProdID().equals(prodID))
				{
					break;
				}
				k--;
				j++;
			}
		}

		if(p[selection-1].getProdID().equals(prodID))
			{
			do{
				//这里整个try catch改完
				try{
				//show the original data to user
				System.out.println("Clothes type     Product ID     Quantity     Unit Price     Sell Unit Price     Quantity Sold");
				System.out.println("------------     ----------     --------     ----------     ---------------     -------------");
				System.out.printf("%-12s     %-10s     %-8d     %-10.2f     %-15.2f     %13d\n",
				p[selection-1].getProductDesc(),p[selection-1].getProdID(),p[selection-1].getQty(),p[selection-1].getUnitPrice(),p[selection-1].getSellUnitPrice(),
				p[selection-1].getQuantitySold());

				System.out.println("1. Product Name");
				System.out.println("2. Product ID");
				System.out.println("3. Product Quantity");
				System.out.println("4. Product Unit Price");
				System.out.println("5. Product Sale Unit Price\n\n");
				System.out.printf("Please choose which part you want to modify (1 to 5) :");
				choose = scan.nextInt();
				}
				catch(Exception chooseError){
					scan.next();
					choose = 0;
					System.out.println("");
				}

				if(choose < 1 || choose > 5)
					System.out.println("Invalid option, please try again.");
			}while(choose < 1 || choose > 5);

			if(choose == 1)//update product name
			{
				oldName = p[selection-1].getProductDesc();
				clearBuff = scan.nextLine();
				System.out.printf("\nPlease enter the new product name :");
				newName = scan.nextLine();
				p[selection-1].updatedProductDesc(newName);
				System.out.println("The product name from " + oldName + " change to " + p[selection-1].getProductDesc() + ".");
			}

			else if(choose == 2)//update product id
			{
				clearBuff = scan.nextLine();
				System.out.printf("\nPlease enter the new product ID :");
				newID = scan.nextLine();
				oldID = p[selection-1].getProdID();
				p[selection-1].updatedProdID(newID);
				System.out.println("The product ID from " + oldID + " change to " + p[selection-1].getProdID() + ".");
			}

			else if(choose == 3)//update product stock quantity
			{
				//这里do，try和catch整个改完
				do{
					try{
						System.out.printf("\nPlease enter the new product quantity :");
						newQuantity = scan.nextInt();
					}
					catch(Exception newQuantityError){
						scan.next();
						newQuantity = -1;
						System.out.println("");
					}
					if(newQuantity < 0){
						System.out.println("Invalid option, please try again");
					}
				}while(newQuantity < 0);

				oldQuantity = p[selection-1].getQty();
				p[selection-1].updatedProductQuantity(newQuantity);
				System.out.println("The product quantity from " + oldQuantity + " change to " + p[selection-1].getQty() + ".");
			}

			else if(choose == 4)//update product unit price
			{
				//这里do，try，catch全部改完
				do{
				do{
					try{
						System.out.printf("\nPlease enter the new product unit price :");
						newUnitPrice = scan.nextDouble();
					}
					catch(Exception newUnitPriceError){
						scan.next();
						newUnitPrice = -1;
						System.out.println("");
					}
					if(newUnitPrice < 0){
						System.out.println("Invalid option, please try again");
					}
				}while(newUnitPrice < 0);
				if(newUnitPrice > p[selection-1].getSellUnitPrice())
						System.out.println("Invalid input, the product unit price is higher than sell unit price.");
				}while(newUnitPrice > p[selection-1].getSellUnitPrice());
				oldUnitPrice = p[selection-1].getUnitPrice();
				p[selection-1].updatedProductUnitPrice(newUnitPrice);
				System.out.printf("The product unit price from %.2f change to %.2f.\n\n",oldUnitPrice,p[selection-1].getUnitPrice());
			}

			else if(choose == 5)//update product sell unit price
			{
				//这里整个do，try，catch改完
				do{
				do
				{
					try{
						System.out.printf("\nPlease enter the new product sell unit price :");
						newSellUnitPrice = scan.nextDouble();
					}
					catch(Exception newSellUnitPriceError){
						scan.next();
						newSellUnitPrice = -1;
						System.out.println("");
					}
					if(newSellUnitPrice < 0){
						System.out.println("Invalid option, please try again.");
					}
				}while(newSellUnitPrice < 0);
				if(newSellUnitPrice < p[selection-1].getUnitPrice())
						System.out.println("Invalid input, the product sell unit price is lower than unit price.");
				}while(newSellUnitPrice < p[selection-1].getUnitPrice());
				oldSellUnitPrice = p[selection-1].getSellUnitPrice();
				p[selection-1].updatedProductSellUnitPrice(newSellUnitPrice);
				System.out.printf("The product sale unit price from %.2f change to %.2f.\n\n",oldSellUnitPrice,p[selection-1].getSellUnitPrice());
			}
		}
    }


}