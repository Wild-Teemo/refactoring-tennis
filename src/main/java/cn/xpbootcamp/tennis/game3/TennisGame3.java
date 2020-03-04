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

  private int p2;
  private int p1;
  private String player1Name;
  private String player2Name;

  public TennisGame3(String player1Name, String player2Name) {
    this.player1Name = player1Name;
    this.player2Name = player2Name;
  }

  public String getScore() {
    String s;
    if (p1 < 4 && p2 < 4 && !(p1 + p2 == 6)) {
      String[] p = new String[] {LOVE, FIFTEEN, THIRTY, FORTY};
      s = p[p1];
      return (p1 == p2) ? s + ALL : s + "-" + p[p2];
    } else {
      if (p1 == p2) return DEUCE;
      s = p1 > p2 ? player1Name : player2Name;
      return ((p1 - p2) * (p1 - p2) == 1) ? ADVANTAGE + s : WIN_FOR + s;
    }
  }

  public void wonPoint(String playerName) {
    if (playerName.equals(PLAYER1)) this.p1 += 1;
    else this.p2 += 1;
  }
}
