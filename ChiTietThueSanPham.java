package TH_LTHDT_CK;

public class ChiTietThueSanPham {
	private SanPhamChoThue sp;
	private int soLuong;
	private int soNgayThue;
	
	public ChiTietThueSanPham() {}
	
	public ChiTietThueSanPham(SanPhamChoThue sp, int soLuong, int soNgayThue) {
		this.sp = sp;
		this.soLuong = soLuong;
		this.soNgayThue = soNgayThue;
	}
	public SanPhamChoThue GetSP() {
		return this.sp;
	}
	public int GetSoLuong() {
		return soLuong;
	}
	public void SetsoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public void SetsoNgaythue(int soNgayThue) {
		this.soNgayThue = soNgayThue;
	}
	public int getSoLuong() {
	    return this.soLuong;
	}

	public double tinhThanhTien() {
		return sp.getgiaThue() * soLuong * soNgayThue;
	}
}
