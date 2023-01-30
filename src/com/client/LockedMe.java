package com.client;
import java.io.*;
import java.util.*;
import com.model.operations.BusinessLevelOperations;

public class LockedMe {

    public static void main(String[] args) {
        welcomeScreen();
        try {
            menuDriven();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void welcomeScreen() {
        System.out.println("\n\n****************************");
        System.out.println("*         WELCOME!         *\n****************************\n****************************\n***********LockedMe*********\n*Developed by Marisia Masao*\n****************************");
    }

    public static void menuDriven() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        BusinessLevelOperations obj = new BusinessLevelOperations();
        int option;
        do {
            System.out.println("\n\nWhat would you like to do today:");
            System.out.println("\t1. Display list of your files");
            System.out.println("\t2. Create file, Delete file or search for file");
            System.out.println("\t3. EXIT");
            System.out.println("\nInsert answer here: ");

            option=sc.nextInt();
            switch(option) {
                case 1:
                    obj.displayFiles();
                    break;
                case 2:
                    int ch;
                    do {
                        System.out.println("\n\nPick an option to get started");
                        System.out.println("\t1. Add File");
                        System.out.println("\t2. Delete File");
                        System.out.println("\t3. Search for File");
                        System.out.println("\t4. GO BACK");

                        ch=sc.nextInt();
                        switch(ch) {
                            case 1:
                                obj.addFile();
                                break;
                            case 2:
                                obj.deleteFile();
                                break;
                            case 3:
                                obj.searchFile();
                                break;
                            case 4:
                                System.out.println("Exited from the Business Level operation...");
                                System.out.println("---------------------------------\n");
                                break;
                            default:
                                System.out.println("Invalid Choice");
                                break;
                        }
                    }while(ch!=4);
                    break;
                case 3:
                    System.out.println("Exiting from the application...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            //System.out.println("Press 0 to continue");
        }while(option!=3);

    }
}