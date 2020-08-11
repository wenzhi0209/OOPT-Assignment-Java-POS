import java.util.*;
public class AddProduct {

	static Product[] p;
	private int i;//solve for loop
	private int j;

	//variable for the new product
	private String productDesc;
	private int quantity;
	private double unitPrice;
	private String productID;
	private double sellUnitPrice;
	private String buf;
	private boolean sameName;
	private boolean sameID;

	//variable for validation about product ID
	private boolean validateID;

    public void AddProduct() {
    	Scanner scan = new Scanner(System.in);
    	boolean con=true;

    	for(i = 0;i < p.length; i++)
    	{
    		if(p[i] == null&&con==true)
    		{
    			p[i] = new Product();

				do{
					sameName = false;
					System.out.printf("\nPlease enter product name :");
    				productDesc = scan.nextLine();
    				for(j = 0; j < i ; j++){
    					while(productDesc.equals(p[j].getProductDesc())){
    						System.out.println("The product name already exist.");
    						sameName = true;
    						break;
    					}
    				}
				}while(sameName == true);

				do{
					try{
						System.out.printf("\nPlease enter product quantity :");
    					quantity = scan.nextInt();
					}

					catch(Exception quantityError){
						scan.next();
						quantity = -1;
						System.out.println("");
					}

    				if(quantity < 0){
    					System.out.println("Invalid option, please try again.");
    				}
				}while(quantity < 0);

				do{
					try{
						System.out.printf("\nPlease enter product unit price :");
    					unitPrice = scan.nextDouble();
					}
					catch(Exception unitPriceError){
						scan.next();
						unitPrice = -1;
						System.out.println("");
					}

					if(unitPrice < 0);{
						System.out.println("Invalid option, please try again");
					}
				}while(unitPrice < 0);

				do{
					do
    				{
    					try{
    						System.out.printf("\nPlease enter product sell unit price :");
    						sellUnitPrice = scan.nextDouble();
    					}
    					catch(Exception sellUnitPriceError){
							scan.next();
							sellUnitPrice = -1;
							System.out.println("");
						}

    					if(sellUnitPrice < unitPrice)
    						System.out.println("Invalid option, please try again.");
    				}while(sellUnitPrice < 0);

    				if(sellUnitPrice < 0){
						System.out.println("Invalid option, please try again");
    				}
				}while(sellUnitPrice < unitPrice);

    			//3 chances to typing the correct product ID to check whether the user is really a admin
    			do{
					sameID = false;
					do
					{
						System.out.printf("\nPlease enter product ID :");
    					productID = scan.next();
    					validateID = p[i].validateProductID(productID);

    					if(validateID == false)
    						System.out.println("Product ID doesn't follow the format, please try again.");
					}while(validateID == false);
    				for(j = 0; j < i ; j++){
    					while(productID.equals(p[j].getProdID())){
    						System.out.println("The product ID already exist.");
    						sameID = true;
    						break;
    					}
    				}
				}while(sameID == true);

				//assign the new product detail into the Product array list, the detail about quantity sold must be 0 because doesn't have sold out
				p[i] = new Product(productDesc,quantity,unitPrice,productID,sellUnitPrice,0);
				System.out.println("\nThe new product item you add is");
				System.out.println("Product name : " + p[i].getProductDesc());
				System.out.println("Product ID : " + p[i].getProdID());
				System.out.println("Product quantity : " + p[i].getQty());
				System.out.printf("Product unit price : RM%7.2f\n",p[i].getUnitPrice());
				System.out.printf("Product sell unit price : RM%7.2f\n",p[i].getSellUnitPrice());
				buf=scan.nextLine();

				System.out.println("Continue add product ? [Y/N]");
				char reply =scan.nextLine().charAt(0);
				if(reply=='Y'||reply=='y')
					con=true;
					else
						con=false;
    		}
    	}
    }


}