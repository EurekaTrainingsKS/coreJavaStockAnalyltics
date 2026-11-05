package interfaces;

public class Cube implements Shape3D {
    private final double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double calculateVolume() {
        return side * side * side;
    }

    @Override
    public double calculateSurfaceArea() {
        return 6 * side * side;
    }
}
