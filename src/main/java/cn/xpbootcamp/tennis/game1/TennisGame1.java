package cn.xpbootcamp.tennis.game1;

import static cn.xpbootcamp.tennis.Constant.ADVANTAGE;
import static cn.xpbootcamp.tennis.Constant.ALL;
import static cn.xpbootcamp.tennis.Constant.DEUCE;
import static cn.xpbootcamp.tennis.Constant.PLAYER1;
import static cn.xpbootcamp.tennis.Constant.PLAYER2;
import static cn.xpbootcamp.tennis.Constant.SCORE_NAMES;
import static cn.xpbootcamp.tennis.Constant.WIN_FOR;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

  private int player1Score = 0;
  private int player2Score = 0;

  public void wonPoint(String playerName) {
    if (playerName.equals(PLAYER1)) player1Score += 1;
    else player2Score += 1;
  }

  public String getScore() {
    if (player1Score == player2Score) {
      return getScoreWhenEqual();
    } else if (player1Score >= 4 || player2Score >= 4) {
      return getScoreWhenMoreThanFour();
    } else {
      return getScoreForNormal();
    }
  }

  private String getScoreForNormal() {
    return SCORE_NAMES[player1Score] + "-" + SCORE_NAMES[player2Score];
  }

  private String getScoreWhenMoreThanFour() {
    String WinOrAdvantage = Math.abs(player1Score - player2Score) == 1 ? ADVANTAGE : WIN_FOR;
    String playerName = player1Score > player2Score ? PLAYER1 : PLAYER2;
    return WinOrAdvantage + playerName;
  }

  private String getScoreWhenEqual() {
    return player1Score > 2 ? DEUCE : SCORE_NAMES[player1Score] + ALL;
  }
}
