/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.projettp3;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
/**
 *
 * @author MSI
 */
public class FileHandler {
    private String filepath;
    private int fileSizeInKb;
    private int numberOfLines;
    private ArrayList<String> fileConent;
    
    public FileHandler(String filePath) throws IOException{
        File f= new File (filePath);
          if(!f.exists()) {
              System.out.println("chemin n'existe pas");
             
        } else {
              this.filepath=filePath;
              this.fileSizeInKb = (int)f.length()/1024;}
              this.numberOfLines=countLines(filePath);
              this.fileConent=ReadFile(filePath);
             
        }

    public String getFilepath() {
        return filepath;
    }

    public int getFileSizeInKb() {
        return fileSizeInKb;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public ArrayList<String> getFileConent() {
        return fileConent;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public void setFileSizeInKb(int fileSizeInKb) {
        this.fileSizeInKb = fileSizeInKb;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public void setFileConent(ArrayList<String> fileConent) {
        this.fileConent = fileConent;
    }


 
        private static int countLines(String filePath) throws IOException {
        // Open the file using FileReader and wrap it in a BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int lines = 0;
            // Read each line until the end of the file
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        }
    }
        public ArrayList<String> ReadFile(String filePath) throws FileNotFoundException, IOException{
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
              String line;
              ArrayList<String> arr=new ArrayList();
              while ((line = br.readLine()) != null) {
                arr.add(line);
             }
              return arr;
            }
        
              

}
        public ArrayList<String> findLinesWithPatterns(String pattern) throws FileNotFoundException, IOException{
            
                String line;
                ArrayList<String> arr=new ArrayList();
                try (BufferedReader br = new BufferedReader(new FileReader(this.filepath))){
                while ((line = br.readLine()) != null && (line = br.readLine()).contains(pattern) ){
                    arr.add(line);
                }
            }
             return arr; 
        }
        public boolean compareStrings1(String str1,String str2){
            return (str1.equals(str2));
        }
        public boolean compareStrings2(String str1,String str2){
            return (str1.equalsIgnoreCase(str2));
        }
        public boolean compareStrings3(String str1,String str2){
            return (str1 == str2);
        }
        
        public void reverseString(int lineIndex) throws FileNotFoundException, IOException{
            ArrayList<String> arr=new ArrayList();  
            arr=this.ReadFile(this.filepath);
            StringBuffer line=new StringBuffer(arr.get(lineIndex));
            line.reverse();
        }
        public void removeDuplicates(int lineIndex){
             LinkedHashSet<Character> charSet = new LinkedHashSet<>();
             StringBuilder sb = new StringBuilder();

        for (char c : this.fileConent.get(lineIndex).toCharArray()) {
            if (!charSet.contains(c)) {
                charSet.add(c);
                sb.append(c);
            }
        }
           this.fileConent.set(lineIndex, sb.toString());
        
        }
}

