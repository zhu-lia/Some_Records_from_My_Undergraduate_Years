package gobangGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class View_South extends JPanel{

	private JTextField message = new JTextField(20);
	
	public View_South() {

		message.setText("Game begins");
		message.setPreferredSize(new Dimension(200,150));
		message.setFont(new Font("Arial",Font.PLAIN,50));
		add(message);
	}
	
	public void winner(int color){
		message.setFont(new Font("Arial",Font.BOLD,50));
		message.setForeground(Color.RED);
		if(color==Model.BLACK){
			message.setText("BLACK win!");
		}
		if(color==Model.WHITE){
			message.setText("WHITE win!");
		}
	}
	
	public void newBegin(){
		message.setText("Game begins");
		message.setFont(new Font("Arial",Font.PLAIN,50));
		message.setForeground(Color.BLACK);
	}
	
	public void regret(boolean re){
		if(re==true)
			message.setText("Be careful!");
		else
			message.setText("You can't regret now.");
		message.setFont(new Font("Arial",Font.PLAIN,50));
		message.setForeground(Color.BLACK);
	}
	
	public void chess(boolean c){
		if(c==true)
			message.setText("good!");
		else
			message.setText("Please choose another position.");
		message.setFont(new Font("Arial",Font.PLAIN,50));
		message.setForeground(Color.BLACK);
	}
	
	public void turn(){
		message.setText("Now it's your turn");
		message.setFont(new Font("Arial",Font.PLAIN,50));
		message.setForeground(Color.BLACK);
	}
}
