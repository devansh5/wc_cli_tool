package org.dev.wc.strategies;

import java.io.File;

public class ByteCountStrategy implements ICountStrategy {

    @Override
    public long execute(String filePath) {
        return new File(filePath).length();
    }
}
