import java.util.*;

/**
 * This class implements a number of filters, i.e. methods that can be used to
 * manipulate Image objects, e.g. make the image darker or mirrored.
 * The filter methods operates on the image in the field (feltvariabel) image.
 * The filter methods change the original image and return the new image.
 *
 * @author Kurt Jensen
 * @version 2017-08-04
 */
public class Filters
{

    private Image image;     // Image on which the filter methods operate
    
    /**
     * The constructor takes as input an instance of Image.
     * 
     * @param image   Image to apply filters to.
     */
    public Filters(Image image) {
        this.image = image;
    }
    
    /**
     * The constructor  creates an Image object from the file picture.jpg (in the project folder).
     * 
     * @param image   Image to apply filters to.
     */
    public Filters() {
        this(new Image("picture.png"));
    }
    
    /**
     * This method brightens an image by adding some amount to the
     * value of all pixels in the image.
     * The title of the new image is prefixed 'brightenX-',
     * where X is the parametervalue.
     *
     * @param amount   Increase in value for each pixel.
     * @return   Brightened image.
     */
    public Image brighten(int amount) {
        Image result = new Image(image.getWidth(), image.getHeight(),
        String.format("brighten%d-%s", amount, this.image.getTitle()), false);
        for (int y = 0; y < result.getHeight(); y++)
            for (int x = 0; x < result.getWidth() / 2; x++)
                result.getPixel(x, y).setValue(image.getPixel(x, y).getValue() + amount);
        return result;
    }

    /**
     * This method darkens an image by subtracting some amount from the
     * value of all pixels in the image.
     * The title of the new image is prefixed 'darkenX-',
     * where X is the parametervalue.
     *
     * @param amount   Decrease in value for each pixel.
     * @return   Darkened image.
     */
    public Image darken(int amount) {
        Image result = new Image(image.getWidth(), image.getHeight(),
        String.format("darken%d-%s", amount, this.image.getTitle()), false);
        for (int y = 0; y < result.getHeight(); y++)
            for (int x = 0; x < result.getWidth() / 2; x++)
                result.getPixel(x, y).setValue(image.getPixel(x, y).getValue() - amount);
        return result;
    }

    /**
     * This method inverts an image by mapping each pixel value 'v' to '255-v'
     * such that white turns black and vice-versa.
     * The title of the new image is prefixed 'invert-'.
     *
     * @return   Inverted image.
     */
    public Image invert() {
        Image result = new Image(image.getWidth(), image.getHeight(),
        String.format("invert-%s", this.image.getTitle()), false);
        for (int y = 0; y < result.getHeight(); y++)
            for (int x = 0; x < result.getWidth() / 2; x++)
                result.getPixel(x, y).setValue(255 - image.getPixel(x, y).getValue());
        return result;
    }

    /**
     * This method mirrors an image across the vertical axis.
     * The value of pixel (i,j) in the new image is set to the value of pixel
     * (width-i-1, j) in the old image, where width is the width of the image.
     * The title of the new image is prefixed 'mirror-'.
     *
     * @return   Mirrored image.
     */
    public Image mirror() {
        Image result = new Image(image.getWidth(), image.getHeight(),
        String.format("mirror-%s", this.image.getTitle()), false);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                result.getPixel(result.getWidth() - x - 1, y).setValue(image.getPixel(x, y).getValue());
            }
        }
        return result;
    }

    /**
     * This method flips an image across the horizontal axis.
     * The value of pixel (i,j) in the new image is set to the value of pixel
     * ?????????? in the old image, where height is the height of the image.
     * The title of the new image is prefixed 'flip-'.
     *
     * @return   Flipped image.
     */
    public Image flip() {
        Image result = new Image(image.getWidth(), image.getHeight(),
        String.format("flip-%s", this.image.getTitle()), false);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                result.getPixel(x, result.getHeight() - y - 1).setValue(image.getPixel(x, y).getValue());
            }
        }
        return result;
    }

    /**
     * This method rotates an image 90 degrees clockwise.
     * The value of pixel (i,j) in the new image is set to the value of pixel
     * (j,width-i-1) in the old image, where width is the width of the new image.
     * The title of the new image is prefixed 'rotate-'.
     *
     * @return   Rotated image.
     */
    public Image rotate() {
        Image result = new Image(image.getHeight(), image.getWidth(),
        String.format("rotate-%s", this.image.getTitle()), false);
        for (int y = 0; y < result.getHeight(); y++) {
            for (int x = 0; x < result.getWidth(); x++) {
                result.getPixel(x, y).setValue(image.getPixel(y, result.getWidth() - x - 1).getValue());
            }
        }
        return result;
    }

    /**
     * Auxillary method for blur.
     * This method computes the average value of the (up to nine) neighbouring pixels
     * of position (i,j) -- including pixel (i,j).
     *
     * @param i   Horizontal index.
     * @param j   Vertical index.
     * @return    Average pixel value.
     */
    private int average(int i, int j) {
        List<Pixel> pixels = this.image.getNeighbours(i, j);
        int sum = 0;
        for (Pixel p : pixels)
            sum += p.getValue();
        return sum / pixels.size();
    }

    /**
     * This method blurs an image.
     * Each pixel (x,y) is mapped to the average value of the neighbouring pixels. 
     * The title of the new image is prefixed 'blur-'.
     *
     * @return   Blurred image.
     */
    public Image blur() {
        Image result = new Image(image.getWidth(), image.getHeight(),
        String.format("blur-%s", this.image.getTitle()), false);
        for (int y = 0; y < result.getHeight(); y++) {
            for (int x = 0; x < result.getWidth(); x++) {
                result.getPixel(x, y).setValue(average(x, y));
            }
        }
        return result;
    }
   
    /**
     * This method adds noise to an image.
     * The value of pixel (i,j) is set to a random value in the interval
     * [v-amount, v+amount], where v is the old value and amount the parameter.
     * The title of the new image is prefixed 'noiseX-'.
     *
     * @param amount   Maximal amount of noise to add.
     * @return  Noisy image. 
     */
    public Image noise(int amount) {
        Image result = new Image(image.getWidth(), image.getHeight(),
        String.format("noise-%s", this.image.getTitle()), false);
        Random random = new Random();
        for (int y = 0; y < result.getHeight(); y++) {
            for (int x = 0; x < result.getWidth(); x++) {
                result.getPixel(x, y).setValue(image.getPixel(x, y).getValue() + random.nextInt(amount + 1));
            }
        }
        return result;
    }

    /**
     * This method resizes an image by some factor.
     * The size of the new image becomes with*factor x hiehgt*factor, where
     * width and heigt are the width and height of the old image.
     * The value of pixel (i,j) in the new image is set to the value of pixel
     * (i/factor,j/factor) in the old image, where factor is the parameter.
     * This produces a new image of size (width*factor, height*factor).
     * The title of the new image is prefixed 'factorX-'.
     *
     * @param factor   Resize factor.
     * @return   Resized image.
     */
    public Image resize(double factor) {
        Image result = new Image((int) (image.getWidth() * factor), (int) (image.getHeight() * factor),
        String.format("resize-%s", this.image.getTitle()), false);
        Random random = new Random();
        for (int y = 0; y < result.getHeight(); y++) {
            for (int x = 0; x < result.getWidth(); x++) {
                result.getPixel(x, y).setValue(
                    image.getPixel((int) (x / factor), (int) (y / factor)).getValue());
            }
        }
        return result;
    }
    
    /**
     * This method rotates an image 90 degrees anti-clockwise.
     * The value of pixel (i,j) in the new image is set to the value of pixel
     * ???????? in the old image, where width is the width of the new image.
     * The title of the new image is prefixed 'rotateAC-'.
     *
     * @return   Rotated image.
     */
    public Image rotateAC() {
        Image result = new Image(image.getHeight(), image.getWidth(),
        String.format("rotate-%s", this.image.getTitle()), false);
        for (int y = 0; y < result.getHeight(); y++) {
            for (int x = 0; x < result.getWidth(); x++) {
                result.getPixel(x, y).setValue(image.getPixel(y, x).getValue());
            }
        }
        return result;
    }
    
    /**
     * This image increases the contrast of an image by some amount.
     * 
     * @param amount    The amount by which to increase contrast
     */
    public Image increaseContrast(double amount) {
        Image result = new Image(image.getHeight(), image.getWidth(),
        String.format("contrast-%s", this.image.getTitle()), false);
        for (int y = 0; y < result.getHeight(); y++) {
            for (int x = 0; x < result.getWidth(); x++) {
                result.getPixel(x, y).setValue(image.getPixel(y, x).getValue());
            }
        }
        return result;
    }
}
