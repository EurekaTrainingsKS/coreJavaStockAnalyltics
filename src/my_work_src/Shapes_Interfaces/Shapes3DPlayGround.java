package my_work_src.Shapes_Interfaces;
import java.math.BigDecimal;

public class Shapes3DPlayGround {
    public static void main(String[] args) {
        Cuboid cuboid1 = new Cuboid(new BigDecimal(5),new BigDecimal(3), new BigDecimal(2));
        System.out.println("Cuboid_volume " + cuboid1.calculateVolume());
        System.out.println("Cuboid_SurfaceArea "+ cuboid1.calculateSurfaceArea());

        Sphere sphere1 = new Sphere(new BigDecimal(8));
        System.out.println("sphere_volume "+ sphere1.calculateVolume());
        System.out.println("sphere_SurfaceArea " + sphere1.calculateSurfaceArea());

        Cube cube1 = new Cube(new BigDecimal(6));
        System.out.println("Cube_volume "+ cube1.calculateVolume());
        System.out.println("Cube_SurfaceArea "+ cube1.calculateSurfaceArea());

        Cylindrical cyn1 = new Cylindrical(new BigDecimal(5), new BigDecimal(7));
        System.out.println("Cyn_volume "+ cyn1.calculateVolume());
        System.out.println("Cyn_SurfaceArea "+ cyn1.calculateSurfaceArea());

        sphere1.geometryShapes();
    }
}