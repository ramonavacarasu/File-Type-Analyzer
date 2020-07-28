package analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.Callable;

public class Worker implements Callable {

    private File currentFile;
    private String pattern;
    public String result;

    public Worker(File currentFile, String pattern, String result) {
        this.currentFile = currentFile;
        this.pattern = pattern;
        this.result = result;
    }

    @Override
    public Object call() {


        try (BufferedReader br = new BufferedReader(new FileReader(currentFile))) {

            String aString;

            while ((aString = br.readLine()) != null) {

                if (KMPAlgorthmSearch.KMPSearch(aString, pattern)) {
                    return currentFile.getName() + ": " + result;
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return currentFile.getName() + ": Unknown file type";

    }



}