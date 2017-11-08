

import java.util.Scanner;

public class OrderTaker {
	static Scanner console = new Scanner(System.in);
	static RestaurantManager manage = new RestaurantManager();
	static double[] price;
	static String[] order;
	static int[] quantity = { 0, 0, 0 };

	public static void setPrice() {
		price = manage.getPrices();
	}

	public static void setOrder() {
		order = manage.getMenuItems();
	}


	public static int getIntReply(String prompt) {
		System.out.print(prompt);
		int c = console.nextInt();
		return c;
	}

	static void menu() {
		System.out.println("____________________________________________________________ ");
		System.out.println("| ___  _ __ ___ ___ ___ ___ ___ ___ _  _ ___ ___ ___   ___ | ");
		System.out.println("| |__  |/_  |__ |_| |__ |__  |  |_| |  | |_| |_| | | |  |  | ");
		System.out.println("| ___| |  |_|__ ||  |__  __| |  | | |__| ||  | | | |_|  |  | ");
		System.out.println("|__________________________________________________________| ");
		System.out.println();
		System.out.println("  Menu\t\t\t\t\t  Price");
		for (int i = 0; i < order.length; i++) {
			System.out.printf(" %d.) %s\t\t\t\t%.2f\t%s\n", i + 1, order[i], price[i],"Baht.");
		}
		System.out.printf(" %d.) Total\n", order.length + 1);
		System.out.printf(" %d.) Exit", order.length + 2);
		System.out.println("");
	}

	static int totalPrice() {
		int sumPrice = 0;
		for (int i = 0; i < order.length; i++) {
			sumPrice += quantity[i] * price[i];
		}
		return sumPrice;
	}

	public static void printMenu() {
		System.out.print(" _______________________________________________________\n");
		System.out.print("|_______ Menu __________|_____ Qty _____|_____ Price ___|\n");
		for (int i = 0; i < order.length; i++) {
			if (quantity[i] * price[i] > 0)
				System.out.printf("|%8s%-15s|%10d%-5s|%11.2f%-4s|\n", "", order[i], quantity[i], "",
						quantity[i] * price[i], "");
		}
		System.out.print("|_______________________|_______________|_______________|\n");
		System.out.printf("|%8s%-33s%10d%-4s|\n", "", "total", totalPrice(), "");
		System.out.print("|_______________________________________________________|\n");
	}

	public static void main(String[] args) {
		
		manage.setMenu("data/menu.txt");
		setOrder();
		setPrice();
		menu();
		int quan = 0;

		while (true) {
			int choice = getIntReply("Enter your Choice: ");
			if (choice == 7) {
				break;
			}

			else if (choice == 1 || choice == 2 || choice == 3) {
				quan = getIntReply("Enter Quantity: ");
				System.out.println("");
				if (choice == 1) {
					quantity[0] += quan;
				} else if (choice == 2) {
					quantity[1] += quan;
				} else if (choice == 3) {
					quantity[2] += quan;
				}

			} else if (choice == 6) {
				printMenu();
				System.out.println("");
			}

		}
		System.out.println("<<<<<< THANK YOU >>>>>>");
		System.out.println("Facebook Page : SkeSkeRestaurant");
		System.out.println("Tel : 02-021-0200");

	}
}

