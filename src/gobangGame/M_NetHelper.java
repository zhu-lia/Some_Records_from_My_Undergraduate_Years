package gobangGame;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class M_NetHelper {

	public static final int PORT = 8000;
	private Socket s;
	private BufferedReader in;
	private PrintStream out;

	public void startListen() {
		new Thread() {
			public void run() {
				listen();
			}
		}.start();
	}

	private void listen() {
		try {
			ServerSocket ss = new ServerSocket(PORT);
			s = ss.accept();
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintStream(s.getOutputStream(), true);
			startReadThread();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void startReadThread() {
		new Thread() {
			public void run() {
				while (true) {
					try {
						String line = in.readLine();
						System.out.println(line);
						if (line.startsWith("chess:")) {
							otherChess(line.substring("chess:".length()), false);
						} else if (line.startsWith("Regret1:")) {
							otherChess(line.substring("Regret1:".length()),true);
							Vars.model.chessBack();
							sendChess(Vars.model.lastChessRow, Vars.model.lastChessCol, "Regret2");
						} else if (line.startsWith("Regret2:")) {
							otherChess(line.substring("Regret2:".length()),true);
						} else if (line.startsWith("begin")) {
							for (int i = 0; i < Vars.model.WIDTH; i++) {
								for (int j = 0; j < Vars.model.WIDTH; j++) {
									Vars.model.clear(i, j);
								}
							}
							Vars.south.newBegin();
							Vars.view.repaint();
							Vars.control.setOpenDoor(true);
						} else if (line.startsWith("Give")) {
							Vars.control.openDoor = false;
							Vars.south.winner(Vars.control.chessColor);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}.start();
	}

	protected void otherChess(String line, boolean ifRegret) {
		String[] param = line.split(",");
		int row = Integer.parseInt(param[0]);
		int col = Integer.parseInt(param[1]);
		Vars.control.otherChess(row, col, ifRegret);

	}

	public void sendChess(int row, int col, String r) {
		if (out != null && r == "0") {
			out.println("chess:" + row + "," + col);
		} else if (out != null && r == "Regret1") {
			out.println("Regret1:" + row + "," + col);
		} else if (out != null && r == "Regret2") {
			out.println("Regret2:" + row + "," + col);
		}
	}

	public void connect(String ip, int port) {
		try {
			Socket s = new Socket(ip, port);
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintStream(s.getOutputStream(), true);
			startReadThread();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendBegin() {
		if (out != null)
			out.println("begin again");
	}

	public void sendGiveUp() {
		if (out != null)
			out.println("Give up");
	}
}
