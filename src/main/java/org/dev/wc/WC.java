package org.dev.wc;

import org.dev.wc.strategies.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class WC {
    private final CommandLineTypes type;
    private final String filePath;

    private static final Map<CommandLineTypes, ICountStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put(CommandLineTypes.BYTES,new ByteCountStrategy());
        strategyMap.put(CommandLineTypes.LINES, new LineCountStrategy());
        strategyMap.put(CommandLineTypes.WORDS, new WordCountStrategy());
        strategyMap.put(CommandLineTypes.CHARACTERS, new CharacterCountStrategy());
        strategyMap.put(CommandLineTypes.ALL, new WordCountStrategy());
    }
    public WC(String[] arguments) {
        type = CommandLineTypes.fromFlag(arguments[0]);
        filePath = arguments[1];
    }

    public Long callType(){
        if (type==CommandLineTypes.ALL){
            strategyMap.forEach((t,strategy)->{
                System.out.println(t + " : " + strategy.execute(filePath));
            });
            return 0L;
        }
        return strategyMap.get(type).execute(filePath);
    }
}