//Написать метод «Шифр Цезаря», с булевым параметром зашифрования и расшифро- вания и числовым ключом;

package ru.minachev.javacore.hw2;

public class CaesarCode {

    public static String caesarCode(String input, int key, boolean encode){
        char[] charArray = input.toCharArray();
        char[] result = new char[charArray.length];
        if (!encode){
            key *= -1;
        }
        String ignoredChars = " ?!(),.#";
        //char[] ignoredChars = new char[]{' ', '!', '?', '#', ',', '.', '@', '(', ')', '&', '%'}; //список знаков, которые шифровать не будем

        for (int i = 0; i < charArray.length; i++) {
            if (ignoredChars.contains("" + charArray[i])) {
                result[i] = charArray[i];
            } else {
                result[i] = (char)(charArray[i] + key);
            }
        }
        String str = new String(result);
        return str;
    }

    public static void main(String[] args) {
        String str = "Hello!";
        System.out.println(str);
        System.out.println(caesarCode(str,7,true));
        System.out.println(caesarCode(caesarCode(str,7,true),5,false));
    }
}
