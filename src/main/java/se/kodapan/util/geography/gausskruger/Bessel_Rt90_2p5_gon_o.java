package se.kodapan.util.geography.gausskruger;

/**
 * @author kalle
 * @since 2013-11-05 03:52
 */
public class Bessel_Rt90_2p5_gon_o extends Bessel {

  @Override
  public double getCentralMeridian() {
    return  20d + 18d / 60d + 29.8d / 3600d;
  }
}
