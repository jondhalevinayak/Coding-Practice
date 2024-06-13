package com.local.coding_practice.ReadFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

public class ReadJsonFile {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        LinkedHashMap linkedHashMap = mapper.readValue(new File("/Volumes/Data/Vinayak/Workspace/Coding_Practice/src/main/resources/swagger.json"), LinkedHashMap.class);
        linkedHashMap.forEach((k, v) -> System.out.println("Key :"+k+" value:"+v));



    }
}
