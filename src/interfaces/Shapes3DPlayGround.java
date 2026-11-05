package interfaces;

public class Shapes3DPlayGround {
    public static void main(String[] args) {
        Shape3D[] shapes = {
                new Cube(3),
                new Sphere(2),
                new Cuboid(2, 3, 4),
                new Cylinder(2, 5)
        };

        String[] names = {"Cube", "Sphere", "Cuboid", "Cylinder"};

        for (int i = 0; i < shapes.length; i++) {
            System.out.println(names[i]);
            System.out.printf("Volume: %.2f%n", shapes[i].calculateVolume());
            System.out.printf("Surface area: %.2f%n",
                    shapes[i].calculateSurfaceArea());
            System.out.println();
        }
    }
}