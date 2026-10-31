package my_work_src.Shapes_Interfaces;

import java.math.BigDecimal;

public class Sphere implements Shapes3D{
    private BigDecimal radius;
    public Sphere(BigDecimal radius){this.radius = radius;}
    public void setRadius(BigDecimal radius) {this.radius = radius;}
    public BigDecimal getSide() {
        return radius;
    }

    @Override
    public BigDecimal calculateVolume() {
        return radius.pow(3).multiply(new BigDecimal(Math.PI)).multiply(new BigDecimal(4.0/3.0));
    }

    @Override
    public BigDecimal calculateSurfaceArea() {
        return radius.multiply(radius).multiply(new BigDecimal(4)).multiply(new BigDecimal(Math.PI));
    }
}
