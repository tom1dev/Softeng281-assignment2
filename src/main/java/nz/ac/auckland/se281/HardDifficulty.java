package nz.ac.auckland.se281;

public class HardDifficulty extends AmountDifficulty {

  // after round 4 it switches to the top stratigy
  @Override
  public void switchstrats(int rndNum, Person Player) {
    if (rndNum == 4) {
      ai = new TopStrat(Player);
    }
  }
}
