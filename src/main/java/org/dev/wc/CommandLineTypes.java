package org.dev.wc;
import java.util.HashMap;
import java.util.Map;

public enum CommandLineTypes {
    BYTES("-c"),
    LINES("-l"),
    WORDS("-w"),
    CHARACTERS("-m"),
    ALL("-all");


    private final String flag;

    private static final Map<String, CommandLineTypes> FLAG_MAP = new HashMap<>();

    // when the program started static function is invoked
    // static initializer

    static {
        for (CommandLineTypes type: values()){
            FLAG_MAP.put(type.flag, type);
        }
    }


    CommandLineTypes(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }

    public static CommandLineTypes fromFlag(String flag){
        CommandLineTypes type = FLAG_MAP.get(flag);
        if (type == null) {
            throw new IllegalArgumentException("Unknown Flag:"+flag);
        }
        return type;
    }
}
