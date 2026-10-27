package interfaces;

import java.math.BigDecimal;

public class Square implements Shape{
    private BigDecimal side;

    public Square(BigDecimal side) {
        this.side = side;
    }

    public BigDecimal getSide() {
        return side;
    }

    public void setSide(BigDecimal side) {
        this.side = side;
    }

    @Override
    public BigDecimal calculateArea() {
        return side.multiply(side);
    }

    @Override
    public BigDecimal calculatePerimeter() {
        return side.multiply(new BigDecimal(2));
    }
}
