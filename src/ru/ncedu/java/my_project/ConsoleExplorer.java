package ru.ncedu.java.my_project;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Zotov S. on 18.11.2016.
 * Класс содержит методы, управляющие консолью проводника
 */
public class ConsoleExplorer {
    private Explorer explorer = new Explorer();
    Scanner scanner = new Scanner(System.in);

    private File[] files = new File("\\").listFiles();//Массив файлов, которые будут отображаться в консоли

    protected void select() {
        this.viewFiles();
        int fileNumber = scanner.nextInt();
        try {
            this.setFiles(explorer.open(files[fileNumber]));
            this.select();
        }
        catch (NullPointerException e) {}
    }

    /**
     * Заполнение поля files
     * @param files массив файлов, которые будут записаны в поле files
     */
    private void setFiles(File[] files) {
        this.files = files;
    }

    private void viewFiles() {
        for (int fileNumber = 0; fileNumber < files.length; fileNumber++) {
            System.out.printf("%d\t%s\n", fileNumber, files[fileNumber].getName());
        }
    }

}
