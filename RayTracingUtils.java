public class RayTracingUtils {
    public static Vec3 normalize(Vec3 v) {
        return Vec3.div(v, v.length());
    }

    public static Vec3 color(Ray r, Scene scene) {
        if(scene.hit(r, 0.001, Double.MAX_VALUE)){
            Vec3 color = new Vec3(scene.hitNormal.x()+1, scene.hitNormal.y()+1, scene.hitNormal.z()+1);
            return Vec3.mul(color, 0.5);
            // return color;
        }
        
        Vec3 unitDir = normalize(r.direction());
        double t = 0.5 * (unitDir.y() + 1.0);
        Vec3 color1 = new Vec3(1.0, 1.0, 1.0);
        Vec3 color2 = new Vec3(0.5, 0.7, 1.0);
        return Vec3.add(color1.mul(1.0 - t), color2.mul(t));
    }
}