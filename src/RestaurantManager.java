import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantManager {

	public String[] getMenuItems() {
		String[] name = new String[foodArrayList.size()];
		for (int i = 0; i < foodArrayList.size(); i++) {
			name[i] = foodArrayList.get(i).getNameF();
		}
		return name;
	}

	public double[] getPrices() {
		double[] price = new double[foodArrayList.size()];
		for (int i = 0; i < foodArrayList.size(); i++) {
			price[i] = foodArrayList.get(i).getPriceF();

		}
		return price;
	}

	public void recordOrder(int orderNumber, int[] order, double total) {

	}

	public List<Food> foodArrayList = new ArrayList<Food>();

	public void setMenu(String filename) {
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
	}
}
