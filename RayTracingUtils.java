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

    public static Vec3 randomInUnitSphere(){
        Vec3 p;
        do{
            p = new Vec3(Math.random(), Math.random(), Math.random());
            p = p.mul(2.0).sub(new Vec3(1.0,1.0,1.0));

        }while(p.squareLength() >= 1.0);
        return p;
    }

    public static Vec3 color(Ray r, Scene scene) {
        if(scene.hit(r, 0.001, Double.MAX_VALUE)){
//            Vec3 target = Vec3.add(Vec3.add(scene.hitPosition, scene.hitNormal), randomInUnitSphere());
            Vec3 rayDir = Vec3.add(scene.hitNormal,randomInUnitSphere());
            Vec3 col = color(new Ray(scene.hitPosition, rayDir), scene);
            return Vec3.mul(col,0.5);
        }
        Vec3 unitDir = Vec3.unitVector(r.direction());
        double t = 0.5 * (unitDir.y() + 1.0);
        Vec3 color1 = new Vec3(1.0, 1.0, 1.0);
        Vec3 color2 = new Vec3(0.5, 0.7, 1.0);
        return Vec3.add(color1.mul(1.0 - t), color2.mul(t));
    }

    public static Vec3 color(Ray r){
        Vec3 sphereLoc = new Vec3(0,0,-1);
        double t = hit_sphere(sphereLoc, 0.5, r);
        if(t > 0.0){
            Vec3 N = Vec3.unitVector(Vec3.sub(r.pointAt(t), new Vec3(0,0,-1)));
            return N.add(1).mul(0.5);
        }
        Vec3 unitDir = Vec3.unitVector(r.direction());
        t = 0.5*(unitDir.y() + 1.0);
        Vec3 color1 = new Vec3(1.0,1.0,1.0);
        Vec3 color2 = new Vec3(0.5,0.7,1.0);
        return Vec3.add(color1.mul(1.0-t), color2.mul(t));
    }

}