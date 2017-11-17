/**
 * This class has the attributes, constructor and behaviors for the Restaurant
 * Management.
 * 
 * @author Vichaphol Thamsuthikul
 */
public class Food {
	private String menuItems;
	private double unitPrice;;

	public Food(String name, double price) {
		this.menuItems = name;
		this.unitPrice = price;
	}

	public String getName() {
		return menuItems;
	}

	public void setName(String nameFood) {
		this.menuItems = nameFood;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setPrice(double priceFood) {
		this.unitPrice = priceFood;
	}

}
