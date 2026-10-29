package Assignment3;

import java.math.BigDecimal;

public interface Shapes3D {
    BigDecimal calculateVolume();
    BigDecimal calculateSurfaceArea();

    default void geometryShapes() {
        System.out.println("interface for 3D shapes");
    }

}
