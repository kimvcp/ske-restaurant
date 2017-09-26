

import java.awt.Choice;
import java.nio.charset.MalformedInputException;
import java.util.Scanner;

public class skerestaurant {
	static Scanner sc = new Scanner(System.in);
	static int readInt(String text) {
		System.out.print(text);
		int c = sc.nextInt();
		return c;
	}
	static void menu(int pizza , int chickens,int coke) {
		System.out.print(" _______________________________________________________\n");
		System.out.print("|_______ Menu __________|_____ Qty _____|_____ Price ___|\n");
		if(pizza>0)System.out.printf("|\tPizza\t\t|\t%d\t|\t%d\t|\n",pizza,pizza*250);
		if(chickens>0)System.out.printf("|\tChickens\t|\t%d \t|\t%d\t|\n",chickens,chickens*120);
		if(coke>0)System.out.printf("|\tCoke\t\t|\t%d\t|\t%d\t|\n",coke,coke*45);
		System.out.print("|_______________________|_______________|_______________|\n");
		System.out.printf("|\tTotal\t\t\t\t\t%d\t|\n",(pizza*250)+(chickens*120)+(coke*45));
		System.out.print("|_______________________________________________________|\n");
	}
	public static void main(String[] args) {
		
		System.out.println("-------------- Welcome to SKE Restautant --------------");
		System.out.printf("1.) Pizza\t\t%5d Baht.\n", 250);
		System.out.printf("2.) Chickens\t\t%5d Baht.\n", 120);
		System.out.printf("3.) Coke\t\t%5d Baht.\n", 45);
		System.out.println("4.) Total");
		System.out.println("5.) Exit");
		System.out.println("");
		int quan=0;
		int sumpizza = 0;
		int sumchickens =0;
		int sumcoke = 0;
		
		while (true) {
			int choice = readInt("Enter your Choice: ");
			if (choice == 5) {
				break;
			}
				
			
			else if(choice == 1 || choice == 2 || choice == 3){
			quan = readInt("Enter Quantity: ");
			System.out.println("");
			if(choice == 1) {
				sumpizza += quan;	
			}
			else if(choice == 2) {
				sumchickens += quan;	
			}
			else if(choice == 3) {
				sumcoke += quan;	
			}
			
		}else if(choice== 4) {
			menu(sumpizza, sumchickens, sumcoke);
			System.out.println("");
		}
		

	}System.out.println("<<<<<< THANK YOU >>>>>>");
	System.out.println("Facebook Page : SkeSkeRestaurant");
	System.out.println("Tel : 02-021-0200");

	
}
}