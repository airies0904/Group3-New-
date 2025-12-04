package TH_LTHDT_CK;

import java.time.LocalDate;

public class KhachHang{
	private String maKH;
	private String tenKH;
	private String diaChi;
	private LocalDate ngaySinh;
	private String SDT;
	private String Email;
	
	public KhachHang() {}
	public KhachHang(String maKH, String tenKH, String diaChi, LocalDate ngaySinh, String SDT, String Email) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.SDT = SDT;
		this.Email = Email;
	}
	
	public String GetmaKH() {
		return maKH;
	}
	public void SetmaKH(String maKH) {
		this.maKH = maKH;
	}
	public String GettenKH() {
		return tenKH;
	}
	public void SettenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String GetdiaChi() {
		return diaChi;
	}
	public void SetdiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public LocalDate GetngaySinh() {
		return ngaySinh;
	}
	public void SetngaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String GetSDT() {
		return SDT;
	}
	public void SetSDT(String SDT) {
		this.SDT = SDT;
	}
	public String GetEmail() {
		return Email;
	}
	public void SetEmail(String Email) {
		this.Email = Email;
	}
	public String toString() {
		return "Ma KH: "+maKH+", Ten KH: "+tenKH+", Dia chi KH: "+diaChi+", Ngay sinh: "+ngaySinh+", SDT: "+SDT+", Email: "+Email;
	}
}
