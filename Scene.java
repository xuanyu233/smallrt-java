public class Scene{
    
    public Sphere[] spheres;
    public Scene(){
        spheres = new Sphere[2];
        spheres[0] = new Sphere(new Vec3(0,0,-1), 0.5);
        spheres[1] = new Sphere(new Vec3(0, -100.5, -1), 100);
    }

    public Vec3 hitPosition;
    public Vec3 hitNormal;
    public double t;

    public boolean hit(Ray r, double tmin, double tmax){
        boolean hitAnything = false;
        double closestSoFar = tmax;
        for(int i = 0; i < spheres.length; i++){
            if(spheres[i].hit(r, tmin, closestSoFar)){
                // System.out.println("hit scene");
                hitAnything = true;
                closestSoFar = spheres[i].t;

                this.hitPosition = spheres[i].hitPosition;
                this.hitNormal = spheres[i].hitNormal;
                this.t = spheres[i].t;

            }
        }
        return hitAnything;
    }
}