package shape3d;

import java.math.BigDecimal;

public class Cylinder implements Shape{
    private BigDecimal radius;
    private BigDecimal height;

    public Cylinder(BigDecimal radius, BigDecimal height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public BigDecimal calculateVolume() {
        return radius.multiply(radius).multiply(height).multiply(new BigDecimal(Math.PI));
    }

    @Override
    public BigDecimal calculateSurfaceArea() {
        return radius.add(height).multiply(radius).multiply(new BigDecimal(2)).multiply(new BigDecimal(Math.PI));
    }
}
