/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6_2;

import kata6_2.Histogram;
import kata6_2.Mail;
import view_2.HistogramDisplay;
import view_2.MailHistogramBuilder;
import view_2.MailListReader;
import java.util.List;
import kata6_2.Histogram;
public class Kata6_2 {

    private String fileName;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histogramDisplay;

    public static void main(String[] args) {
        Kata6_2 kata = new Kata6_2();
        kata.execute();
    }

    private void execute() {
        input();
        proccess();
        output();
    }

    private void input() {
        fileName = "emails.txt";
        mailList = MailListReader.read(fileName);
    }

    private void proccess() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    private void output() {
        histogramDisplay = new HistogramDisplay(histogram);
        histogramDisplay.execute();
    }
}
