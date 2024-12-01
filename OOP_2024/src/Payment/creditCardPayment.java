package Payment;

import java.util.Scanner;

public class creditCardPayment extends payment{
private String sothe;
    private String loaithe;
    private String tenchuthe;
    private String matkhau;

    public creditCardPayment() {
        super();
        this.sothe = "";
        this.loaithe = "";
        this.tenchuthe = "";
        this.matkhau = "";
    }

    public creditCardPayment(double sotientt, String trangthaitt, String sothe, String loaithe, String tenchuthe, String matkhau) {
        super(sotientt, "The ngan hang", trangthaitt);
        this.sothe = sothe;
        this.loaithe = loaithe;
        this.tenchuthe = tenchuthe;
        this.matkhau = matkhau;
    }

    public String getSothe() {
        return sothe;
    }

    public void setSothe(String sothe) {
        this.sothe = sothe;
    }

    public String getLoaithe() {
        return loaithe;
    }

    public void setLoaithe(String loaithe) {
        this.loaithe = loaithe;
    }

    public String getTenchuthe() {
        return tenchuthe;
    }

    public void setTenchuthe(String tenchuthe) {
        this.tenchuthe = tenchuthe;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so the : ");
        this.sothe = sc.nextLine();
        System.out.print("Nhap loai the : ");
        this.loaithe = sc.nextLine();
        System.out.print("Nhap ten chu the : ");
        this.tenchuthe = sc.nextLine();
        System.out.print("Nhap mat khau : ");
        this.matkhau = sc.nextLine();
    }

    @Override
    public String toString() {
        return super.toString() + "\nSo the : " + sothe + "\nLoai the : " + loaithe + "\nTen chu the : " + tenchuthe + "\nMat khau : " + matkhau;
    }
}
