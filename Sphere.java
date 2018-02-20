/**
 * Sphere
 */
public class Sphere implements hitable{
    public enum Material {DIFFUSE, SPECULAR, REFRACTIVE};
    
    public Vec3 center;
    public double radius;

    public Vec3 emission;
    public Vec3 color;
    public Material material;
    
    public Sphere(){}
    public Sphere(Vec3 center, double r){
        this.center = center;
        this.radius = r;
    }

    public Sphere(Vec3 center, double r, Vec3 color, Vec3 emission, Material material){
        this.center = center;
        this.radius = r;
        this.emission = emission;
        this.color = color;
        this.material = material;
    }

    public Vec3 hitPosition;
    public Vec3 hitNormal;
    public double t;

    public boolean hit(Ray r, double tmin, double tmax){
        Vec3 oc = Vec3.sub(r.origin(), this.center);
        double a = Vec3.dot(r.direction(), r.direction());
        double b = Vec3.dot(oc, r.direction());
        double c = Vec3.dot(oc,oc) - this.radius * this.radius;
        double delta = b*b - a*c;
        if(delta > 0){
            double temp = (-b-Math.sqrt(b*b-a*c))/a;
            if(temp < tmax && temp > tmin){
                this.t = temp;
                this.hitPosition = r.pointAt(temp);
                this.hitNormal = Vec3.div(Vec3.sub(this.hitPosition, this.center), this.radius);
                return true;
            }
            temp = (-b + Math.sqrt(b*b-a*c))/a;
            if(temp < tmax && temp > tmin){
                this.t = temp;
                this.hitPosition = r.pointAt(temp);
                this.hitNormal = Vec3.div(Vec3.sub(this.hitPosition, this.center), this.radius);
                return true;
            }
        }
        return false;
    }

    // public boolean hit(Ray r, double tmin, double tmax){
    //     Vec3 op = Vec3.sub(this.center, r.origin());
    //     double dop = r.direction().dot(op);
    //     double D = dop * dop - op.dot(op) + this.radius * this.radius;

    //     if(D > 0){
    //         double temp = dop + Math.sqrt(D);
    //         if(temp < tmax && temp > tmin){
    //             this.hitPosition = r.pointAt(temp);
    //             this.hitNormal = Vec3.div(Vec3.sub(this.hitPosition, this.center),this.radius);
    //             this.t = temp;
    //             return true;
    //         }
    //         temp = dop - Math.sqrt(D);
    //         if(temp < tmax && temp > tmin){
    //             this.hitPosition = r.pointAt(temp);
    //             this.hitNormal = Vec3.div(Vec3.sub(this.hitPosition, this.center),this.radius);
    //             this.t = temp;
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}