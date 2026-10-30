package Shape3D;

import java.math.BigDecimal;

public class ShapePlayGround {
    public static void main(String[] args) {
    Cube mycube = new Cube(new BigDecimal(4));
        System.out.println(mycube.calculateVolume());
        System.out.println(mycube.calculateSurfaceArea());

    Sphere mySphere = new Sphere(new BigDecimal(4));
        System.out.println(mySphere.calculateVolume());
        System.out.println(mySphere.calculateSurfaceArea());

    Cuboid myCuboid = new Cuboid(new BigDecimal(5),  new BigDecimal(3), new BigDecimal(2));
        System.out.println(myCuboid.calculateVolume());
        System.out.println(myCuboid.calculateSurfaceArea());

    Cylinder myCylinder = new Cylinder(new BigDecimal(3), new BigDecimal(7));
        System.out.println(myCylinder.calculateVolume());
        System.out.println(myCylinder.calculateSurfaceArea());



    }
}
