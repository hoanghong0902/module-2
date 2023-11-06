package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static void main(String[] args) throws IOException {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("result.txt", maxValue);
    }
    public List<Integer> readFile(String filePath) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        File file = null;
        BufferedReader br = null;
        try {
            file = new File(filePath);
            boolean a= file.exists();
            String b=file.getAbsolutePath();
            if(!file.exists()){
                throw new FileNotFoundException();
            }
            br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null){
                numbers.add(Integer.parseInt(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                br.close();
            }
        }
        return numbers;
    }

    public void writeFile(String filePath, int max) throws IOException{
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(filePath,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\nMax value = " + max);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(bufferedWriter != null) {
                bufferedWriter.close();
            }
        }
    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (Integer number : numbers) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }
}