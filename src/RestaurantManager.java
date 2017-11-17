import java.awt.MenuItem;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This Restaurant Manager can record orders from a file text. It provides the
 * ArrayList of all the Food and also get Menu Items and Prices method for the
 * main class.
 * 
 * @author Vichaphol Thamsuthikul
 */

public class RestaurantManager {
	private String[] menuItems;
	private double[] Prices;

	public List<Food> foodArrayList = new ArrayList<Food>();

	public void recordOrder(int orderNumber, int[] order, double total) {

	}

	public String[] getMenuItems() {
		return menuItems;
	}

	public double[] getPrices() {
		return Prices;
	}

	public void init(String filename) {
		String fileMenu = filename;
		ClassLoader loader = RestaurantManager.class.getClassLoader();
		InputStream in = loader.getResourceAsStream(fileMenu);
		if (in == null) {
			System.out.println("Could not access file " + fileMenu);
			return;
		}
		Scanner reader = new Scanner(in);
		while (reader.hasNextLine()) {
			String[] foodS = reader.nextLine().split(";");
			foodArrayList.add(new Food(foodS[0], Double.parseDouble(foodS[1])));
		}
		menuItems = new String[foodArrayList.size()];
		Prices = new double[foodArrayList.size()];
		for (int i = 0; i < foodArrayList.size(); i++) {
			menuItems[i] = foodArrayList.get(i).getName();
			Prices[i] = foodArrayList.get(i).getUnitPrice();
		}
	}
}
