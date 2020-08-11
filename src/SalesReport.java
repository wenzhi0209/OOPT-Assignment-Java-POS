import java.util.*;
import java.text.*;
public class SalesReport extends Report {

	private ProductSell[] ps=new ProductSell[PointOfSale.ps.length];
	private ProductSell[] ps2;
	private Product[] p=new Product[AddProduct.p.length];

	// for monthly
    private SimpleDateFormat formatter;

	private Date DateEnd=new Date(2019-1900,12,10);
	private Date DateStart=new Date();
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

	private double totalCost=0;
	private double gross=0;
	private double revenue=0;
	private double sale=0;




	public SalesReport()
	{
	}

	public void getReport()
	{
		System.out.println("Which Sales Report you need <default:Yearly>  ?");
		System.out.println("1.Daily Sales Report");
		System.out.println("2.Monthly Sales Report");
		System.out.println("3.Yearly Sales Report");
		int choice = scan.nextInt();
		if(choice==1)
			getDailyReport();
		else if(choice==2)
			getMonthlyReport();
			else
				getYearlyReport();

	}

	public void getDailyReport()
	{
		int count=0;

		System.arraycopy(ProductSell.ps,0,ps,0,ProductSell.ps.length);
		System.arraycopy(AddProduct.p,0,p,0,AddProduct.p.length);
		String dateS= ps[ProductSell.getNum()-1].getSCurrentDate();
		System.out.printf("\n\n\n\n %-20s \n",super.getCompanyName());
	 	System.out.println(" "+dateS);
	 	System.out.println(" Daily Sales Report ");
	 	System.out.println("----------------------------------------------------------------------------------------------");
	 	System.out.printf(" %-10s %-20s %-8s %-12s %-12s %-10s %-15s %-15s \n","Product_ID","Product Description","Qty Sold","Cost_Price(RM)","Sale Price(RM)","Total Cost (RM)","Gross Sale(RM)","Revenue (RM)");
	 	//should calculate total revenue
	 	for(int i=0;i<ps.length;i++)
	 	{
	 		if(ps[i]!= null)
	 		{
	 			if(dateS.equals(ps[i].getSCurrentDate()))
	 			{
	 				double cost=0;
		 			for(int j=0;j<p.length;j++)
		 			{
		 				if(p[j].getProdID()==ps[i].getProdID())
		 				{
		 					cost=p[j].getUnitPrice();
		 					break;
		 				}
		 			}
		 			totalCost=cost*ps[i].getQuantitySold();
		 			gross=ps[i].getSellUnitPrice()*ps[i].getQuantitySold();
		 			revenue=gross-totalCost;


	 			System.out.printf(" %-10s %-20s %-8d %-12.2f   %-12.2f   %-10.2f      %-15.2f   %-15.2f\n",
	 			ps[i].getProdID(),ps[i].getProductDesc(),ps[i].getQuantitySold(),cost,ps[i].getSellUnitPrice(),totalCost,gross,revenue);
	 			count++;
	 			}
	 		}
	 	}



	 	System.out.printf("\n\n %s \n\n","-----------END OF REPORT-----------");


	 }


	 public void getMonthlyReport()
	{
		int count=0;

		System.arraycopy(ProductSell.ps,0,ps,0,ProductSell.ps.length);
		System.arraycopy(AddProduct.p,0,p,0,AddProduct.p.length);

		Date Mdate= ps[ProductSell.getNum()-1].getCurrentDate();//get date foramt
		int mon=Mdate.getMonth();//get the latest transaction month
		//mon=6;//SET TO JULY

		String dateS= ps[ProductSell.getNum()-1].getSCurrentDate();//get string format

		System.out.printf("\n\n\n\n %-20s \n",super.getCompanyName());
	 	System.out.println(" "+dateS);
	 	//System.out.println("JULY REPORT")

	 	System.out.println(" Monyhly Sales Report ");
	 	System.out.printf(" %-10s %-20s %-8s %-12s %-12s %-10s %-15s %-15s %-15s \n",
	 	"Product_ID","Product Description","Qty Sold","Cost_Price(RM)","Sale Price(RM)","Total Cost (RM)","Gross Sale(RM)","Revenue (RM)","DATE");
	 	//should calculate total revenue
	 	for(int i=0;i<ps.length;i++)
	 	{
	 		if(ps[i]!= null)
	 		{
	 			Date psdate= ps[i].getCurrentDate();//get date foramt for check month is valit or not
	 			int mon1=psdate.getMonth();

	 			if(mon==mon1)
	 			{
	 				double cost=0;
	 			for(int j=0;j<p.length;j++)
	 			{
	 				if(p[j].getProdID()==ps[i].getProdID())
	 				{
	 					cost=p[j].getUnitPrice();
	 					break;
	 				}

	 			}
	 				totalCost=cost*ps[i].getQuantitySold();
		 			gross=ps[i].getSellUnitPrice()*ps[i].getQuantitySold();
		 			revenue=gross-totalCost;

	 			System.out.printf(" %-10s %-20s %-8d %-12.2f   %-12.2f   %-10.2f      %-15.2f   %-15.2f%-15s\n",
	 			ps[i].getProdID(),ps[i].getProductDesc(),ps[i].getQuantitySold(),cost,ps[i].getSellUnitPrice(),totalCost,gross,revenue,ps[i].getSCurrentDate());
	 			count++;
	 			}
	 		}
	 	}



	 	System.out.printf("\n\n %s \n\n","-----------END OF REPORT-----------");


	 }


	 public void getYearlyReport()
	{
		int count=0;

		System.arraycopy(ProductSell.ps,0,ps,0,ProductSell.ps.length);
		System.arraycopy(AddProduct.p,0,p,0,AddProduct.p.length);

		Date Mdate= ps[ProductSell.getNum()-1].getCurrentDate();//get date foramt
		int year=Mdate.getYear();//get the latest transaction month
		//mon=6;//SET TO JULY

		String dateS= ps[ProductSell.getNum()-1].getSCurrentDate();//get string format

		System.out.printf("\n\n\n\n %-20s \n",super.getCompanyName());
	 	System.out.println(" "+dateS);
	 	//System.out.println("JULY REPORT")

	 	System.out.println(" Yearly Sales Report ");
	 	System.out.printf(" %-10s %-20s %-8s %-12s %-12s %-10s %-15s %-15s %-15s \n",
	 	"Product_ID","Product Description","Qty Sold","Cost_Price(RM)","Sale Price(RM)","Total Cost (RM)","Gross Sale(RM)","Revenue (RM)","DATE");

	 	//should calculate total revenue
	 	for(int i=0;i<ps.length;i++)
	 	{
	 		if(ps[i]!= null)
	 		{
	 			Date psdate= ps[i].getCurrentDate();//get date foramt for check month is valit or not
	 			int year1=psdate.getYear();

	 			if(year==year1)
	 			{
	 				double cost=0;
	 			for(int j=0;j<p.length;j++)
	 			{
	 				if(p[j].getProdID()==ps[i].getProdID())
	 				{
	 					cost=p[j].getUnitPrice();
	 					break;
	 				}

	 			}
	 				totalCost=cost*ps[i].getQuantitySold();
		 			gross=ps[i].getSellUnitPrice()*ps[i].getQuantitySold();
		 			revenue=gross-totalCost;

	 			System.out.printf(" %-10s %-20s %-8d %-12.2f   %-12.2f   %-10.2f      %-15.2f   %-15.2f%-15s\n",
	 			ps[i].getProdID(),ps[i].getProductDesc(),ps[i].getQuantitySold(),cost,ps[i].getSellUnitPrice(),totalCost,gross,revenue,ps[i].getSCurrentDate());
	 			count++;
	 			}
	 		}
	 	}



	 	System.out.printf("\n\n %s \n\n","-----------END OF REPORT-----------");


	 }



	  public String toString()
	 {
	 	return String.format("This is Sales Report");
	 }





}

