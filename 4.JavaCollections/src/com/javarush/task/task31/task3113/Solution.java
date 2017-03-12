package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;



/* 
Что внутри папки?
Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.

Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией — выведи «[полный путь] — не папка» и заверши работу.
Затем посчитай и выведи следующую информацию:

Всего папок — [количество папок в директории]
Всего файлов — [количество файлов в директории и поддиректориях]
Общий размер — [общее количество байт, которое хранится в директории]

Используй только классы и методы из пакета java.nio.
*/
/*public class Solution {
    public static long filesCount = 0;
    public static long foldersCount = 0;
    public static long fileSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();


        Path filePath = Paths.get(path);
        if (!filePath.toFile().isDirectory()) {
            System.out.println(filePath.toAbsolutePath().toString() + " - не папка");
            return;
        }else{
        Files.walkFileTree(filePath, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                filesCount++;
                fileSize = fileSize + attrs.size();
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                foldersCount++;
                return super.preVisitDirectory(dir, attrs);
            }
        });

        System.out.println("Всего папок - " + foldersCount);
        System.out.println("Всего файлов - " + filesCount);
        System.out.println("Общий размер - " + fileSize);

    }
    }


}*/

public class Solution {
    static int countFolder =0;
    static int countFiles =0;
    static long countSize =0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String folderName = reader.readLine();
        Path path= Paths.get(folderName);
        if (!Files.isDirectory(path))
        {
            System.out.println(path.toAbsolutePath().toString() + " - не папка");
            return;
        }
        Files.walkFileTree(path, new MyFileVisitor());
        System.out.println("Всего папок - " + (countFolder - 1));
        System.out.println("Всего файлов - " + countFiles);
        System.out.println("Общий размер - " + countSize);
    }
    static class MyFileVisitor extends SimpleFileVisitor <Path>
    {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            countFiles++;
            countSize+= attrs.size();
            return super.visitFile(file, attrs);
        }
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            countFolder++;
            return super.preVisitDirectory(dir, attrs);
        }
    }
}