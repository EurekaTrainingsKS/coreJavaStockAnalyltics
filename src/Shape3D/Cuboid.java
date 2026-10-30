package Shape3D;

import java.math.BigDecimal;

public class Cuboid implements Shape {
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
        return length.multiply(width).add(width.multiply(height)).add(height.multiply(length)).multiply(new BigDecimal(2));
    }
}
