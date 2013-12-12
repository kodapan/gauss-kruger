package se.kodapan.util.geography.gausskruger;

/**
 * @author kalle
 * @since 2013-11-05 03:26
 */
public abstract class Projection {

  public abstract double getCentralMeridian();

  public abstract double getFlattening();

  public abstract double getAxis();

  public abstract double getScale();

  public abstract double getFalseNorthing();

  public abstract double getFalseEasting();

  private double latitude;
  private double longitude;

  /**
   * Conversion from geodetic coordinates to grid coordinates.
   */
  public void geodetic_to_grid(double latitude, double longitude) {

    // Prepare ellipsoid-based stuff.
    double e2 = getFlattening() * (2.0 - getFlattening());
    double n = getFlattening() / (2.0 - getFlattening());
    double a_roof = getAxis() / (1.0 + n) * (1.0 + n * n / 4.0 + n * n * n * n / 64.0);
    double A = e2;
    double B = (5.0 * e2 * e2 - e2 * e2 * e2) / 6.0;
    double C = (104.0 * e2 * e2 * e2 - 45.0 * e2 * e2 * e2 * e2) / 120.0;
    double D = (1237.0 * e2 * e2 * e2 * e2) / 1260.0;
    double beta1 = n / 2.0 - 2.0 * n * n / 3.0 + 5.0 * n * n * n / 16.0 + 41.0 * n * n * n * n / 180.0;
    double beta2 = 13.0 * n * n / 48.0 - 3.0 * n * n * n / 5.0 + 557.0 * n * n * n * n / 1440.0;
    double beta3 = 61.0 * n * n * n / 240.0 - 103.0 * n * n * n * n / 140.0;
    double beta4 = 49561.0 * n * n * n * n / 161280.0;

    // Convert.
    double deg_to_rad = Math.PI / 180.0;
    double phi = latitude * deg_to_rad;
    double lambda = longitude * deg_to_rad;
    double lambda_zero = getCentralMeridian() * deg_to_rad;

    double phi_star = phi - Math.sin(phi) * Math.cos(phi) * (A +
        B * Math.pow(Math.sin(phi), 2) +
        C * Math.pow(Math.sin(phi), 4) +
        D * Math.pow(Math.sin(phi), 6));
    double delta_lambda = lambda - lambda_zero;
    double xi_prim = Math.atan(Math.tan(phi_star) / Math.cos(delta_lambda));
    double eta_prim = atanh(Math.cos(phi_star) * Math.sin(delta_lambda));
    double x = getScale() * a_roof * (xi_prim +
        beta1 * Math.sin(2.0 * xi_prim) * cosh(2.0 * eta_prim) +
        beta2 * Math.sin(4.0 * xi_prim) * cosh(4.0 * eta_prim) +
        beta3 * Math.sin(6.0 * xi_prim) * cosh(6.0 * eta_prim) +
        beta4 * Math.sin(8.0 * xi_prim) * cosh(8.0 * eta_prim)) +
        getFalseNorthing();
    double y = getScale() * a_roof * (eta_prim +
        beta1 * Math.cos(2.0 * xi_prim) * sinh(2.0 * eta_prim) +
        beta2 * Math.cos(4.0 * xi_prim) * sinh(4.0 * eta_prim) +
        beta3 * Math.cos(6.0 * xi_prim) * sinh(6.0 * eta_prim) +
        beta4 * Math.cos(8.0 * xi_prim) * sinh(8.0 * eta_prim)) +
        getFalseEasting();

    this.latitude = Math.round(x * 1000.0) / 1000.0;
    this.longitude = Math.round(y * 1000.0) / 1000.0;

  }

  /**
   * Conversion from grid coordinates to geodetic coordinates.
   */
  public void grid_to_geodetic(double x, double y) {

    // Prepare ellipsoid-based stuff.
    double e2 = getFlattening() * (2.0 - getFlattening());
    double n = getFlattening() / (2.0 - getFlattening());
    double a_roof = getAxis() / (1.0 + n) * (1.0 + n * n / 4.0 + n * n * n * n / 64.0);
    double delta1 = n / 2.0 - 2.0 * n * n / 3.0 + 37.0 * n * n * n / 96.0 - n * n * n * n / 360.0;
    double delta2 = n * n / 48.0 + n * n * n / 15.0 - 437.0 * n * n * n * n / 1440.0;
    double delta3 = 17.0 * n * n * n / 480.0 - 37 * n * n * n * n / 840.0;
    double delta4 = 4397.0 * n * n * n * n / 161280.0;

    double Astar = e2 + e2 * e2 + e2 * e2 * e2 + e2 * e2 * e2 * e2;
    double Bstar = -(7.0 * e2 * e2 + 17.0 * e2 * e2 * e2 + 30.0 * e2 * e2 * e2 * e2) / 6.0;
    double Cstar = (224.0 * e2 * e2 * e2 + 889.0 * e2 * e2 * e2 * e2) / 120.0;
    double Dstar = -(4279.0 * e2 * e2 * e2 * e2) / 1260.0;

    // Convert.
    double deg_to_rad = Math.PI / 180;
    double lambda_zero = getCentralMeridian() * deg_to_rad;
    double xi = (x - getFalseNorthing()) / (getScale() * a_roof);
    double eta = (y - getFalseEasting()) / (getScale() * a_roof);
    double xi_prim = xi -
        delta1 * Math.sin(2.0 * xi) * cosh(2.0 * eta) -
        delta2 * Math.sin(4.0 * xi) * cosh(4.0 * eta) -
        delta3 * Math.sin(6.0 * xi) * cosh(6.0 * eta) -
        delta4 * Math.sin(8.0 * xi) * cosh(8.0 * eta);
    double eta_prim = eta -
        delta1 * Math.cos(2.0 * xi) * sinh(2.0 * eta) -
        delta2 * Math.cos(4.0 * xi) * sinh(4.0 * eta) -
        delta3 * Math.cos(6.0 * xi) * sinh(6.0 * eta) -
        delta4 * Math.cos(8.0 * xi) * sinh(8.0 * eta);
    double phi_star = Math.asin(Math.sin(xi_prim) / cosh(eta_prim));
    double delta_lambda = Math.atan(sinh(eta_prim) / Math.cos(xi_prim));
    double lon_radian = lambda_zero + delta_lambda;
    double lat_radian = phi_star + Math.sin(phi_star) * Math.cos(phi_star) *
        (Astar +
            Bstar * Math.pow(Math.sin(phi_star), 2) +
            Cstar * Math.pow(Math.sin(phi_star), 4) +
            Dstar * Math.pow(Math.sin(phi_star), 6));
    latitude = lat_radian * 180.0 / Math.PI;
    longitude = lon_radian * 180.0 / Math.PI;
  }

  // Missing functions in the Math library.

  private double sinh(double value) {
    return 0.5 * (Math.exp(value) - Math.exp(-value));
  }

  private double cosh(double value) {
    return 0.5 * (Math.exp(value) + Math.exp(-value));
  }

  private double atanh(double value) {
    return 0.5 * Math.log((1.0 + value) / (1.0 - value));
  }


  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

}
