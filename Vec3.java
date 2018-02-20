/**
 * Vec3
 */
public class Vec3 {

    public double x, y, z;

    public Vec3() {
    }

    public Vec3(double a) {
        this(a, a, a);
    }

    public Vec3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getValue(int i) {
        if (i == 0)
            return x;
        if (i == 1)
            return y;
        if (i == 2)
            return z;
        return 0.0;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double z() {
        return z;
    }

    public double r() {
        return x;
    }

    public double g() {
        return y;
    }

    public double b() {
        return z;
    }

    public static Vec3 minus(Vec3 v) {
        return new Vec3(-v.x, -v.y, -v.z);
    }

    public static Vec3 add(Vec3 v1, Vec3 v2) {
        return new Vec3(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    public static Vec3 sub(Vec3 v1, Vec3 v2) {
        return new Vec3(v1.x - v2.x, v1.x - v2.x, v1.z - v2.z);
    }

    public static Vec3 sub(Vec3 v1, double v){
        return new Vec3(v1.x-v, v1.y-v,v1.z-v);
    }

    public static Vec3 sub(double a, Vec3 v){
        return new Vec3(a-v.x, a-v.y, a-v.z);
    };

    public static Vec3 mul(Vec3 v1, Vec3 v2) {
        return new Vec3(v1.x * v2.x, v1.y * v2.y, v1.z * v2.z);
    }

    public static Vec3 mul(Vec3 v1, double v) {
        return new Vec3(v1.x * v, v1.x * v, v1.z * v);
    }

    public static Vec3 div(Vec3 v1, Vec3 v2) {
        return new Vec3(v1.x / v2.x, v1.y / v2.y, v1.z / v2.z);
    }

    public static Vec3 div(Vec3 v1, double v) {
        return new Vec3(v1.x / v, v1.y / v, v1.z / v);
    }

    public static Vec3 div(double v, Vec3 v1){
        return new Vec3(v/v1.x, v/v1.y, v/v1.z);
    }

    public static double dot(Vec3 v1, Vec3 v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    public static Vec3 cross(Vec3 v1, Vec3 v2) {
        return new Vec3(v1.y * v2.z - v1.z * v2.y, v1.z * v2.x - v1.x * v2.z, v1.x * v2.y - v1.y * v2.x);
    }

    public static Vec3 unitVector(Vec3 v){
        return div(v, v.length());
    }

    public double dot(Vec3 v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    public Vec3 cross(Vec3 v) {
        return new Vec3(this.y * v.z - this.z * v.y, this.z * v.x - this.x * v.z, this.x * v.y - this.y * v.x);

    }

    public String toString() {
        return "( " + this.x + ", " + this.y + ", " + this.z + " )";
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public double squarLength() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public Vec3 add(double v){
        return new Vec3(this.x+v, this.y+v, this.z+v);
    }

    public Vec3 sub(double v){
        return new Vec3(this.x-v, this.y-v, this.z-v);
    }

    public Vec3 mul(double v){
        return new Vec3(this.x*v, this.y*v,this.z*v);
    }

    public Vec3 div(double v){
        return new Vec3(this.x/v, this.y/v, this.z/v);
    }

    public Vec3 unitVector(){
        return div(this, this.length());
    }

    public Vec3 minus(){
        return new Vec3(-this.x, -this.y, -this.z);
    }

}