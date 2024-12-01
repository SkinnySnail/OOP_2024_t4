import java.util.Scanner;
class cardpayment extends payment{
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
    public cardpayment(double sotientt, String trangthaitt, String sothe, String loaithe, String tenchuthe, String matkhau, double sotiennhan){
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
    public double getSotiennhan(){
        return sotiennhan;
    }
    public void setSotiennhan(double sotiennhan){
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
        while (true){
            System.out.print("Nhap so the : ");
            String nhapSothe = sc.nextLine();
            if (ktsothe.matches("\\d+")){
                this.sothe = ktsothe;
                break;
            } else{
                System.out.println("So the khong co chu hay ky tu dac biet, hay nhap lai");
            }
        }
        
        System.out.print("Nhap loai the : ");
        this.loaithe = sc.nextLine();
        
        System.out.print("Nhap ten chu the : ");
        this.tenchuthe = sc.nextLine();
        
        System.out.print("Nhap mat khau : ");
        this.matkhau = sc.nextLine();
        
        do{
            System.out.print("Nhap so tien khach tra : ");
            this.sotiennhan = sc.nextDouble();
            if (this.sotiennhan < getSotientt()){
                System.out.println("Khong du tien de thanh toan, hay nhap lai");
            }
        } while (this.sotiennhan < getSotientt());
        
        this.sotientl = this.sotiennhan - getSotientt();
    }

    @Override
    public String toString(){
        return super.toString() + 
               "\nSo the : " + sothe + 
               "\nLoai the : " + loaithe + 
               "\nTen chu the : " + tenchuthe + 
               "\nMat khau : " + matkhau + 
               "\nSo tien khach tra : " + sotiennhan + 
               "\nTien tra lai : " + sotientl;
    }
}