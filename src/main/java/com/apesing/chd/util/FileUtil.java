package com.apesing.chd.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<String> readFileByLine(String filePath) {
        List<String> arrayList = new ArrayList<>();
        try {
            File file = new File(filePath);
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bf = new BufferedReader(inputReader);
            // 按行读取字符串
            String str;
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            inputReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
