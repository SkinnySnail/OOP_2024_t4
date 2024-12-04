package Product;

import java.util.Scanner;

import Main.KiemTra;

public class Paper_product extends Product {
    private String ptype;
    KiemTra kt = new KiemTra();
    Scanner sc = new Scanner(System.in);
    public Paper_product() {
        this.category = "Paper_product";
    }

    public Paper_product(String product_id, String product_name, int price) {
        super(product_id, product_name, price);
    }

    public Paper_product(String maSP, String tenSP, int donGia,int num, String type) {
        super(maSP, tenSP, donGia,num);
        this.category = "Paper_product";
        this.ptype = type;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    @Override
    public void nhap() {
        System.out.print("Nhap vao ma san pham: ");
        String maSP = kt.kiemtraMaSanpham();
        setProduct_id(maSP); 
        System.out.print("Nhap vao ten san pham: ");
        String tenSP = kt.nhapChuoi();
        setProduct_name(tenSP);
        System.out.print("Nhap vao gia cua san pham: ");
        int gia = kt.KiemTraNhapSoNguyen();
        setPrice(gia);
        System.out.print("Nhap vao so luong cua san pham: ");
        int sl = kt.KiemTraNhapSoTuNhien();
        setItemnum(sl);
        System.out.print("Nhap vao loai cua giay: ");
        this.ptype = kt.nhapChuoi();

    }


    public void xuat(){
        System.out.printf("%-25s%-25s%-21s%-26d%-13d%-26s\n", this.category , getProduct_id() , getProduct_name() , getPrice(),getItemnum(),getPtype());
    }
    @Override
    public String toString() {
        return category + "," + itemnum + "," + getProduct_id()
        + "," + getItemnum() + "," + getProduct_name()
        + "," + getPrice() + "," + getPtype();
    }
}
