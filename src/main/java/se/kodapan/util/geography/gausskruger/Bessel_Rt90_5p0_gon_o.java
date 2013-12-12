package se.kodapan.util.geography.gausskruger;

/**
 * @author kalle
 * @since 2013-11-05 03:53
 */
public class Bessel_Rt90_5p0_gon_o extends Bessel {

  @Override
  public double getCentralMeridian() {
    return 22d + 33d / 60d + 29.8d / 3600d;
  }
}
