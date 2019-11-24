package com.esisba2019.finalproject2019.evaluation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
@Controller
public class DiskFileExplorer {

    private String initialpath = "";
    private Boolean recursivePath = false;
    public int filecount = 0;
    public int dircount = 0;

    public static int numberOfFiles(File srcDir) {
        int count = 0;
        File[] listFiles = srcDir.listFiles();
        for(int i = 0; i < listFiles.length; i++){
            if (listFiles[i].isDirectory()) {
                count += numberOfFiles(listFiles[i]);
            } else if (listFiles[i].isFile()) {
                count++;
            }
        }
        return count;
    }
    @GetMapping("/evaluation")
    private String listDirectory(Model model) {
        String dir =  "C:\\archive";
        File file = new File(dir);
        File[] files = file.listFiles();
        HashMap<String, Integer> surveyMap = new LinkedHashMap<>();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() == true) {
//
                    File directory1=new File("uploads\\");
                    int fileCount1=numberOfFiles(directory1);
//                    System.out.println(fileCount1);
                    File directory=new File(files[i].getAbsolutePath());
                    int fileCount=numberOfFiles(directory);
//                    System.out.println(files[i].getName()+ " "+"Count:"+fileCount);

                    int performance = 0;
                    performance = fileCount *100 /fileCount1;

                    System.out.println( files[i].getName() + " Performance = "  +  performance +" "+"%");

                    surveyMap.put( files[i].getName(), performance);
//                    surveyMap.put( files[i].getName(), performance);
//					surveyMap.put("Dev oops", 25);
//					surveyMap.put("Python", 20);
//					surveyMap.put(".Net", 15);

                    model.addAttribute("surveyMap", surveyMap);

                    }




            }
            this.dircount++;
        }
        return "evaluation";
    }

//    @GetMapping("/displayPieChart")
//    public String pieChart(Model model) {
//        String dir =  "C:\\archivage2";
//        File file = new File(dir);
//        File[] files = file.listFiles();
//        HashMap<String, Integer> surveyMap = new LinkedHashMap<>();
//        if (files != null) {
//            for (int i = 0; i < files.length; i++) {
//                if (files[i].isDirectory() == true) {
////
//                    File directory1=new File("uploads\\");
//                    int fileCount1=numberOfFiles(directory1);
////                    System.out.println(fileCount1);
//                    File directory=new File(files[i].getAbsolutePath());
//                    int fileCount=numberOfFiles(directory);
////                    System.out.println(files[i].getName()+ " "+"Count:"+fileCount);
//
//                    int performance = 0;
//                    performance = fileCount *100 /fileCount1;
//
//                    System.out.println( files[i].getName() + " Performance = "  +  performance +" "+"%");
//                    String pass =files[i].getName();
//                    surveyMap.put( files[i].getName(), performance);
////                    surveyMap.put( files[i].getName(), performance);
////					surveyMap.put("Dev oops", 25);
////					surveyMap.put("Python", 20);
////					surveyMap.put(".Net", 15);
//
//                    model.addAttribute("surveyMap", surveyMap);
//
//                }
//            }
//            this.dircount++;
//        }
//
//        return "pieChart";
//    }
}