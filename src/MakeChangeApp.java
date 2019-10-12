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
				System.out.printf("How much is the item, your current balance due is: $%.2f \n", amountOwed);
				amountOwed += input.nextDouble();
				System.out.printf("Thank you, your new balance due is: $%.2f \n", amountOwed);
				continue;
			case "pay":
			case "2":
			case "two":
				amountMore = amountOwed - amountPaid;
				System.out.printf("How much will you tender? Your current balance due is $%.2f \n", amountMore);
				amountPaid = input.nextDouble();
				convertOwed = (int) (amountOwed * 100);
				convertPaid += (int) (amountPaid * 100);

				if (convertOwed > convertPaid) {
					amountMore = amountOwed - amountPaid;
					System.out.printf("You paid $%.2f you need to pay $%.2f more to buy everything.\n", amountPaid,
							amountMore);
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
			case "three":
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
		int amount = 0;

		while (totalChange != 0) {
			if (totalChange >= 2000) {
				amount = totalChange / 2000;
				totalChange -= 2000 * amount;
				changeBack += amount + " 20 dollar bill(s), ";
			} else if (totalChange >= 1000) {
				amount = totalChange / 1000;
				totalChange -= 1000 * amount;
				changeBack += amount + " 10 dollar bill(s), ";
			} else if (totalChange >= 500) {
				amount = totalChange / 500;
				totalChange -= 500 * amount;
				changeBack += amount + " 5 dollar bill(s), ";
			} else if (totalChange >= 100) {
				amount = totalChange / 100;
				totalChange -= 100 * amount;
				changeBack += amount + " 1 dollar bill(s), ";
			} else if (totalChange >= 25) {
				amount = totalChange / 25;
				totalChange -= 25 * amount;
				changeBack += amount + " quarter(s), ";
			} else if (totalChange >= 10) {
				amount = totalChange / 10;
				totalChange -= 10 * amount;
				changeBack += amount + " dime(s), ";
			} else if (totalChange >= 5) {
				amount = totalChange / 5;
				totalChange -= 5 * amount;
				changeBack += amount + " nickel(s), ";
			} else {
				amount = totalChange / 1;
				totalChange -= 1 * amount;
				changeBack += amount + " penny(s).";
			}
		}
		return changeBack;
	}

}
