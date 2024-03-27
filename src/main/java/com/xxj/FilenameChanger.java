package com.xxj;

import java.io.File;

public class FilenameChanger {
    public static boolean changePDFFilename(String folderPath, String stringToBeDeleted) {
        String postfix = ".pdf";
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    String filename = file.getName();
                    if (filename.endsWith(postfix)) {
                        String filePrefix = filename.substring(0, filename.lastIndexOf("."));
//                        only change the filename if it is a pdf
                        if (filePrefix.contains(stringToBeDeleted)) {
                            String newFilename = filePrefix.replace(stringToBeDeleted, "").trim() + postfix;
                            File newFile = new File(folderPath + "/" + newFilename);
                            if (file.renameTo(newFile)) {
                                System.out.println("File renamed successfully: " + newFilename);
                            } else {
                                System.err.println("Failed to rename file: " + filename);
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
