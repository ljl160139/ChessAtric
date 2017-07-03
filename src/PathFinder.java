import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by kinglong on 2017/7/3.
 */
public class PathFinder {
    //5*5棋盘
    private static final int COLUMNS = 5;
    private static final int LINES = 5;
    private static final int MARKED_CP = 1;   //默认标记的第几颗棋子位置,（参数+1，这里默认第二颗）
    private static List<List<ChessPiece>> pathList = new ArrayList<>();


    /**
     * 生成棋子
     */
    public static List<ChessPiece> getChesses() {
        List<ChessPiece> result = new ArrayList<>();
        for (int i = 0; i < COLUMNS * LINES; i++) {
            ChessPiece chessPiece = new ChessPiece();
            chessPiece.setChessNo(i);
            if (i == MARKED_CP) {
                chessPiece.setMarked(true);
            }
            result.add(chessPiece);
        }
        return result;
    }


    /**
     * 生成棋盘
     * @param data
     * @return
     */
    public static List<ChessPiece> getChessBoard(List<ChessPiece> data) {
        for (int i = 0; i < data.size(); i++) {
            int left = i - 1;
            int top = i - COLUMNS;
            int right = i + 1;
            int bottom = i + COLUMNS;
            if (i % COLUMNS > 0) {
                data.get(i).setLeft(data.get(left));
            }
            if (i % COLUMNS != LINES - 1) {
                data.get(i).setRight(data.get(right));
            }
            if (top >= 0) {
                data.get(i).setTop(data.get(top));
            }
            if (bottom < data.size()) {
                data.get(i).setBottom(data.get(bottom));
            }
            System.out.println("fdasdfasdf--" + data.get(i).getChessNo() +
                    "  left=" + (data.get(i).getLeft() == null ? "-" : data.get(i).getLeft().getChessNo() + "") +
                    "  top=" + (data.get(i).getTop() == null ? "-" : data.get(i).getTop().getChessNo() + "") +
                    "  right" + (data.get(i).getRight() == null ? "-" : data.get(i).getRight().getChessNo() + "") +
                    "  bottom" + (data.get(i).getBottom() == null ? "-" : data.get(i).getBottom().getChessNo() + "")
            );
        }
        return data;
    }


    public static void findPath(List<ChessPiece> data) {
        for (int i = 0; i < data.size(); i++) {
            if(!data.get(i).isMarked()){
                goNext(data.get(i), new ArrayList<>());
            }
        }

        Collections.sort(pathList, new Comparator<List<ChessPiece>>() {
            @Override
            public int compare(List<ChessPiece> o1, List<ChessPiece> o2) {
                return o2.size()-o1.size();
            }
        });


        for(int i=0;i<200;i++){
            String path = "";
            List<ChessPiece> list=pathList.get(i);
            for (int j = 0; j < list.size(); j++) {
                path += list.get(j).getChessNo() + "  ";
            }
            System.out.println(path);
        }
        System.out.println("pathList size---" + pathList.size());
    }

    private static void goNext(ChessPiece piece, List<ChessPiece> parentSteps) {
        List<ChessPiece> curSteps = new ArrayList<>();
        curSteps.addAll(parentSteps);
        if (null != piece) {
            curSteps.add(piece);
            boolean hasNext=false;
            if(null!=piece.getLeft()&&!curSteps.contains(piece.getLeft())&&!piece.getLeft().isMarked()){
                hasNext=true;
                goNext(piece.getLeft(), curSteps);
            }
            if(null!=piece.getTop()&&!curSteps.contains(piece.getTop())&&!piece.getTop().isMarked()){
                hasNext=true;
                goNext(piece.getTop(), curSteps);
            }
            if(null!=piece.getRight()&&!curSteps.contains(piece.getRight())&&!piece.getRight().isMarked()){
                hasNext=true;
                goNext(piece.getRight(), curSteps);
            }
            if(null!=piece.getBottom()&&!curSteps.contains(piece.getBottom())&&!piece.getBottom().isMarked()){
                hasNext=true;
                goNext(piece.getBottom(), curSteps);
            }
            if(!hasNext){
                pathList.add(curSteps);
            }
        }
    }



}
