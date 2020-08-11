import java.util.*;
public class Product implements Comparable<Product> {


		private String productDesc;
		private int qtySold;
		private int quantity;
		private double unitPrice;
		private String prodID;
		private double sellUnitPrice;
		private static int count;


	public Product(){
			productDesc = "";
			quantity = 0;
			unitPrice = 0.0;
			prodID = "";
			count = 0;
			qtySold = 0;
	}

	public Product(String productDesc, int qty, double unitPrice, String prodID, double sellUnitPrice, int qtySold){
			this.productDesc = productDesc;
			quantity = qty;
			this.unitPrice = unitPrice;
			this.prodID = prodID;
			this.sellUnitPrice = sellUnitPrice;
			this.qtySold = qtySold;
			count += 1;

	}

	public Product(String prodID, String productDesc, int qtySold, double sellUnitPrice){
			this.prodID = prodID;
			this.productDesc = productDesc;
			this.qtySold = qtySold;
			this.sellUnitPrice = sellUnitPrice;

	}
		public int getQuantitySold(){
		return qtySold;
	}

		public String getProductDesc(){
			return productDesc;
		}

		public int getQty(){
			return quantity;
		}

		public double getUnitPrice(){
			return unitPrice;
		}

		public String getProdID(){
			return prodID;
		}

		public double getSellUnitPrice(){
			return sellUnitPrice;
		}

		public int getCount(){
			return count;
		}

		public void inQuantity(int updateQuantity){
			//update the new product quantity from the incoming goods
			quantity += updateQuantity;
		}

		public void outQuantity(int updateQuantity){
			//update the new product quantity and quantity sold from point of sale
			qtySold += updateQuantity;
			quantity -= updateQuantity;
		}

		public void updatedProductDesc(String newName){
			//update the product name from edit product
			productDesc = newName;
		}

		public void updatedProdID(String newID){
			//update product id from edit product
			prodID = newID;
		}

		public void updatedProductQuantity(int newQuantity){
			//update product quantity from edit product
			quantity = newQuantity;
		}

		public void updatedProductUnitPrice(double newUnitPrice){
			//update product unit price from edit product
			unitPrice = newUnitPrice;
		}

		public void updatedProductSellUnitPrice(double newSellUnitPrice){
			//update product sell unit price from edit product
			sellUnitPrice = newSellUnitPrice;
		}

		public boolean validateProductID(String productID){
			//the validation about the product id which is 3 upper case follow by 4 digit number
			boolean a = false;

			if(productID.length() == 7)
				a = true;

			boolean b = false;

				if(Character.isUpperCase(productID.charAt(0)) == true &&
				   Character.isUpperCase(productID.charAt(1)) == true &&
				   Character.isUpperCase(productID.charAt(2)) == true)
					b = true;

			boolean c = false;

				if(Character.isDigit(productID.charAt(3)) == true &&
				   Character.isDigit(productID.charAt(4)) == true &&
				   Character.isDigit(productID.charAt(5)) == true &&
				   Character.isDigit(productID.charAt(6)) == true)
					c = true;

			return (a && b && c);
		}
//compare to
		public int compareTo(Product p)
		{
		    return this.getProductDesc().compareTo(p.getProductDesc());
		}
}