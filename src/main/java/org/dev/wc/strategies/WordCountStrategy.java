package org.dev.wc.strategies;

import java.io.BufferedReader;
import java.io.FileReader;

public class WordCountStrategy implements ICountStrategy {
    @Override
    public long execute(String filePath) {
        long totalWords = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line=br.readLine())!=null){
                totalWords+=line.split(" ").length;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return totalWords;
    }
}
