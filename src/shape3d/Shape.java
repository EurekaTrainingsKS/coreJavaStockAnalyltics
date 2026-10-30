package shape3d;

import java.math.BigDecimal;

public interface Shape {

    BigDecimal calculateVolume();
    BigDecimal calculateSurfaceArea();

    default void geometryShapes(){
        System.out.println("interface for 3D shapes");
    }
}