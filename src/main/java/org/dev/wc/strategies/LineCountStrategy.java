package org.dev.wc.strategies;

import java.io.BufferedReader;
import java.io.FileReader;

public class LineCountStrategy implements ICountStrategy {
    @Override
    public long execute(String filePath) {
        long totalLines=0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line=br.readLine())!=null){
                System.out.println(line);
                totalLines++;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return totalLines;
    }
}
