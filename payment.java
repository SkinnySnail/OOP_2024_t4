import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class payment {
    private double sotientt;
    private String phuongthuctt;
    private String trangthaitt;

    public payment() {
        this.sotientt = 0;
        this.phuongthuctt = "";
        this.trangthaitt = "";
    }

    public payment(double sotientt, String phuongthuctt, String trangthaitt) {
        this.sotientt = sotientt;
        this.phuongthuctt = phuongthuctt;
        this.trangthaitt = trangthaitt;
    }

    public double getSotientt() {
        return sotientt;
    }

    public void setSotientt(double sotientt) {
        this.sotientt = sotientt;
    }

    public String getPhuongthuctt() {
        return phuongthuctt;
    }

    public void setPhuongthuctt(String phuongthuctt) {
        this.phuongthuctt = phuongthuctt;
    }

    public String getTrangthaitt() {
        return trangthaitt;
    }

    public void setTrangthaitt(String trangthaitt) {
        this.trangthaitt = trangthaitt;
    }
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tien thanh toan : ");
        this.sotientt = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhap trang thai thanh toan : ");
        this.trangthaitt = sc.nextLine();
        if (this.trangthaitt.isEmpty()) {
            this.trangthaitt = "pending";
        }
    }

    public String toString() {
        return "Phuong thuc thanh toan : " + phuongthuctt + "\nSo tien thanh toan : " + sotientt + "\nTrang thai thanh toan : " + trangthaitt;
    }

    public static void ghifile(ArrayList<payment> hoadon, boolean append) {
        try (BufferedWriter ghi = new BufferedWriter(new FileWriter("incart.txt", append))) {
            if (!append) {
                ghi.write("");
            }
            else {
                for (int i = 0; i < hoadon.size(); i++) {
                    ghi.write(hoadon.get(i).toString());
                    ghi.newLine();
                }
                System.out.println("Da ghi vao file");
            }
        } 
        catch (Exception e) {
            System.out.println("Loi khong ghi duoc vao tep: " + e.getMessage());
        }
    }    

    public static void docFile(String tenfile) {
        try (BufferedReader doc = new BufferedReader(new FileReader(tenfile))) {
            System.out.println("Da doc file");
        }
        catch (Exception e) {
            System.out.println("Loi khi doc file : ");
        }
    }
}

class cashPayment extends payment {
    private String tenthungan;
    private double sotiennhan;
    private double sotientl;

    public cashPayment() {
        super();
        this.tenthungan = "";
        this.sotiennhan = 0;
        this.sotientl = 0;
    }

    public cashPayment(double sotientt, String trangthaitt, String tenthungan, double sotiennhan) {
        super(sotientt, "Tien mat", trangthaitt);
        this.tenthungan = tenthungan;
        this.sotiennhan = sotiennhan;
        this.sotientl = sotiennhan - sotientt;
    }

    public String getTenthungan() {
        return tenthungan;
    }

    public void setTenthungan(String tenthungan) {
        this.tenthungan = tenthungan;
    }

    public double getSotiennhan() {
        return sotiennhan;
    }

    public void setSotiennhan(double sotiennhan) {
        this.sotiennhan = sotiennhan;
        this.sotientl = sotiennhan - getSotientt();
    }

    public double getSotientl() {
        return sotientl;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten thu ngan : ");
        this.tenthungan = sc.nextLine();
        do {
            System.out.print("Nhap so tien khach tra : ");
            this.sotiennhan = sc.nextDouble();
            if (this.sotiennhan < getSotientt()) {
                System.out.println("Khong du tien de thanh toan, hay nhap lai");
            }
        } while (this.sotiennhan < getSotientt());
        this.sotientl = this.sotiennhan - getSotientt();
    }

    @Override
    public String toString() {
        return super.toString() + "\nTen thu ngan : " + tenthungan + "\nSo tien khach tra : " + sotiennhan + "\nTien tra lai : " + sotientl;
    }
}

class creditCardPayment extends payment {
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

class Main {
    public static void main(String[] args) {
        ArrayList<payment> hoadon = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int z;
        while (true) {
            System.out.println("---------------MENU----------------");
            System.out.println("Chon phuong thuc thanh toan:");
            System.out.println("1.Thanh toan bang tien mat");
            System.out.println("2.Thanh toan bang the ngan hang");
            System.out.println("3.Xem cac hoa don thanh toan");
            System.out.println("4.Xoa cac hoa don da duoc luu");
            System.out.println("5.Thoat");
            System.out.println("-----------------------------------");
            System.out.print("Nhap lua chon : ");
            z = sc.nextInt();
            sc.nextLine();
            if (z == 1) {
                cashPayment tienmat = new cashPayment();
                tienmat.setPhuongthuctt("Tien mat");
                tienmat.nhap();
                hoadon.add(tienmat);
                payment.ghifile(hoadon, true);
                payment.docFile("incart.txt");
                System.out.println("Thanh toan bang tien mat da duoc them");
            } else if (z == 2) {
                creditCardPayment thenh = new creditCardPayment();
                thenh.setPhuongthuctt("The ngan hang");
                thenh.nhap();
                hoadon.add(thenh);
                payment.ghifile(hoadon, true);
                payment.docFile("incart.txt");
                System.out.println("Thanh toan bang the da duoc them");
            } else if (z == 3) {
                System.out.println("Danh sach hoa don : ");
                for (int i = 0; i < hoadon.size(); i++) {
                    payment pay = hoadon.get(i);
                    System.out.println(pay.toString());
                }
            } else if (z == 4) {
                hoadon.clear();
                payment.ghifile(hoadon, false);
                System.out.println("Da xoa tat ca hoa don");
            } else if (z == 5) {
                System.out.println("Thoat");
                break;
            } else {
                System.out.println("Lua chon khong hop le, hay chon lai");
            }
        }
    }
}