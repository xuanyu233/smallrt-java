public class RayTracingUtils {

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
        Vec3 p = null;
        do{
            p = new Vec3(Math.random(), Math.random(), Math.random());
            p.mul(2.0);
            p.sub(new Vec3(1.0,1.0,1.0));

        }while(p.squareLength() >= 1.0);
        return p;
    }

    public static Vec3 reflect(Vec3 v, Vec3 n){
        double t = 2*Vec3.dot(v,n);
        return Vec3.sub(v, Vec3.mul(n,2*t));
    }

    public static boolean ifRefracted(Vec3 v, Vec3 n, double niOverNt){
        Vec3 uv = Vec3.unitVector(v);
        double dt = Vec3.dot(uv,n);
        double discriminant = 1.0 - niOverNt*niOverNt*(1-dt*dt);
        return discriminant > 0;
    }

    public static Vec3 refract(Vec3 v, Vec3 n, double niOverNt){
        Vec3 uv = Vec3.unitVector(v);
        double dt = Vec3.dot(uv,n);
        Vec3 ndt = Vec3.mul(n,dt);
        double discriminant = 1.0 - niOverNt*niOverNt*(1-dt*dt);
        Vec3 unvdt = Vec3.sub(uv,ndt);
        n.mul(Math.sqrt(discriminant));
        unvdt.mul(niOverNt);
        return Vec3.sub(unvdt, n);
    }

    public static double schlick(double cosine, double refIdx){
        double r0 = (1-refIdx)/(1+refIdx);
        r0 = r0*r0;
        return r0 + (1-r0)*Math.pow((1-cosine),5);
    }


    public static Vec3 color(Ray r, Scene scene) {
        if(scene.hit(r, 0.001, Double.MAX_VALUE)){
            Vec3 rayDir = Vec3.add(scene.hitNormal,randomInUnitSphere());
            Vec3 col = color(new Ray(scene.hitPosition, rayDir), scene);
            return Vec3.mul(col,0.5);
        }
        Vec3 unitDir = Vec3.unitVector(r.direction());
        double t = 0.5 * (unitDir.y() + 1.0);
        Vec3 color1 = new Vec3(1.0, 1.0, 1.0);
        Vec3 color2 = new Vec3(0.5, 0.7, 1.0);
        color1.mul(1.0-t);
        color2.mul(t);
        return Vec3.add(color1, color2);
    }

    public static Vec3 color(Ray r){
        Vec3 sphereLoc = new Vec3(0,0,-1);
        double t = hit_sphere(sphereLoc, 0.5, r);
        if(t > 0.0){
            Vec3 N = Vec3.unitVector(Vec3.sub(r.pointAt(t), new Vec3(0,0,-1)));
            N.add(1);
            N.mul(0.5);
            return N;
        }
        Vec3 unitDir = Vec3.unitVector(r.direction());
        t = 0.5*(unitDir.y() + 1.0);
        Vec3 color1 = new Vec3(1.0,1.0,1.0);
        Vec3 color2 = new Vec3(0.5,0.7,1.0);
        color1.mul(1.0-t);
        color2.mul(t);
        return Vec3.add(color1, color2);
    }

    public static Vec3 color(Ray r, Scene scene, int depth) {
        if(scene.hit(r, 0.001, Double.MAX_VALUE) && depth < 40){
            if(scene.hitMaterial == hitable.Material.DIFF){
                Vec3 rayDir = Vec3.add(scene.hitNormal,randomInUnitSphere());
                Vec3 col = color(new Ray(scene.hitPosition, rayDir), scene, depth++);
                Vec3 hitColor = new Vec3(0);
                double sines = Math.sin(10*scene.hitPosition.x())*Math.sin(10*scene.hitPosition.y())*Math.sin(10*scene.hitPosition.z());
                if(sines < 0){
                    hitColor.x = 0.2;
                    hitColor.y = 0.3;
                    hitColor.z = 0.1;
                }else{
                    hitColor.x = 0.9;
                    hitColor.y = 0.9;
                    hitColor.z = 0.9;
                }
                return Vec3.mul(col, hitColor);
            }else if(scene.hitMaterial == hitable.Material.SPEC){
                Vec3 reflected = reflect(Vec3.unitVector(r.direction()), scene.hitNormal);
                Vec3 col = color(new Ray(scene.hitPosition, reflected), scene, depth++);
                Vec3 hitColor = scene.hitColor;
                return Vec3.mul(col, hitColor);
            }else if(scene.hitMaterial == hitable.Material.REFR){
                Vec3 outNormal;
                Vec3 reflected = reflect(r.direction(),scene.hitNormal);
                double niOverNt = 1.5;
                Vec3 attenuation = new Vec3(1.0,1.0,1.0);
                Vec3 refracted;
                Ray scattered;
                double reflectProb;
                double cosine;
                if(Vec3.dot(r.direction(), scene.hitNormal) > 0){
                    outNormal = Vec3.sub(0,scene.hitNormal);
                    cosine = niOverNt*Vec3.dot(r.direction(), scene.hitNormal) / r.direction().length();
                }else{
                    outNormal = scene.hitNormal;
                    cosine = -Vec3.dot(r.direction(), scene.hitNormal) / r.direction().length();
                }
                if(ifRefracted(r.direction(), outNormal, niOverNt)){
                    refracted = refract(r.direction(),outNormal,niOverNt);
                    reflectProb = schlick(cosine, niOverNt);
                    if(Math.random() < reflectProb){
                        scattered = new Ray(scene.hitPosition, reflected);
                    }else{
                        scattered = new Ray(scene.hitPosition, refracted);
                    }
                }else{
                    scattered = new Ray(scene.hitPosition, reflected);
                }
                Vec3 col = color(scattered, scene, depth++);
                return Vec3.mul(col, attenuation);
            }

        }
        Vec3 unitDir = Vec3.unitVector(r.direction());
        double t = 0.5 * (unitDir.y() + 1.0);
        Vec3 color1 = new Vec3(1.0, 1.0, 1.0);
        Vec3 color2 = new Vec3(0.5, 0.7, 1.0);
        color1.mul(1.0-t);
        color2.mul(t);
        return Vec3.add(color1, color2);
    }

}