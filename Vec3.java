/**
 * Vec3
 */
public class Vec3 {

    public double x;
    public double y;
    public double z;

    public Vec3() {
    }

    public Vec3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public double z() {
        return this.z;
    }

    public double r() {
        return this.x;
    }

    public double g() {
        return this.y;
    }

    public double b() {
        return this.z;
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public double squareLength() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public static Vec3 add(Vec3 v1, Vec3 v2) {
        return new Vec3(v1.x + v2.x, v1.y + v2.y, v1.z + v1.z);
    }

    public static Vec3 add(Vec3 v, double value) {
        return new Vec3(v.x + value, v.y + value, v.z + value);
    }

    public static Vec3 add(double value, Vec3 v) {
        return add(value, v);
    }

    public static Vec3 sub(Vec3 v1, Vec3 v2) {
        return new Vec3(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    public static Vec3 sub(Vec3 v, double value) {
        return new Vec3(v.x - value, v.x - value, v.z - value);
    }

    public static Vec3 sub(double value, Vec3 v) {
        return new Vec3(value - v.x, value - v.y, value - v.z);
    }

    public static Vec3 mul(Vec3 v1, Vec3 v2) {
        return new Vec3(v1.x * v2.x, v1.y * v2.y, v1.z * v2.z);
    }

    public static Vec3 mul(Vec3 v, double value) {
        return new Vec3(v.x * value, v.y * value, v.z * value);
    }

    public static Vec3 mul(double value, Vec3 v) {
        return mul(v, value);
    }

    public static Vec3 div(Vec3 v1, Vec3 v2){
        return new Vec3(v1.x/v2.x, v1.y/v2.y, v1.z/v2.z);
    }

    public static Vec3 div(Vec3 v, double value){
        return new Vec3(v.x/value, v.y/value, v.z/value);
    }

    public static Vec3 div(double value, Vec3 v){
        return new Vec3(value / v.x, value / v.y, value /v.z);
    }

    public Vec3 add(Vec3 v) {
        return new Vec3(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public Vec3 add(double value) {
        return new Vec3(this.x + value, this.y + value, this.z + value);
    }

    public Vec3 sub(Vec3 v) {
        return new Vec3(this.x - v.x, this.y - v.y, this.z - v.z);
    }

    public Vec3 sub(double value) {
        return new Vec3(this.x - value, this.y - value, this.z - value);
    }

    public Vec3 mul(Vec3 v) {
        return new Vec3(this.x * v.x, this.y * v.y, this.z * v.z);
    }

    public Vec3 mul(double value) {
        return new Vec3(this.x * value, this.y * value, this.z * value);
    }

    public Vec3 div(Vec3 v){
        return new Vec3(this.x/v.x, this.y/v.y, this.z/v.z);
    }

    public Vec3 div(double value){
        return new Vec3(this.x/value, this.y/value, this.z/value);
    }

    public static Vec3 unitVector(Vec3 v){
        double len = Math.sqrt(v.x*v.x + v.y*v.y + v.z*v.z);
        return new Vec3(v.x/len, v.y/len, v.z/len);
    }

    public Vec3 unitVector(){
        double len = Math.sqrt(this.x * this.x + this.y*this.y + this.z*this.z);
        return new Vec3(this.x/len, this.y/len, this.z/len);
    }

}