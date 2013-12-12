package se.kodapan.util.geography.gausskruger;

/**
 * @author kalle
 * @since 2013-11-05 03:48
 */
public abstract class Bessel extends Projection {

  @Override
  public double getFlattening() {
    return 1d / 299.1528128d; // Bessel 1841.
  }

  @Override
  public double getAxis() {
    return 6377397.155d; // Bessel 1841.
  }

  @Override
  public double getScale() {
    return 1d;
  }

  @Override
  public double getFalseNorthing() {
    return 0d;
  }

  @Override
  public double getFalseEasting() {
    return 1500000d;
  }
}
