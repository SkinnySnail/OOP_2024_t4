package daoop;


public abstract class SanPham {
    protected String LSP, maSP, tenSP;
    protected int donGia;
    

    public SanPham() {}
    public SanPham(String LSP, String maSP, String tenSP, int donGia){
        this.LSP = LSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
    }
    public SanPham(String maSP, String tenSP, int donGia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
    }

    public String getMaSP() {
        return this.maSP;
    }
    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
    public String getTenSP() {
        return this.tenSP;
    }
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    public String getLSP() {
        return this.LSP;
    }
    public void setLSP(String lSP) {
        this.LSP = lSP;
    }
    public int getDonGia() {
        return this.donGia;
    }
    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    
    public abstract void nhap();
    public abstract void xuat();
    public abstract void tinhNang();

    @Override
    public String toString(){
        return this.LSP+ ", "+ this.maSP+ ", "+ this.tenSP+", "+ donGia;
    }
}