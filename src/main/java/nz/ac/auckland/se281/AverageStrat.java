package nz.ac.auckland.se281;

import java.util.ArrayList;

public class AverageStrat implements AiStratigy {
  private int finger;
  private int sum;
  private int avgPersonFinger;
  private Person player;

  public AverageStrat(Person player) {
    this.player = player;
  }

  // outputs a random finger
  @Override
  public int getFingers() {
    finger = Utils.getRandomNumber(1, 5);
    return finger;
  }

  // calculates the correct sum based on the players previous finger picks and the ai chosen finger
  @Override
  public int getSum() {
    ArrayList<Integer> personFingers = player.getPlayerFingerPicks();
    avgPersonFinger = getAvgPersonFingers(personFingers);
    sum = avgPersonFinger + finger;
    return sum;
  }

  // finds the average finger of the
  public int getAvgPersonFingers(ArrayList<Integer> personFingers) {
    int totalFingers = 0;
    // counts the total all the players previous choices
    for (int finger : personFingers) {
      totalFingers += finger;
    }
    // calculates the average and rounds it
    double averageFingers = (double) totalFingers / personFingers.size();
    return (int) Math.round(averageFingers);
  }
}
