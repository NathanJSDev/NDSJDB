package LDatabaseControllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LDBController {

    private String InstantWorksFolder;
    private final String USER_DIR = System.getProperty("user.dir");
    private final String SEPARATOR = System.getProperty("file.separator");
    private final String DATABASES_FOLDER = "DataBases";
    private String BaseFolder = USER_DIR + SEPARATOR + DATABASES_FOLDER + SEPARATOR;
    
    public LDBController(){}
    
    public String getInstantWorksFolder() {
        return InstantWorksFolder;
    }
    
    public void setInstantWorksFolder(String instantWorksFolder) {
        InstantWorksFolder = instantWorksFolder;
    }

    public String getUSER_DIR() {
        return USER_DIR;
    }

    public String getSEPARATOR() {
        return SEPARATOR;
    }

    public String getDATABASES_FOLDER() {
        return DATABASES_FOLDER;
    }

    public String getBaseFolder() {
        return BaseFolder;
    }

    public void setBaseFolder(String baseFolder) {
        BaseFolder = baseFolder;
    }

    private boolean createFolder(String FolderName) {
        try {
            File f = new File(BaseFolder + FolderName);
            if (!f.exists()){f.mkdir();return true;}else return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean writeOn(String Path, String text) throws FileNotFoundException{
        File f = new File(Path);
        try {
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.print(text);
            out.close();
            return true;
        } catch (IOException e) { e.printStackTrace(); return false; }
    }

    public void createDBFolder(String DBName){
        String Path = BaseFolder + "dbs.csv";
        try {
            System.out.println(createFolder(DBName));
            writeOn(Path, ","+DBName);
            InstantWorksFolder = DBName;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable(String TableName, int NumberOfColumns){
        String CSVControl = BaseFolder + InstantWorksFolder + SEPARATOR + "tables.csv";
        String TableDat = BaseFolder + InstantWorksFolder + SEPARATOR + TableName + ".dat";

        try {
            System.out.println(writeOn(CSVControl, TableName + ".dat,"));
            System.out.println(writeOn(TableDat, String.valueOf(NumberOfColumns)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
