package hackathon2019;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import tutorial.Recognize;

import java.util.ArrayList;
import java.util.Scanner;

import uk.co.caprica.vlcj.binding.internal.libvlc_logo_position_e;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.Logo;

public class Text_to_Sign_Language {

	static Scanner scan = new Scanner(System.in);
	private JFrame frame;
	private final JButton pauseButton;
	private final JButton closeWindow;
	private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

	public static void main(final String[] vidName) {
		new NativeDiscovery().discover();
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				Scanner scan = new Scanner(System.in);
				System.out.println("Would you like to translate a word from English to ASL? [y/n]");
				String response = scan.nextLine();
				while (response.charAt(0)=='y')
				{
					try 
					{
						new Text_to_Sign_Language(vidName);
					} 
					catch (FileNotFoundException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Would you like to translate another word from English to ASL? [y/n]");
					response = scan.nextLine();
				}
				if (response.charAt(0)=='n')
					System.exit(0);
			}

		});
	}
	public Text_to_Sign_Language(String[] vidName) throws Exception {

		frame = new JFrame("My First Media Player");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pauseButton = new JButton("Pause");
		closeWindow = new JButton ("Close");
		mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
		vidName = new String[1];
		Scanner data = new Scanner(new File("C:\\Users\\bakub\\eclipse-workspace\\quickstart\\src\\main\\java\\hackathon2019\\data"));
		ArrayList<String> word = new ArrayList<String>();
		ArrayList<String> link = new ArrayList<String>();

		while(data.hasNextLine())
		{
			word.add(data.nextLine());
			link.add(data.nextLine());
		}

		BinaryTree bst = new BinaryTree(word.get(0), link.get(0));
		for (int x = 1; x < word.size(); x++)
		{
			bst.addNode(word.get(x), link.get(x));
		}
		//System.out.println("Would you like to translate a word from English to ASL? [y/n]");
		//String response = scan.nextLine();
		//while(response.charAt(0)=='y') {
		System.out.print("Enter the word/phrase you would like in ASL: "
						  +"\nYou may choose from these options:\nHello\t\t\tYes\t\t\tNo\t\tMy Name Is"
				          +"\nNice to Meet You\tYou Sign Too Fast\tAgain\t\tI Understand"
						  +"\nI Do Not Understand\tSorry\t\t\tHow\t\tThank You\n");
		String input = scan.nextLine();
		//String input = Recognize.streamingMicRecognize();
		while (bst.search(input)==null) {
			System.out.println("Sorry, that either not a dictionary word or it is not currently in our database.\nPlease reenter the word you would like.");
			input = scan.nextLine();
			//input = Recognize.streamingMicRecognize();
			vidName[0] = bst.search(input);
		}
		vidName[0] = bst.search(input);
		/*	frame = new JFrame("My First Media Player");
    			pauseButton = new JButton("Pause");
    			mediaPlayerComponent = new EmbeddedMediaPlayerComponent();*/
		if (!(vidName[0].equals(null)))
		{
			System.out.println("im here");
			frame.setBounds(100, 100, 1200, 800);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			JPanel contentPane = new JPanel();
			contentPane.setLayout(new BorderLayout());
			
			Logo logo = Logo.logo()
				    .file("C:\\Users\\bakub\\Downloads\\output-onlinepngtools.png")
				    .position(libvlc_logo_position_e.bottom_right)
				    .opacity(0.3f)
				    .enable();

			contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);

			JPanel controlsPane = new JPanel();

			controlsPane.add(pauseButton);
			controlsPane.add(closeWindow);
			//contentPane.add(controlsPane, BorderLayout.SOUTH);
			contentPane.add(controlsPane, BorderLayout.NORTH);

			pauseButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mediaPlayerComponent.getMediaPlayer().pause();
				}
			});
			logo.apply(mediaPlayerComponent.getMediaPlayer());
			frame.setContentPane(contentPane);
			frame.setVisible(true);
			mediaPlayerComponent.getMediaPlayer().setPlaySubItems(true);
			mediaPlayerComponent.getMediaPlayer().playMedia(vidName[0]);
			Thread.sleep(6500);
			frame.dispose();

		}
		//System.out.println("");
	}
	//}
}