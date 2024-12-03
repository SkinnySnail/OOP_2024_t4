package Product;


public abstract class Product {
    private String  product_id, product_name;
    private int price;
    protected String category;
    public int itemnum;
    
    public Product() {}
    public Product(String product_id, String product_name, int price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
    }

    public Product(String product_id, String product_name, int price, int itemnum) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.itemnum = itemnum;
    }
    public Product(String product_id, String product_name, int price, String category, int itemnum) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.category = category;
        this.itemnum = itemnum;
    }
    public String getProduct_id() {
        return this.product_id;
    }
    public int getItemnum() {
        return itemnum;
    }
    public void setItemnum(int itemnum) {
        this.itemnum = itemnum;
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
    

}