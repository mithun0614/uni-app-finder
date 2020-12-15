package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class VerifyLogin {

	static Scanner input;
	static String filepath = "members.txt";

	/*
	 * Checks if the username and password pair entered matches a pair in the
	 * members.txt file
	 */
	public static boolean verifyLogin(String username, String password) {
		String tempUsername;
		String tempPassword;
		boolean found = false;

		try {
			input = new Scanner(new File(filepath));
			input.useDelimiter(",");

			while (input.hasNext() && !found) {
				tempUsername = input.next();
				tempPassword = input.next();

				if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
					found = true;
				}
			}

		} catch (Exception e) {
			System.out.println("error");
		}
		return found;
	}

	/*
	 * Checks if the username they entered when creating account already exists. If
	 * so, they will not be allowed to create another account
	 */
	public static boolean existingUsername(String username) {
		int index = 0;
		try {
			input = new Scanner(new File("members.txt"));
			input.useDelimiter(",");

			while (input.hasNext()) {
				if (index % 9 == 0) {
					String existingUser = input.next();
					if (existingUser.trim().equals(username.trim())) {
						return false;
					}
				}
				index++;
			}
			input.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not Found :(");
		}
		return true;
	}

	/*
	 * Checks if the password they entered matches the second password. This
	 * confirms they have entered the correct password.
	 */
	public static boolean verifyPassword(String password, String password1) {
		if (password.trim().equals(password1.trim())) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Checks if there are any spaces or commas. There cannot be any spaces/commas
	 * as we use .trim() which removes spaces, and the comma is used to separate the
	 * username and password.
	 */
	public static boolean unwantedCharacter(String username, String password) {
		char[] name = username.toCharArray();
		char[] pw = password.toCharArray();

		for (int x = 0; x < name.length; x++) {
			if (name[x] == ',' || name[x] == ' ') {
				return true;
			}
		}
		for (int x = 0; x < pw.length; x++) {
			if (pw[x] == ',' || pw[x] == ' ') {
				return true;
			}
		}
		return false;
	}

	/*
	 * When the user creates their account, this method saves it to the members.txt
	 * file.
	 */
	public static void saveLogin(String username, String password) throws IOException {
		File file = new File("members.txt");
		FileWriter fw = new FileWriter(file, true);
		PrintWriter pw = new PrintWriter(fw);

		pw.println(username + "," + password + ",");
		pw.close();
	}
}
