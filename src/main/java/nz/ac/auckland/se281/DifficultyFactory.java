package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {

  // depending on the inputted difficulty it outputs the correct class for the difficulty
  public static AmountDifficulty createDifficulty(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyDifficulty();

      case MEDIUM:
        return new MediumDifficulty();

      case HARD:
        return new HardDifficulty();

      case MASTER:
        return new MasterDifficulty();

      default:
    }
    return null;
  }
}
