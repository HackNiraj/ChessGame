package com.chess.engine.player.AI;

import com.chess.engine.Board.Board;
import com.chess.engine.pieces.Piece;
import com.chess.engine.player.Player;

/**
 *
 * @author NiKhil Kr
 */
public final class StandardBoardEvaluator implements BoardEvaluator {

    private static final int CHECK_BONUS = 50;
    private static final int CHECK_MATE_BONUS = 10000;
    private static final int DEPTH_BONUS = 100;
    private static final int CASTLE_BONUS = 100;

    @Override
    public int evaluate(Board board, 
                        int depth) {
        return scorePlayer(board, board.whitePlayer(), depth) -
               scorePlayer(board, board.blackPlayer(), depth);
    }

    private int scorePlayer(final Board board, 
                            final Player player, 
                            final int depth) {
        return pieceValue(player) + mobility(player) + check(player) + 
                checkmate(player, depth) + castled(player);
    }

    private int pieceValue(final Player player) {
        int pieceValueScore = 0;
        for(final Piece piece : player.getActivePieces()){
            pieceValueScore += piece.getPieceValue(); 
        }
        return pieceValueScore;
    }

    private static int mobility(Player player) {
        return player.getLegalMoves().size()*10;
    }

    private static int check(Player player) {
        return player.getOpponent().isInCheck() ? CHECK_BONUS : 0;
    }    

    private static int checkmate(Player player, int depth) {
        return player.getOpponent().isInCheckMate() ? CHECK_MATE_BONUS + depthBonus(depth) : 0;
    }

    private static int depthBonus(int depth) {
        return depth == 0 ? 1 : DEPTH_BONUS * depth;
    }

    private static int castled(Player player) {
        return player.isCastled() ? CASTLE_BONUS : 0;
    }
}
