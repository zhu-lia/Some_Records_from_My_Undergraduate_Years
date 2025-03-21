package gobangGame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

public class View_East extends JPanel {

	private JButton newBegin = new JButton("New Begin");
	private JButton regret = new JButton("Regret");
	private JButton giveUP=new JButton("Give up");

	public View_East() {

		newBegin.setPreferredSize(new Dimension(150,50));
		regret.setPreferredSize(new Dimension(150,50));
		giveUP.setPreferredSize(new Dimension(150,50));
		newBegin.setFont(new Font("Arial",Font.PLAIN,20));
		regret.setFont(new Font("Arial",Font.PLAIN,20));
		giveUP.setFont(new Font("Arial",Font.PLAIN,20));
		add(newBegin);
		add(regret);
		add(giveUP);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  

		regret.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Vars.control.regret();
			}
		});

		newBegin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Vars.model.newBegin();
				Vars.control.newBegin();
			}
		});
		
		giveUP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Vars.control.giveUP();
			}
		});

	}

}
