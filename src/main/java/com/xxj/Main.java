package com.xxj;

public class Main {
    public static void main(String[] args) {
        PropertyReader propertyReader = new PropertyReader();
        String folderPath = propertyReader.getProperty("folderpath");
        String stringToBeDeleted = propertyReader.getProperty("stringToBeDeleted.last");
        boolean result = FilenameChanger.changePDFFilename(folderPath, stringToBeDeleted);
        if (result) {
            System.out.println("All files have been renamed successfully!");
        } else {
            System.err.println("Error occurred while renaming files. Please check the folder path and the string to " +
                    "be deleted.");
        }
    }
}