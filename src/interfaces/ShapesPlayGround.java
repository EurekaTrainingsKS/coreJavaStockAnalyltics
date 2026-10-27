package interfaces;

import java.math.BigDecimal;

public class ShapesPlayGround {
    public static void main(String[] args) {
        Square sq1 = new Square(new BigDecimal(4));
        System.out.println(sq1.calculateArea());
        System.out.println(sq1.calculatePerimeter());

        Cricle cir1 = new Cricle(new BigDecimal(4));
        System.out.println(cir1.calculateArea());
        System.out.println(cir1.calculatePerimeter());
    }
}
