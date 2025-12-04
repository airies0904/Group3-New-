package TH_LTHDT_CK;

import java.util.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HopDong {
	private String maHopDong;
	private LocalDate ngayLap;
	private LocalDate ngayThue;
	private LocalDate ngayTra;
	private double tongTien = 0;
	private String trangThai;
	private KhachHang khachhang;
	private List<NhanVien> nhanvien;
	private List<ChiTietThueSanPham> cttsp;
	private List<ChiTietDatDichVu> ctddv;
	
	public HopDong() {}
	public HopDong(String maHopDong, KhachHang khachhang, List<NhanVien> nhanvien, List<ChiTietThueSanPham> cttsp, List<ChiTietDatDichVu> ctddv, LocalDate ngayLap, LocalDate ngayThue, LocalDate ngayTra, String trangThai) {
		this.maHopDong = maHopDong;
		this.khachhang = khachhang;
		this.ngayLap = ngayLap;
		this.ngayThue = ngayThue;
		this.ngayTra = ngayTra;
		this.tongTien = tinhTongTien();
		this.trangThai = trangThai;
		this.nhanvien = nhanvien;
		this.cttsp = cttsp;
		this.ctddv = ctddv;
	}
	public void SetkhachHang(KhachHang kh) {
		this.khachhang = kh;
	}
	public KhachHang GetkhachHang() {
	    return this.khachhang;
	}
	public void SetmaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}
	public String GetmaHopDong() {
		return maHopDong;
	}
	public void SetngayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}
	public LocalDate GetngayLap() {
		return ngayLap;
	}
	public void SetngayThue(LocalDate ngayThue) {
		this.ngayThue = ngayThue;
	}
	public LocalDate GetngayThue() {
		return ngayThue;
	}
	public void SetngayTra(LocalDate ngayTra) {
		this.ngayTra = ngayTra;
	}
	public LocalDate GetngayTra() {
		return ngayTra;
	}
	public void SettongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public double GettongTien() {
		return tinhTongTien();
	}
	public void SettrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String GettrangThai() {
		return trangThai;
	}
	public List<ChiTietThueSanPham> getChiTietSanPham() {
	    return this.cttsp;
	}
	
	public double tinhTongTien() {
		this.tongTien = 0;
		if(cttsp != null)
			for(ChiTietThueSanPham ct : cttsp)
				tongTien += ct.tinhThanhTien();
		if(ctddv != null)
			for(ChiTietDatDichVu ct : ctddv)
				tongTien += ct.tinhThanhTien();
		return tongTien;
	}
	
	public boolean CapNhapMotNhanVienPhuTrach(String maNVcu, NhanVien nhanvienmoi) {
		for(NhanVien nv : this.nhanvien) {
			if(nv.GetmaNV().equalsIgnoreCase(nhanvienmoi.GetmaNV())) {
				System.out.println("Loi: Nhan vien moi "+ nhanvienmoi.GetmaNV()+" da co trong hop dong nay roi!");
				return false;
			}
		}
		for(int i = 0; i < this.nhanvien.size(); i++) {
			NhanVien nhanvienhientai = this.nhanvien.get(i);
			if(nhanvienhientai.GetmaNV().equalsIgnoreCase(maNVcu)) {
				this.nhanvien.set(i, nhanvienmoi);
				System.out.println("Da thay the NV "+maNVcu+" bang NV "+nhanvienmoi.GetmaNV());
				return true;
			}
		}
		System.out.println("Khong tim thay nhan vien co ma "+maNVcu);
		return false;
	}
	
	public boolean CapNhapMotSanPham(String maSP, int soLuongMoi, int soNgayThueMoi) {
		ChiTietThueSanPham chiTietSPCanDoi = null;
		for(ChiTietThueSanPham ct : this.cttsp) {
			if(ct.GetSP().getmaSP().equalsIgnoreCase(maSP)) {
				chiTietSPCanDoi = ct;
				break;
			}
		}
		
		if(chiTietSPCanDoi == null) {
			System.out.println("Khong tim thay san pham "+maSP+" trong hop dong nay!");
			return false;
		}
		SanPhamChoThue sp = chiTietSPCanDoi.GetSP();
		int soLuongCu = chiTietSPCanDoi.GetSoLuong();
		sp.SetsoLuong(-soLuongCu);
		
		long thoiHanHDLong = ChronoUnit.DAYS.between(this.ngayThue, this.ngayTra);
	    int thoiHanHD = (int) thoiHanHDLong;
	    if(thoiHanHD <= 0) 
	    	thoiHanHD = 1;

	    if (soNgayThueMoi <= 0) {
	        System.out.println("Loi: So ngay thue phai lon hon 0");
	        return false;
	    }
	    if (soNgayThueMoi > thoiHanHD) {
	        System.out.println("Loi: So ngay thue "+ soNgayThueMoi +" khong duoc vuot qua thoi han hop dong "+ thoiHanHD+" ngay!");
	        return false;
	    }
		if(soLuongMoi <= sp.GetsoLuong()) {
			sp.SetsoLuong(soLuongMoi);
			chiTietSPCanDoi.SetsoLuong(soLuongMoi);
			chiTietSPCanDoi.SetsoNgaythue(soNgayThueMoi);
			this.tinhTongTien();
			System.out.println("Cap nhat san pham thanh cong!");
			return true;
		}
		else {
			System.out.println("So luong thue phai nho hon ton kho");
			sp.SetsoLuong(soLuongCu);
			return false;
		}
	}
	
	public boolean CapNhapMotDichVu(String maDV, int soLuongNVMoi, int soNgayThueMoi) {
	    ChiTietDatDichVu chiTietDVCanDoi = null;
	    for(ChiTietDatDichVu ct : this.ctddv) {
	        if(ct.GetDichVu().GetmaDV().equalsIgnoreCase(maDV)) {
	        	chiTietDVCanDoi = ct;
	            break;
	        }
	    }
	    if(chiTietDVCanDoi == null) {
	        System.out.println("Khong tim thay dich vu "+maDV+" trong hop dong nay!");
	        return false;
	    }
	    long thoiHanHDLong = ChronoUnit.DAYS.between(this.ngayThue, this.ngayTra);
	    int thoiHanHD = (int) thoiHanHDLong;
	    if(thoiHanHD <= 0) 
	    	thoiHanHD = 1;
	    
	    if (soNgayThueMoi <= 0) {
	        System.out.println("So ngay thue phai lon hon 0");
	        return false;
	    }
	    if (soNgayThueMoi > thoiHanHD) {
	        System.out.println("So ngay thue khong duoc vuot qua thoi han hop dong (" + thoiHanHD + " ngay)!");
	        return false;
	    }

	    DichVu dv = chiTietDVCanDoi.GetDichVu();
	    int maxNhanVien = 0;
	    if (dv instanceof DichVuChupAnh) {
	        maxNhanVien = ((DichVuChupAnh) dv).GetsoLuongNhanVien(); 
	    } else if (dv instanceof DichVuTrangDiem) {
	        maxNhanVien = ((DichVuTrangDiem) dv).GetsoLuongNhanVien();
	    } else if (dv instanceof DichVuTrangTri) {
	        maxNhanVien = ((DichVuTrangTri) dv).GetsoLuongNhanVien();
	    }

	    if (soLuongNVMoi <= 0) {
	        System.out.println("So luong nhân vien phai > 0");
	        return false;
	    }
	    
	    if (soLuongNVMoi > maxNhanVien) {
	        System.out.println("So luong nhan vien yeu cau vuot qua so luong Ekip hien co "+ maxNhanVien+"");
	        return false;
	    }

	    chiTietDVCanDoi.SetsoLuongNhanVien(soLuongNVMoi);
	    chiTietDVCanDoi.SetsoNgayThue(soNgayThueMoi);
	    this.tinhTongTien();
	    System.out.println("Cap nhat dich vu thanh cong!");
	    return true;
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    
	    sb.append("==================================================\n");
	    sb.append(String.format("| MA HD: %-15s | TRANG THAI: %s\n", maHopDong, trangThai));
	    sb.append("--------------------------------------------------\n");
	    
	    String tenKH = (khachhang != null) ? khachhang.GettenKH() : "Chua cap nhat";
	    sb.append("Khach hang: ").append(tenKH).append("\n");
	    sb.append("Ngay lap:   ").append(ngayLap).append("\n");
	    sb.append("Thoi gian:  Tu ").append(ngayThue).append(" den ").append(ngayTra).append("\n");
	    
	    sb.append("--------------------------------------------------\n");
	    sb.append("NHAN VIEN PHU TRACH:\n");
	    if (nhanvien != null && !nhanvien.isEmpty()) {
	        for (NhanVien nv : nhanvien) {
	            sb.append(" - ").append(nv.GetTenNV())
	              .append(" (").append(nv.GetChucVu()).append(")\n");
	        }
	    } else {
	        sb.append(" (Chua co nhan vien)\n");
	    }

	    sb.append("--------------------------------------------------\n");
	    sb.append("CHI TIET SAN PHAM:\n");
	    if (cttsp != null && !cttsp.isEmpty()) {
	        for (ChiTietThueSanPham ct : cttsp) {
	            sb.append(String.format(" + %-25s | SL: %-3d | %12s VND\n", 
	                    ct.GetSP().GettenSP(), 
	                    ct.getSoLuong(), 
	                    String.format("%,.0f", ct.tinhThanhTien())));
	        }
	    } else {
	        sb.append(" (Khong thue san pham)\n");
	    }

	    sb.append("--------------------------------------------------\n");
	    sb.append("CHI TIET DICH VU:\n");
	    if (ctddv != null && !ctddv.isEmpty()) {
	        for (ChiTietDatDichVu ct : ctddv) {
	            sb.append(String.format(" + %-25s | NV: %-3d | %12s VND\n", 
	                    ct.GetDichVu().GettenDV(), 
	                    ct.GetsoLuongNhanVien(), 
	                    String.format("%,.0f", ct.tinhThanhTien())));
	        }
	    } else {
	        sb.append(" (Khong dat dich vu)\n");
	    }

	    sb.append("--------------------------------------------------\n");
	    sb.append(String.format("TONG TIEN HOP DONG: %25s VND\n", String.format("%,.0f", this.tinhTongTien())));
	    sb.append("==================================================");

	    return sb.toString();
	}
}
