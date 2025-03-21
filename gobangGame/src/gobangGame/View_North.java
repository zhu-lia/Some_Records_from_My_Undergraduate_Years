package gobangGame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View_North extends JPanel {

	private JTextField ipTF = new JTextField();
	private JTextField portTF = new JTextField();
	private JButton listenBtn = new JButton("listen");
	private JButton connBtn = new JButton("connect");

	public View_North() {
		ipTF.setText("localhost");
		portTF.setText("8000");
		ipTF.setFont(new Font("Arial",Font.PLAIN,20));
		portTF.setFont(new Font("Arial",Font.PLAIN,20));
		listenBtn.setFont(new Font("Arial",Font.PLAIN,20));
		connBtn.setFont(new Font("Arial",Font.PLAIN,20));
		ipTF.setPreferredSize(new Dimension(150,50));
		portTF.setPreferredSize(new Dimension(150,50));
		listenBtn.setPreferredSize(new Dimension(150,50));
		connBtn.setPreferredSize(new Dimension(150,50));
		listenBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Vars.net.startListen();
				Vars.control.setChessColor(Model.BLACK);
				listenBtn.setEnabled(false);
				Vars.control.setOpenDoor(true);
			}
		});
		connBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String ip = ipTF.getText();
				String port = portTF.getText();
				Vars.control.setChessColor(Model.WHITE);
				Vars.control.setOpenDoor(false);
				Vars.net.connect(ip, Integer.parseInt(port));
			}
		});
		add(ipTF);
		add(portTF);
		add(listenBtn);
		add(connBtn);
	}
}
