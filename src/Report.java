
import java.util.*;

public class Report {
	protected Date date;
	protected String companyName;
	protected static Scanner scan= new Scanner(System.in);
	protected static String clrBuf;

	public Report()
	{
		companyName="UniYSL";
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public Date getDate()
	{
		date=new Date();//each time of refresh on report will also refresh time
		date.getTime();
		return date;
	}




}
