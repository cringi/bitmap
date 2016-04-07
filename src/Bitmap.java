public class Bitmap {
    private String[][] images = new String[10][10];

    public Bitmap(int[] points) {
        reset(images);
        // security checks??

        // let's make sure that they put in an even amount of number
        if (!(points.length % 2 == 0)) {
            // we're not good fam
            System.out.println("Points aren't even :(");
            return;
        }

        // let's make sure every number is 0-9
        for (int point : points) {
            if (point > 9) {
                // we're not good fam
                System.out.println("There's a point with a value over 9 :(");
                return;
            }
        }

        // we didn't die yet, i guess the list is good ?  ( ͡° ͜ʖ ͡° )

        for (int x = 1; x < points.length; x = x + 2) {
            System.out.printf("Coordinate! (%d,%d)%n", points[x], points[x - 1]);
            images[points[x - 1]][points[x]] = "*";
        }

    }

    private void reset(String[][] list) {
        // fills a 2d array full of dashes
        for (int x = 0; x < list.length; x++) {
            for (int y = 0; y < list[0].length; y++) {
                list[x][y] = "-";
            }
        }
    }

    private void updateImage(String[][] picture) {
        reset(images); // reset the original picture

        for (int x = 0; x < picture.length; x++) {
            for (int y = 0; y < picture[0].length; y++) {
                if (picture[x][y].equals("*")) { // if the new picture has a star, we want it too.
                    images[x][y] = "*";
                }
            }
        }
    }

    public String toString() {
        String picture = "";
        for (int x = 0; x < images.length; x++) {
            for (int y = 0; y < images[0].length; y++) {
                picture = picture + images[x][y];
            }
            picture = picture + "\n";
        }

        return picture;
    }

    public void flipHorizontal() {
        String[][] newImage = new String[10][10];
        reset(newImage);

        for (int x = 0; x < images.length; x++) {
            for (int y = 0; y < images.length; y++) {
                if (images[x][y].equals("*")) {
                    newImage[x][9 + (y * -1)] = "*"; // since i've passed math a few times i'm (hoping) this will work
                }
            }
        }

        updateImage(newImage);
    }

    public void flipVertical() {
        String[][] newImage = new String[10][10];
        reset(newImage);

        for (int x = 0; x < images.length; x++) {
            for (int y = 0; y < images.length; y++) {
                if (images[x][y].equals("*")) {
                    newImage[9 + (x * -1)][y] = "*"; // since i've passed math a few times i'm (hoping) this will work
                }
            }
        }

        updateImage(newImage);
    }

    public void reverse() {
        String[][] newImage = new String[10][10];
        reset(newImage);

        for (int x = 0; x < images.length; x++) {
            for (int y = 0; y < images.length; y++) {
                if (images[x][y].equals("-")) { // if there wasn't a star here in the first place we're putting one in now
                    newImage[x][y] = "*"; // since i've passed math a few times i'm (hoping) this will work
                }
            }
        }

        updateImage(newImage);
    }
}
