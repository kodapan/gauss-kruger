package se.kodapan.util.geography.gausskruger;

/**
 * @author kalle
 * @since 2013-11-05 03:54
 */
public abstract class Sweref_99 extends Projection {

  @Override
  public double getFlattening() {
    return 1d / 298.257222101d; // GRS 80.
  }

  @Override
  public double getAxis() {
    return 6378137d; // GRS 80.
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
    return 150000d;
  }
}
