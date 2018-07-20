package com.epam.file;

import java.io.IOException;

public class MyIOException extends Exception {
    public MyIOException(IOException e) {
        super(e);
    }
}
