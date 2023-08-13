package nz.ac.auckland.se281;

public class MasterDifficulty extends AmountDifficulty {

  // depending on the rnd it switches the ai to be on the correct stratigy
  @Override
  public void switchstrats(int rndNum, Person player) {
    if (rndNum > 3) {
      if (rndNum % 2 == 0) {
        ai = new AverageStrat(player);
      } else {
        ai = new TopStrat(player);
      }
    }
  }
}
