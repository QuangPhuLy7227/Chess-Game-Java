package ChessGame;
import java.util.LinkedList;

public class Piece {
    //Position
    int xp;
    int yp;
    int x;
    int y;
    boolean isWhite;
    String name;
    public static LinkedList<Piece> ps;

    public Piece(int xp, int yp, boolean isWhite, String n, LinkedList<Piece> ps) {
        this.xp = xp;
        this.yp = yp;
        x = xp * 64;
        y = yp * 64;
        this.isWhite = isWhite;
        this.ps = ps;
        ps.add(this);
        name = n;
    }

    public void move(String name, int fromX, int fromY, int toX, int toY){
        /*this.name = name;
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;*/
        System.out.println(isValid(name, fromX, fromY, toX, toY));
        if (isValid(name,fromX, fromY, toX, toY) == false){
            x = fromX * 64;
            y = fromY * 64;
            return;
        }
        if (Game.getPiece(toX*64, toY*64) != null){
            if (Game.getPiece(toX*64, toY*64).isWhite != isWhite){
                Game.getPiece(toX*64, toY*64).kill();
            }else {
                x = fromX * 64;
                y = fromY * 64;
                return;
            }
        }
        xp = toX;
        yp = toY;
        x = xp * 64;
        y = yp * 64;
    }

    public void kill(){
        ps.remove(this);
    }

    public boolean isValid(String name, int fromX, int fromY, int toX, int toY){
        /* if(toX == fromX && toY == fromY)
            return false; //cannot move nothing
        //if(toX > 0 && toX < 7 && fromX > 0 && fromX < 7 && toY > 0 && toY < 7 && fromY >0 && fromY < 7){  */
        boolean valid = true;
        switch (name){
            case "King":
                if((Math.pow(Math.abs((toX - fromX)),2)) + Math.pow(Math.abs((toY - fromY)), 2) > 2){
                    valid = false;
                }
                break;
            case "Knight":
                if (Math.abs(toX - fromX) == 1){
                    if (Math.abs(toY - fromY) != 2)
                        valid = false;
                    else valid = true;
                } else if (Math.abs(toX - fromX) == 2) {
                    if (Math.abs(toY - fromY) != 1)
                        valid = false;
                    else valid = true;
                } else valid = false;
                break;
            case "Bishop":
                if(Math.abs(toX - fromX) != Math.abs(toY - fromY))
                    valid = false;
                break;
            case "Rook":
                if(toX != fromX || toY == fromY)
                    valid = false;
                break;
            case "Queen":
                if((Math.abs(toX - fromX) != Math.abs(toY - fromY)) || (toX != fromX || toY == fromY))
                    valid = false;
                break;
            case "Pawn":
                if ((Math.abs(toX - fromX) + Math.abs(toY - fromY)) > 2) {
                    valid = false;
                }
                else valid = true;
                break;
            }
        return valid;
    }
}
