package ru.javarush.island.stepanov.utils;

import ru.javarush.island.stepanov.exceptions.IslandAppException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//TODO ---  bad name FileReader (in JDK found)
public class FileReader {

    private FileReader() {
    }

    public static String readResourceToString(String fileName){

        StringBuilder stringBuilder = new StringBuilder();
        String nextLine = "";

        try(
                InputStream inputStream = Thread.currentThread()
                        .getContextClassLoader()
                        .getResourceAsStream(fileName)
        ){
            if (inputStream != null) {
                try(
                        BufferedReader bufferedReader = new BufferedReader(
                                new InputStreamReader(inputStream)
                        )
                ){
                    while ((nextLine = bufferedReader.readLine()) != null){
                        stringBuilder.append(nextLine).append("\n");
                    }
                    return stringBuilder.toString();
                }
            } else {
                throw new IslandAppException("Error: input Stream for given resource (" + fileName + ") is empty.");
            }
        } catch (NullPointerException e){
            throw new IslandAppException("Passed filename is null");
        } catch (IOException e) {
            throw new IslandAppException("IO exception occured while reading file");
        }
    }
}
