package tutorial;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.util.Scanner;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class Tutorial {
	
	Scanner scan = new Scanner(System.in);
    private final JFrame frame;
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    public static void main(final String[] vidName) {
        new NativeDiscovery().discover();
        SwingUtilities.invokeLater(new Runnable() {
        	
            public void run() {
                new Tutorial(vidName);
            }
        });
    }
    public Tutorial(String[] vidName) {
    	vidName = new String[1];
    	String usrInput = scan.nextLine();
    	if (usrInput.equals("Bird"))
    		vidName[0]= "Dubstep Bird (Original 5 Sec Video).avi";
        frame = new JFrame("My First Media Player");
        frame.setBounds(200, 200, 1366, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        frame.setContentPane(mediaPlayerComponent);
        frame.setVisible(true);
        mediaPlayerComponent.getMediaPlayer().setPlaySubItems(true);
        mediaPlayerComponent.getMediaPlayer().playMedia("https://www.youtube.com/watch?v=QH2-TGUlwu4");
       // mediaPlayerComponent.getMediaPlayer().playMedia("C:\\Users\\bakub\\Downloads\\"+vidName[0]);
    }
}