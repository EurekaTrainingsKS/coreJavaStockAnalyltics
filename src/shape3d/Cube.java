package shape3d;

import java.math.BigDecimal;

public class Cube implements Shape {
        private BigDecimal side;

        public Cube(BigDecimal side){
            this.side = side;
        }

    public BigDecimal getSide() {
        return side;
    }

    public void setSide(BigDecimal side) {
        this.side = side;
    }

    @Override
    public BigDecimal calculateVolume() {
        return side.multiply(side).multiply(side);
    }

    @Override
    public BigDecimal calculateSurfaceArea() {
        return side.multiply(side).multiply(new BigDecimal(6));
    }
    }
