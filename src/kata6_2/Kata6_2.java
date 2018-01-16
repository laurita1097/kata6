/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6_2;


import view_2.HistogramDisplay;
import view_2.HistogramBuilder;
import view_2.MailListReader;
import java.util.List;

import view_2.DatabaseList;

public class Kata6_2 {

    private String fileName;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histogramDisplay;

    public static void main(String[] args) {
        String nameFile = "emails.txt";
        List<Mail> listMail = MailListReader.read(nameFile);
        HistogramBuilder<Mail> builder = new HistogramBuilder<>(listMail);
        Histogram<String> domains = builder.build(new Attribute<Mail, String>() {
            @Override
            public String get(Mail item) {
                return item.getMail().split("@")[1];
            }
        });

        new HistogramDisplay(domains, "Dominios", "Nº Emails").execute();

        Histogram<Character> characters = builder.build(new Attribute<Mail, Character>() {
            @Override
            public Character get(Mail item) {
                return item.getMail().charAt(0);
            }
        });

        new HistogramDisplay(characters, "Primer Caracter", "Nº Emails").execute();
        List< Person> people = DatabaseList.read("KATA.sDB");
        HistogramBuilder< Person> builderPerson = new HistogramBuilder<>(people);
        Histogram< Character> gender = builderPerson.build(new Attribute<Person, Character>() {
            @Override

            public Character get(Person item) {
                return item.getGender();
            }

        });
        new HistogramDisplay(gender, "Géneros", "Nº personas").execute();

        Histogram<Float> weights = builderPerson.build(new Attribute<Person, Float>() {
            @Override
            public Float get(Person item) {
                return item.getWeight();
            }
        });

        new HistogramDisplay(weights, "Pesos", "Nº personas").execute();
    }
}

