package TH_LTHDT_CK;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private String SDT;
	private String chucVu;
	private double luongCoBan;
	
	public NhanVien() {}
	public NhanVien(String maNV, String tenNV, String SDT, String chucVu, double luongCoBan) {
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.SDT = SDT;
		this.chucVu = chucVu;
		this.luongCoBan = luongCoBan;
	}
	public String GetmaNV() {
		return maNV;
	}
	public void SetmaNV(String maNV) {
		this.maNV = maNV;
	}
	public String GetTenNV() {
        return tenNV;
    }

    public void SetTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String GetSDT() {
        return SDT;
    }

    public void SetSDT(String SDT) {
        this.SDT = SDT;
    }

    public String GetChucVu() {
        return chucVu;
    }

    public void SetChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public double GetLuongCoBan() {
        return luongCoBan;
    }

    public void SetLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
    
    public String toString() {
    	return "Ma NV: "+maNV+", Ten NV: "+tenNV+", SDT: "+SDT+", Chuc vu: "+chucVu+", Luong co ban: "+luongCoBan;
    }

}