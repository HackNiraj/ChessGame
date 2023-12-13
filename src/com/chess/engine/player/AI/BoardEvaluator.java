package com.chess.engine.player.AI;

import com.chess.engine.board.Board;

/**
 *
 * @author NiKhil Kr
 */
public interface BoardEvaluator {
    int evaluate(Board board, int depth);
}
