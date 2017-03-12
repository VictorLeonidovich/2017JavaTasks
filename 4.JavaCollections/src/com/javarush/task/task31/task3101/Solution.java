package com.javarush.task.task31.task3101;


import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;


/*
Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый — path — путь к директории, второй — resultFileAbsolutePath — имя файла,
 который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его (используй метод FileUtils.deleteFile).
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
2.2.2. Переименовать resultFileAbsolutePath в ‘allFilesContent.txt‘
(используй метод FileUtils.renameFile).
2.2.3. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1.
 Тела файлов разделять «n«.
Все файлы имеют расширение txt.
*/
public class Solution
{
    /*private static int fileCount = 0;
    private static int folderCount = 0;
    private static int fileSize = 0;*/
    //private static TreeMap<String, Path> map1 = new TreeMap<>();
    private static ArrayList<Path> map = new ArrayList<>();

    public static void main(String[] args) throws  Exception {
        Path path = Paths.get(args[0]);


        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        /*fileCount++;
                        fileSize = fileSize + path.*/
                        if (file.toFile().length() > 50) {
                            FileUtils.deleteFile(file.toFile());
                        } else if (file.toFile().length() <= 50 && file.toFile().length() > 0) {
                            map.add(file);
                        }
                        return FileVisitResult.CONTINUE;
                    }

                }
        );
        Collections.sort(map, (o1, o2) -> o1.toFile().getName().compareTo(o2.toFile().getName()));

        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + File.separator + "allFilesContent.txt");
        //System.out.println(resultFileAbsolutePath.getAbsolutePath() + allFilesContent.getAbsolutePath());
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        OutputStream fileOutputStream = new FileOutputStream(allFilesContent);
        InputStream fileInputStream = null;
        for (int i = 0; i < map.size(); i++) {
            fileInputStream = new FileInputStream(map.get(i).toFile());
            while (fileInputStream.available() > 0){
                fileOutputStream.write(fileInputStream.read());
            }
            fileOutputStream.write(System.lineSeparator().getBytes());
            fileInputStream.close();
        }
        fileOutputStream.close();
    }
    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
