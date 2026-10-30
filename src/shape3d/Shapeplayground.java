package shape3d;

import java.math.BigDecimal;

public class Shapeplayground {
    public static void main(String[] args){
        Cube cube1 = new Cube(new BigDecimal(4));
        System.out.println(cube1.calculateVolume());
        System.out.println(cube1.calculateSurfaceArea());

        Sphere sphere1 = new Sphere(new BigDecimal(4));
        System.out.println(sphere1.calculateVolume());
        System.out.println(sphere1.calculateSurfaceArea());

        Cuboid cuboid1 = new Cuboid(new BigDecimal(5),new BigDecimal(3), new BigDecimal(2));
        System.out.println(cuboid1.calculateVolume());
        System.out.println(cuboid1.calculateSurfaceArea());

        Cylinder cylinder1 = new Cylinder(new BigDecimal(3), new BigDecimal(7));
        System.out.println(cylinder1.calculateVolume());
        System.out.println(cylinder1.calculateSurfaceArea());

        cube1.geometryShapes();
    }
}
