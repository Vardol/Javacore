package ru.minachev.javacore.hw5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


//1. Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup
public class FilesBackup {

    public static void fileBackup(String folderPath) {
        File folder = new File(folderPath);
        //Path folder = Paths.get(".");

        Path backupPath = Paths.get(folderPath + "backup/").normalize();

        if (!Files.exists(backupPath)) {
            try {
                Files.createDirectory(backupPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        if (folder.listFiles() != null && folder.listFiles().length > 0) {
            for (File file : folder.listFiles()) {
                if (!file.isDirectory()) {
                    try {
                        Files.copy(Paths.get(file.getAbsolutePath()).normalize(), Paths.get(backupPath + "/" + file.getName()), REPLACE_EXISTING);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }

    }

    public static void main(String[] args) {
        fileBackup("D:\\developer\\ru\\minachev\\javacore\\hw5\\");
    }

}
