
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class FileWrite {
    public static void main(String[] args){
        String data = "Hello, World!";
        String fileName1 = "example.txt";
        String fileName2 = "example2.txt";
        String fileName3 = "example3.txt";
        String fileName4 = "example4.txt";
        String fileName5 = "example5.txt";

        // 1. Using FileWriter
        try (FileWriter writer = new FileWriter(fileName1)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Using BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Using FileOutputStream
        try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
            outputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. Using BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName4))) {
            bufferedOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5. Using Files (java.nio.file)
        try {
            Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //HW Day 2

        try{
            FileWriter myFileWriter = new FileWriter(".thesecretpassword.txt");
            myFileWriter.write("definetly not andrews bank password");
            getFileSize(".thesecretpassword.txt");
        }
        catch(IOException e){
            e.printStackTrace();
        }
        try{
            File newDir = new File (".classifiedinfo");
            newDir.mkdir();
            FileWriter myOtherFilewriter = new FileWriter (".classifiedinfo/supasecretdata.dat");
            myOtherFilewriter.write("4840 Van Noord Ave.");

        }
        catch(IOException e){
            e.printStackTrace();
        }

        printTotalFileSize("file1.txt", "directory1/file2.txt", ".hiddenDirectory/file3.txt");
        
    }
    public static void getFileSize (String fileName){
        System.out.println("This file is " + fileName.length() + " bytes long");
    }

    private static void printTotalFileSize(String... fileNames) {
    long totalSize = 0;
    for (String fileName : fileNames) {
        File file = new File(fileName);
        if (file.exists()) {
            totalSize += file.length();
        }
    }
    System.out.println("Total size of all files: " + totalSize + " bytes");

}


}
