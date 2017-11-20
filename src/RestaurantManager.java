import java.awt.MenuItem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
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
	static LocalDate date = LocalDate.now();
	static LocalTime time = LocalTime.now();

	public String[] getMenuItems() {
		return menuItems;
	}

	public double[] getPrices() {
		return Prices;
	}

	@SuppressWarnings("resource")
	public void recordOrder(int ordernumber, int[] order, double total) throws FileNotFoundException {
		OutputStream outputStream = null;
		File root = new File("data");
		root.mkdir(); 
		File file = new File(root, "SalesLog.txt");
		try {
			outputStream = new FileOutputStream(file, true);

		} catch (Exception e) {
			System.out.println("Could not access file " + root);
		}
		System.out.println(" ______________ SKE RESTAUTANT ______________");
		System.out.println();
		System.out.printf(" %s%31s%tT\n", "Time:", "", System.currentTimeMillis());
		System.out.printf(" Order number [%d]", ordernumber);
		System.out.println(" --------------------------------------------");
		System.out.printf(" %8s%31s%s\n", "Menu", "", "Price");
		System.out.println(" --------------------------------------------");
		for (int i = 0; i < menuItems.length; i++) {
			if (order[i] > 0) {
				System.out.printf(" %d%-3s%-28s%12.2f%-5s\n", order[i], "", menuItems[i], order[i] * Prices[i], "");
			}
		}
		System.out.println(" --------------------------------------------");
		System.out.printf(" %8s%33.2f\n", "Total Price", total);
		System.out.printf(" %s%38.2f\n", "VAT 7%", total * 0.07);
		System.out.printf(" %s%28.2f\n", "Total Net Price.", total + (total * 0.07));
		System.out.println(" ____________________________________________");

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
