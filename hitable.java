/**
 * hitable
 */
public interface hitable {
    public static enum Material{DIFF, SPEC, REFR }
    public boolean hit(Ray r, double tmin, double tmax);
}