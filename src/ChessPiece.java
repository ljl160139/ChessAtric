import java.io.Serializable;

/**
 * Created by kinglong on 2017/7/3.
 */
public class ChessPiece implements Serializable {

    private int chessNo;
    private boolean marked;  //标记
    private ChessPiece left;
    private ChessPiece top;
    private ChessPiece right;
    private ChessPiece bottom;


    public int getChessNo() {
        return chessNo;
    }

    public ChessPiece setChessNo(int chessNo) {
        this.chessNo = chessNo;
        return this;
    }

    public boolean isMarked() {
        return marked;
    }

    public ChessPiece setMarked(boolean marked) {
        this.marked = marked;
        return this;
    }

    public ChessPiece getLeft() {
        return left;
    }

    public ChessPiece setLeft(ChessPiece left) {
        this.left = left;
        return this;
    }

    public ChessPiece getTop() {
        return top;
    }

    public ChessPiece setTop(ChessPiece top) {
        this.top = top;
        return this;
    }

    public ChessPiece getRight() {
        return right;
    }

    public ChessPiece setRight(ChessPiece right) {
        this.right = right;
        return this;
    }

    public ChessPiece getBottom() {
        return bottom;
    }

    public ChessPiece setBottom(ChessPiece bottom) {
        this.bottom = bottom;
        return this;
    }
}
