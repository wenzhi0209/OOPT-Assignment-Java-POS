import java.util.*;
import java.text.*;
public class ProductSell extends Product{
	static ProductSell[] ps;
	private Date currentDate;
	private SimpleDateFormat formatter;
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	public static int num=0;

    public ProductSell() {
    }

    public ProductSell(String prodID, String productDesc, int qtySold, double sellUnitPrice, Date currentDate){
    	super(prodID, productDesc, qtySold, sellUnitPrice);
    	this.currentDate = currentDate;
    	num++;
    }

    public String getSCurrentDate(){
    	return format.format(currentDate);
    }
    public Date getCurrentDate(){
    	return currentDate;
    }

    public static int getNum()
    {
    	return num;
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