package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Drug{
    String name;
    String dosage;
    String description;
    String tableTime;
    File drug;

    public Drug(String name,String dosage,String description ,String tableTime){
        this.name = name;
        this.dosage = dosage;
        this.description = description;
        this.tableTime = tableTime;

        drug = new File("/Users/applestore/IdeaProjects/Medical Assitant/src/classes/Drug/" + name + ".txt");
    }

    public void saveInfo(){
        try{
            PrintWriter writer = new PrintWriter(drug);
            writer.println(name);
            writer.println(dosage);
            writer.println(tableTime);
            writer.print(description);
            writer.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public String getDescription() {
        return description;
    }

    public String getDosage() {
        return dosage;
    }

    public String getName() {
        return name;
    }

    public String getTableTime() {
        return tableTime;
    }

    public void setDescription(String description) {
        this.description = description;
        saveInfo();
    }

    public void setDosage(String dosage) {

        this.dosage = dosage;
        saveInfo();
    }
    public void setTableTime(String tableTime) {
        this.tableTime = tableTime;
        saveInfo();

    }

    public void setName(String name) {
        this.name = name;
        drug.renameTo(new File("/Users/applestore/IdeaProjects/Medical Assitant/src/classes/Drug" + name + "/txt"));
        saveInfo();
    }

    @Override
    public String toString() {
        return name;
    }
}
