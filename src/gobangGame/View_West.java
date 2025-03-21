package gobangGame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class View_West extends JPanel {
	private JButton bgBtn = new JButton(new ImageIcon("loud.jpg"));
	File directory = new File("src//music.wav");
	AudioClip audioClip;
	private boolean isPlay = true;

	public View_West() {
		bgBtn.setPreferredSize(new Dimension (150,150));
		bgBtn.setOpaque(true);
		 add(bgBtn);
		 
		 bgBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isPlay==true){
					audioClip.stop();
					isPlay=false;
					}
				else{
					audioClip.play();
					isPlay=true;
					}
					
			}
		});	
	}

	public void soundPlay() {

		URL url = null;
		try {
			url = new File(directory.getCanonicalPath()).toURL();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		audioClip = Applet.newAudioClip(url);
		audioClip.loop();

	}

}
