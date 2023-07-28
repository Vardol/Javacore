/* Доделать сортировку подсчетом с урока (если нет, реализовать) классическим способом через промежуточный массив
(см. последние минут 10 семинара)
*/


package ru.minachev.javacore.hw2;

import ru.minachev.javacore.utils.Utils;

public class CountSort {

    //собственно метод сортировки
    public static int[] countSort(int[] array){
        int[] map = new int[1001]; //сортировка для массива целых чисел от 0 до 1000
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            map[array[i]]++; //здесь будет выкидываться outofboundsexception, если во входном массиве есть отрицательные числа или числа>1000
        }
        int j = 0;
        for (int i = 0; i < map.length; i++) {
            for (int k = 0; k < map[i]; k++) {
                result[j] = i;
                j++;
            }
        }

        return result;
    }

    //применение
    public static void main(String[] args) {
        int[] array = new int[10];
        Utils.fillIntArray(array,0,1000); //использую вспомогательные методы из вспомогательного своего класса
        Utils.printIntArray(array);
        System.out.println("---------------------------------------");
        int[] sortedArray = countSort(array);
        Utils.printIntArray(sortedArray);
    }
}
