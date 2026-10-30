package Shape3D;

import java.math.BigDecimal;

public interface Shape {
    BigDecimal calculateVolume();
    BigDecimal calculateSurfaceArea();

    default void geometryShapes() {
        System.out.println("Interface for 3D Shapes");
    }
}
