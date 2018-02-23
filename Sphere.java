/**
 * Sphere
 */
public class Sphere implements hitable{

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

    public Sphere(Vec3 center, double r, Vec3 color){
        this.center = center;
        this.radius = r;
        this.color = color;
    }

    public Sphere(Vec3 center, double r, Vec3 color, Material material){
        this.center = center;
        this.radius = r;
        this.color = color;
        this.material = material;
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
        double b = 2.0 * Vec3.dot(oc, r.direction());
        double c = Vec3.dot(oc, oc) - this.radius*this.radius;
        double delta = b*b - 4*a*c;
        if(delta > 0){
            double temp = (-b-Math.sqrt(b*b-4*a*c))/(2*a);
            if(temp < tmax && temp > tmin){
                this.t = temp;
                this.hitPosition = r.pointAt(temp);
                this.hitNormal = Vec3.div(Vec3.sub(this.hitPosition, this.center), this.radius);
                return true;
            }
            temp = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
            if(temp < tmax && temp > tmin){
                this.t = temp;
                this.hitPosition = r.pointAt(temp);
                this.hitNormal = Vec3.div(Vec3.sub(this.hitPosition, this.center), this.radius);
                return true;
            }
        }
        return false;
    }
}