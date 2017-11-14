

import java.awt.Menu;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class OrderTaker {
	static Scanner console = new Scanner(System.in);
	static RestaurantManager manage = new RestaurantManager();
	static double[] prices;
	static String[] menuItems;
	static int[] quantity;

	public static void setPrice() {
		prices = manage.getPrices();
	}

	public static void setOrder() {
		menuItems = manage.getMenuItems();
		quantity = new int[menuItems.length];
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
		System.out.print("|_______ Menu __________|_____ Qty _____|____ Price ____|\n");
		for (int i = 0; i < menuItems.length; i++) {

			if (quantity[i] > 0) {
				System.out.printf("|%8s%-15s|%9d%-6s|%11.2f%-4s|\n", "", menuItems[i], quantity[i], "",
						quantity[i] * prices[i], "");
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
			else if (choice.equals("c"))
				break;
			if (choice.charAt(0) > 48 && choice.charAt(0) < 57) {
				int choicenum = Integer.parseInt(choice);
				int quan = getIntReply("Enter you Quantity: ");
				quantity[choicenum - 1] += quan;
			}

		}
		System.out.println("<<<<<< THANK YOU >>>>>>");
		System.out.println("Facebook Page : SkeSkeRestaurant");
		System.out.println("Tel : 02-021-0200");
	}

	public static void editMenu() {
		int editnum = getIntReply("The number you want to edit: ");
		int quantityMenu = getIntReply("You want to change the quantity to: ");
		quantity[editnum-1] = quantityMenu; 

	}

	public static void cancelMenu() {
		int cancelnum = getIntReply("The number you want to cancel: ");
		quantity[cancelnum-1] = 0;
	}

	public static void main(String[] args) {

		manage.setMenu("data/menu.txt");
		setOrder();
		setPrice();
		menu();
		command();

	}
}

