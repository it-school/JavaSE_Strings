package com.itschool;

import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      // theory();
      practice();
   }

   private static void practice() {
      // 1
      char c = '³';
      System.out.println((int) c);

      // 2
      int n = 10;

      for (int i = 65; i < 65 + n; i++) {
         System.out.println((char) i);
      }

      // 10
      String text = "Дана строка. Вывести строку, содержащую те же символы, но расположенные в обратном порядке";
      String reversedText = "";
      for (int i = text.length() - 1; i >= 0; i--) {
         reversedText += text.charAt(i);
         System.out.println(reversedText);
      }

      reversedText = "";
      for (int i = 0; i < text.length(); i++) {
         reversedText += text.charAt(text.length() - 1 - i);
         System.out.println(reversedText);
      }

      StringBuilder revTextBuilder = new StringBuilder();
      for (int i = text.length() - 1; i >= 0; i--) {
         revTextBuilder.append(text.charAt(i));
         System.out.println(revTextBuilder);
      }

      // 13
      text = "Даны целые положительные числа N1 и N2 и строки S1 и S2";
      int numCounter = 0;
      for (int i = 0; i < text.length(); i++) {
         if (text.charAt(i) >= '0' && text.charAt(i) <= '9')
            numCounter++;
      }
      System.out.println("Text contains " + numCounter + " number" + (numCounter != 1 ? "s" : ""));

      // 41
      System.out.println("\n\n41:");
      text = "    Дана строка, состоящая  из  русских  слов,  разделенных пробелами (одним  или несколькими). Найти количество слов в строке.";
      System.out.println(text);
      text = text.strip();
      System.out.println(text);

      /*
      while (text.indexOf("  ") >= 0 || text.indexOf("\t\t") >= 0)
      {
         text = text.replace("  ", " ");
         text = text.replace("\t\t", "\t");
      }
       */

      for (int i = 0; i < text.length() - 1; i++) {
         if (Character.isWhitespace(text.charAt(i)) && Character.isWhitespace(text.charAt(i + 1))) {
            text = text.substring(0, i) + text.substring(i + 1);
         }
      }
      System.out.println(text);

      int wordsCounter = 0;
      for (int i = 0; i < text.length() - 1; i++) {
         if (Character.isWhitespace(text.charAt(i)))
            wordsCounter++;
      }
      System.out.println("Oue text consists of " + ++wordsCounter + " word" + (numCounter != 1 ? "s" : ""));
   }

   private static void theory() {
      Scanner scanner = new Scanner(System.in);

/*      String number1 = "12345", number2 = "12345";
      System.out.println(number1 + number2);
      int number = Integer.parseInt(number1);
      System.out.println(number + 123);

      System.out.println(number1 + number2 + 555);
      System.out.println(123 + 456 + number1 + number2);
      System.out.println(number1 + number2 + (123 + 456));

      System.out.println(number1 == number2);
      System.out.println(number1.equals(number2));


      number2 = scanner.nextLine();
      System.out.println("|" + number1 + "|");
      System.out.println("|" + number2 + "|");
      System.out.println(number1 == number2);
      System.out.println(number1.equals(number2));*/

      /*
      String login = "login", password="Pa$$w0rd";
      int hash = password.hashCode();

      System.out.println("Input login: ");
      String userLogin = scanner.nextLine();

      System.out.println("Input password: ");
      String userPassword = scanner.nextLine();
      int userPasswordHash = userPassword.hashCode();

      System.out.println(login.equalsIgnoreCase(userLogin.strip())&& hash == userPasswordHash ? "OK" : "Incorrect login or password");
//      System.out.println(login.compareTo(userLogin));
//      System.out.println((int)'L' + "\t" + (int)'l');
*/
      String text = "Text example for checking in Strings";
      String needle = "FO1R";
      if (text.toLowerCase().contains(needle.toLowerCase())) {
         System.out.println(text + " contains " + needle);
         System.out.println("It's position is: " + text.toLowerCase().indexOf(needle.toLowerCase()));
      } else
         System.out.println(text + " NOT contains " + needle);

      System.out.println();

      String filename = "file.xlsx";
      System.out.println(filename + (filename.toLowerCase().endsWith(".TXT".toLowerCase()) ? "" : " NOT") + " ends with TXT");

      char[] charsArray = text.toCharArray();
      charsArray[4] = '*';
      for (int i = 0; i < charsArray.length; i++) {
         System.out.print(charsArray[i]);
      }
      String string = new String(charsArray);
      System.out.println(string);

      String string1 = text.substring(0, 12) + "*" + text.substring(13);
      System.out.println(string1);


      String num = "2³";
      char[] num3 = num.toCharArray();
      int w = 0;
      switch (num3[1]) {
         case 0x00B9:
            w = 1;
            break;
         case 0x00B2:
            w = 2;
            break;
         case 0x00B3:
            w = 3;
            break;
      }
      System.out.println(w);

      try {
         int num1 = Integer.parseInt(num);
         Integer num2 = Integer.getInteger(num);
         System.out.println(num1);
         System.out.println(num2);
      } catch (Exception e) {
         System.out.println("Conversion error");
         System.out.println(e.getLocalizedMessage());
      }

      String finderText = "aqreq 45 fdgs 567 f45 fhdgh67 45b 45 hdh3345 dgh";
      needle = "45";

      int position = 0, counter = 0;

      while ((position = finderText.indexOf(needle, position + 1)) >= 0)
         counter++;

      System.out.println(needle + " found in text " + counter + " times");

      String newText = finderText.replace("45", "$$");
      System.out.println(newText);

      String s1 = " ";
      StringBuilder s2 = new StringBuilder(" ");
/*      while (true) {
         s2.append(" ");
      }

 */
      int N = 10;
      String string4 = String.valueOf(N);
      String string5 = "" + N;
      System.out.println(string4);
      System.out.println(string5);
   }


}
