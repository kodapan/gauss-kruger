package se.kodapan.util.geography.gausskruger;

/**
 * @author kalle
 * @since 2013-11-05 03:55
 */
public class Sweref_99_tm extends Sweref_99 {

  @Override
  public double getCentralMeridian() {
    return 15d;
  }

  @Override
  public double getScale() {
    return 0.9996d;
  }

  @Override
  public double getFalseEasting() {
    return 500000d;
  }
}
