package Product;


public abstract class SanPham {
    private String  product_id, product_name;
    private int price;
    protected String category;
    
    public SanPham() {}
    public SanPham(String product_id, String product_name, int price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
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
        return "SanPham [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
                + ", category=" + category + "]";
    }

}