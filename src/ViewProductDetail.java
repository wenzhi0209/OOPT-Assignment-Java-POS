import java.util.*;
public class ViewProductDetail {
	static Product[] p;
	private int i;//the sequence number of the array list
	private String clearBuff;//let the user can press one of the key to end the view product detail function

    public void ViewProductDetail() {
    	DeleteProduct dp = new DeleteProduct();
    	p = dp.p;
    	i = 0;
    	Scanner scan = new Scanner(System.in);
    	//show the detail
    	System.out.println("Clothes type     Product ID     Quantity     Unit Price     Sell Unit Price     Quantity Sold");
		System.out.println("------------     ----------     --------     ----------     ---------------     -------------");

		do
		{
			//the menu will not show the null array list to user
			if(p[i] != null)
			{
				System.out.printf("%-12s     %-10s     %-8d     %-10.2f     %-15.2f     %13d\n",
				p[i].getProductDesc(), p[i].getProdID(),p[i].getQty(),p[i].getUnitPrice(),p [i].getSellUnitPrice(),p[i].getQuantitySold());
				i++;
			}
		}while(p[i] != null);

		System.out.println("Press ENTER key to continue.");
		clearBuff = scan.nextLine();

    }


}