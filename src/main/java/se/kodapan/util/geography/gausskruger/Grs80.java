package se.kodapan.util.geography.gausskruger;

/**
 * @author kalle
 * @since 2013-11-05 03:37
 */
public abstract class Grs80 extends Projection {

  @Override
  public double getAxis() {
    return 6378137d;
  }

  @Override
  public double getFlattening() {
    return 1d / 298.257222101d;
  }

}
