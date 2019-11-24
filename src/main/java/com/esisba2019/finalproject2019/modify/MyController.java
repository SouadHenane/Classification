package com.esisba2019.finalproject2019.modify;

import com.esisba2019.finalproject2019.model.Filiale;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class MyController {

    @GetMapping("/ajouterFiliale")
    public String sendForm(Filiale filiale) {

        return "ajouterFiliale";
    }

    @PostMapping("/ajouterFiliale")
    public String processForm(Filiale filiale) throws IOException {

        File file = new File("data/filiale.txt");
        String et = filiale.getName();
        double randomDouble = Math.random();
        randomDouble = randomDouble * 100 +44;
        int randomInt = (int) randomDouble;
        System.out.println(randomInt);

        FileWriter fileWriter = new FileWriter(file,true); //Set true for append mode
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println(randomInt+":"+" "+ et+":"+" "+"-- Document Separator -- reut2-013.sgm");
        printWriter.println(et);//New line
        printWriter.close();

        return "showMessage";
    }
}