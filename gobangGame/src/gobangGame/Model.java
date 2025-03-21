package gobangGame;

public class Model {
	static public int BLACK = 1;// 黑棋
	static public int WHITE = -1;// 白棋
	static public int WIDTH = 15;// 棋盘宽度
	static public int SPACE = 0;// 无棋

	private int[][] chessBoard = new int[WIDTH][WIDTH];// 棋盘
	public int lastChessRow, lastChessCol;// 上一个棋子

	Model() {
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < WIDTH; j++) {
				chessBoard[i][j] = SPACE;
			}
		}
	}

	public boolean putChess(int color, int row, int col) { // 下棋
		if (row >= 0 && row < WIDTH && col >= 0 && col < WIDTH
				&& chessBoard[row][col] == SPACE) {
			chessBoard[row][col] = color;
			return true;
		} else {
			return false;
		}
	}

	public int getChess(int row, int col) {// 得到某个位置上的棋子
		return chessBoard[row][col];
	}

	public void chessBack() {// 悔棋

		chessBoard[lastChessRow][lastChessCol] = SPACE;

	}

	public boolean whoWin(int row, int col, int color) {// 判断输赢
		for (int i = 1; i <= 4; i++) {
			if ((row - i) >= 0 && chessBoard[row - i][col] == color) {
				if (i == 4) {
					return true;
				}
				continue;
			} else {
				break;
			}
		}

		for (int i = 1; i <= 4; i++) {
			if ((row + i) < WIDTH && chessBoard[row + i][col] == color) {
				if (i == 4) {
					return true;
				}
				continue;
			} else {
				break;
			}
		}

		for (int j = 1; j <= 4; j++) {
			if ((col - j) >= 0 && chessBoard[row][col - j] == color) {
				if (j == 4) {
					return true;
				}
				continue;
			} else {
				break;
			}
		}

		for (int j = 1; j <= 4; j++) {
			if ((col + j) < WIDTH && chessBoard[row][col + j] == color) {
				if (j == 4) {
					return true;
				}
				continue;
			} else {
				break;
			}
		}

		for (int j = 1; j <= 4; j++) {
			if ((col - j) >= 0 && (row - j) >= 0
					&& chessBoard[row - j][col - j] == color) {
				if (j == 4) {
					return true;
				}
				continue;
			} else {
				break;
			}
		}

		for (int j = 1; j <= 4; j++) {
			if ((col + j) < WIDTH && (row + j) < WIDTH
					&& chessBoard[row + j][col + j] == color) {
				if (j == 4) {
					return true;
				}
				continue;
			} else {
				break;
			}
		}

		for (int j = 1; j <= 4; j++) {
			if ((col + j) < WIDTH && (row - j) >= 0
					&& chessBoard[row - j][col + j] == color) {
				if (j == 4) {
					return true;
				}
				continue;
			} else {
				break;
			}
		}

		for (int j = 1; j <= 4; j++) {
			if ((row + j) < WIDTH && (col - j) >= 0
					&& chessBoard[row + j][col - j] == color) {
				if (j == 4) {
					return true;
				}
				continue;
			} else {
				break;
			}
		}
		return false;
	}

	public void clear(int row, int col) {// 清除
		chessBoard[row][col] = SPACE;
	}

	public void newBegin() {// 新的一局
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (this.getChess(i, j) != SPACE)
					this.clear(i, j);
			}
		}
	}
}
