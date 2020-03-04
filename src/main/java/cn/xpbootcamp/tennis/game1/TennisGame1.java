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

  private int playScore1 = 0;
  private int playScore2 = 0;

  public void wonPoint(String playerName) {
    if (playerName.equals("player1")) playScore1 += 1;
    else playScore2 += 1;
  }

  public String getScore() {
    StringBuilder score = new StringBuilder();
    if (playScore1 == playScore2) {
      score = getScoreWhenEqual();
    } else if (playScore1 >= 4 || playScore2 >= 4) {
      score = getScoreWhenMoreThanFour();
    } else {
      getScoreForNormal(score);
    }
    return score.toString();
  }

  private void getScoreForNormal(StringBuilder score) {
    int tempScore;
    for (int i = 1; i < 3; i++) {
      if (i == 1) tempScore = playScore1;
      else {
        score.append("-");
        tempScore = playScore2;
      }
      switch (tempScore) {
        case 0:
          score.append(LOVE);
          break;
        case 1:
          score.append(FIFTEEN);
          break;
        case 2:
          score.append(THIRTY);
          break;

        case 3:
          score.append(FORTY);
          break;
      }
    }
  }

  private StringBuilder getScoreWhenMoreThanFour() {
    StringBuilder score;
    int minusResult = playScore1 - playScore2;
    if (minusResult == 1) score = new StringBuilder(ADVANTAGE + PLAYER1);
    else if (minusResult == -1) score = new StringBuilder(ADVANTAGE + PLAYER2);
    else if (minusResult >= 2) score = new StringBuilder(WIN_FOR + PLAYER1);
    else score = new StringBuilder(WIN_FOR + PLAYER2);
    return score;
  }

  private StringBuilder getScoreWhenEqual() {
    StringBuilder score;
    switch (playScore1) {
      case 0:
        score = new StringBuilder(LOVE_ALL);
        break;

      case 1:
        score = new StringBuilder(FIFTEEN_ALL);
        break;
      case 2:
        score = new StringBuilder(THIRTY_ALL);
        break;
      default:
        score = new StringBuilder(DEUCE);
        break;
    }
    return score;
  }
}
