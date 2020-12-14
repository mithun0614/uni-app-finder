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

	public static boolean verifyPassword(String password, String password1) {
		if (password.trim().equals(password1.trim())) {
			return true;
		} else {
			return false;
		}
	}
	
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

	public static void saveLogin(String username, String password) throws IOException {
		File file = new File("members.txt");
		FileWriter fw = new FileWriter(file, true);
		PrintWriter pw = new PrintWriter(fw);

		pw.println(username + "," + password + ",");
		pw.close();
	}
}
