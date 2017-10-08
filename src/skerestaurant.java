

import java.util.Scanner;

public class MenuSystem {
	static Scanner console = new Scanner(System.in);
	static int[] price = { 250, 150, 45 };
	static String[] order = { "Pizza", "Chickens", "Coke" };
	static int[] quantity = { 0, 0, 0 };

	public static int getIntReply(String prompt) {
		System.out.print(prompt);
		int c = console.nextInt();
		return c;
	}

	static void menu() {
		System.out.println("-------------- Welcome to SKE Restautant --------------");
		for (int i = 0; i < order.length; i++) {
			System.out.printf("%d.) %s\t\t%5d Baht.\n", i + 1, order[i], price[i]);
		}
		System.out.printf("%d.) Total\n", order.length + 1);
		System.out.printf("%d.) Exit", order.length + 2);
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
				System.out.printf("|\t%-8s\t|\t%d\t|\t%d\t|\n", order[i], quantity[i], quantity[i] * price[i]);
		}
		System.out.print("|_______________________|_______________|_______________|\n");
		System.out.printf("|\tTotal\t\t\t\t\t%d\t|\n", totalPrice());
		System.out.print("|_______________________________________________________|\n");
	}

	public static void main(String[] args) {

		menu();
		int quan = 0;

		while (true) {
			int choice = getIntReply("Enter your Choice: ");
			if (choice == 5) {
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

			} else if (choice == 4) {
				printMenu();
				System.out.println("");
			}

		}
		System.out.println("<<<<<< THANK YOU >>>>>>");
		System.out.println("Facebook Page : SkeSkeRestaurant");
		System.out.println("Tel : 02-021-0200");

	}
}
