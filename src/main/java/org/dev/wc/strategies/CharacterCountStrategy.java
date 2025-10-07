package org.dev.wc.strategies;

import java.io.BufferedReader;
import java.io.FileReader;

public class CharacterCountStrategy implements ICountStrategy {
    @Override
    public long execute(String filePath) {
        long totalChars=0;
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line=br.readLine())!=null){
                totalChars+=line.length();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return totalChars;
    }
}
