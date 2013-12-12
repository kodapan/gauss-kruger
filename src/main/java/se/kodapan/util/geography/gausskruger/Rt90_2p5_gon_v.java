package se.kodapan.util.geography.gausskruger;

/**
 * hitta.se seems to use this projection in their API.
 *
 * @author kalle
 * @since 2013-11-05 03:45
 */
public class Rt90_2p5_gon_v extends Grs80 {

  @Override
  public double getCentralMeridian() {
    return 15d + 48d / 60d + 22.624306d / 3600d;
  }

  @Override
  public double getScale() {
    return 1.00000561024d;
  }

  @Override
  public double getFalseNorthing() {
    return -667.711d;
  }

  @Override
  public double getFalseEasting() {
    return 1500064.274d;
  }
}
