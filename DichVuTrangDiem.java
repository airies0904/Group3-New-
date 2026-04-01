package TH_LTHDT_CK;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DichVuTrangDiem extends DichVu {
	private String phongCach;
	private List<NhanVien> EkipTrangDiem;
	private Scanner sc = new Scanner(System.in);;
	
	public DichVuTrangDiem() {}
	public DichVuTrangDiem(String maDV, String tenDV, double giaTien, String phongCach) {
		super(maDV, tenDV, giaTien);
		this.phongCach = phongCach;
		this.EkipTrangDiem = new ArrayList<>();
	}
	public void SetphongCach(String phongCach) {
		this.phongCach = phongCach;
	}
	public int GetsoLuongNhanVien() {
		return this.EkipTrangDiem.size();
	}
	public void themNhanVienVaoEkip(NhanVien nv) {
	    this.EkipTrangDiem.add(nv);
	}
	
	@Override
	public void PhanCong(List<NhanVien> dsnv) {
		System.out.println("Danh sach nhan vien trang diem");
		for(NhanVien nv : dsnv) 
			if(nv.GetChucVu().equalsIgnoreCase("Trang diem"))
				System.out.println(nv);
		System.out.println("Nhap ma nhan vien de phan cong trang diem (0 de ket thuc): ");
		while(true) {
			String ma = sc.nextLine();
			if(ma.equals("0"))
				break;
			boolean found = false;
			NhanVien nvDuocChon = null;
			for(NhanVien nv : dsnv)
				if(nv.GetmaNV().equalsIgnoreCase(ma)) {
					nvDuocChon = nv;
					if(!nvDuocChon.GetChucVu().equalsIgnoreCase("Trang diem")) {
	                    System.out.println("Loi: Nhan vien nay khong phai nhan vien trang diem!");
	                }
					else{
						this.EkipTrangDiem.add(nvDuocChon);
						System.out.println("Da phan cong nhan vien: "+nvDuocChon.GetmaNV());
						found = true;
						break;
					}
				}
			if(!found)
				System.out.println("Ma nhan vien khong hop le, hay nhap lai");
		}
		System.out.println("Tong so nhan vien trang diem duoc phan cong: "+EkipTrangDiem.size());
			
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Ekip trang diem: "+EkipTrangDiem+", Phong cach: "+phongCach;
	}
		
}
