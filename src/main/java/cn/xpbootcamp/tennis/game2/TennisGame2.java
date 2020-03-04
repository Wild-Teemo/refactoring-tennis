package cn.xpbootcamp.tennis.game2;

import static cn.xpbootcamp.tennis.Constant.ADVANTAGE;
import static cn.xpbootcamp.tennis.Constant.ALL;
import static cn.xpbootcamp.tennis.Constant.DEUCE;
import static cn.xpbootcamp.tennis.Constant.FIFTEEN;
import static cn.xpbootcamp.tennis.Constant.FORTY;
import static cn.xpbootcamp.tennis.Constant.LOVE;
import static cn.xpbootcamp.tennis.Constant.PLAYER1;
import static cn.xpbootcamp.tennis.Constant.PLAYER2;
import static cn.xpbootcamp.tennis.Constant.THIRTY;
import static cn.xpbootcamp.tennis.Constant.WIN_FOR;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 implements TennisGame {

  private int P1point = 0;
  private int P2point = 0;

  private String P1res = "";
  private String P2res = "";

  public String getScore() {
    String score = "";
    if (P1point == P2point && P1point < 4) {
      if (P1point == 0) score = LOVE;
      if (P1point == 1) score = FIFTEEN;
      if (P1point == 2) score = THIRTY;
      score += ALL;
    }
    if (P1point == P2point && P1point >= 3) score = DEUCE;

    if (P1point > 0 && P2point == 0) {
      if (P1point == 1) P1res = FIFTEEN;
      if (P1point == 2) P1res = THIRTY;
      if (P1point == 3) P1res = FORTY;

      P2res = LOVE;
      score = P1res + "-" + P2res;
    }
    if (P2point > 0 && P1point == 0) {
      if (P2point == 1) P2res = FIFTEEN;
      if (P2point == 2) P2res = THIRTY;
      if (P2point == 3) P2res = FORTY;

      P1res = LOVE;
      score = P1res + "-" + P2res;
    }

    if (P1point > P2point && P1point < 4) {
      if (P1point == 2) P1res = THIRTY;
      if (P1point == 3) P1res = FORTY;
      if (P2point == 1) P2res = FIFTEEN;
      if (P2point == 2) P2res = THIRTY;
      score = P1res + "-" + P2res;
    }
    if (P2point > P1point && P2point < 4) {
      if (P2point == 2) P2res = THIRTY;
      if (P2point == 3) P2res = FORTY;
      if (P1point == 1) P1res = FIFTEEN;
      if (P1point == 2) P1res = THIRTY;
      score = P1res + "-" + P2res;
    }

    if (P1point > P2point && P2point >= 3) {
      score = ADVANTAGE + PLAYER1;
    }

    if (P2point > P1point && P1point >= 3) {
      score = ADVANTAGE + PLAYER2;
    }

    if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
      score = WIN_FOR + PLAYER1;
    }
    if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
      score = WIN_FOR + PLAYER2;
    }
    return score;
  }

  private void P1Score() {
    P1point++;
  }

  private void P2Score() {
    P2point++;
  }

  public void wonPoint(String player) {
    if (player.equals(PLAYER1)) P1Score();
    else P2Score();
  }
}
