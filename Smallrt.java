
public class Smallrt {

    public static void main(String[] args) {
        int nx = 200;
        int ny = 100;
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

        for (int j = ny - 1; j >= 0; j--) {
            for (int i = 0; i < nx; i++) {
                Vec3 col = new Vec3(0);
                for(int s = 0; s < ns; s++){
                    double u =  (i + Math.random()) / (double) nx;
                    double v =  (j + Math.random()) / (double) ny;
                    // double b = 0.2;
                    Vec3 rayDir = Vec3.add(lowerLeftCorner, Vec3.add(horizontal.mul(u), vertical.mul(v)));
                    // Ray r = new Ray(origin, Vec3.add(lowerLeftCorner, Vec3.add(horizontal.mul(u), vertical.mul(v))));
                    Ray r = new Ray(origin, rayDir);
                    col = col.add(RayTracingUtils.color(r, sphereScene));
                }
                images[index++] = Vec3.div(col, ns);
            }
        }
        ImageWriter.writePPM(nx, ny, images, "image");
    }
}