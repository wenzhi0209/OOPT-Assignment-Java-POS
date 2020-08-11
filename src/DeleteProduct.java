import java.util.*;
public class DeleteProduct {

	static Product[] p;
	private int i;//solve for loop
	private int j;//the variable to read the Product array list which is null or not null and also solve the while loop
	private int k;//counter for the chance of entering the product ID
	private int select;//the selection of the user in the menu
	private int number;//show the number beside the menu as the selection for the user
	private String prodID;//get the product ID from the user for do the validation

    public void DeleteProduct() {
    	Scanner scan = new Scanner(System.in);

		//show the menu to user
    	do{
			number = 1;
			System.out.println("No		Clothes type");
			System.out.println("--      ------------");

			i = 0;

			//the menu will not show the null array list to user
			while(i < p.length){
				if(p[number-1] != null)
				{
					System.out.println(number + "        " + p[number-1].getProductDesc());
					number++;
				}
				i++;
			}

			try{
				System.out.printf("\nWhich of the product you want to delete (1 to " + (number-1) + ") :");
				select = scan.nextInt();
			}
			catch(Exception selectError){
				scan.next();
				select = 0;
				System.out.println("");
			}

			if(select < 1 || select > number-1)
				System.out.println("Invalid option, please try again.");
		}while(select < 1 || select > number-1);

		System.out.printf("\nPlease enter product ID of the product you choose above :");
		prodID = scan.next();
		//validation about the product ID
		if(p[select-1].getProdID().equals(prodID) == false)
		{
			j = 0;
			k = 3;
			while(j < 3){
				System.out.println("Your product ID does not match with the product, you still " + k + " chance.");
				System.out.printf("\nEnter Product ID :");
				prodID = scan.next();
				if(p[select-1].getProdID().equals(prodID))
				{
					//set the choosen array list to null
					p[select-1] = null;
					//array list as a temporary
					Product[] temp = new Product[1000];
					j = 0;

					for(i = 0; i < number-1; i++){
						if(p[j] != null)
						{
							//the array list doesn't choosen will remain the same and store in temporary array list
							temp[i] = p[j];
						}
						else{
							//the affected array list will assign the next array list to original array list
							temp[i] = p[j+1];
							j++;
						}
						j++;
					}

					//let the original array list take back the array list from temporary array list
					p = temp;

					System.out.println("Delete successfully.");
					break;
				}
				k--;
				j++;
			}
		}

		else{
			//set the choosen array list to null
			p[select-1] = null;
			//array list as a temporary
			Product[] temp = new Product[1000];
			j = 0;

			for(i = 0; i < number-1; i++){
				if(p[j] != null)
				{
					//the array list doesn't choosen will remain the same and store in temporary array list
					temp[i] = p[j];
				}
				else{
					//the affected array list will assign the next array list to original array list
					temp[i] = p[j+1];
					j++;
				}
				j++;
			}

			//let the original array list take back the array list from temporary array list
			p = temp;

			System.out.println("Delete successfully.");
			}


    }


}