package ChessGame;

import java.util.LinkedList;

public class Bishop extends Piece{

    public Bishop(int xp, int yp, boolean isWhite, String n, LinkedList<Piece> ps) {
        super(xp, yp, isWhite, n, ps);
    }
    public boolean isValid(int fromX, int fromY, int toX, int toY) {
        if(super.isValid(name = "Bishop", fromX, fromY, toX, toY) == false)
            return false;

        if(toX - fromX == toY - fromY)
            return true;

        return false;
    }
}
