package com.esisba2019.finalproject2019.modify;

import java.io.*;

public class DeleteFiliale {

    public static void main(String[] args) {
        try {
            String fichier = "data/filiale.txt";
            InputStream fis = new FileInputStream(fichier);
            Reader reader = new InputStreamReader(fis, "utf-8");
            BufferedReader input = new BufferedReader(reader);
            String line = null;
            StringBuilder str = new StringBuilder();
            while ((line = input.readLine()) != null) {
                str.append(line);
                str.append("\n");
            }

            writeTo(str.toString(), fichier);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private static void writeTo(String data, String fichier) throws IOException {
        String et = "sara";
        FileWriter writer = new FileWriter(fichier);
        writer.write(data.replaceAll(et, ""));
        writer.close();
    }
}