import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ImageWriter
 */
public class ImageWriter {

    public static double clamp(double x, double low, double high){
        return (x < high) ? ((x > low) ? x:low) : high;
    }

    public static int toByte(double x){
        return (int)clamp(x, 0.0, 255.0);
    }

    public static void writePPM(int w, int h, Vec3[] imageData, String name){
        if(name == null){name = "image";}
        name = name + ".ppm";
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("image.ppm"));
            writer.write("P3\n" + w + " " + h + " " + 255 + "\n\n");
            for(int i = 0; i < w*h; i++){
                int ir = toByte(imageData[i].r() * 255.99);
                int ig = toByte(imageData[i].g() * 255.99);
                int ib = toByte(imageData[i].b() * 255.99);
                writer.write(ir + " " + ig + " " + ib + "   ");
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
