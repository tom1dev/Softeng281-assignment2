package nz.ac.auckland.se281;

public class RandomStrat implements AiStratigy {
  private int finger;
  private int sum;

  // randomly chooses a outputted finger
  @Override
  public int getFingers() {
    finger = Utils.getRandomNumber(1, 5);
    return finger;
  }

  // randomly chooses a outputted sum
  @Override
  public int getSum() {
    sum = Utils.getRandomNumber(finger + 1, finger + 5);
    return sum;
  }
}
