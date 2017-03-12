package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();
    //int count = -1;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        //count += 1;
        long fileSize = Files.size(file);
        String buff = new String(Files.readAllBytes(file));
        /*if (partOfName != null && partOfContent != null) {
            if (file.getFileName().toString().toLowerCase().contains(partOfName.toLowerCase()) && (buff.contains(partOfContent))) {
                foundFiles.add(file);
            }
        }*/
        if (partOfName == null) {

            if ((partOfContent == null)) {
                if (minSize == 0){
                    if (maxSize == 0){
                        foundFiles.add(file);
                    }else if (fileSize <= maxSize){
                        foundFiles.add(file);
                    }
                }else if (fileSize >= minSize){
                    if (maxSize == 0){
                        foundFiles.add(file);
                    }else if (fileSize <= maxSize){
                        foundFiles.add(file);
                    }
                }

            } else if ((buff.contains(partOfContent))) {
                if (minSize == 0){
                    if (maxSize == 0){
                        foundFiles.add(file);
                    }else if (fileSize <= maxSize){
                        foundFiles.add(file);
                    }
                }else if (fileSize >= minSize){
                    if (maxSize == 0){
                        foundFiles.add(file);
                    }else if (fileSize <= maxSize){
                        foundFiles.add(file);
                    }
                }

            }
        } else if (
                file.getFileName().toString().toLowerCase().contains(partOfName.toLowerCase())) {

            if ((partOfContent == null)) {
                if (minSize == 0){
                    if (maxSize == 0){
                        foundFiles.add(file);
                    }else if (fileSize <= maxSize){
                        foundFiles.add(file);
                    }
                }else if (fileSize >= minSize){
                    if (maxSize == 0){
                        foundFiles.add(file);
                    }else if (fileSize <= maxSize){
                        foundFiles.add(file);
                    }
                }

            } else if ((buff.contains(partOfContent))) {
                if (minSize == 0){
                    if (maxSize == 0){
                        foundFiles.add(file);
                    }else if (fileSize <= maxSize){
                        foundFiles.add(file);
                    }
                }else if (fileSize >= minSize){
                    if (maxSize == 0){
                        foundFiles.add(file);
                    }else if (fileSize <= maxSize){
                        foundFiles.add(file);
                    }
                }

            }
        }

            return super.visitFile(file, attrs);
        }

        /*if (partOfName == null) {
            foundFiles.add(file);
        } else if (
                file.getFileName().toString().toLowerCase().contains(partOfName.toLowerCase())) {
            foundFiles.add(file);
        }*/
        /*if ((partOfContent == null) && (!foundFiles.contains(file))) {
            foundFiles.add(file);
        } else if ((buff.contains(partOfContent)) && (!foundFiles.contains(file))) {
            foundFiles.add(file);
        }*/
        /*if (minSize == 0 && (!foundFiles.contains(file))){
            foundFiles.add(file);
        }else if (fileSize >= minSize && (!foundFiles.contains(file))){
            foundFiles.add(file);
        }*/
        /*if (maxSize == 0 && (!foundFiles.contains(file))){
            foundFiles.add(file);
        }else if (fileSize <= maxSize && (!foundFiles.contains(file))){
            foundFiles.add(file);
        }
*/


        /*else
        if (partOfContent == null){ foundFiles.add(file);} else if (
                buff.toLowerCase().contains(partOfContent.toLowerCase())){
            foundFiles.add(file);
        }*/
            /*if ((maxSize == 0 || fileSize <= maxSize) && (minSize == 0 || fileSize >= minSize)){


                    if (buff.contains(partOfContent) || partOfContent == null){
                        foundFiles.add(file);
                    }
            }*/



        /*if (!Files.isRegularFile(file)){return FileVisitResult.CONTINUE;}
        String content = new String(Files.readAllBytes(file)*//*, StandardCharsets.UTF_8*//*);
        boolean isPartOfName;
        boolean isPartOfContent;
        boolean isMoreThenMinSize;
        boolean isLessThenMaxSize;

        if ((partOfName != null) && partOfContent != null && ((Integer)minSize == null || Files.size(file) >= minSize) && ((Integer)maxSize == null || Files.size(file) <= maxSize)){
            foundFiles.add(file);
        }
        *//*if (partOfName != null){
         isPartOfName = file.getFileName().toString().contains(partOfName);}else {
             isPartOfName = true;}
        if (partOfContent != null){isPartOfContent = content.contains(partOfContent);}else {
            isPartOfContent = true;}
        if (minSize == 0){isMoreThenMinSize = file.toFile().length() > minSize;}else {
            isMoreThenMinSize = true;}
        if (maxSize == 0){isLessThenMaxSize = file.toFile().length() < maxSize;}else {
            isLessThenMaxSize = true;}
        if (isPartOfName && isPartOfContent && isMoreThenMinSize && isLessThenMaxSize){
            foundFiles.add(file);
        }*/

      /*if (partOfName != null){ file.getFileName().toString().contains(partOfName);}
        else if (partOfContent != null){
                (() | content.contains(partOfContent)) &&
                ((minSize == 0) | file.toFile().length() > minSize) &&
                ((maxSize == 0) | file.toFile().length() < maxSize)){
            foundFiles.add(file);
        }*/

          /*boolean isPartOfName = file.getFileName().toString().contains(partOfName);
        boolean isPartOfContent = content.contains(partOfContent);
        boolean isMoreThenMinSize = file.toFile().length() > minSize;
        boolean isLessThenMaxSize = file.toFile().length() < maxSize;*/
            //System.out.println(file.toFile().length());
        //System.out.println(partOfName + " " + partOfContent + " " + minSize + " " + maxSize);
        //System.out.println(isPartOfName + " " + isPartOfContent + " " + isMoreThenMinSize + " " + isLessThenMaxSize);

        /*if (isPartOfName && (partOfContent == "") && (minSize == 0) && (maxSize == 2147483647)){
            foundFiles.add(file);
        }else*//* if (isPartOfName && isPartOfContent && isMoreThenMinSize && isLessThenMaxSize){
            foundFiles.add(file);
        }*/
        




    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
