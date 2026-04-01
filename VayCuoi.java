package TH_LTHDT_CK;

public class VayCuoi extends SanPhamChoThue {
	private String kichCo;
	private String mauSac;
	private String kieuDang;
	private String chatLieu;
	
	public VayCuoi() {}
	public VayCuoi(String maSP, String tenSP, double giaThue, int soLuong, String trangThai, String kichCo, String mauSac, String kieuDang, String chatLieu) {
		super(maSP, tenSP, giaThue, soLuong, trangThai);
		this.kichCo = kichCo;
		this.mauSac = mauSac;
		this.kieuDang = kieuDang;
		this.chatLieu = chatLieu;
	}
	public void SetkichCo(String kichCo) {
		this.kichCo = kichCo;
	}
	public void SetmauSac(String mauSac) {
		this.mauSac = mauSac;
	}
	public void SetkieuDang(String kieuDang) {
		this.kieuDang = kieuDang;
	}
	public void SetchatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
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
		return super.toString() + ", Kich co: "+kichCo+", Mau sac: "+mauSac+", Kieu dang: "+kieuDang+", Chat lieu: "+chatLieu;
	}
}
