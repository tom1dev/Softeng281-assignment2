package nz.ac.auckland.se281;

public class MediumDifficulty extends AmountDifficulty {

  // if the round is 4 it switches the ai to player ai
  @Override
  public void switchstrats(int rndNum, Person player) {
    if (rndNum == 4) {
      ai = new AverageStrat(player);
    }
  }
}
