public class Scene{
    
    public Sphere[] spheres;
    public Scene(){
        spheres = new Sphere[4];
        spheres[0] = new Sphere(new Vec3(-0.6,0,-1), 0.3, new Vec3(0.0, 0.2, 0.7), hitable.Material.SPEC);
        spheres[1] = new Sphere(new Vec3(0,-100.5,-1), 100, new Vec3(0.7, 0.2, 0.2), hitable.Material.SPEC);
        spheres[2] = new Sphere(new Vec3(0.6, 0, -1), 0.3, new Vec3(0.2, 0.2, 0.7), hitable.Material.REFR);
        spheres[3] = new Sphere(new Vec3(0,0,-0.5), 0.3, new Vec3(0.7, 0.4, 0.2), hitable.Material.REFR);
//        spheres[2] = new Sphere(new Vec3(0, -100.5, -1), 100, new Vec3(0.2, 0.2, 0.2), hitable.Material.DIFF);
    }

    public Vec3 hitPosition;
    public Vec3 hitNormal;
    public Vec3 hitColor;
    public hitable.Material hitMaterial;
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
                this.hitColor = spheres[i].color;
                this.t = spheres[i].t;
                this.hitMaterial = spheres[i].material;

            }
        }
        return hitAnything;
    }
}