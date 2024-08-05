class Product {
    private String name;         // Name
    private String description;  // Description
    private String code;         // Code
    private float price;         // Price

    public Product(String name, String description, String code, float price) {
        this.name = name;
        this.description = description;
        this.code = code;
        this.price = price;
    }

    public String getName() {
        return name;  // Get name
    }

    public String getDescription() {
        return description;  // Get description
    }

    public String getCode() {
        return code;  // Get code
    }

    public float getPrice() {
        return price;  // Get price
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                '}';
    }
}
