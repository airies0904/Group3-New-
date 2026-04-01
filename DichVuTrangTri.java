package TH_LTHDT_CK;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DichVuTrangTri extends DichVu {
	private String Concept;
	private String diaDiem;
	private List<NhanVien> EkipTrangTri;
	private Scanner sc = new Scanner(System.in);
	
	public DichVuTrangTri() {}
	public DichVuTrangTri(String maDV, String tenDV, double giaTien, String Concept, String diaDiem) {
		super(maDV, tenDV, giaTien);
		this.Concept = Concept;
		this.diaDiem = diaDiem;
		this.EkipTrangTri = new ArrayList<>();
	}
	public void SetConcept(String Concept) {
		this.Concept = Concept;
	}
	public void SetdiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}
	public int GetsoLuongNhanVien() {
		return this.EkipTrangTri.size();
	}
	public void themNhanVienVaoEkip(NhanVien nv) {
	    this.EkipTrangTri.add(nv);
	}
	
	@Override
	public void PhanCong(List<NhanVien> dsnv) {
		System.out.println("Danh sach nhan vien trang tri");
		for(NhanVien nv : dsnv) 
			if(nv.GetChucVu().equalsIgnoreCase("Trang tri"))
				System.out.println(nv);
		System.out.println("Nhap ma nhan vien de phan cong trang tri (0 de ket thuc): ");
		while(true) {
			String ma = sc.nextLine();
			if(ma.equals("0"))
				break;
			boolean found = false;
			NhanVien nvDuocChon = null;
			for(NhanVien nv : dsnv)
				if(nv.GetmaNV().equalsIgnoreCase(ma)) {
					nvDuocChon = nv;
					if(!nvDuocChon.GetChucVu().equalsIgnoreCase("Trang tri")) {
	                    System.out.println("Loi: Nhan vien nay khong phai nhan vien trang tri!");
	                }
					else{
						this.EkipTrangTri.add(nvDuocChon);
						System.out.println("Da phan cong nhan vien: "+nvDuocChon.GetmaNV());
						found = true;
						break;
					}
				}
			if(!found)
				System.out.println("Ma nhan vien khong hop le, hay nhap lai");
		}
		System.out.println("Tong so nhan vien trang diem tri phan cong: "+EkipTrangTri.size());
			
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Ekip trang tri: "+EkipTrangTri+", Concept: "+Concept+", DiaDiem: "+diaDiem;
	}
}
