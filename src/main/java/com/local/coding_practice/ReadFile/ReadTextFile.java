package com.local.coding_practice.ReadFile;

import java.io.*;

public class ReadTextFile {
    public static void main(String[] args) throws IOException {
        File file = new File("/Volumes/Data/Vinayak/Workspace/Coding_Practice/src/main/resources/testText.text");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
    }

}
