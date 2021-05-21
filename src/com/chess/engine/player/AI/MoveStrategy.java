package com.chess.engine.player.AI;

import com.chess.engine.Board.Board;
import com.chess.engine.Board.Move;

/**
 *
 * @author NiKhil Kr
 */
public interface MoveStrategy {
    //Minimax to have Padagogical Understanding
    Move execute(Board board);
}
