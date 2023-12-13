package com.chess.engine;

import com.chess.engine.board.Board;
import com.chess.gui.Table;
/*
 *
 * @author NiKhil Kr
 */
public class JChess{
    /*
    @Override
    public void start(Stage primaryStage){
        Group root = new Group();
        
        Scene sc = new Scene(root,500,500);
        primaryStage.setScene(sc);
        primaryStage.setTitle("JChess");
        primaryStage.show();
    }
    */
    public static void main(String[] args) {
        Board board = Board.createStandardBoard();
        System.out.println(board);
        //launch(args);
        Table.get().show();
    }
}
