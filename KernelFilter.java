import java.awt.Color;

public class KernelFilter {
    
    private static Picture kernel(Picture picture, double[][] transMatrix) {
        int height = picture.height();
        int width = picture.width();
        int n = transMatrix.length;
        Picture filtered = new Picture(width, height);
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                double r = 0, g = 0, bl = 0;
                int a = i - (n / 2);
                for (int x = 0; x < n; x++) {
                    if (a < 0) {
                        if (Math.abs(a) > height) {
                            int xs = Math.abs(a) % height;
                            a = height - xs - 1;
                        }
                        else a = height + a - 1;
                    }
                    else if (a >= height) a = 0;
                    int b = j - (n / 2);
                    for (int y = 0; y < n; y++) {
                        if (b < 0) {
                            if (Math.abs(a) > height) {
                                int ys = Math.abs(a) % height;
                                b = width - ys - 1;
                            }
                            else b = width + b - 1;
                        }
                        else if (b >= width) b = 0;
                        Color elem = picture.get(b, a);
                        r += elem.getRed() * transMatrix[x][y];
                        g += elem.getGreen() * transMatrix[x][y];
                        bl += elem.getBlue() * transMatrix[x][y];
                        b++;
                    }
                    a++;
                }
                
                if (r < 0) r = 0;
                if (g < 0) g = 0;
                if (bl < 0) bl = 0;
                if (r > 255) r = 255;
                if (g > 255) g = 255;
                if (bl > 255) bl = 255;
                
                r = Math.round(r);
                g = Math.round(g);
                bl = Math.round(bl);
                
                filtered.set(j, i, new Color((int) r, (int) g, (int) bl));
            }
        }
        
        return filtered;
    }
    
    public static Picture gaussian(Picture picture) {
        double[][] weights = {
                {0.0625, 0.125, 0.0625},
                {0.125, 0.25, 0.125},
                {0.0625, 0.125, 0.0625}
        };
        
        return kernel(picture, weights);
    }

    public static Picture sharpen(Picture picture) {
        double[][] weights = {
                {0, -1, 0},
                {-1, 5, -1},
                {0, -1, 0}
        };

        return kernel(picture, weights);
    }

    public static Picture laplacian(Picture picture) {
        double[][] weights = {
                {-1, -1, -1},
                {-1, 8, -1},
                {-1, -1, -1}
        };

        return kernel(picture, weights);
    }

    public static Picture emboss(Picture picture) {
        double[][] weights = {
                {-2, -1, 0},
                {-1, 1, 1},
                {0, 1, 2}
        };

        return kernel(picture, weights);
    }

    public static Picture motionBlur(Picture picture) {
        double[][] weights = {
                {1.0/9, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1.0/9, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1.0/9, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1.0/9, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1.0/9, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1.0/9, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1.0/9, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1.0/9, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1.0/9}
        };

        return kernel(picture, weights);
    }
    
    public static void main(String[] args) {
        Picture baboon = new Picture("C:\\Users\\Anefu Favour\\Documents\\baboon.png");
        Picture c = sharpen(baboon);
        c.show();
        c = emboss(baboon);
        c.show();
        c = laplacian(baboon);
        c.show();
        c = motionBlur(baboon);
        c.show();
        c = gaussian(baboon);
        c.show();
    }
}
