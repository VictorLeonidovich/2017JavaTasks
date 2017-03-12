package com.javarush.task.task31.task3102;

import com.sun.java.util.jar.pack.*;


import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
Реализовать логику метода getFileTree,
который должен в директории root найти список всех файлов включая вложенные.
Используй очередь, рекурсию не используй.
Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();
        Collections.addAll(fileTree, new File(root).listFiles());
        while (!fileTree.isEmpty()){
            File currentFile = fileTree.remove();
            if (currentFile.isDirectory()){
                Collections.addAll(fileTree, currentFile.listFiles());
            }else {
                result.add(currentFile.getAbsolutePath());
            }
        }

            return result;


    }
}
