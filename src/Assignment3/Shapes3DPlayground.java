package Assignment3;

import java.math.BigDecimal;

public class Shapes3DPlayground {

    public static void main(String[] args) {
        System.out.println("CUBE Calculations:- ");
        Cube c = new Cube(new BigDecimal(4));
        System.out.println("Surface Area:- " + c.calculateSurfaceArea());
        System.out.println("Volume:- " + c.calculateVolume());

        System.out.println("SPHERE Calculations:- ");
        Sphere s = new Sphere(new BigDecimal(3.5));
        System.out.println("Surface Area:- " + s.calculateSurfaceArea());
        System.out.println("Volume:- " + s.calculateVolume());

        System.out.println("CUBIOD Calculations:- ");
        Cuboid co = new Cuboid(new BigDecimal(5),new BigDecimal(3.0),new BigDecimal(2.0));
        System.out.println("Surface Area:- " + co.calculateSurfaceArea());
        System.out.println("Volume:- " + co.calculateVolume());

        System.out.println("CYLINDER Calculations:- ");
         Cylinder cy = new Cylinder(new BigDecimal(2.5),new BigDecimal(7.0));
        System.out.println("Surface Area:- " + cy.calculateSurfaceArea());
        System.out.println("Volume:- " + cy.calculateVolume());


    }
}
