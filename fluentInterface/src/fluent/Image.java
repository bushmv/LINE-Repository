package fluent;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    enum IMAGE_FORMAT {
        PNG,
        JPEG
    }

    private final File file;
    private final BufferedImage image;
    private IMAGE_FORMAT imgFormat;

    public Image(File file, IMAGE_FORMAT image_format) throws IOException {
        this.file = file;
        this.imgFormat = image_format;
        image = ImageIO.read(file);
    }

    public Image convert(IMAGE_FORMAT to) {
        //convert image in another format
        return this;
    }

    public Image filter(ImageFilter imageFilter) {
        //apply filter to image
        imageFilter.apply(image);
        return this;
    }

    public Image rotate(int degree) {
        //rotate image by an angle
        return this;
    }

    public void save() throws IOException {
        ImageIO.write(image, String.valueOf(imgFormat), file);
    }




}
