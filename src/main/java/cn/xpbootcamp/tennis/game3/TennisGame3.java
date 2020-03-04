package cn.xpbootcamp.tennis.game3;

import static cn.xpbootcamp.tennis.Constant.ADVANTAGE;
import static cn.xpbootcamp.tennis.Constant.ALL;
import static cn.xpbootcamp.tennis.Constant.DEUCE;
import static cn.xpbootcamp.tennis.Constant.FIFTEEN;
import static cn.xpbootcamp.tennis.Constant.FORTY;
import static cn.xpbootcamp.tennis.Constant.LOVE;
import static cn.xpbootcamp.tennis.Constant.PLAYER1;
import static cn.xpbootcamp.tennis.Constant.THIRTY;
import static cn.xpbootcamp.tennis.Constant.WIN_FOR;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame3 implements TennisGame {

  private int score2;
  private int score1;
  private String player1Name;
  private String player2Name;

  public TennisGame3(String player1Name, String player2Name) {
    this.player1Name = player1Name;
    this.player2Name = player2Name;
  }

  public String getScore() {
    String s;
    if (score1 < 4 && score2 < 4 && !(score1 + score2 == 6)) {
      String[] p = new String[] {LOVE, FIFTEEN, THIRTY, FORTY};
      s = p[score1];
      return (score1 == score2) ? s + ALL : s + "-" + p[score2];
    } else {
      if (score1 == score2) return DEUCE;
      s = score1 > score2 ? player1Name : player2Name;
      return ((score1 - score2) * (score1 - score2) == 1) ? ADVANTAGE + s : WIN_FOR + s;
    }
  }

  public void wonPoint(String playerName) {
    if (playerName.equals(PLAYER1)) this.score1 += 1;
    else this.score2 += 1;
  }
}
