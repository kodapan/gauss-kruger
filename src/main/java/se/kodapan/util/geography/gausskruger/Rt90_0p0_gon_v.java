package se.kodapan.util.geography.gausskruger;

/**
 * @author kalle
 * @since 2013-11-05 03:46
 */
public class Rt90_0p0_gon_v extends Grs80 {

  @Override
  public double getCentralMeridian() {
    return 18d + 3.378d / 60d;
  }

  @Override
  public double getScale() {
    return 1.0000054d;
  }

  @Override
  public double getFalseNorthing() {
    return -668.844d;
  }

  @Override
  public double getFalseEasting() {
    return 1500083.521d;
  }
}
