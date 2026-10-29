package Assignment3;

import java.math.BigDecimal;

public class Cylinder implements Shapes3D{
    private BigDecimal radius;
    private BigDecimal height;

    public Cylinder(BigDecimal radius, BigDecimal height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public BigDecimal calculateVolume() {
        return radius.pow(2).multiply(new BigDecimal(Math.PI)).multiply(height);
    }

    @Override
    public BigDecimal calculateSurfaceArea() {
        return (radius.add(height)).multiply(radius).multiply(new BigDecimal(Math.PI)).multiply(new BigDecimal(2));
    }
}
