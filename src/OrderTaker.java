import java.awt.Menu;
import java.util.Scanner;

import javax.print.attribute.standard.Sides;
import javax.security.auth.x500.X500Principal;

/**
 * This is the main class for taking orders. Order can be added and edited or
 * canceled. When done, it prints a receipt including all the added orders.
 * 
 * @author Vichaphol Thamsuthikul
 */
public class OrderTaker {
	static Scanner console = new Scanner(System.in);
	static RestaurantManager manage = new RestaurantManager();
	static double[] prices;
	static String[] menuItems;
	static int[] order;

	public static void setPrice() {
		prices = manage.getPrices();
	}

	public static void setOrder() {
		menuItems = manage.getMenuItems();
		order = new int[menuItems.length];
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
		System.out.println("|_______à___________________________________________________| ");
		System.out.println();
		System.out.printf("  %s%42s\n", "Menu", "Price");
		for (int i = 0; i < menuItems.length; i++) {
			System.out.printf(" [%d] %-20s%20.2f %s\n", i + 1, menuItems[i], prices[i], "Baht.");
		}
		System.out.println();
		System.out.println(" [e] Edit order");
		System.out.println(" [p] Print order");
		System.out.println(" [x] Cancel order");
		System.out.println(" [c] Review order and Checkout");
	}

	static double totalPrice() {
		double sumPrice = 0;
		for (int i = 0; i < menuItems.length; i++) {
			sumPrice += order[i] * prices[i];
		}
		return sumPrice;
	}
	static double vat() {
		int sumPrice = 0;
		double vat;
		for (int i = 0; i < menuItems.length; i++) {
			sumPrice += order[i] * prices[i];
		}
		vat = sumPrice*0.07;
		
		return vat;
	}

	public static void printTotalMenu() {
		System.out.print(" _______________________________________________________\n");
		System.out.print("|_______ Menu __________|_____ Qty _____|____ Price ____|\n");
		for (int i = 0; i < menuItems.length; i++) {
			if (order[i] > 0) {
				System.out.printf("|%8s%-15s|%9d%-6s|%11.2f%-4s|\n", "", menuItems[i], order[i], "",
						order[i] * prices[i], "");
			}
		}
		System.out.print("|_______________________|_______________|_______________|\n");
		System.out.printf("|%8s%-33s%10d%-4s|\n", "", "total", totalPrice(), "");
		System.out.print("|_______________________________________________________|\n");
	}

	public static void command() {
		while (true) {
			System.out.println();
			String choice = getStringReply("Enter your Choice: ");
			if (choice.equals("p"))
				printTotalMenu();
			else if (choice.equals("e"))
				editMenu();
			else if (choice.equals("x"))
				cancelMenu();
			else if (choice.equals("c")) {
				receipt();
				break;
			}
			if (choice.charAt(0) > 48 && choice.charAt(0) < 57) {
				int choicenum = Integer.parseInt(choice);
				int quan = getIntReply("Enter you Quantity: ");
				order[choicenum - 1] += quan;
			}

		}

	}

	public static void editMenu() {
		int editnum = getIntReply("The number you want to edit: ");
		int quantityMenu = getIntReply("You want to change the quantity to: ");
		order[editnum - 1] = quantityMenu;

	}

	public static void cancelMenu() {
		int cancelnum = getIntReply("The number you want to cancel: ");
		order[cancelnum - 1] = 0;
	}
	
	public static void receipt() {
		System.out.println();
		System.out.println(" ______________ SKE RESTAUTANT ______________");
		System.out.println();
		System.out.println(" Facebook Page : SkeSkeRestaurant");
		System.out.println(" Tel : 02-021-0200");
		System.out.println();
		System.out.printf(" %27s\n", "Bill Check");
		System.out.println();
		System.out.printf(" %s%31s%tT\n", "Time:", "", System.currentTimeMillis());
		System.out.println(" --------------------------------------------");
		System.out.printf(" %8s%31s%s\n", "Menu", "", "Price");
		System.out.println(" --------------------------------------------");
		for (int i = 0; i < menuItems.length; i++) {
			if (order[i] > 0) {
				System.out.printf(" %d%-3s%-28s%12.2f%-5s\n", order[i], "", menuItems[i], order[i] * prices[i], "");
			}
		}
		System.out.println(" --------------------------------------------");
		System.out.printf(" %8s%33.2f\n","Total Price", totalPrice());
		System.out.printf(" %s%38.2f\n","VAT 7%",totalPrice()*0.07);
		System.out.printf(" %s%28.2f\n","Total Net Price.",totalPrice()+(totalPrice()*0.07));
		System.out.println(" ____________________________________________");
	}

	public static void main(String[] args) {
		manage.init("data/menu.txt");
		setOrder();
		setPrice();
		menu();
		command();

	}
}
