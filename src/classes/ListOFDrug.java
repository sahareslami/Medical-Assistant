package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOFDrug {
    public static File listFile = new File("/Users/applestore/IdeaProjects/Medical Assitant/src/classes/ListOfDrug/list");
    public static List<Drug> listOfDrug = new ArrayList<>();

    public static void makeList(){
        try{
            Scanner scan = new Scanner(listFile);
            while(scan.hasNext()){
                File currentFile = new File("/Users/applestore/IdeaProjects/Medical Assitant/src/classes/Drug/" + scan.next() + ".txt");
                try{
                    Scanner scanDrug = new Scanner(currentFile);
                    String name = scanDrug.next();
                    String dosage = scanDrug.next();
                    String tableTime = scanDrug.next();
                    String discription = "";
                    while(scanDrug.hasNext()){
                        discription += scanDrug.next() + " ";
                    }
                    listOfDrug.add(new Drug(name , dosage , tableTime , discription));
                }
                catch (FileNotFoundException e){
                    e.printStackTrace();
                }
            }

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public static void add(Drug d){
        listOfDrug.add(d);
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(listFile, true));
            writer.print(d.getName() + " ");
            writer.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
