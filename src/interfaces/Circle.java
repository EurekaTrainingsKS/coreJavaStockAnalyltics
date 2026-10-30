package interfaces;

import java.math.BigDecimal;

public class Circle implements Shape{
    private BigDecimal radius;

    public Circle(BigDecimal radius) {
        this.radius = radius;
    }

    @Override
    public BigDecimal calculateArea() {
        return radius.multiply(radius).multiply(new BigDecimal(Math.PI));
    }

    @Override
    public BigDecimal calculatePerimeter() {
        return radius.multiply(new BigDecimal(2)).multiply(new BigDecimal(Math.PI));
    }
}
