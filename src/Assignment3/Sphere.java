package Assignment3;

import java.math.BigDecimal;

public class Sphere implements Shapes3D{
    private BigDecimal radius;

    public Sphere(BigDecimal radius) {
        this.radius = radius;
    }

    @Override
    public BigDecimal calculateVolume() {
        return ((radius.pow(3)).multiply(new BigDecimal(Math.PI))).multiply((new BigDecimal(3).divide(new BigDecimal(4))));
    }

    @Override
    public BigDecimal calculateSurfaceArea() {
        return radius.pow(2).multiply(new BigDecimal(Math.PI)).multiply(new BigDecimal(4));
    }
}
