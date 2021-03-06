package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constant.ADVANTAGE;
import static cn.xpbootcamp.tennis.Constant.ALL;
import static cn.xpbootcamp.tennis.Constant.DEUCE;
import static cn.xpbootcamp.tennis.Constant.PLAYER1;
import static cn.xpbootcamp.tennis.Constant.PLAYER2;
import static cn.xpbootcamp.tennis.Constant.SCORE_NAMES;
import static cn.xpbootcamp.tennis.Constant.WIN_FOR;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 implements TennisGame {

  private int player1Point = 0;
  private int player2Point = 0;

  public void wonPoint(String player) {
    if (player.equals(PLAYER1)) {
      player1Point++;
    }else {
      player2Point++;
    }
  }

  public String getScore() {
    if (isWin()) {
      return WIN_FOR + (player2Point > player1Point ? PLAYER2 : PLAYER1);
    }
    if (isAdvantage()) {
      return ADVANTAGE + (player2Point > player1Point ? PLAYER2 : PLAYER1);
    }
    if (ifHigherLessThanFour()) {
      return SCORE_NAMES[player1Point] + "-" + SCORE_NAMES[player2Point];
    }
    if (isDeuce()) return DEUCE;

    if (isEqual()) {
      return SCORE_NAMES[player1Point] + ALL;
    }

    return "";
  }

  private boolean isDeuce() {
    return player1Point == player2Point && player1Point >= 3;
  }

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

}
