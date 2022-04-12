package com.itschool;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
   private static final int CAESAR_CODE = 3;
   private static String alphabetVigenere;
   private static char[][] vigenereTable;

   public static void main(String[] args) {
      theory();

      practice();

      homeTask3();
      homeTask4();
      homeTask9();

      moreExamples();
   }

   /**
    * Теоретическая часть
    */
   private static void theory() {
      Scanner scanner = new Scanner(System.in);

      System.out.println("\uD80C\uDC36"); // Unicode

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
      System.out.println("\nПравильное сравнение строк на равенство в Java\nВведите число '11111': ");
      number2 = scanner.nextLine();
      System.out.println("|" + number1 + "|");
      System.out.println("|" + number2 + "|");
      System.out.println("Равенство объектов: " + (number1 == number2));
      System.out.println("Равенство значений: " + number1.equals(number2));
      System.out.println();

      // Сравнение строк на примере проверки логина и пароля
      String login = "login", password = "Pa$$w0rd";
      int hash = password.hashCode();

      System.out.println("Input login: ");
      String userLogin = scanner.nextLine();

      System.out.println("Input password: ");
      String userPassword = scanner.nextLine();
      int userPasswordHash = userPassword.hashCode();

      System.out.println("L: " + (int) 'L' + "\tl: " + (int) 'l');
      System.out.println("Лексикографическое сравнение без учёта регистра: " + (login.equalsIgnoreCase(userLogin.strip()) && hash == userPasswordHash ? "OK" : "Incorrect login or" + " " + "password"));
      System.out.println("Сравнение с учётом кодов символов (вычитание кодов символов строки): " + login.compareTo(userLogin));
      System.out.println();

      // Проверка наличия символа/подстроки в строке
      String text = "Text example for checking in Strings";
      String needle = "FO1R";
      if (text.toLowerCase().contains(needle.toLowerCase())) {
         System.out.println(text + " contains " + needle);
         System.out.println("It's position is: " + text.toLowerCase().indexOf(needle.toLowerCase()));
      } else System.out.println(text + " NOT contains " + needle);

      System.out.println();

      String filename = "file.xlsx";
      System.out.println(filename + (filename.toLowerCase().endsWith(".TXT".toLowerCase()) ? "" : " NOT") + " ends with TXT");
      System.out.println();

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
      System.out.println();

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
      System.out.println();

      // Поиск символа/подстроки в строке
      String finderText = "45aqreq 45 fdgs 567 f45 fhdgh67 45b 45 hdh3345 dgh";
      needle = "45";

      int position = -1, counter = 0;
      while ((position = finderText.indexOf(needle, position + 1)) >= 0) counter++;

      System.out.println(needle + " found in text " + counter + " times");

      String newText = finderText.replace("45", "$$");
      System.out.println(newText);
      System.out.println();

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

   /**
    * Несколько практических примеров
    */
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
         if (text.charAt(i) >= '0' && text.charAt(i) <= '9') numCounter++;
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
         if (Character.isWhitespace(text.charAt(i))) wordsCounter++;
      }
      System.out.println("Oue text consists of " + ++wordsCounter + " word" + (numCounter != 1 ? "s" : ""));
   }

   /**
    * Ещё практические примеры
    */
   private static void moreExamples() {
      Scanner scanner = new Scanner(System.in);

      // Проверка соответствия автомобильного номера формату украинских номеров 2020 года
      String number = " ВH1234aE ";
      System.out.println(number + (isCorrectAutoNumber(number) ? "" : "НЕ") + "корректный автомобильный номер");
      System.out.println();

      // Преобразование всей строки к нижнему регистру, а первой буквы - к строчной
      System.out.println("\nПреобразование всей строки к нижнему регистру, а первой буквы - к строчной:");
      String name = "iVANOV";
      System.out.println(name + " -> " + capitalize(name));
      System.out.println();

      // Шифрование строки шифром Цезаря
      System.out.println("\nШифрование/дешифрование строки шифром Цезаря:");
      String cryptedText = CaesarCipher("CAESAR");
      System.out.println(cryptedText);
      String decryptedText = CaesarUnCipher(cryptedText);
      System.out.println(decryptedText);
      System.out.println();


      // Шифрование строки шифром Виженера
      System.out.println("\nШифрование/дешифрование строки шифром Виженера:");
      String text = "The Vigenere cipher is a method of encrypting alphabetic text by using a series of interwoven Caesar ciphers, based on the letters of a keyword.";
      System.out.println((alphabetVigenere = getAlphabet(text))); // Формирование алфавита
      fillVigenereTable(alphabetVigenere);                        // Заполнение таблицы для шифрования
      String key = genKey(alphabetVigenere, 1);         // Генерация ключа шифрования
      System.out.println(key);

      String encryptedText = cypherVigenere(text, key);          // Шифрование текста с ключом
      System.out.println(encryptedText);

      System.out.println(text);
      decryptedText = uncypherVigenere(encryptedText, key);      // Дешифрование текста с ключом
      System.out.println(decryptedText);
      System.out.println(text.equals(decryptedText));            // Сравнение исходного и расшифрованного текста
      System.out.println();


      // Генерация и проверка пароля
      System.out.println("\nГенерация и проверка пароля:");
      String password = generatePassword(8);
      System.out.println("Сгенерирован пароль: " + password);
      System.out.println("Корректен ли пароль: " + password + "\t- " + isCorrectPassword(password));
      System.out.println("Корректен ли пароль: Pa$$w0rd\t- " + isCorrectPassword(" Pa$$w0rd "));
      System.out.println();


      // Использование регулярных выражений
      regexpExample();
      System.out.println();


      // Формирование английского алфавита циклом
      System.out.println("\nФормирование всего английского алфавита (в верхнем и нижнем регистре) одним циклом:");
      String UCASE_letters = "";
      for (char c = 'A'; c <= 'z'; c++) {
         if (c > 'Z' && c < 'a') continue;
         UCASE_letters += c;
      }
      System.out.println(UCASE_letters);
      System.out.println();


      // Принудительный контроль ввода числового значения с помощью цикла и обработки исключений
      String string = "";
      int first;
      boolean isCorrectNumber = false;

      do {
         System.out.println("Введите целочисленное значение (можно попробовать сделать это с ошибкой): ");
         string = scanner.nextLine();
         try {
            first = Integer.parseInt(string);
            System.out.println(first);
            isCorrectNumber = true;
         } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
         }
      } while (!isCorrectNumber);
   }

   /**
    * Удалить из строки пробелы и определить, является ли она перевертышем
    */
   private static void homeTask3() {
      String string = "Qwerty   uiop  poiu     ytrewQ";
      StringBuilder sbstring = new StringBuilder(string);
      System.out.println(string);
      System.out.println(sbstring);

      string = string.replace(" ", "");
      System.out.println(string);

      int p = 0;
      do {
         p = sbstring.indexOf(" ", 0);
         if (p >= 0) sbstring.replace(p, p + 1, "");
         System.out.println(sbstring);
      } while (p >= 0);

      boolean isReversed = true;
      for (int i = 0; i < string.length() / 2; i++) {
         if (!(string.charAt(i) == string.charAt(string.length() - 1 - i))) {
            isReversed = false;
            break;
         }
      }
      System.out.println(isReversed ? "Palindrom" : "Not palindrom");

      isReversed = true;
      for (int i = 0; i < string.length() / 2; i++) {
         if (!(sbstring.charAt(i) == sbstring.charAt(string.length() - 1 - i))) {
            isReversed = false;
            break;
         }
      }
      System.out.println(isReversed ? "Palindrom" : "Not palindrom");
   }

   /**
    * Найти в строке указанную подстроку и заменить ее на новую.
    */
   private static void homeTask4() {
      String string = "Qwerty   uiop  poiu   poiu  ytrewQ";
      StringBuilder sbstring = new StringBuilder(string);

      String textOld = "poiu";
      String textNew = "12345";

//      string = string.replace(textOld, textNew);

      int pos = -1;
      do {
         pos = string.indexOf(textOld);
         if (pos >= 0) string = string.substring(0, pos) + textNew + string.substring(pos + textOld.length());
      } while (pos >= 0);
      System.out.println(string);
   }

   /**
    * Вводится строка, состоящая из слов, разделенных пробелами. Требуется посчитать количество слов в ней
    */
   private static void homeTask9() {
      String string = "Qwerty   uiop  poiu  poiu  ytrewQ";
      System.out.println(string.split("\s+").length);
   }

   /**
    * приведение первого символа строки к верхнему регистра, остальных символов - к нижнему регистру
    *
    * @param str
    *
    * @return
    */
   private static String capitalize(final String str) {
      return str.strip().substring(0, 1).toUpperCase() + str.strip().substring(1).toLowerCase();
   }

   /**
    * Удаляет часть строки
    *
    * @param string строка из которой удаляем подстроку
    * @param start  с какой позиции удаляем
    * @param end    по какую позицию удаляем
    *
    * @return строку без удалённого фрагмента
    */
   private static String delete(String string, int start, int end) {
      return string.substring(0, start) + string.substring(end + 1);
   }

   private static void replace(StringBuilder s1, String needle, String replacement) {
      int pos = -1;
      while ((pos = s1.indexOf(needle)) >= 0) {
         s1.replace(pos, pos + 1, replacement);
         // s1.setCharAt(pos, replacement.charAt(0));
      }
   }

   /**
    * Проверка производительности поиска в строке при помощи регулярных выражений
    */
   private static void regexpExample() {
      System.out.println("\nПроверка производительности поиска в строке при помощи регулярных выражений:");
      String text = "Егор Алла Александр";
      long start = System.currentTimeMillis();
      String result = "";
      Pattern pattern;
      Matcher matcher;
      pattern = Pattern.compile("А.+а");
      for (int i = 0; i < 1000000; i++) {
         matcher = pattern.matcher(text);
         matcher.find();
         {
            result = text.substring(matcher.start(), matcher.end());
            //System.out.println(text.substring(matcher.start(), matcher.end()));
         }
      }

      long stop = System.currentTimeMillis();
      System.out.println("При помощи регулярных выражений:\t" + (stop - start) + " мс");

      int p1, p2;
      for (int i = 0; i < 1000000; i++) {
         p1 = text.indexOf("А");
         p2 = text.indexOf("а", p1 + 1);
         result = text.substring(p1, p2);
      }
      System.out.println("С использованием линейного поиска:\t" + (System.currentTimeMillis() - stop) + " мс");
   }

   /**
    * Шифрование шифром Виженера
    *
    * @param encryptedText исходный текст
    * @param key           ключ
    *
    * @return зашифрованный текст
    */
   private static String cypherVigenere(String encryptedText, String key) {
      String result = "";
      int posH;
      int posV;
      for (int i = 0; i < encryptedText.length(); i++) {
         posH = alphabetVigenere.indexOf(encryptedText.charAt(i));
         posV = alphabetVigenere.indexOf(key.charAt(i % key.length()));
         result += vigenereTable[posH][posV];
      }

      return result;
   }

   /**
    * дешифрование шифра Виженера
    *
    * @param text зашифрованный текст
    * @param key  ключ
    *
    * @return расшифрованный текст
    */
   private static String uncypherVigenere(final String text, final String key) {
      String result = "";
      int posH = 0;
      int posV = 0;
      for (int i = 0; i < text.length(); i++) {
         //posV = alphabetVigenere.indexOf(text.charAt(i));
         posV = alphabetVigenere.indexOf(key.charAt(i % key.length()));
         for (int j = 0; j < alphabetVigenere.length(); j++) {
            if (vigenereTable[posV][j] == text.charAt(i)) posH = j;
         }
         result += vigenereTable[0][posH];
      }

      return result;
   }

   /**
    * Генерация ключа для шифра Виженера
    *
    * @param alphabetVigenere алфавит
    * @param keyLength        длина ключа
    *
    * @return ключ
    */
   private static String genKey(final String alphabetVigenere, final int keyLength) {
      String newKey = "";
      int counter = 0;
      char c = 0;
      Random random = new Random();

      while (counter < keyLength) {
         do {
            c = alphabetVigenere.charAt(random.nextInt(alphabetVigenere.length()));
         } while (newKey.contains("" + c));
         newKey += c;
         counter++;
      }

      return newKey;
   }

   /**
    * Заполнение таблицы для шифрования шифром Виженера
    *
    * @param alphabetVigenere двумерный массив-таблица
    */
   private static void fillVigenereTable(final String alphabetVigenere) {
      vigenereTable = new char[alphabetVigenere.length()][alphabetVigenere.length()];
      for (int row = 0; row < alphabetVigenere.length(); row++) {
         for (int col = 0; col < alphabetVigenere.length(); col++) {
            vigenereTable[row][col] = alphabetVigenere.charAt((row + col) % alphabetVigenere.length());
            System.out.print(vigenereTable[row][col] + " ");
         }
         System.out.println();
      }
   }

   /**
    * Формирование алфавита из текста
    *
    * @param text
    *
    * @return строка со всеми различными символами из текста
    */
   private static String getAlphabet(final String text) {
      String alphabet = "";

      for (Character c : text.toCharArray()) {
         if (!alphabet.contains(c + "")) alphabet += c;
      }

      return alphabet;
   }

   /**
    * Шифрование шифром Цезаря
    *
    * @param text исходный текст
    *
    * @return зашифрованный текст
    */
   private static String CaesarCipher(final String text) {
      return ShiftCipher(text, CAESAR_CODE);
   }

   /**
    * Дешифрование шифром Цезаря
    *
    * @param text зашифрованный текст
    *
    * @return исходный текст
    */
   private static String CaesarUnCipher(final String text) {
      return ShiftCipher(text, -CAESAR_CODE);
   }

   /**
    * Шифрование со смещением
    *
    * @param text кодируемый текст
    * @param KEY  ключ шифрования (смещение)
    *
    * @return зашифрованный текст
    */
   private static String ShiftCipher(final String text, final int KEY) {
      String result = "";

      for (Character c : text.toCharArray()) {
         //System.out.println(c + " : " + (int) c);
         result += (char) (((int) c) + KEY);
      }

      return result;
   }

   /**
    * Замена кириллических символов на аналогичные по начертанию латинские
    *
    * @param number строка в которой есть символы для замены
    *
    * @return строка с заменёнными символами
    */
   private static String glyphSubstitute(String number) {
      String result = "";

      String engChars = new String(new char[]{'A', 'B', 'C'});
      String cyrChars = new String(new char[]{'А', 'В', 'С'});

      int pos = -1;
      for (char symbol : number.toCharArray()) {
         if (cyrChars.contains(symbol + "")) {
            pos = cyrChars.indexOf(symbol + "");
            result += engChars.substring(pos, pos + 1);
         } else result += symbol;
      }

      return result;
   }

   /**
    * Проверка корректности автомобильного номера Украины
    *
    * @param number проверяемая строка с номером
    *
    * @return корректен ли номер
    */
   private static boolean isCorrectAutoNumber(String number) {
      final String autoNumberChars = "ETIOPAHKXCBM";
      number = glyphSubstitute(number.strip().toUpperCase());
      //System.out.println("|"+number+"|");

      char char1 = number.charAt(0);
      char char2 = number.charAt(1);
      char char7 = number.charAt(6);
      char char8 = number.charAt(7);

      if (autoNumberChars.contains(char1 + "") && autoNumberChars.contains(char2 + "") && autoNumberChars.contains(char7 + "") && autoNumberChars.contains(char8 + "")) {
         for (int symbol = 2; symbol <= 5; symbol++) {
            if (!Character.isDigit(number.charAt(symbol))) {
               return false;
            }
         }
      } else {
         return false;
      }

      return true;
   }


   /**
    * Проверка корректности пароля (длина >= 8 символов, содержит большую и маленькую букву, цифру и прочий символ)
    *
    * @param password проверяемый пароль
    *
    * @return true, если корректный, false - если некорректный
    */
   private static boolean isCorrectPassword(String password) {
      boolean hasUpper = false, hasLower = false, hasDigit = false, hasNonLetterOrDigit = false, result = false;
      password = password.strip();
      if (password.length() < 8) {
         System.out.println("Incorrect length: " + password.length());
      } else {
         for (int i = 0; i < password.length(); i++) {
            if (!hasDigit && Character.isDigit(password.charAt(i))) {
               hasDigit = true;
            }
            if (!hasUpper && Character.isUpperCase(password.charAt(i))) {
               hasUpper = true;
            }
            if (!hasLower && Character.isLowerCase(password.charAt(i))) {
               hasLower = true;
            }
            if (!hasNonLetterOrDigit && !Character.isAlphabetic(password.charAt(i)) && !Character.isDigit(password.charAt(i))) {
               hasNonLetterOrDigit = true;
            }
            if (hasDigit && hasUpper && hasLower && hasNonLetterOrDigit) {
               result = true;
               break;
            }
         }

         if (!hasDigit) {
            System.out.println("No digit");
         }
         if (!hasUpper) {
            System.out.println("No UPPERCASE letter");
         }
         if (!hasLower) {
            System.out.println("No lowercase letter");
         }
         if (!hasNonLetterOrDigit) {
            System.out.println("No symbol neither letter nor digit");
         }

      }
      return result;
   }

   /**
    * генерация случайного пароля заданной длины
    *
    * @param passLength длина пароля
    *
    * @return сгенерированный пароль
    */
   private static String generatePassword(final int passLength) {
      String password = "";
      Random random = new Random();

      // добавление случайных символов из случайных наборов
      for (int i = 0; i < passLength; i++) {
         switch (random.nextInt(4)) {
            case 0 -> password += ((char) (65 + random.nextInt(26)));   // прописные буквы
            case 1 -> password += ((char) (97 + random.nextInt(26)));   // строчные буквы
            case 2 -> password += ((char) (48 + random.nextInt(10)));   // цифры
            case 3 -> password += ((char) (33 + random.nextInt(14)));   // остальные символы
         }
      }

      // добавление символов из диапазона прописных букв
      String uppercaseLetters = "";
      for (int i = 65; i < 91; i++) {
         uppercaseLetters += (char) i;
      }
      boolean hasUcase = false;
      for (char c : uppercaseLetters.toCharArray()) {
         if (password.indexOf(c) >= 0) {
            hasUcase = true;
            break;
         }
      }
      if (!hasUcase) {
         password += uppercaseLetters.toCharArray()[random.nextInt(uppercaseLetters.length())];
      }


      // добавление символов из диапазона строчных букв
      String lowercaseLetters = "";
      for (int i = 97; i < 97 + 26; i++) {
         lowercaseLetters += (char) i;
      }
      boolean hasLcase = false;
      for (char c : uppercaseLetters.toCharArray()) {
         if (password.indexOf(c) >= 0) {
            hasLcase = true;
            break;
         }
      }
      if (!hasLcase) {
         password += lowercaseLetters.toCharArray()[random.nextInt(lowercaseLetters.length())];
      }


      // добавление символов из диапазона цифр
      String digits = "1234567890";
      boolean hasDigit = false;
      for (char c : digits.toCharArray()) {
         if (password.indexOf(c) >= 0) {
            hasDigit = true;
            break;
         }
      }
      if (!hasDigit) {
         password += digits.toCharArray()[random.nextInt(digits.length())];
      }

      // добавление символов из диапазона остальных символов
      String otherSymbols = ",.!@#$%^&*()_+<>?:|\\\"`~'";
      boolean hasOther = false;
      for (char c : otherSymbols.toCharArray()) {
         if (password.indexOf(c) >= 0) {
            hasOther = true;
            break;
         }
      }
      if (!hasOther) {
         password += otherSymbols.toCharArray()[random.nextInt(otherSymbols.length())];
      }


      return password;
   }
}
