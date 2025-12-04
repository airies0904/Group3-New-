package TH_LTHDT_CK;

public class ChiTietDatDichVu {
	private DichVu dv;
	private int soLuongNhanVien;
	private int soNgayThue;
	
	public ChiTietDatDichVu() {}
	public ChiTietDatDichVu(DichVu dv, int soLuongNhanVien, int soNgayThue) {
		this.dv = dv;
		this.soLuongNhanVien = soLuongNhanVien;
		this.soNgayThue = soNgayThue;
	}
	public DichVu GetDichVu() {
		return this.dv;
	}
	public void SetsoNgayThue(int songaythue) {
		this.soNgayThue = songaythue;
	}
	public int GetsoLuongNhanVien() {
		return soLuongNhanVien;
	}
	public void SetsoLuongNhanVien(int soluongnhanvien) {
		this.soLuongNhanVien = soluongnhanvien;
	}
	public int GetsoNgayThue() {
		return soNgayThue;
	}
	
	public double tinhThanhTien() {
		return dv.GetgiaTien() * soLuongNhanVien * soNgayThue;
	}
}
