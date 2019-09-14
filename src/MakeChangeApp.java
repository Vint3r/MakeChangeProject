import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double amountOwed = 0.0, amountPaid = 0.0, amountMore = 0;
		int convertOwed = 0, convertPaid = 0;
		boolean choice = true;

		System.out.println("Welcome to the cash register!");

		while (choice) {
			System.out.println("Please choose an option:");
			System.out.println("1.) Add item to cart");
			System.out.println("2.) Pay for your current items");
			System.out.println("3.) Quit or cancel (will terminate all transactions)");
			String userIn = input.next();

			switch (userIn.toLowerCase()) {
			case "add item":
			case "add":
			case "1":
			case "one":
				System.out.println("How much is the item, your current balance due is: $" + amountOwed);
				amountOwed += input.nextDouble();
				System.out.println("Thank you, your new balance due is: $" + amountOwed);
				continue;
			case "pay":
			case "2":
				amountMore = amountOwed - amountPaid;
				System.out.println("How much will you tender? Your current balance due is $" + amountMore);
				amountPaid = input.nextDouble();
				convertOwed = (int) (amountOwed * 100);
				convertPaid += (int) (amountPaid * 100);

				if (convertOwed > convertPaid) {
					amountMore = amountOwed - amountPaid;
					System.out.printf("You paid $%.2f you need to pay $%.2f more to buy everything.\n", amountPaid, amountMore);
				} else if (convertOwed == convertPaid) {
					System.out.println("Thank you, you paid the exact amount!");
					amountOwed = 0;
					amountPaid = 0;
					convertOwed = 0; 
					convertPaid = 0;
				} else {
					String changeBack = getChange(convertOwed, convertPaid);
					System.out.println("Your change back is: " + changeBack);
					amountOwed = 0;
					amountPaid = 0;
					convertOwed = 0; 
					convertPaid = 0;
				}
				continue;
			case "3":
			case "quit":
			case "cancel":
				if (amountOwed != 0) {
					System.out.println("Thank you, your transaction has been cancelled. Have a great day!");
					amountOwed = 0;
					choice = false;
					break;
				} else {
					System.out.println("Thank you for shopping with us today!");
					choice = false;
					break;
				}
			default:
				System.out.println("That is not a valid option, please try again.");
				continue;
			}
		}

		input.close();

	}

	public static String getChange(int amountOwed, int amountPaid) {
		int totalChange = amountPaid - amountOwed;
		String changeBack = "";

		while (totalChange != 0) {
			if (totalChange >= 2000) {
				totalChange -= 2000;
				changeBack += "A 20 dollar bill,";
			} else if (totalChange >= 1000) {
				totalChange -= 1000;
				changeBack += " a 10 dollar bill,";
			} else if (totalChange >= 500) {
				totalChange -= 500;
				changeBack += " a 5 dollar bill,";
			} else if (totalChange >= 100) {
				totalChange -= 100;
				changeBack += " a 1 dollar bill,";
			} else if (totalChange >= 25) {
				totalChange -= 25;
				changeBack += " a quarter,";
			} else if (totalChange >= 10) {
				totalChange -= 10;
				changeBack += " a dime,";
			} else if (totalChange >= 5) {
				totalChange -= 5;
				changeBack += " a nickel,";
			} else {
				totalChange -= 1;
				changeBack += " a penny,";
			}
		}
		return changeBack;
	}

}
