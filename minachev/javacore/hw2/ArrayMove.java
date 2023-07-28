package ru.minachev.javacore.hw2;
/*Написать метод, принимающий на вход массив чисел и параметр n. Метод должен осуществить циклический
(последний элемент при сдвиге становится первым) сдвиг всех элементов массива на n позиций;*/
import ru.minachev.javacore.utils.Utils;

public class ArrayMove {

    public static int[] arrayMove(int[] inputArray, int moveFactor){
        //возвращаем исходный массив, если сдвиг не нужен или двигать нечего
        if (inputArray == null || moveFactor % inputArray.length == 0 || inputArray.length <= 1){
            return inputArray;
        }

        //приводим фактор сдвига к масштабу  массива
        moveFactor = moveFactor % inputArray.length;

        //для универсальности алгоритма, преобразовываем отрицательный фактор сдвига в положительный
        if (moveFactor < 0){
            moveFactor = inputArray.length + moveFactor;
        }

        int[] result = new int[inputArray.length];

        //собственно сдвигаем элементы в два прихода (до фактора сдвига и после)
        for (int i = 0; i < (inputArray.length - moveFactor); i++) {
            result[i + moveFactor] = inputArray[i];
        }

        for (int i = inputArray.length - moveFactor; i < inputArray.length; i++) {
            result[i - (inputArray.length - moveFactor)] = inputArray[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        Utils.fillIntArray(array,0,1000); //использую свои вспомогательные методы из вспомогательного своего класса
        System.out.println("Сгенерирован случайный массив:");
        Utils.printIntArray(array);
        System.out.println("---------------------------------------");
        System.out.println("Сдвинутый массив:");
        int[] sortedArray = arrayMove(array, -1452);
        Utils.printIntArray(sortedArray);
    }
}
