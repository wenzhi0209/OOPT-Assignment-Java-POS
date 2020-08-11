import java.util.*;

public class IncomingGoods {

	static Product[] p;
	private int count;//show the number beside the menu as the selection for the user
	private int select;//the selection of the user in the menu
	private int updateQuantity;//get the update quantity which is add quantity from user
	private String prodID;//get the product ID from the user for do the validation
	private int j;//solve the while loop
	private int k;//counter for the chance of entering the product ID

    public void IncomingGoods() {
    	Scanner scan = new Scanner(System.in);
    	DeleteProduct dp = new DeleteProduct();

    	p = dp.p;

    	count = 1;
		do{
			//show menu to user
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

			//这里整个try catch改完
			try{
				System.out.printf("\nWhich of the product you want to add (1 to " + (count-1) + ") :");
				select = scan.nextInt();
			}
			catch(Exception selectError){
					scan.next();
					select = 0;
					System.out.println("");
			}

			if(select < 1 || select > count-1)
				System.out.println("Invalid option, please try again.");
		}while(select < 1 || select > count-1);

		//这里do，try，catch全部改完
		do{
			try{
				System.out.printf("\nEnter add quantity :");
				updateQuantity = scan.nextInt();
			}
			catch(Exception updateQuantityError){
				scan.next();
				updateQuantity = 0;
				System.out.println("");
			}
			if(updateQuantity <= 0){
				System.out.println("Invalid option, please try again");
			}
		}while(updateQuantity <= 0);

		System.out.printf("\nEnter Product ID :");
		prodID = scan.next();
		//validation about the product ID
		if(p[select-1].getProdID().equals(prodID))
		{
			p[select-1].inQuantity(updateQuantity);
		}
		else
		{
			j = 0;
			k = 3;
			while(j < 3){
				System.out.println("Your product ID does not match with the product, you still " + k + " chance.");
				System.out.printf("\nEnter Product ID :");
				prodID = scan.next();
				if(p[select-1].getProdID().equals(prodID))
				{
					p[select-1].inQuantity(updateQuantity);
					break;
				}
				k--;
				j++;
			}
		}
		System.out.println("\nNow " + p[select-1].getProductDesc() + " have " + p[select-1].getQty() + ".\n");
    }


}