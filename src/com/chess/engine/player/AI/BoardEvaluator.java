package com.chess.engine.player.AI;

import com.chess.engine.Board.Board;

/**
 *
 * @author NiKhil Kr
 */
public interface BoardEvaluator {
    int evaluate(Board board, int depth);
}
