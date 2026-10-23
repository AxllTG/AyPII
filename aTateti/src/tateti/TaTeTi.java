package tateti;

public class TaTeTi {
    public static final int X = 1, O = -1;
    public static final int EMPTY = 0;

    private int[][] board;
    private int player;
    private int size;

    public TaTeTi(int size) {
        this.size = size;
        board = new int[size][size];
        clearBoard();
    }

    public void clearBoard() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                board[i][j] = EMPTY;
        player = X;
    }

    public void putMark(int i, int j) throws IllegalArgumentException {
        if ((i < 0) || (i >= size) || (j < 0) || (j >= size))
            throw new IllegalArgumentException("Posición inválida");
        if (board[i][j] != EMPTY)
            throw new IllegalArgumentException("Posición ocupada");
        board[i][j] = player;
        player = -player;
    }

    public boolean isWin(int mark) {
        int target = mark * size;

        for (int i = 0; i < size; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += board[i][j];
                colSum += board[j][i];
            }
            if (rowSum == target || colSum == target) return true;
        }

        int diag1 = 0, diag2 = 0;
        for (int i = 0; i < size; i++) {
            diag1 += board[i][i];
            diag2 += board[i][size - 1 - i];
        }
        return diag1 == target || diag2 == target;
    }

    public int winner() {
        if (isWin(X))
        	return X;
        else if (isWin(O))
        	return O;
        else 
        	return 0;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (board[i][j] == EMPTY) return false;
        return true;
    }

    public int getPlayer() {
        return player;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String separator = "-".repeat(size * 2 - 1);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switch (board[i][j]) {
                    case X:     
                    	sb.append("X"); 
                    	break;
                    case O:     
                    	sb.append("O"); 
                    	break;
                    case EMPTY: 
                    	sb.append(" "); 
                    	break;
                }
                if (j < size - 1) 
                	sb.append("|");
            }
            if (i < size - 1)
            	sb.append("\n").append(separator).append("\n");
        }
        return sb.toString();
    }
}