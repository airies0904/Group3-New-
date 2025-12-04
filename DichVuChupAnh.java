package TH_LTHDT_CK;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DichVuChupAnh extends DichVu {
	private List<NhanVien> EkipChupAnh;
	private String diaDiem;
	private int soLuongAnh;
	private Scanner sc = new Scanner(System.in);;
	
	public DichVuChupAnh() {}
	public DichVuChupAnh(String maDV, String tenDV, double giaTien, String diaDiem, int soLuongAnh) {
		super(maDV, tenDV, giaTien);
		this.EkipChupAnh = new ArrayList<>();
		this.diaDiem = diaDiem;
		this.soLuongAnh = soLuongAnh;
	}
	public void themNhanVienVaoEkip(NhanVien nv) {
	    this.EkipChupAnh.add(nv);
	}
	public int GetsoLuongNhanVien() {
		return this.EkipChupAnh.size();
	}
	public void SetdiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}
	public void SetsoLuongAnh(int soLuongAnh) {
		this.soLuongAnh = soLuongAnh;
	}
	
	@Override
	public void PhanCong(List<NhanVien> dsnv) {
		System.out.println("Danh sach nhan vien chup anh");
		for(NhanVien nv : dsnv) 
			if(nv.GetChucVu().equalsIgnoreCase("Chup anh"))
				System.out.println(nv);
		System.out.println("Nhap ma nhan vien de phan cong chup anh (0 de ket thuc): ");
		while(true) {
			String ma = sc.nextLine();
			if(ma.equals("0"))
				break;
			boolean found = false;
			NhanVien nvDuocChon = null;
			for(NhanVien nv : dsnv) {
				if(nv.GetmaNV().equalsIgnoreCase(ma)) {
					nvDuocChon = nv;
					if(!nvDuocChon.GetChucVu().equalsIgnoreCase("Chup anh")) {
	                    System.out.println("Loi: Nhan vien nay khong phai tho chup anh!");
	                }
					else{
						this.EkipChupAnh.add(nvDuocChon);
						System.out.println("Da phan cong nhan vien: "+nvDuocChon.GetmaNV());
						found = true;
					}
					break;
				}
			}
			if(!found)
				System.out.println("Ma nhan vien khong hop le, hay nhap lai");
		}
		System.out.println("Tong so nhan vien chup anh duoc phan cong: "+EkipChupAnh.size());
			
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Ekip chup anh: "+EkipChupAnh+", Dia diem: "+diaDiem+", So luong anh: "+soLuongAnh;
	}
	
	
}
