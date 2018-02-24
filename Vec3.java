/**
 * Vec3
 */
public class Vec3 {

    public double x;
    public double y;
    public double z;

    public Vec3() {
    }

    public Vec3(double value){
        this.x = this.y = this.z = value;
    }

    public Vec3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3(Vec3 v){
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public void setVec3(Vec3 v){
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public void setVec3(double value){
        this.x = value;
        this.y = value;
        this.z = value;
    }

    public void setVec3(double x, double y, double z){
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
        return new Vec3(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
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

    public void add(Vec3 v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
    }

    public void add(double value) {
        this.x += value;
        this.y += value;
        this.z += value;
    }

    public void sub(Vec3 v) {
        this.x -= v.x;
        this.y -= v.y;
        this.z -= v.z;
    }

    public void sub(double value) {
        this.x -= value;
        this.y -= value;
        this.z -= value;
    }

    public void mul(Vec3 v) {
        this.x *= v.x;
        this.y *= v.y;
        this.z *= v.z;
    }

    public void mul(double value) {
        this.x *= value;
        this.y *= value;
        this.z *= value;
    }

    public void div(Vec3 v){
        this.x /= v.x;
        this.y /= v.y;
        this.z /= v.z;
    }

    public void div(double value){
        this.x /= value;
        this.y /= value;
        this.z /= value;
    }

    public static Vec3 unitVector(Vec3 v){
        double len = Math.sqrt(v.x*v.x + v.y*v.y + v.z*v.z);
        return new Vec3(v.x/len, v.y/len, v.z/len);
    }

    public void unitVector(){
        double len = Math.sqrt(this.x * this.x + this.y*this.y + this.z*this.z);
        this.div(len);
    }

    public double dot(Vec3 v){
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    public static double dot(Vec3 v1, Vec3 v2){
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    public void cross(Vec3 v){
        double x = this.y * v.z - this.z * v.y;
        double y = this.z * v.x - this.x * v.z;
        double z = this.x * v.y - this.y * v.x;
        this.setVec3(x, y, z);
    }

    public static Vec3 cross(Vec3 v1, Vec3 v2){
        return new Vec3(v1.y * v2.z - v1.z * v2.y,
                        v1.z * v2.x - v1.x * v2.z,
                        v1.x * v2.y - v1.y * v2.x);
    }

    public String toString(){
        return "( " + this.x + ", " + this.y + ", " + this.z + " )";
    }

    @Override
    public Vec3 clone(){
        return new Vec3(this.x(), this.y(), this.z());
    }

}
