package com.esisba2019.finalproject2019.add;

import java.io.*;

public class Ajoutfiliale {
    public static void main(String args[]) throws IOException {
        File file = new File("data/filiale.txt");

        File temp = File.createTempFile("filiale", ".txt", file.getParentFile());
        String delete = "autre";
        String charset = "UTF-8";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), charset));
        for (String line; (line = reader.readLine()) != null;) {
            // ...
            line = line.replace(delete, "");
            writer.println(line);
            reader.close();
            writer.close();
            file.delete();
        }
//
//        double randomDouble = Math.random();
//        randomDouble = randomDouble * 100 +44;
//        int randomInt = (int) randomDouble;
//        System.out.println(randomInt);
//
//        FileWriter fileWriter = new FileWriter(file, true); //Set true for append mode
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//
//       printWriter.println(randomInt+":"+" "+ et+":"+" "+"-- Document Separator -- reut2-013.sgm");
//        printWriter.println(et);//New line
//        printWriter.close();


  }}

