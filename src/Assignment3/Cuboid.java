package Assignment3;

import java.math.BigDecimal;

public class Cuboid implements Shapes3D{
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal height;

    public Cuboid(BigDecimal length, BigDecimal width, BigDecimal height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public BigDecimal calculateVolume() {
        return length.multiply(width).multiply(height);
    }

    @Override
    public BigDecimal calculateSurfaceArea() {
        return (length.multiply(width).add(length.multiply(height).add(width.multiply(height)))).multiply(new BigDecimal(2));

    }
}
