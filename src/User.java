import java.util.*;
//test
public class User {

	String id;
	String password;
	String empName;//later change
	private static int num=0;

	char type;

	public User(){
		num++;

	}

	public User(String id,String password,String name)
	{
		this.id=id;
		this.password=password;
		empName=name;
		num++;
	}

	public static boolean validatePassword(char type,User[] existUser,String id,String password)
	{
		for(int i=0;i<existUser.length;i++)
		{
			if((type=='A'||type=='M')&&id.charAt(0)=='A')
			{
				if(existUser[i]!=null)
				{
					if(existUser[i].id.equals(id))
					{
						if(existUser[i].password.equals(password))
						{
							return true;
						}
					}
				}
			}
			else if(id.charAt(0)==type)
			{
				if(existUser[i]!=null)
				{if(existUser[i].id.equals(id))
					{
					if(existUser[i].password.equals(password))
					{
						return true;
					}
					}
				}
			}

		}	return false;
	}


	public static int getNum()
	{
		return num;
	}

	public String getName()
	{
		return empName;
	}
	public String getID()
	{
		return id;
	}
	public String getPassword()
	{
		return password;
	}
	public void setID(String id)
	{
		this.id=id;
	}
	public void setPassword(String p)
	{
		password=p;
	}

	public String toString()
	{
		return String.format("  USER ID: "+id+"   Owner: "+empName);
	}




}
