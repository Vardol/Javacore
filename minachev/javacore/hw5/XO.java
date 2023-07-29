package ru.minachev.javacore.hw5;

/*
2. Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой,
например, состояния ячеек поля для игры в крестикинолики, где 0 – это пустое поле, 1 – это поле с крестиком,
2 – это поле с ноликом, 3 – резервное значение. Такое предположение позволит хранить в одном числе типа int всё поле 3х3.
Реализовать функционал с записью в файл и обратно игрового поля. Выводить в консоль игровое поле после импорта,
заменяя числа символами X, O, •(пусто)
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XO {

    //метод для красивого отображени поля в консоль
    public static void printField(String field) {
        if (field.length() != 9) {
            throw new RuntimeException("invalid field size!");
        }

        char[] fieldCharArray = field.toCharArray();
        System.out.println("_____________");

        for (int i = 0; i < 9; i++) {

            if (fieldCharArray[i] != '0' && fieldCharArray[i] != '1'
                    && fieldCharArray[i] != '2' && fieldCharArray[i] != '3') {
                throw new RuntimeException("Field value out of bounds [0,3]!");
            }
            if (i % 3 == 0) {
                System.out.print("| ");
            }

            if (fieldCharArray[i] == '0') {
                System.out.print("   ");
            }
            if (fieldCharArray[i] == '1') {
                System.out.print(" X ");
            }
            if (fieldCharArray[i] == '2') {
                System.out.print(" O ");
            }
            if (fieldCharArray[i] == '3') {
                System.out.print(" ? ");
            }
            if (i % 3 == 2) {
                System.out.println(" |");
            }
        }
        System.out.println("_____________");


    }


    //два варианта записывающего метода - с указанием пути и с путем по умолчанию
    public static void storeField(String field) {
        try {
            Files.write(Paths.get("field.txt"), field.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void storeField(String field, String path) {
        try {
            Files.write(Paths.get(path), field.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //два варианта считывающего метода - с указанием пути и с путем по умолчанию
    public static String readField(){
        try {
            return Files.readString(Paths.get("field.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readField(String path){
        try {
            return Files.readString(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //тестим методы в Main
    public static void main(String[] args) {
        String field = "012300123";
        printField(field);
        storeField(field);

        String field2 = readField();
        printField(field2);

    }

}
