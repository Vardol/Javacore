package ru.minachev.javacore.utils;

import java.util.Random;
import java.util.random.*;
public class Utils {
    public static void printIntArray(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length-1; i++) {
            System.out.print(array[i]);
            System.out.print(", ");
        }
        System.out.print(array[array.length-1]);
        System.out.println("]");
    }

    public static void fillIntArray(int[] array, int startPos, int endPos){
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(startPos, endPos);
        }
    }

}
