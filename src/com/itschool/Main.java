package com.itschool;

import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      theory();

      practice();
   }

   private static void practice() {
      // 1 - Дан символ C. Вывести его код (т. е. номер в кодовой таблице)
      char c = '³';
      System.out.println((int) c);

      // 4 - Дано целое число N (1 ≤ N ≤ 26). Вывести N первых прописных (т. е. заглавных) букв латинского алфавита
      int n = 10;
      for (int i = 65; i < 65 + n; i++) {
         System.out.println((char) i);
      }

      // 10 - Дана строка. Вывести строку, содержащую те же символы, но расположенные в обратном порядке
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

      // 13 - Дана строка. Подсчитать количество содержащихся в ней цифр
      text = "Даны целые положительные числа N1 и N2 и строки S1 и S2";
      int numCounter = 0;
      for (int i = 0; i < text.length(); i++) {
         if (text.charAt(i) >= '0' && text.charAt(i) <= '9')
            numCounter++;
      }
      System.out.println("Text contains " + numCounter + " number" + (numCounter != 1 ? "s" : ""));

      // 41 - Дана строка, состоящая из русских слов, разделенных пробелами/табуляциями (одним или несколькими). Найти количество слов в строке
      System.out.println("\n\n41:");
      text = "    Дана   строка, состоящая  из   русских  слов,  разделенных пробелами    (одним   или  несколькими).  Найти  количество    слов в строке.   ";
      System.out.println(text);
      text = text.strip();
      System.out.println(text);

/*
      // Простой способ избавиться от множественных пробелов и табуляций
      while (text.indexOf("  ") >= 0 || text.indexOf("\t\t") >= 0)
      {
         text = text.replace("  ", " ");
         text = text.replace("\t\t", "\t");
      }
*/
      // Способ избавиться от любых разделителей, идущих более 1 раза подряд
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

      // Сложение (конкатенация) строк со строками, строк и числовых значений, порядок сложения смешанных типов данных
      String number1 = "11111", number2 = "22222";
      System.out.println(number1 + number2);
      int number = Integer.parseInt(number1);
      System.out.println(number + 33333);

      System.out.println(number1 + number2 + 555);
      System.out.println(123 + 456 + number1 + number2);
      System.out.println(number1 + number2 + (123 + 456));

      System.out.println(number1 == number2);
      System.out.println(number1.equals(number2));


      // Правильное сравнение строк на равенство в Java
      number2 = scanner.nextLine();
      System.out.println("|" + number1 + "|");
      System.out.println("|" + number2 + "|");
      System.out.println(number1 == number2);
      System.out.println(number1.equals(number2));


      // Сравнение строк на примере проверки логина и пароля
      String login = "login", password = "Pa$$w0rd";
      int hash = password.hashCode();

      System.out.println("Input login: ");
      String userLogin = scanner.nextLine();

      System.out.println("Input password: ");
      String userPassword = scanner.nextLine();
      int userPasswordHash = userPassword.hashCode();

      System.out.println("L: " + (int) 'L' + "\tl: " + (int) 'l');
      System.out.println("Лексикографическое сравнение без учёта регистра: " + (login.equalsIgnoreCase(userLogin.strip()) && hash == userPasswordHash ? "OK" : "Incorrect login or" +
              " " + "password"));
      System.out.println("Сравнение с учётом кодов символов (вычитание кодов символов строки): " + login.compareTo(userLogin));


      // Проверка наличия символа/подстроки в строке
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


      // Замена символа в строке
      char[] charsArray = text.toCharArray();
      charsArray[4] = '*';
      for (int i = 0; i < charsArray.length; i++) {
         System.out.print(charsArray[i]);
      }
      String string = new String(charsArray);
      System.out.println(string);

      String string1 = text.substring(0, 12) + "*" + text.substring(13);
      System.out.println(string1);


      // Извлечение специфических цифр из строки в число
      String num = "2³", numb = "234";
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
         Integer num2 = Integer.getInteger(numb);
         System.out.println(num1);
         System.out.println(num2);
      } catch (Exception e) {
         System.out.println("Conversion error");
         System.out.println(e.getLocalizedMessage());
      }


      // Поиск символа/подстроки в строке
      String finderText = "aqreq 45 fdgs 567 f45 fhdgh67 45b 45 hdh3345 dgh";
      needle = "45";

      int position = 0, counter = 0;

      while ((position = finderText.indexOf(needle, position + 1)) >= 0)
         counter++;

      System.out.println(needle + " found in text " + counter + " times");

      String newText = finderText.replace("45", "$$");
      System.out.println(newText);


      // Строка с изменяемым содержимым
      StringBuilder s2 = new StringBuilder(" ");
/*      while (true) {
         s2.append(" ");
      }
 */

      // Преобразование числового значения в строковое
      int N = 10;
      String string4 = String.valueOf(N); // Простой способ
      String string5 = "" + N;            // Ещё более простой, а с Java 15 ещё и быстрый
      System.out.println(string4);
      System.out.println(string5);
   }


}
