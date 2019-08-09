package com.infoshare.jse.files.exercise.task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exercise5 {

    public static void main( String[] args ) throws FileNotFoundException, IOException {


        //set patches to files
        Path origin = Paths.get("./src/main/java/com/infoshare/jse/files/exercise/zad4/myFile");
        Path destination  = Paths.get((System.getProperty("user.home")),"Desktop","myFile.txt");
        Path destination2  = Paths.get((System.getProperty("user.home")),"Desktop","myFileCopy.txt");

        // COPY used to not re-run task4, should be
        // Files.move(origin,destination);
        Files.copy(origin,destination);
        Files.copy(destination,destination2);

        //read file, prep output
        Scanner input = new Scanner(destination);
        String inputStream=input.nextLine();
        char[] array=inputStream.toCharArray();

        //output

        File outputFile = new File(String.valueOf(destination2));
        System.out.println(outputFile);
        PrintWriter pw = new PrintWriter(outputFile);
        for(int x=array.length-1;x>=0;x--) {
            pw.print(array[x]);
        }
        pw.close();

    }
}