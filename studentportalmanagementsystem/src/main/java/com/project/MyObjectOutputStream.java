package com.project;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

// Custom ObjectOutputStream to override writeStreamHeader
class MyObjectOutputStream extends ObjectOutputStream {
    public MyObjectOutputStream() throws IOException {
        super();
    }

    public MyObjectOutputStream(OutputStream o) throws IOException {
        super(o);
    }

    // Override writeStreamHeader to do nothing
    public void writeStreamHeader() {
        // Empty body, preventing the serialization stream header from being written
    }
}
