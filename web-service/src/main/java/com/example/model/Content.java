package com.example.model;

import java.io.InputStream;

public class Content {

    private String fileName;
    private String description;
    private InputStream file;

    public Content(String fileName, String description, InputStream file) {
        this.fileName = fileName;
        this.description = description;
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDescription() {
        return description;
    }

    public InputStream getFile() {
        return file;
    }
}
