public class RayTracingUtils {
    // public static Vec3 normalize(Vec3 v) {
    //     return Vec3.div(v, v.length());
    // }

    public static double hit_sphere(Vec3 center, double radius, Ray r){
        Vec3 oc = Vec3.sub(r.origin(), center);
        double a = Vec3.dot(r.direction(), r.direction());
        double b = 2.0 * Vec3.dot(oc, r.direction());
        double c = Vec3.dot(oc, oc) - radius*radius;
        double delta = b*b - 4*a*c;
        if(delta < 0){
            return -1.0;
        }
        return (-b - Math.sqrt(delta)) / (2.0 * a);
    }

    public static Vec3 color(Ray r, Scene scene) {
        if(scene.hit(r, 0.001, Double.MAX_VALUE)){
            Vec3 N = scene.hitNormal;
            Vec3 col =  Vec3.mul(N, 0.5);
            // System.out.println(col);
            return col;
        }
        Vec3 unitDir = Vec3.unitVector(r.direction());
        // Vec3 unitDir = normalize(r.direction());
        double t = 0.5 * (unitDir.y() + 1.0);
        Vec3 color1 = new Vec3(1.0, 1.0, 1.0);
        Vec3 color2 = new Vec3(0.5, 0.7, 1.0);
        return Vec3.add(color1.mul(1.0 - t), color2.mul(t));
    }
}