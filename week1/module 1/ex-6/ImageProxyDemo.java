public class ImageProxyDemo {

    // Interface for displaying images
    public interface Picture {
        void show();
    }

    // Actual image class that handles loading and displaying
    public static class ActualPicture implements Picture {
        private String file;

        public ActualPicture(String file) {
            this.file = file;
            loadFromStorage();
        }

        private void loadFromStorage() {
            System.out.println("Loading " + file);
        }

        @Override
        public void show() {
            System.out.println("Showing " + file);
        }
    }

    // Proxy class to control access to the ActualPicture
    public static class PictureProxy implements Picture {
        private ActualPicture actualPicture;
        private String file;

        public PictureProxy(String file) {
            this.file = file;
        }

        @Override
        public void show() {
            if (actualPicture == null) {
                actualPicture = new ActualPicture(file);
            }
            actualPicture.show();
        }
    }

    // Test the simplified Proxy pattern
    public static void main(String[] args) {
        Picture pic1 = new PictureProxy("image1.jpg");
        Picture pic2 = new PictureProxy("image2.jpg");

        // Image will be loaded from storage
        pic1.show();
        System.out.println("");

        // Image will not be loaded from storage
        pic1.show();
        System.out.println("");

        // Image will be loaded from storage
        pic2.show();
        System.out.println("");

        // Image will not be loaded from storage
        pic2.show();
    }
}
