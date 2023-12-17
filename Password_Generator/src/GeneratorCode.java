//Anit Sankar
//Password Generator Project
import java.util.Scanner;
import java.util.Random;

public class GeneratorCode {
	
	public static void main(String[] args) {
		System.out.println(Generator());
	}
	
	/***
	 * No input, but asks user for password preferences (Length, numbers, special characters)
	 * Creates arrays of lowercase and uppercase letters, numbers, special characters	 
	 * Generates randomized password (random order too) based on user preferences
	 * @return Password as a string.
	 */
	static String Generator() {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
	//Getting User Preference
		System.out.println("Welcome! To begin generating your password, enter the requirements down below");
		System.out.print("Enter the total length: ");
		int passwordLength = input.nextInt();
		input.nextLine();
		
		System.out.print("Do you want to use numbers? Enter 'yes' or 'no': ");
		String numbersPreference = input.nextLine();
		
		System.out.print("Do you want to use special characters? Enter 'yes' or 'no': ");
		String specialCharPreference = input.nextLine();
		
	//Generating arrays based on user preference
		char[] lowercaseLetters = new char[26];
		char[] uppercaseLetters = new char[26];
		int[] numbersArray = new int[10];
		String specialCharacters = "!@#$%^&*()-+/?";
		
		//Lower case letters
		int lowercaseIndex = 0;
		for (char letter = 'a'; letter <= 'z'; letter++) {
			lowercaseLetters[lowercaseIndex] = letter;
			lowercaseIndex++;
		}
		
		//Upper case letters
		int uppercaseIndex = 0;
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			uppercaseLetters[uppercaseIndex] = letter;
			uppercaseIndex++;
		}
		
		//Numbers		
		for (int i = 0; i <= 9; i++) {
			numbersArray[i] = i;
		}
		
		//Special characters
		specialCharacters.toCharArray();
		
	//Password Generating Process		
		String Password = "";
		int choice;
		for (int i = 0; i < passwordLength; i++) {
			if (numbersPreference.equalsIgnoreCase("yes") && specialCharPreference.equalsIgnoreCase("yes")) {
				choice = random.nextInt(4);
				if (choice == 0) {
					Password += lowercaseLetters[random.nextInt(lowercaseLetters.length - 1)];
				}
				else if (choice == 1) {
					Password += uppercaseLetters[random.nextInt(uppercaseLetters.length - 1)];
				}
				else if (choice == 2) {
					Password += String.valueOf(numbersArray[random.nextInt(numbersArray.length - 1)]);
				}
				else {
					Password += specialCharacters.charAt(random.nextInt(specialCharacters.length() - 1));
				}
			}
			else if (numbersPreference.equalsIgnoreCase("yes") && specialCharPreference.equalsIgnoreCase("no")) {
				choice = random.nextInt(3);
				if (choice == 0) {
					Password += lowercaseLetters[random.nextInt(lowercaseLetters.length - 1)];
				}
				else if (choice == 1) {
					Password += uppercaseLetters[random.nextInt(uppercaseLetters.length - 1)];
				}
				else {
					Password += String.valueOf(numbersArray[random.nextInt(numbersArray.length - 1)]);
				}
			}
			else if (numbersPreference.equalsIgnoreCase("no") && specialCharPreference.equalsIgnoreCase("yes")) {
				choice = random.nextInt(3);
				if (choice == 0) {
					Password += lowercaseLetters[random.nextInt(lowercaseLetters.length - 1)];
				}
				else if (choice == 1) {
					Password += uppercaseLetters[random.nextInt(uppercaseLetters.length - 1)];
				}
				else {
					Password += specialCharacters.charAt(random.nextInt(specialCharacters.length() - 1));
				}
			}
			else {
				choice = random.nextInt(2);
				if (choice == 0) {
					Password += lowercaseLetters[random.nextInt(lowercaseLetters.length - 1)];
				}
				else {
					Password += uppercaseLetters[random.nextInt(uppercaseLetters.length - 1)];
				}
			}
		}
	
		input.close();
		
	//Returning randomly generated Password
		return "Your password: " + Password;
	}
}
