package se.kodapan.util.geography.gausskruger;

/**
 * @author kalle
 * @since 2013-11-05 03:41
 */
public class Rt90_7p5_gon_v extends Grs80 {

  @Override
  public double getCentralMeridian() {
    return 11d + 18.375d / 60d;
  }

  @Override
  public double getScale() {
    return 1.000006d;
  }

  @Override
  public double getFalseNorthing() {
    return -667.282d;
  }

  @Override
  public double getFalseEasting() {
    return 1500025.141d;
  }
}
