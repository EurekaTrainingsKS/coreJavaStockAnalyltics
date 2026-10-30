package shape3d;

import javax.print.attribute.standard.PresentationDirection;
import java.math.BigDecimal;

public class Sphere implements Shape{
    private BigDecimal radius;

    public Sphere(BigDecimal radius) {
        this.radius = radius;
    }

    @Override
    public BigDecimal calculateVolume() {
        return radius.multiply(radius).multiply(radius).multiply(new BigDecimal(Math.PI)).multiply(new BigDecimal(4.0/3.0));
    }

    @Override
    public BigDecimal calculateSurfaceArea() {
        return radius.multiply(radius).multiply(new BigDecimal(Math.PI)).multiply(new BigDecimal(4));
    }
}
