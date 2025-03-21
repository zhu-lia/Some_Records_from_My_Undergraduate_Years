package gobangGame;

public class Control {

	int chessColor = Model.BLACK;
	public boolean openDoor = true;
	public boolean ending = false;

	public void reportUserPressMouse(int row, int col) {
		if (!openDoor)
			return;
		boolean success = Vars.model.putChess(chessColor, row, col);
		if (success) {
			Vars.model.lastChessRow = row;
			Vars.model.lastChessCol = col;
			Vars.south.chess(true);
			openDoor = false;
			Vars.view.repaint();
			ending = Vars.model.whoWin(row, col, chessColor);
			if (ending == true) {
				Vars.south.winner(chessColor);
				openDoor = false;
			}
			Vars.net.sendChess(row, col, "0");
		} else {
			Vars.south.chess(false);
		}
	}

	public void otherChess(int row, int col, boolean ifRegret) {
		if (ifRegret == false) {
			Vars.model.putChess(-chessColor, row, col);
			Vars.south.turn();
			ending = Vars.model.whoWin(row, col, -chessColor);
			openDoor = true;
			if (ending == true) {
				Vars.south.winner(-chessColor);
				openDoor = false;
			}
		} else {
			Vars.model.clear(row, col);
		}
		Vars.view.repaint();
	}

	public void setChessColor(int color) {
		chessColor = color;
	}

	public void setOpenDoor(boolean openDoor) {
		this.openDoor = openDoor;
	}

	public boolean getOpenDoor() {
		return openDoor;
	}

	public void newBegin() {
		Vars.view.repaint();
		Vars.net.sendBegin();
		Vars.south.newBegin();
		this.setOpenDoor(true);
	}

	public void regret() {
		if (getOpenDoor() == true) {
			Vars.model.chessBack();
			Vars.south.regret(true);
			Vars.view.repaint();
			Vars.net.sendChess(Vars.model.lastChessRow, Vars.model.lastChessCol, "Regret1");
		} else {
			Vars.south.regret(false);
		}
	}
	
	public void giveUP(){
		Vars.net.sendGiveUp();
		Vars.south.winner(-Vars.control.chessColor);
		this.openDoor=false;
	}
}
