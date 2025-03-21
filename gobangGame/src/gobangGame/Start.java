package gobangGame;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Start {
	public static void main(String[] args) {
		JFrame gobang=new JFrame("Gobang game");
		gobang.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel bg=new JLabel(new ImageIcon("bg.jpg"));
		bg.setBounds(0, 0, bg.getIcon().getIconWidth(), bg.getIcon().getIconHeight());
		gobang.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
		gobang.add(bg);
		gobang.getContentPane().add(Vars.view,BorderLayout.CENTER);
		gobang.getContentPane().add(Vars.north,BorderLayout.NORTH);
		gobang.getContentPane().add(Vars.south,BorderLayout.SOUTH);
		gobang.getContentPane().add(Vars.west,BorderLayout.WEST);
		gobang.getContentPane().add(Vars.east,BorderLayout.EAST);
		gobang.setSize(1000, 1000);
		gobang.setVisible(true);
		Vars.west.soundPlay();
}
	}