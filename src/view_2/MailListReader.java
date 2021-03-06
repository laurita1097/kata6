/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_2;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata6_2.Mail;



public class MailListReader {

    public static List<Mail> read(String fileName) {
        ArrayList<Mail> list = new ArrayList<>();
        Integer id = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("@")) {
                    list.add(new Mail(id,line));
                }
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo");
        }
        return list;
    }

}
