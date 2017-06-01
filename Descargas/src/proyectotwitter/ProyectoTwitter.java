
package proyectotwitter;

/**
 *
 * @author fdacostamillos
 */
public class ProyectoTwitter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AppTwitter tweet = new AppTwitter();
        tweet.verTimeline();
        tweet.postearTweet();
    }
    
}
