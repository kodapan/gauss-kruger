package se.kodapan.util.geography.gausskruger;

/**
 * @author kalle
 * @since 2013-11-05 03:47
 */
public class Rt90_5p0_gon_o extends Grs80 {

  @Override
  public double getCentralMeridian() {
    return 22d + 33.38d / 60d;
  }

  @Override
  public double getScale() {
    return 1.0000049d;
  }

  @Override
  public double getFalseNorthing() {
    return -672.557d;
  }

  @Override
  public double getFalseEasting() {
    return 1500121.846d;
  }
}
