package ChessGame;

import java.util.LinkedList;

public class King extends Piece{

    public King(int xp, int yp, boolean isWhite, String n, LinkedList<Piece> ps) {
        super(xp, yp, isWhite, n, ps);
    }

    public boolean isValid(int fromX, int fromY, int toX, int toY) {
        if(super.isValid(name = "King", fromX, fromY, toX, toY) == false)
            return false;
        if(Math.sqrt(Math.pow(Math.abs((toX - fromX)),2)) + Math.pow(Math.abs((toY - fromY)), 2) >= Math.sqrt(2)){
            return false;
        }
        return false;
    }
}
