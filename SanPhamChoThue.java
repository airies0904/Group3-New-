package TH_LTHDT_CK;

public abstract class SanPhamChoThue implements IBaoTri {
	protected String maSP;
	protected String tenSP;
	protected double giaThue;
	protected int soLuong;
	protected String trangThai;
	
	public SanPhamChoThue() {}
	public SanPhamChoThue(String maSP, String tenSP, double giaThue, int soLuong, String trangThai) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaThue = giaThue;
		this.soLuong = soLuong;
		this.trangThai = trangThai;
	}
	public String GettenSP() {
		return tenSP;
	}
	public void SetmaSP(String maSP) {
		this.maSP = maSP;
	}
	public void SettenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public void SetgiaThue(double giaThue) {
		this.giaThue = giaThue;
	}
	public String getmaSP() {
		return maSP;
	}
	public String gettrangThai() {
		return trangThai;
	}
	public void settrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public double getgiaThue() {
		return giaThue;
	}
	public int GetsoLuong() {
		return soLuong;
	}
	public void SetsoLuong(int soluong) {
		this.soLuong = soLuong - soluong;
	}
	public void SetsoLuongNhap(int soluongnhap) {
		this.soLuong = soluongnhap;
	}
	

	public String toString() {
		return "Ma SP: "+maSP+", Ten SP: "+tenSP+", Gia thue: "+giaThue+", So Luong: "+soLuong+", Trang thai: "+trangThai;
	}
}
