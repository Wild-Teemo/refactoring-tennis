package cn.xpbootcamp.tennis.game1;

import static cn.xpbootcamp.tennis.Constant.ADVANTAGE;
import static cn.xpbootcamp.tennis.Constant.DEUCE;
import static cn.xpbootcamp.tennis.Constant.FIFTEEN;
import static cn.xpbootcamp.tennis.Constant.FIFTEEN_ALL;
import static cn.xpbootcamp.tennis.Constant.FORTY;
import static cn.xpbootcamp.tennis.Constant.LOVE;
import static cn.xpbootcamp.tennis.Constant.LOVE_ALL;
import static cn.xpbootcamp.tennis.Constant.PLAYER1;
import static cn.xpbootcamp.tennis.Constant.PLAYER2;
import static cn.xpbootcamp.tennis.Constant.THIRTY;
import static cn.xpbootcamp.tennis.Constant.THIRTY_ALL;
import static cn.xpbootcamp.tennis.Constant.WIN_FOR;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

  private int player1Score = 0;
  private int player2Score = 0;

  public void wonPoint(String playerName) {
    if (playerName.equals("player1")) player1Score += 1;
    else player2Score += 1;
  }

  public String getScore() {
    String score = "";
    if (player1Score == player2Score) {
      score = getScoreWhenEqual();
    } else if (player1Score >= 4 || player2Score >= 4) {
      score = getScoreWhenMoreThanFour();
    } else {
      score = getScoreForNormal(score);
    }
    return score;
  }

  private String getScoreForNormal(String score) {
    int tempScore;
    for (int i = 1; i < 3; i++) {
      if (i == 1) tempScore = player1Score;
      else {
        score += ("-");
        tempScore = player2Score;
      }
      switch (tempScore) {
        case 0:
          score += (LOVE);
          break;
        case 1:
          score += (FIFTEEN);
          break;
        case 2:
          score += (THIRTY);
          break;

        case 3:
          score += (FORTY);
          break;
      }
    }
    return score;
  }

  private String getScoreWhenMoreThanFour() {
    String score;
    int minusResult = player1Score - player2Score;
    if (minusResult == 1) score = ADVANTAGE + PLAYER1;
    else if (minusResult == -1) score = ADVANTAGE + PLAYER2;
    else if (minusResult >= 2) score = WIN_FOR + PLAYER1;
    else score = WIN_FOR + PLAYER2;
    return score;
  }

  private String getScoreWhenEqual() {
    String score;
    switch (player1Score) {
      case 0:
        score = LOVE_ALL;
        break;

      case 1:
        score = FIFTEEN_ALL;
        break;
      case 2:
        score = THIRTY_ALL;
        break;
      default:
        score = DEUCE;
        break;
    }
    return score;
  }
}
