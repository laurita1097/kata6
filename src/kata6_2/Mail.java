/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6_2;

public class Mail {

    private final String mail;
    private final int id;

    public Mail(int id, String mail) {
        this.mail = mail;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }
}
