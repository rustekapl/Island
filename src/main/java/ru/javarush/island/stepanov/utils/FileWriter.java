package ru.javarush.island.stepanov.utils;


import ru.javarush.island.stepanov.exceptions.IslandAppException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter {

    public static String writeFile(String path, String textToWrite){

        Path validatedPath = validatePath(path);

        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(path), StandardCharsets.UTF_8)))
        {
            bufferedWriter.write(textToWrite);
        } catch (IOException e){
            e.printStackTrace();
        }

        return "New file has been written to " + validatedPath + ".";
    }

    private static Path validatePath(String path){

        String userDir = System.getProperty("user.dir");
        Path filePath = Path.of(path);

        if (filePath.isAbsolute()){
            if (Files.exists(filePath)){
                deleteFile(filePath);
            }
            return filePath;
        }

        Path validatedPath = searchInDirectory(filePath.getFileName().toString(), userDir);
        if (!(validatedPath.toString().equals(""))){
            deleteFile(validatedPath);
        }

        return Path.of(userDir, "log", filePath.getFileName().toString());
    }

    private static void deleteFile(Path filePath){
        try{
            Files.delete(filePath);
        } catch (IOException e) {
            throw new IslandAppException("\nERROR: while deleting existing output file the following error has occured:\n" + e);
        }
    }

    private static Path searchInDirectory(String fileName, String userDir){
        if (Files.exists(Path.of(userDir, fileName))){
            return Path.of(userDir, fileName);
        }
        try (DirectoryStream<Path> files = Files.newDirectoryStream(Path.of(userDir))) {
            for (Path path : files) {
                if (Files.isDirectory(path)){
                    if (Files.exists(Path.of(path.toString(), fileName))){
                        return Path.of(path.toString(), fileName);
                    }
                }
            }
        } catch (IOException e) {
            throw new IslandAppException("While searching for file the error has occured: " + e);
        }
        return Path.of("");
    }

}
