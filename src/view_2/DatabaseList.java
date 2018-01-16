/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_2;

import kata6_2.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseList {

    public static List<Person> read(String fileName) {
        ArrayList<Person> list = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");

            Connection c = DriverManager.getConnection("jdbc:sqlite:" + fileName);
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM people");

            while (rs.next()) {
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                Character gender = rs.getString(3).charAt(0);
                String birthDate = rs.getString(4);
                Float weight = rs.getFloat(5);
                String mail = rs.getString(6);
                list.add(new Person(id, name, gender, birthDate, weight, mail));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

