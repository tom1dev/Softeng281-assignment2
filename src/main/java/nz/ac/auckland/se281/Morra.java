package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  // initalises variables
  private int amountPlay;
  private AmountDifficulty difficulty;
  private Person player;
  private boolean gamestart;
  private int pointsToWin;
  private int humanPointCounter;
  private int aiPointCounter;

  public Morra() {
    gamestart = false;
    amountPlay = 0;
    humanPointCounter = 0;
    aiPointCounter = 0;
  }

  // creates a new game
  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    // based on the difficulty chosen a different difficulty is added.
    this.difficulty = DifficultyFactory.createDifficulty(difficulty);
    gamestart = true;
    player = new Person(options[0]);
    this.pointsToWin = pointsToWin;

    // resets values for a new game
    amountPlay = 0;
    player.clear();
    humanPointCounter = 0;
    aiPointCounter = 0;

    // welcomes the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {

    // if there is already no game running then don't allow play to run
    if (gamestart == false) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {
      amountPlay += 1;

      // prints start messages
      String stringAmountPlay = Integer.toString(amountPlay);
      MessageCli.START_ROUND.printMessage(stringAmountPlay);
      MessageCli.ASK_INPUT.printMessage();

      // gets input for sum and fingers from player. int[0] is fingers, int[1] is sums
      Integer[] playerInputs = player.getPlayerChoices();

      // prints the players move
      MessageCli.PRINT_INFO_HAND.printMessage(
          player.getName(), Integer.toString(playerInputs[0]), Integer.toString(playerInputs[1]));

      // switches the ai's strat based on the amount of rnds played then gets ais outputs
      difficulty.switchstrats(amountPlay, player);
      int aiFinger = difficulty.getFingers();
      int aiSum = difficulty.getSum();

      // adds current player inputs after ai has done calculations
      player.setRndInputs(playerInputs[0], playerInputs[1]);

      // prints aimove
      MessageCli.PRINT_INFO_HAND.printMessage(
          "Jarvis", Integer.toString(aiFinger), Integer.toString(aiSum));

      // calculates the actual sum
      int sum = aiFinger + playerInputs[0];

      // checks who one the Rnd and adds to there point totals
      if (sum == playerInputs[1] && sum == aiSum) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      } else if (sum == playerInputs[1]) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
        humanPointCounter += 1;

      } else if (sum == aiSum) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
        aiPointCounter += 1;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      }

      // checks if anyone has won the game
      if (humanPointCounter == pointsToWin) {
        MessageCli.END_GAME.printMessage(player.getName(), Integer.toString(amountPlay));
        gamestart = false;
      } else if (aiPointCounter == pointsToWin) {
        MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(amountPlay));
        gamestart = false;
      }
    }
  }

  public void showStats() {

    // if there is a game currently being played then allow showstats, and prints messages
    if (gamestart == true) {
      String humanPointsToWin = Integer.toString(pointsToWin - humanPointCounter);
      String aiPointsToWin = Integer.toString(pointsToWin - aiPointCounter);

      MessageCli.PRINT_PLAYER_WINS.printMessage(
          player.getName(), Integer.toString(humanPointCounter), humanPointsToWin);

      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "Jarvis", Integer.toString(aiPointCounter), aiPointsToWin);
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }
}
