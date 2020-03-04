package cn.xpbootcamp.tennis.game2;

import static cn.xpbootcamp.tennis.Constant.ADVANTAGE;
import static cn.xpbootcamp.tennis.Constant.ALL;
import static cn.xpbootcamp.tennis.Constant.DEUCE;
import static cn.xpbootcamp.tennis.Constant.LOVE;
import static cn.xpbootcamp.tennis.Constant.PLAYER1;
import static cn.xpbootcamp.tennis.Constant.PLAYER2;
import static cn.xpbootcamp.tennis.Constant.SCORE_NAMES;
import static cn.xpbootcamp.tennis.Constant.WIN_FOR;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 implements TennisGame {

  private int player1Point = 0;
  private int player2Point = 0;

  public String getScore() {
    String score = "";
    if (isEqual()) {
      score = SCORE_NAMES[player1Point] + ALL;
      ;
    }

    if (isDeuce()) score = DEUCE;

    if (ifOneEqualZero()) {
      score =
          player1Point == 0
              ? SCORE_NAMES[player1Point] + "-" + LOVE
              : LOVE + "-" + SCORE_NAMES[player2Point];
    }

    if (ifHigherLessThanFour()) {
      score = SCORE_NAMES[player1Point] + "-" + SCORE_NAMES[player2Point];
    }

    if (isAdvantage()) {
      score = ADVANTAGE + (player2Point > player1Point ? PLAYER2 : PLAYER1);
    }

    if (isWin()) {
      score = WIN_FOR + (player2Point > player1Point ? PLAYER2 : PLAYER1);
    }

    return score;
  }

  private boolean isDeuce() {
    return player1Point == player2Point && player1Point >= 3;
  };

  private boolean isAdvantage() {
    return player1Point != player2Point && Math.min(player1Point, player2Point) >= 3;
  }

  private boolean isWin() {
    return Math.max(player1Point, player2Point) >= 4 && Math.abs(player1Point - player2Point) >= 2;
  }

  private boolean isEqual() {
    return player1Point == player2Point && player1Point < 4;
  }

  private boolean ifHigherLessThanFour() {
    return player1Point != player2Point && Math.max(player1Point, player2Point) < 4;
  }

  private boolean ifOneEqualZero() {
    return Math.max(player1Point, player2Point) > 0 && Math.min(player1Point, player2Point) == 0;
  }

  private void P1Score() {
    player1Point++;
  }

  private void P2Score() {
    player2Point++;
  }

  public void wonPoint(String player) {
    if (player.equals(PLAYER1)) P1Score();
    else P2Score();
  }
}
