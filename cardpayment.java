import java.util.Scanner;

public class cardpayment extends payment {
    private String sothe;
    private String loaithe;
    private String tenchuthe;
    private String matkhau;
    private double sotiennhan;
    private double sotientl;
    public cardpayment(){
        super();
        this.sothe = "";
        this.loaithe = "";
        this.tenchuthe = "";
        this.matkhau = "";
        this.sotiennhan = 0;
        this.sotientl = 0;
    }

    public cardpayment(double sotientt, String trangthaitt, String sothe, String loaithe, String tenchuthe, String matkhau){
        super(sotientt, "The ngan hang", trangthaitt);
        this.sothe = sothe;
        this.loaithe = loaithe;
        this.tenchuthe = tenchuthe;
        this.matkhau = matkhau;
        this.sotiennhan = sotiennhan;
        this.sotientl = sotiennhan - sotientt;
    }
    public String getSothe(){
        return sothe;
    }
    public void setSothe(String sothe){
        this.sothe = sothe;
    }
    public String getLoaithe(){
        return loaithe;
    }
    public void setLoaithe(String loaithe){
        this.loaithe = loaithe;
    }
    public String getTenchuthe(){
        return tenchuthe;
    }
    public void setTenchuthe(String tenchuthe){
        this.tenchuthe = tenchuthe;
    }
    public String getMatkhau(){
        return matkhau;
    }
    public void setMatkhau(String matkhau){
        this.matkhau = matkhau;
    }
    public double getsotiennhan(){
        return sotiennhan;
    }
    public void setsotiennhan(double sotiennhan){
        this.sotiennhan = sotiennhan;
        this.sotientl = sotiennhan - getSotientt();
    }
    public double getSotientl(){
        return sotientl;
    }
    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        boolean kiemtrasoflag = false;
        do{
            System.out.print("Nhap so the : ");
            this.sothe = sc.nextLine();
            if (kiemtraso.hople(sothe)){
                kiemtrasoflag = true;
                System.out.println("So the hop le, hay tiep tuc");
            } else{
                System.out.println("So the khong hop le, hay nhap lai");
            }
        } while (!kiemtrasoflag);
        System.out.print("Nhap loai the : ");
        this.loaithe = sc.nextLine();
        System.out.print("Nhap ten chu the : ");
        this.tenchuthe = sc.nextLine();
        System.out.print("Nhap mat khau : ");
        this.matkhau = sc.nextLine();
        do{
            System.out.print("Nhap so tien khach hang tra : ");
            this.sotiennhan = sc.nextDouble();
            if (this.sotiennhan < getSotientt()){
                System.out.println("Khong du tien de thanh toan, hay nhap lai");
            }
        } while (this.sotiennhan < getSotientt());
        this.sotientl = this.sotiennhan - getSotientt();
        System.out.println("So tien tra lai : " + this.sotientl);
    }
    @Override
    public String toString(){
        return super.toString() + "\nSo the : " + sothe + "\nLoai the : " + loaithe + "\nTen chu the : " + tenchuthe + "\nMat khau : " + matkhau;
    }
}
