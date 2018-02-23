import java.util.Random;

public class Smallrt {

    public static void main(String[] args) {
        int nx = 600;
        int ny = 300;
        int ns = 30;

        if (args.length >= 1){nx = Integer.parseInt(args[0]);}
        if (args.length >= 2){ny = Integer.parseInt(args[1]);}
        if (args.length >= 3){ns = Integer.parseInt(args[2]);}
        
        Vec3[] images = new Vec3[nx * ny];
        int index = 0;

        Vec3 lowerLeftCorner = new Vec3(-2.0, -1.0, -1.0);
        Vec3 horizontal = new Vec3(4.0, 0.0, 0.0);
        Vec3 vertical = new Vec3(0.0, 2.0, 0.0);
        Vec3 origin = new Vec3(0.0, 0.0, 0.0);

        Scene sphereScene = new Scene();

        Random rand = new Random();

        for (int j = ny-1; j >= 0; j--) {
            for (int i = 0; i < nx; i++) {
                 Vec3 col = new Vec3(0);
                 for(int s = 0; s < ns; s++){
                    double u =  ((double)i + rand.nextDouble()) / (double) nx;
                    double v =  ((double)j + rand.nextDouble()) / (double) ny;

                    Vec3 rayDir = Vec3.add(lowerLeftCorner, Vec3.add(Vec3.mul(horizontal, u), Vec3.mul(vertical,v)));
                    Ray r = new Ray(origin, rayDir);
                    col = col.add(RayTracingUtils.color(r, sphereScene));
                 }
                 col = col.div(ns);
                 col = new Vec3(Math.sqrt(col.r()), Math.sqrt(col.g()), Math.sqrt(col.b()));
                 images[index++] = col;

            }
        }
        ImageWriter.writePPM(nx, ny, images, "image");
    }
}