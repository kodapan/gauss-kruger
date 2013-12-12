package se.kodapan.util.geography.gausskruger;

/**
 * @author kalle
 * @since 2013-11-05 03:50
 */
public class Bessel_Rt90_5p0_gon_v extends Bessel {

  @Override
  public double getCentralMeridian() {
    return 13d + 33d / 60d + 29.8d / 3600d;
  }
}
