package se.kodapan.util.geography.gausskruger;

/**
 * @author kalle
 * @since 2013-11-05 03:47
 */
public class Rt90_2p5_gon_o extends Grs80 {

  @Override
  public double getCentralMeridian() {
    return 20d + 18.379d / 60d;
  }

  @Override
  public double getScale() {
    return 1.0000052d;
  }

  @Override
  public double getFalseNorthing() {
    return -670.706d;
  }

  @Override
  public double getFalseEasting() {
    return 1500102.765d;
  }
}
