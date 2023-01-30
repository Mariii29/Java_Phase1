package com.model.operations;
import com.model.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class BusinessLevelOperations implements FileInterface  {
    List<String> myList= new ArrayList<String>();
    File[] files = new File("C:\\Users\\masam005\\IdeaProjects\\ClassLabs").listFiles();
    @Override
    public void displayFiles() {
        // TODO Auto-generated method stub
        for(File file : files) {
            if(file.isFile()) {
                myList.add(file.getName());
                //System.out.println(file.getName());
            }
        }
        myList.forEach(x -> System.out.println(x));

    }

    @Override
    public void addFile() {
        // TODO Auto-generated method stub
        System.out.println("Please insert new file name:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        File newFile = new File(fileName);
        try {
            if(newFile.createNewFile()) {
                System.out.println(fileName+" file is added to the directory");
                Desktop.getDesktop().edit(newFile);
            }
            else {
                System.out.println("This file is already there\n\n");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void deleteFile() {
        // TODO Auto-generated method stub
        System.out.println("Enter the name of the file you want deleted:");
        Scanner scanner1 = new Scanner(System.in);
        String fileName = scanner1.nextLine();
        File removeFile= new File(fileName);
        if(removeFile.isFile()) {
            removeFile.delete();
            System.out.println(fileName + " got Deleted");
        }
        else
            System.out.println("File Not Found");
    }

    @Override
    public void searchFile() {
        // TODO Auto-generated method stub
        try {
            Scanner scanner2= new Scanner(System.in);
            File directory = new File("C:\\Users\\masam005\\IdeaProjects\\ClassLabs");
            System.out.println("\nSearch for: ");
            String fileName = scanner2.nextLine();
            File[] files = directory.listFiles();
            int a = 0;
            for (File file : files) {
                String name = file.getName();
                if (name.equals(fileName)) {
                    System.out.println("File "+fileName+" found");
                    System.out.println("Displaying file contents now...");
                    File f= new File(fileName);
                    Scanner sc1 = new Scanner(f);
                    while(sc1.hasNextLine()) {
                        System.out.println("\n"+sc1.nextLine());
                    }
                    a = 1;
                }
            }
            if(a==0) {
                System.out.println("File not found");
            }

        }catch(FileNotFoundException fileNotFoundException) {
            System.out.println("An error occurred, please try again");
        }

    }

}