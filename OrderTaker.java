
import java.awt.Menu;
import java.util.Scanner;

public class OrderTaker {
	static Scanner console = new Scanner(System.in);
	static RestaurantManager manage = new RestaurantManager();
	static double[] prices;
	static String[] menuItems;
	static double[] quantity;

	public static void setPrice() {
		prices = manage.getPrices();
	}

	public static void setOrder() {
		menuItems = manage.getMenuItems();
	}

	public static int getIntReply(String prompt) {
		System.out.print(prompt);
		int c = console.nextInt();
		return c;
	}

	public static String getStringReply(String prompt) {
		System.out.print(prompt);
		String c = console.next();
		return c;
	}

	static void menu() {
		System.out.println("____________________________________________________________ ");
		System.out.println("| ___  _ __ ___ ___ ___ ___ ___ ___ _  _ ___ ___ ___   ___ | ");
		System.out.println("| |__  |/_  |__ |_| |__ |__  |  |_| |  | |_| |_| | | |  |  | ");
		System.out.println("|  __| |  | |__ |\\_ |__  __| |  | | |__| |\\_ | | | |_|  |  |");
		System.out.println("|__________________________________________________________| ");
		System.out.println();
		System.out.printf("  %s%42s\n", "Menu", "Price");
		for (int i = 0; i < menuItems.length; i++) {
			System.out.printf(" [%d] %-20s%20.2f %s\n", i + 1, menuItems[i], prices[i], "Baht.");
		}
		System.out.println();
		System.out.println(" [e] Edit order");
		System.out.println(" [p] Print order");
		System.out.println(" [x] Cancel order");
		System.out.println(" [c] Checkout");
		System.out.println("");
	}

	static int totalPrice() {
		int sumPrice = 0;
		for (int i = 0; i < menuItems.length; i++) {
			sumPrice += quantity[i] * prices[i];
		}
		return sumPrice;
	}

	public static void printTotalMenu() {
		System.out.print(" _______________________________________________________\n");
		System.out.print("|_______ Menu __________|_____ Qty _____|_____ Price ___|\n");
		for (int i = 0; i < menuItems.length; i++) {

			System.out.println(menuItems.length + " " + quantity.length + " " + prices.length);
			if (quantity[i] > 0)
				System.out.printf("|%8s%-15s|%10.0f%-5s|%11.2f%-4s|\n", "", menuItems[i], quantity[i], "",
						quantity[i] * prices[i], "");
		}
		System.out.print("|_______________________|_______________|_______________|\n");
		System.out.printf("|%8s%-33s%10d%-4s|\n", "", "total", totalPrice(), "");
		System.out.print("|_______________________________________________________|\n");
	}

	public static void command() {
		while (true) {
			String choice = getStringReply("Enter your Choice: ");
			if (choice.equals("p"))
				printTotalMenu();
			else if (choice.equals("e"))
				editMenu();
			else if (choice.equals("x"))
				cancelMenu();
			else if (choice.equals("c"))
				break;
			int choicenum = Integer.parseInt(choice);
			for (int i = 0; i < menuItems.length; i++) {
				
			}

		}
		System.out.println("<<<<<< THANK YOU >>>>>>");
		System.out.println("Facebook Page : SkeSkeRestaurant");
		System.out.println("Tel : 02-021-0200");
	}

	public static void editMenu() {
		int editnum = getIntReply("The number you want to edit: ");
		int quantityMenu = getIntReply("You want to change the quantity to: ");

	}

	public static void cancelMenu() {
		int cancelnum = getIntReply("The number you want to cancel: ");

	}

	public static void main(String[] args) {

		manage.setMenu("data/menu.txt");
		setOrder();
		setPrice();
		menu();
		// int quan = 0;
		// while (true) {
		// int choice = getIntReply("Enter your Choice: ");
		// if (choice == 7) {
		// break;
		// }

		// else if (choice == 1 || choice == 2 || choice == 3) {
		// quan = getIntReply("Enter Quantity: ");
		// System.out.println("");
		// if (choice == 1) {
		// quantity[0] += quan;
		// } else if (choice == 2) {
		// quantity[1] += quan;
		// } else if (choice == 3) {
		// quantity[2] += quan;
		// }
		//
		// } else if (choice == 6) {
		// printTotalMenu();
		// System.out.println("");
		//
		// }
		

	}
}
