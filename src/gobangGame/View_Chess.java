package gobangGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class View_Chess extends JPanel {
	private int gap = 50;
	private int unit = 10;
	private int screenWidth;
	private int screenHeight;
	private int x1, y1;
	private int x2, y2;
	

	public View_Chess(){
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				int row = (y - y1) / unit;
				if ((y - y1) % unit > unit / 2) {
					row++;
				}
				int col = (x - x1) / unit;
				if ((x - x1) % unit > unit / 2) {
					col++;
				}
				Vars.control.reportUserPressMouse(row, col);
			}
		});
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				screenWidth = getWidth();
				screenHeight = getHeight();
				int min = Math.min(screenHeight, screenWidth);
				unit = (min - gap * 2) / (Model.WIDTH - 1);
				x1 = (screenWidth - unit * (Model.WIDTH - 1)) / 2;
				y1 = (screenHeight - unit * (Model.WIDTH - 1)) / 2;
				repaint();
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		drawChessPanel(g);
		drawChess(g);
	}

	private void drawChess(Graphics g) {
		for (int row = 0; row < Model.WIDTH; row++) {
			for (int col = 0; col < Model.WIDTH; col++) {
				int c = Vars.model.getChess(row, col);
				if (c == Model.BLACK) {
					g.setColor(Color.black);
					g.fillOval(x1 + unit * col - unit / 2, y1 + unit * row
							- unit / 2, unit, unit);
				} else if (c == Model.WHITE) {
					g.setColor(Color.white);
					g.fillOval(x1 + unit * col - unit / 2, y1 + unit * row
							- unit / 2, unit, unit);
				}

			}
		}
	}

	
	private void drawChessPanel(Graphics g) {
		for (int i = 0; i < Model.WIDTH; i++) {
			g.drawLine(x1, y1 + unit * i, x1 + unit * (Model.WIDTH - 1),
					y1 + unit * i);
			g.drawLine(x1 + unit * i, y1, x1 + unit * i, y1 + unit
					* (Model.WIDTH - 1));
		}

	}
	
}
