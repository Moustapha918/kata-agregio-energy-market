package com.agregio.kata.infrastructure;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class TestUtils {

    public static String toJson(String fileName, String folderName){
        var path = String.format("%s/%s", folderName, fileName);
        URL jsonURL = TestUtils.class.getClassLoader().getResource(path);
        assert jsonURL != null;
        try {
            return Files.lines(Paths.get(jsonURL.toURI())).collect(Collectors.joining());
        } catch (Exception e) {
            throw new IllegalArgumentException("NO JSON found : " + fileName, e);
        }
    }
}
