package com.esisba2019.finalproject2019.modify;

import com.esisba2019.finalproject2019.model.Filiale;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.*;

@Controller
public class MyController2 {

    @GetMapping("/supprimerFiliale")
    public String sendForm(Filiale filiale) {

        return "supprimerFiliale";
    }

    @PostMapping("/supprimerFiliale")
    public String processForm(Filiale filiale) throws IOException {
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

        writeTo(str.toString(), fichier,filiale);

        return "showMessage";
    }
    private static void writeTo(String data, String fichier,Filiale filiale) throws IOException {
        String et = filiale.getName();
        FileWriter writer = new FileWriter(fichier);
        writer.write(data.replaceAll(et, ""));
        writer.close();
    }
}