package se.kodapan.util.geography.gausskruger;

/**
 * @author kalle
 * @since 2013-11-05 03:51
 */
public class Bessel_Rt90_0p0_gon_v extends Bessel {

  @Override
  public double getCentralMeridian() {
    return 18d + 3d / 60d + 29.8d / 3600d;
  }
}
