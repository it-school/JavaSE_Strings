package com.itschool;

import java.util.Random;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		String password = "";
		final int passLength = 8;
		Random random = new Random();

		for (int i = 0; i < passLength; i++) {
			switch (random.nextInt(4
			)) {
				case 0:
					password += ((char) (65 + random.nextInt(26)));
					break;
				case 1:
					password += ((char) (97 + random.nextInt(26)));
					break;
				case 2:
					password += ((char) (48 + random.nextInt(10)));
					break;
				case 3:
					password += ((char) (33 + random.nextInt(14)));
					break;
			}
		}
		String ucaseA = "";
		for (int i = 65; i < 91; i++) {
			ucaseA += (char) i;
		}
		String lcaseA = "";
		for (int i = 97; i < 97 + 26; i++) {
			lcaseA += (char) i;
		}
		String digits = "1234567890";
		String others = ",.!@#$%^&*()_+<>?:|\\\"`~'";

		System.out.println(password);

		boolean hasOther = false;
		for (char c : others.toCharArray()) {
			if (password.indexOf(c) >= 0) {
				hasOther = true;
				break;
			}
		}
		if (!hasOther) { password += others.toCharArray()[random.nextInt(others.length())]; }


		hasOther = false;
		for (char c : ucaseA.toCharArray()) {
			if (password.indexOf(c) >= 0) {
				hasOther = true;
				break;
			}
		}
		if (!hasOther) { password += ucaseA.toCharArray()[random.nextInt(ucaseA.length())]; }

		hasOther = false;
		for (char c : lcaseA.toCharArray()) {
			if (password.indexOf(c) >= 0) {
				hasOther = true;
				break;
			}
		}
		if (!hasOther) { password += lcaseA.toCharArray()[random.nextInt(lcaseA.length())]; }

		hasOther = false;
		for (char c : digits.toCharArray()) {
			if (password.indexOf(c) >= 0) {
				hasOther = true;
				break;
			}
		}
		if (!hasOther) { password += digits.toCharArray()[random.nextInt(digits.length())]; }

		System.out.println(password);
		Scanner scanner = new Scanner(System.in);
		//String yourPassword = scanner.nextLine();
		//System.out.println(password.trim().equals(yourPassword.trim()));

		password += "A";
		System.out.println(password);

		password.replace("A", "Z");
		System.out.println(password);
		System.out.println();
		StringBuilder pass = new StringBuilder(password);
		System.out.println(pass);
		pass.replace(pass.indexOf("A"), pass.indexOf("A") + 1, "Z");
		System.out.println(pass);
	}
}
