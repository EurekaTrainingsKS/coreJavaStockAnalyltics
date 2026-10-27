package interfaces;

import java.math.BigDecimal;

public interface Shape {
    /**
     * An interface can only have method signature it doesn't allow method body's
     * but where as abstrcat class will allow method body and also can only define method
     * signature by making it as an abstarct method
     * shound't contain any instance variables
     * and it will allow a default method with body
     * @return
     */
    BigDecimal calculateArea();
    BigDecimal calculatePerimeter();

    default void geometryShapes(){
        System.out.println("interface for 2D shapes");
    }
}
