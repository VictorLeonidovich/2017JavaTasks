package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
Реализовать логику FileConsoleWriter.
Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter.
Класс FileConsoleWriter должен содержать все конструкторы,
 которые инициализируют fileWriter для записи.

При записи данных в файл, должен дублировать эти данные на консоль.
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        super(fileName, append);
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        super(file);
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        super(file, append);
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        super(fd);
        fileWriter = new FileWriter(fd);
    }

    @Override
    public void write(int c) throws IOException {
        super.write(c);
        System.out.println(c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        super.write(cbuf, off, len);
        System.out.println(String.valueOf(cbuf).substring(off, off + len));
    }
    private char[] buff;
    @Override
    public void write(String str, int off, int len) throws IOException {
        char[] cbuf;
        if (len <= 1024){
            if (buff == null){
                buff = new char[1024];
            }
            cbuf = buff;
        }else {
            cbuf  = new char[len];
        }
        str.getChars(off, (off + len), cbuf, 0);
        write(cbuf, 0, len);

    }

    @Override
    public void write(char[] cbuf) throws IOException {
        write(cbuf, 0, cbuf.length);

    }

    @Override
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    public static void main(String[] args) {

    }

}
