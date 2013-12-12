package se.kodapan.util.geography.gausskruger;

/**
 * @author kalle
 * @since 2013-11-05 03:43
 */
public class Rt90_5p0_gon_v extends Grs80 {


  @Override
  public double getCentralMeridian() {
    return 13d + 33.376d / 60d;
  }

  @Override
  public double getScale() {
    return 1.0000058d;
  }

  @Override
  public double getFalseNorthing() {
    return -667.130d;
  }

  @Override
  public double getFalseEasting() {
    return 1500044.695d;
  }
}
