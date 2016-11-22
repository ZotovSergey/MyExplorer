package ru.ncedu.java.my_project;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Zotov S. on 18.11.2016.
 */
public class Explorer {

    protected File[] open(File selectedFile) {
        File[] files = null;
        if (selectedFile.isDirectory()) {
            files = this.openDirectory(selectedFile);
        }
        else {
            this.openFile(selectedFile);
        }
        return files;
    }

    private File[] openDirectory(File selectedFile) {
        return selectedFile.listFiles();
    }

    private void openFile(File selectedFile) {
        Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }
        try {
            desktop.open(selectedFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}