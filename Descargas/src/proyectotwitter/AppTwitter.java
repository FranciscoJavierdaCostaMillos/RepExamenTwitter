/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotwitter;

import javax.swing.JOptionPane;
import twitter4j.*;
import twitter4j.conf.Configuration;

/**
 *
 * @author fdacostamillos
 */
public class AppTwitter {

    TwitterFactory tf = new TwitterFactory();
    Twitter twitter = tf.getInstance();


    public void verTimeline() {
        
        try {
            Paging pagina = new Paging();
            pagina.setCount(40);
            ResponseList listado = twitter.getHomeTimeline(pagina);
            for (int i = 0; i < listado.size(); i++) {
                System.out.println(listado.get(i).toString());
            }
        } catch (TwitterException ex) {
            System.out.println("No se ve la linea de tiempo");
        }
    }

    public void postearTweet() {
        try {
            twitter.updateStatus(JOptionPane.showInputDialog("Escribe Mensaje"));
        } catch (TwitterException ex) {
            System.out.println("No posteado");
        }
    }

    public void buscar(String text) {
        try {
            Query query = new Query("#" + text);
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }
        } catch (TwitterException ex) {
            System.out.println("No busqueda");
        }
    }

    public void mensajeDirecto(String user, String msg) {
        DirectMessage message;
        try {
            message = twitter.sendDirectMessage("@" + user, msg);
            System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());
        } catch (TwitterException ex) {
            System.out.println("Error mensaje directo");
        }
    }
}
