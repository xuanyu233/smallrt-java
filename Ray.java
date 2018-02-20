public class Ray {

    public Vec3 A;
    public Vec3 B;

    public Ray() {
    }

    public Ray(Vec3 a, Vec3 b) {
        this.A = a;
        this.B = b;
    }

    public Vec3 origin() {
        return this.A;
    }

    public Vec3 direction() {
        return this.B;
    }

    public Vec3 pointAt(double t) {
        return Vec3.add(this.A, Vec3.mul(this.B, t));
    }
}