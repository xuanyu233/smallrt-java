public class Camera {

    public Vec3 origin;
    public Vec3 lowerLeftCorner;
    public Vec3 horizontal;
    public Vec3 vertical;

    public Camera(){}
    public Camera(double fov, double aspect){
        double theta = fov * Math.PI / 180;
        double halfHeight = Math.tan(theta/2);
        double halfWidth = aspect*halfHeight;
        this.lowerLeftCorner = new Vec3(-halfWidth, -halfHeight, -1.0);
        this.horizontal = new Vec3(2*halfWidth, 0.0,0.0);
        this.vertical = new Vec3(0.0, 2*halfHeight, 0.0);
        this.origin = new Vec3(0.0, 0.0, 0.0);
    }

    public Camera(Vec3 lookFrom, Vec3 lookAt, Vec3 vup, double fov, double aspect){
        Vec3 u, v, w;
        double theta = fov * Math.PI / 180;
        double halfHeight = Math.tan(theta/2);
        double halfWidth = aspect*halfHeight;
        this.origin = lookAt;
        Vec3 lookFromMinusLookAt = Vec3.sub(lookFrom,lookAt);
        w = Vec3.unitVector(lookFromMinusLookAt);
        u = Vec3.unitVector(Vec3.cross(vup, w));
        v = Vec3.cross(w,u);

//        Vec3 halfWidthU = u.mul(halfWidth);
//        Vec3 halfHeightV = v.mul(halfHeight);
//        Vec3 temp1 = Vec3.sub(lookFrom,halfWidthU);
//        Vec3 temp2 = Vec3.sub(temp1, halfHeightV);
//        this.lowerLeftCorner = Vec3.sub(temp2, w);
//
        this.lowerLeftCorner = Vec3.sub(lookFrom, Vec3.add(u.mul(halfWidth), Vec3.add(v.mul(halfHeight), w)));

        this.horizontal = u.mul(2*halfWidth);
        this.vertical = v.mul(2*halfHeight);

    }

    public Ray getRay(double s, double t){
        Vec3 rayDir = Vec3.add(lowerLeftCorner, Vec3.add(Vec3.mul(horizontal, s), Vec3.mul(vertical,t)));
        return new Ray(origin, rayDir);
    }
}
