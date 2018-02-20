import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ImageWriter
 */
public class ImageWriter {
    public static void writePPM(int w, int h, Vec3[] imageData, String name){
        if(name == null){name = "image";}
        name = name + ".ppm";
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("image.ppm"));
            writer.write("P3\n" + w + " " + h + " " + 255 + "\n");
            for(int i = 0; i < w*h; i++){
                int ir = (int)(imageData[i].r() * 255.99);
                int ig = (int)(imageData[i].g() * 255.99);
                int ib = (int)(imageData[i].b() * 255.99);
                writer.write(ir + " " + ig + " " + ib + "\n");
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
