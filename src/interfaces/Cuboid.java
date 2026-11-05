package interfaces;

public class Cuboid implements Shape3D {
    private final double length;
    private final double width;
    private final double height;

    public Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        return length * width * height;
    }

    @Override
    public double calculateSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }
}