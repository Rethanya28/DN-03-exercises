public class SimpleBuilderPattern {

    // Laptop class
    public static class Laptop {
        private String processor;
        private String memory;
        private String storage;
        private String graphicsCard;

        private Laptop(String processor, String memory, String storage, String graphicsCard) {
            this.processor = processor;
            this.memory = memory;
            this.storage = storage;
            this.graphicsCard = graphicsCard;
        }

        @Override
        public String toString() {
            return "Laptop [Processor=" + processor + ", Memory=" + memory + ", Storage=" + storage + 
                   ", GraphicsCard=" + graphicsCard + "]";
        }
    }

    // Builder class
    public static class LaptopBuilder {
        private String processor;
        private String memory;
        private String storage;
        private String graphicsCard;

        public LaptopBuilder withProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public LaptopBuilder withMemory(String memory) {
            this.memory = memory;
            return this;
        }

        public LaptopBuilder withStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public LaptopBuilder withGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Laptop build() {
            return new Laptop(processor, memory, storage, graphicsCard);
        }
    }

    // Testing the simplified Builder pattern
    public static void main(String[] args) {
        Laptop gamingLaptop = new LaptopBuilder()
                .withProcessor("Intel i9")
                .withMemory("32GB")
                .withStorage("1TB SSD")
                .withGraphicsCard("NVIDIA RTX 3080")
                .build();

        Laptop officeLaptop = new LaptopBuilder()
                .withProcessor("Intel i5")
                .withMemory("16GB")
                .withStorage("512GB SSD")
                .build();

        System.out.println("Gaming Laptop: " + gamingLaptop);
        System.out.println("Office Laptop: " + officeLaptop);
    }
}
