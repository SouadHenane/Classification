package com.esisba2019.finalproject2019.classifiers;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Lister le contenu d'un répertoire
 * http://www.fobec.com/java/964/lister-fichiers-dossiers-repertoire.html
 * @author fobec 2010
 */
public class DiskFileExplorer {

    private String initialpath = "";
    private Boolean recursivePath = false;
    public int filecount = 0;
    public int dircount = 0;

    /**
     * Constructeur
     * @param path chemin du répertoire
     * @param subFolder analyse des sous dossiers
     */
    public DiskFileExplorer(String path, Boolean subFolder) {
        super();
        this.initialpath = path;
        this.recursivePath = subFolder;
    }

    public void list() {
        this.listDirectory(this.initialpath);
    }
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
    private void listDirectory(String dir) {
        File file = new File(dir);
        File[] files = file.listFiles();

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

//                    System.out.println( files[i].getName() + " Performance = "  +  performance +" "+"%");
                    final List<KeyValue> pieDataList;
                    pieDataList = new ArrayList<KeyValue>();
                    Map<String,Long> barChartData = new HashMap<>();
                    barChartData.put(files[i].getName(), (long) performance);
//                        pieDataList.add(new KeyValue(files[i].getName(), performance));
                        System.out.println(barChartData);

                    }
                    this.dircount++;

//                } else {
//                    System.out.println("  Fichier: " + files[i].getName());
//                    this.filecount++;
//                }
//                if (files[i].isDirectory() == true && this.recursivePath == true) {
//                    this.listDirectory(files[i].getAbsolutePath());
//                }
            }
        }

    }

    public static void main(String[] args) {
        String pathToExplore = "C:\\archivage2";
        DiskFileExplorer diskFileExplorer = new DiskFileExplorer(pathToExplore, true);
        Long start = System.currentTimeMillis();
        diskFileExplorer.list();
//        System.out.println("----------");
//        System.out.println("Analyse de " + pathToExplore + " en " + (System.currentTimeMillis() - start) + " mses");

    }
}