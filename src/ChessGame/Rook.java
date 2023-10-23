package ChessGame;

import java.util.LinkedList;

public class Rook extends Piece{

    public Rook(int xp, int yp, boolean isWhite, String n, LinkedList<Piece> ps) {
        super(xp, yp, isWhite, n, ps);
    }
    public boolean isValid(int fromX, int fromY, int toX, int toY) {
        if(super.isValid(name = "Rook", fromX, fromY, toX, toY) == false)
            return false;
        if(toX == fromX)
            return true;
        if(toY == fromY)
            return true;
        return false;
    }
}
