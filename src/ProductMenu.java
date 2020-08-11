
import java.util.*;

public class ProductMenu {
	AddProduct ap = new AddProduct();
	DeleteProduct dp = new DeleteProduct();
	EditProduct ep = new EditProduct();
	IncomingGoods ig = new IncomingGoods();
	PointOfSale pos = new PointOfSale();
	ViewProductDetail vpd = new ViewProductDetail();

	private int option;

	public void adminProductMenu()
	{

		Scanner scan = new Scanner(System.in);
		do{
			//这里整个try catch包着改完
			try{
				System.out.println("Please choose your option about the product :");
    			System.out.println("1. Add new product");
    			System.out.println("2. Delete product");
    			System.out.println("3. Edit product detail");
    			System.out.println("4. View product detail");//这里改
    			System.out.printf("5. Exit \n\n");//这里改
    			System.out.print("Your option (1 to 5) : ");//这里改
    			option = scan.nextInt();
			}
			catch(Exception optionError){
				scan.next();
				option = 0;
				System.out.println("");
			}

    	if (option == 1)
    	{
    		//call add product function
    		ap.AddProduct();
    	}

		else if (option == 2)
		{
			//call delete product function
			dp.DeleteProduct();
		}

		else if (option == 3)
		{
			//call edit product function
			ep.EditProduct();
		}

		else if (option == 4){//这里改
			//call view product detail function
			vpd.ViewProductDetail();
		}

		else if (option == 5){//这里改
			System.out.println();
		}

		else{
			System.out.println("Invalid option, please choose again.");
		}
		}while(option != 5);//这里改
	}
	public void staffProductMenu()
		{
			Scanner scan = new Scanner(System.in);
			do{
				//这里整个try catch包着改完
				try{
					System.out.println("Please choose your option about the product :");
    				System.out.println("1. Incoming Goods");
		    		System.out.println("2. Point-Of-Sales");
    				System.out.println("3. View Product Detail");
    				System.out.println("4. Exit");
    				System.out.print("Your option (1 to 4) : ");
    				option = scan.nextInt();
				}
				catch(Exception optionError){
					scan.next();
					option = 0;
					System.out.println("");
				}

				if (option == 1)
				{
					//call incoming goods function
					ig.IncomingGoods();
				}
				else if (option == 2){
					//call point of sale function
					pos.PointOfSale();
				}
				else if (option == 3){
					//call view product detail function
					vpd.ViewProductDetail();
				}
				else if (option == 4){
					System.out.println();
				}
				else{
					System.out.println("Invalid option, please choose again.");
				}
				}while(option != 4);
		}
}
