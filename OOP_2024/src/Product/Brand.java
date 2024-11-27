package Product;

import java.util.Scanner;

public class Brand {
    private  String brand_id, brand_name;
    Scanner sc = new Scanner(System.in);

    

    public Brand() {
    }

    public Brand(String brand_id, String brand_name) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }
    public void nhap(){
        System.out.print("Nhap vao ma nha cung cap: ");
        String maNcc = sc.nextLine();
        setBrand_id(maNcc);
        System.out.print("Nhap vao ten nha cung cap: ");
        String tenNcc = sc.nextLine();
        setBrand_name(tenNcc);
    }

    @Override
    public String toString() {
        return "Brand [brand_id=" + brand_id + ", brand_name=" + brand_name + "]";
    }

    public void xuat(){
        System.out.print("Brand [brand_id=" + brand_id + ", brand_name=" + brand_name + "]");
}
}
