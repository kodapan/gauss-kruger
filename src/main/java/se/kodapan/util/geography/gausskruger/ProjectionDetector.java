package se.kodapan.util.geography.gausskruger;

import java.util.*;

/**
 * @author kalle
 * @since 2013-11-05 04:05
 */
public class ProjectionDetector {

  private Set<Projection> projections;

  public ProjectionDetector() {
    projections = new HashSet<>();
    projections.add(new Bessel_Rt90_0p0_gon_v());
    projections.add(new Bessel_Rt90_2p5_gon_o());
    projections.add(new Bessel_Rt90_2p5_gon_v());
    projections.add(new Bessel_Rt90_5p0_gon_o());
    projections.add(new Bessel_Rt90_5p0_gon_v());
    projections.add(new Bessel_Rt90_7p5_gon_v());

    projections.add(new Rt90_0p0_gon_v());
    projections.add(new Rt90_2p5_gon_o());
    projections.add(new Rt90_2p5_gon_v());
    projections.add(new Rt90_5p0_gon_o());
    projections.add(new Rt90_5p0_gon_v());
    projections.add(new Rt90_7p5_gon_v());

    projections.add(new Sweref_99_tm());
    projections.add(new Sweref_99_1200());
    projections.add(new Sweref_99_1330());
    projections.add(new Sweref_99_1415());
    projections.add(new Sweref_99_1500());
    projections.add(new Sweref_99_1545());
    projections.add(new Sweref_99_1630());
    projections.add(new Sweref_99_1715());
    projections.add(new Sweref_99_1800());
    projections.add(new Sweref_99_1845());
    projections.add(new Sweref_99_2015());
    projections.add(new Sweref_99_2145());
    projections.add(new Sweref_99_2315());
  }

  public ProjectionDetector(Set<Projection> projections) {
    this.projections = projections;
  }

  public List<Map.Entry<Projection, Double>> distanceToProjections(double x, double y, double aprioriLatitude, double aprioriLongitude) {
    Map<Projection, Double> distanceToProjections = new HashMap<>(projections.size());
    for (Projection projection : projections) {
      projection.grid_to_geodetic(x, y);
      distanceToProjections.put(projection, calculateKilometersDistance(projection.getLatitude(), projection.getLongitude(), aprioriLatitude, aprioriLongitude));
    }
    List<Map.Entry<Projection, Double>> ordered = new ArrayList<>(distanceToProjections.entrySet());
    Collections.sort(ordered, new Comparator<Map.Entry<Projection, Double>>() {
      @Override
      public int compare(Map.Entry<Projection, Double> o1, Map.Entry<Projection, Double> o2) {
        return o1.getValue().compareTo(o2.getValue());
      }
    });
    return ordered;
  }


  private double calculateKilometersDistance(double latitudeA, double longitudeA, double latitudeB, double longitudeB) {

    double dLatitude = Math.toRadians(latitudeB - latitudeA);
    double dLongitude = Math.toRadians(longitudeB - longitudeA);
    double a = Math.sin(dLatitude / 2) * Math.sin(dLatitude / 2) +
        Math.cos(Math.toRadians(latitudeA)) * Math.cos(Math.toRadians(latitudeB)) *
            Math.sin(dLongitude / 2) * Math.sin(dLongitude / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    double radiusEarth = 6371; // km
    double distance = radiusEarth * c;

    return distance;
  }

  public Set<Projection> getProjections() {
    return projections;
  }

  public void setProjections(Set<Projection> projections) {
    this.projections = projections;
  }
}
