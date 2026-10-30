package Shape3D;

import java.math.BigDecimal;
import java.util.concurrent.CyclicBarrier;

public class Cylinder implements Shape {
    private BigDecimal radius;
    private BigDecimal height;


    public Cylinder(BigDecimal height, BigDecimal radius) {
        this.height = height;
        this.radius = radius;
    }

    @Override
    public BigDecimal calculateSurfaceArea() {
        return radius.multiply(radius).multiply(height).multiply(new BigDecimal(Math.PI));
    }

    @Override
    public BigDecimal calculateVolume() {
        return radius.add(height).multiply(radius).multiply(new BigDecimal(2)).multiply(new BigDecimal(Math.PI));
    }
}
