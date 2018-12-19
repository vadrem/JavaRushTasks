package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName,true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception{

        String fileName = "C:/Vadrem/test.txt";
        Solution solution1 = new Solution(fileName);

        solution1.writeObject("Тест1");

        FileOutputStream fileOutput = new FileOutputStream("C:/Vadrem/text.txt");

        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        solution1.writeObject(outputStream);

        fileOutput.close();
        outputStream.close();

        FileInputStream fiStream = new FileInputStream("C:/Vadrem/text.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        solution1.readObject(objectStream);

        fiStream.close();
        objectStream.close();

        solution1.writeObject("Тест2");

    }
}
