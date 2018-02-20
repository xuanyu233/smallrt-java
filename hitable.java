/**
 * hitable
 */
public interface hitable {
    public boolean hit(Ray r, double tmin, double tmax);
}