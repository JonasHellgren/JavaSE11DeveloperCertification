package object_oriented_approach.six_ploymorphism.geography;

public class Circle {
    private Coordinate origin;
    private int radiusNm;

    public Circle(Coordinate origin, int radiusNm) {
        this.origin = origin;
        this.radiusNm = radiusNm;
    }

    public Coordinate getOrigin() {
        return origin;
    }

    public int getRadiusNm() {
        return radiusNm;
    }
}
