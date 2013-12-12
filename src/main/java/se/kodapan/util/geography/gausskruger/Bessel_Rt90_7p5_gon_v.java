package se.kodapan.util.geography.gausskruger;

/**
 * @author kalle
 * @since 2013-11-05 03:48
 */
public class Bessel_Rt90_7p5_gon_v extends Bessel {

  @Override
  public double getCentralMeridian() {
    return 11d + 18d / 60d + 29.8d / 3600d;
  }
}
