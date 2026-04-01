package TH_LTHDT_CK;

public class PhuKien extends SanPhamChoThue {
	private String maPhuKien;
	private String tenPhuKien;
	
	public PhuKien() {}
	public PhuKien(String maSP, String tenSP, double giaThue, int soLuong, String trangThai, String maPhuKien, String tenPhuKien) {
		super(maSP, tenSP, giaThue, soLuong, trangThai);
		this.maPhuKien = maPhuKien;
		this.tenPhuKien = tenPhuKien;
	}
	public void SetmaPhuKien(String mapk) {
		this.maPhuKien = mapk;
	}
	public void Settenpk(String tenpk) {
		this.tenPhuKien = tenpk;
	}
	
	@Override
	public boolean kiemTraCanBaoTri() {
		return this.trangThai.equalsIgnoreCase("Hong");
	}
	
	@Override
	public void thucHienBaoTri() {
		if(this.kiemTraCanBaoTri()) {
			System.out.println("Dang bao tri san pham: "+tenSP);
			this.settrangThai("Dang bao tri");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
			this.settrangThai("Tot");
			System.out.println("Da bao tri san pham: "+tenSP);
		}
		else
			System.out.println("San pham "+tenSP+" chua can duoc bao tri");
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Ma phu kien: "+maPhuKien+", Ten phu kien: "+tenPhuKien;
	}
}
