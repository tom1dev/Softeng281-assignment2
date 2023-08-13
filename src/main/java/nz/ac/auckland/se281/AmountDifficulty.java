package nz.ac.auckland.se281;

public abstract class AmountDifficulty {
  protected AiStratigy ai;

  // initialises variables in amountdifficulty
  public AmountDifficulty() {
    ai = new RandomStrat();
  }

  // outputs ai fingers
  public int getFingers() {
    return ai.getFingers();
  }

  // switches the strategy used based on the amount of rounds
  public void switchstrats(int rndNum, Person player) {}

  // outputs ai sum
  public int getSum() {
    return ai.getSum();
  }
}
