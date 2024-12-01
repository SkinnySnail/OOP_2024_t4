package Product;


public abstract class Product {
    private String  product_id, product_name;
    private int price;
    protected String category;
    private Brand brand;
    public Product() {}
    public Product(String product_id, String product_name, int price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    public String getProduct_id() {
        return this.product_id;
    }
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
    public String getProduct_name() {
        return this.product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
    public abstract void nhap();
    public abstract void xuat();
    @Override
    public String toString() {
        return "Product [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
                + ", category=" + category + "]" + ",brand=" + brand;
    }

}