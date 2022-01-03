package object_oriented_approach.six_ploymorphism.airspace;


import object_oriented_approach.six_ploymorphism.geography.Coordinate;

public interface AirSector {
    boolean isInSector(Coordinate x, int altitude);

    default boolean isCrowded(int aircraft, int maxNbAircraft) {
        return aircraft > maxNbAircraft;
    }
}
