public class Cat extends Animals {
    private String furColor;

    public Cat(String name, int age, String furColor) {
        super(name, age);
        setFurColor(furColor);
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        if (furColor == null || furColor.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Màu lông không được để trống"
            );
        }

        this.furColor = furColor.trim();
    }

    @Override
    public String makeSound() {
        return "Meow Meow";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Màu lông: " + furColor);
    }
}
