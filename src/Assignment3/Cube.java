package Assignment3;

import java.math.BigDecimal;

public class Cube implements Shapes3D{
    private BigDecimal side;

    public Cube(BigDecimal side) {
        this.side = side;
    }

    @Override
    public BigDecimal calculateSurfaceArea() {
        return side.pow(2).multiply(new BigDecimal(6));
    }

    @Override
    public BigDecimal calculateVolume() {
        return side.pow(3);
    }
}
