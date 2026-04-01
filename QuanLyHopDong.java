package TH_LTHDT_CK;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;

public class QuanLyHopDong {
	private Map<String, HopDong> DSHD;
	private Scanner sc;
	private QuanLyKhachHang qlkh;
	private QuanLyNhanVien qlnv;
	private QuanLySanPham qlsp;
	private QuanLyDichVu qldv;
	
	public QuanLyHopDong(QuanLyKhachHang qlkh, QuanLyNhanVien qlnv, QuanLySanPham qlsp, QuanLyDichVu qldv) {
		this.DSHD = new HashMap<>();
		sc = new Scanner(System.in);
		this.qlkh = qlkh;
		this.qlnv = qlnv;
		this.qlsp = qlsp;
		this.qldv = qldv;
	}
	public Map<String, HopDong> GetDSHD(){
		return this.DSHD;
	}
	
	public void ThemHopDongBanDau(HopDong hd) {
	    this.DSHD.put(hd.GetmaHopDong(), hd);
	}
	
	public void ThemHopDong() {
		String mahd;
		while(true) {
			System.out.println("Nhap ma hop dong: ");
			mahd = sc.nextLine();
			if(this.DSHD.containsKey(mahd)) {
				System.out.println("Ma hop dong da ton tai");
			}
			else
				break;
		}
		LocalDate ngaylap = null;
		LocalDate ngayhientai = LocalDate.now();
		while(true) {
			System.out.println("Nhap ngay lap hop dong: ");
			String ngay = sc.nextLine();
			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				ngaylap = LocalDate.parse(ngay, dtf);
				if(ngaylap.isAfter(ngayhientai))
					throw new Exception("Ngay lap phai truoc ngay hien tai: "+ngayhientai);
				else
					break;
			} catch(DateTimeParseException e) {
				System.out.println("Nhap sai dinh dang ngay thang!");
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		LocalDate ngaythue = null;
		while(true) {
			System.out.println("Nhap ngay bat dau thue: ");
			String ngay = sc.nextLine();
			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				ngaythue = LocalDate.parse(ngay, dtf);
				if(ngaythue.isBefore(ngaylap))
					throw new Exception("Ngay bat dau thue phai sau ngay lap!");
				else
					break;
			} catch(DateTimeParseException e) {
				System.out.println("Nhap sai dinh dang ngay thang!");
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		LocalDate ngaytra = null;
		while(true) {
			System.out.println("Nhap ngay tra: ");
			String ngay = sc.nextLine();
			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				ngaytra = LocalDate.parse(ngay, dtf);
				if(ngaytra.isBefore(ngaylap))
					throw new Exception("Ngay tra phai sau ngay lap!");
				else if(ngaytra.isBefore(ngaythue))
					throw new Exception("Ngay tra phai sau ngay thue!");
				else
					break;
			} catch(DateTimeParseException e) {
				System.out.println("Nhap sai dinh dang ngay thang!");
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		long thoiHanHopDong = ChronoUnit.DAYS.between(ngaythue, ngaytra);
		
		String trangthai = null;
		while(true) {
			System.out.println("Nhap trang thai (Moi tao/Cho thanh toan/Da thanh toan): ");
			trangthai = sc.nextLine();
			if(!(trangthai.equalsIgnoreCase("Moi tao") || trangthai.equalsIgnoreCase("Cho thanh toan") || trangthai.equalsIgnoreCase("Da thanh toan"))) 
				System.out.println("Trang thai khong hop le!");
			else
				break;
		}
		
		KhachHang kh = null;
		while(true) {
			System.out.println("Nhap ma khach hang can them vao hop dong: ");
			String makh = sc.nextLine();
			kh = this.qlkh.GetKhachHang(makh);
			if(kh != null) {
				System.out.println("Da them khach hang "+kh.GettenKH()+" vao hop dong "+mahd);
				break;
			}
			else
				System.out.println("Khong tim thay khach hang voi ma "+makh);
		}
		
		List<ChiTietThueSanPham> cttspTam = new ArrayList<>();
		List<ChiTietDatDichVu> ctddvTam = new ArrayList<>();
		List<NhanVien> nvTam = new ArrayList<>();
		
		while(true) {
			String chon;
			while(true) {
				System.out.println("Ban co muon them san pham thue khong (y/n): ");
				chon = sc.nextLine();
				if(!chon.equalsIgnoreCase("y") && !chon.equalsIgnoreCase("n"))
					System.out.println("Vui long nhap lua chon hop le!");
				else
					break;
			}
			if(chon.equalsIgnoreCase("n"))
				break;
			System.out.println("Nhap ma san pham: ");
			String ma = sc.nextLine();
			SanPhamChoThue sp = qlsp.GetSanPham(ma);
			int soLuong;
			int soNgayThue;
			if(sp != null) {
				while(true) {
					System.out.println("Nhap so luong thue: ");
					String soluong = sc.nextLine();
					try {
						soLuong = Integer.parseInt(soluong);
						if(soLuong < 1)
							throw new Exception("So luong phai lon hon hoac bang 1");
						if(soLuong > sp.GetsoLuong())
							throw new Exception("So luong thue phai nho hon ton kho");
						else
							break;
					} catch(NumberFormatException e) {
						System.out.println("So luong khong hop le!");
					} catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				while(true) {
					System.out.println("Nhap so ngay thue: ");
					String songaythue = sc.nextLine();
					try {
						soNgayThue = Integer.parseInt(songaythue);
						if(soNgayThue > thoiHanHopDong)
							throw new Exception("So ngay thue san pham phai nho hon thoi han hop dong!");
						if(soNgayThue < 1)
							throw new Exception("So ngay thue san pham phai lon hoac bang 1!");
						else
							break;
					} catch(NumberFormatException e) {
						System.out.println("So ngay thue san pham khong hop le!");
					} catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
				sp.settrangThai("Cho thue");
				sp.SetsoLuong(soLuong);
				ChiTietThueSanPham cttsp = new ChiTietThueSanPham(sp, soLuong, soNgayThue);
				cttspTam.add(cttsp);
				System.out.println("Them san pham thue hoan tat!");
			}
			else
				System.out.println("Khong tim thay san pham co ma "+ma);
		}
		
		while(true) {
			String chon;
			while(true) {
				System.out.println("Ban co muon them dich vu thue khong (y/n): ");
				chon = sc.nextLine();
				if(!chon.equalsIgnoreCase("y") && !chon.equalsIgnoreCase("n"))
					System.out.println("Vui long nhap lua chon hop le!");
				else
					break;
			}
			if(chon.equalsIgnoreCase("n"))
				break;
			System.out.println("Nhap ma dich vu thue: ");
			String ma = sc.nextLine();
			DichVu dv = qldv.GetDichVu(ma);
			int soLuongNhanVien;
			int soNgayThue;
			if(dv != null) {
				while(true) {
					System.out.println("Nhap so luong nhan vien thue cua Ekip: ");
					String soluong = sc.nextLine();
					try {
						soLuongNhanVien = Integer.parseInt(soluong);
						if(soLuongNhanVien < 1)
							throw new Exception("So luong nhan vien thue phai lon hon 0!");
						if(dv instanceof DichVuChupAnh)	{
							int maxNV = ((DichVuChupAnh) dv).GetsoLuongNhanVien();
                            if(soLuongNhanVien > maxNV)
								throw new Exception("So luong nhan vien thue phai nho hon so luong hien co!");
						}
						if(dv instanceof DichVuTrangDiem) {
							int maxNV = ((DichVuTrangDiem) dv).GetsoLuongNhanVien();
                            if(soLuongNhanVien > maxNV)
								throw new Exception("So luong nhan vien thue phai nho hon so luong hien co!");
						}
						if(dv instanceof DichVuTrangTri) {
							int maxNV = ((DichVuTrangTri) dv).GetsoLuongNhanVien();
                            if(soLuongNhanVien > maxNV)
								throw new Exception("So luong nhan vien thue phai nho hon so luong hien co!");
						}
						break;
					} catch(NumberFormatException e){
						System.out.println("Nhap so luong nhan vien thue hop le!");
					} catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
				while(true) {
					System.out.println("Nhap so ngay thue: ");
					String songay = sc.nextLine();
					try {
						soNgayThue = Integer.parseInt(songay);
						if(soNgayThue < 1)
							throw new Exception("So ngay thue phai lon hon hoac bang 1!");
						if(soNgayThue > 30) 
							throw new Exception("So ngay thue phai duoi 30 ngay!");
						if(soNgayThue > thoiHanHopDong)
							throw new Exception("So ngay thue san pham phai nho hon thoi han hop dong!");
						else
							break;
					} catch(NumberFormatException e) {
						System.out.println("Nhap so ngay hop le!");
					} catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
				ChiTietDatDichVu ctddv = new ChiTietDatDichVu(dv, soLuongNhanVien, soNgayThue);
				ctddvTam.add(ctddv);
				System.out.println("Them dich vu hoan tat!");
			}
			else
				System.out.println("Khong tim thay san pham co ma "+ma);
		}
		
		while(true) {
			String chon;
			System.out.println("Nhap ma nhan vien lap hop dong: ");
			String ma = sc.nextLine();
			NhanVien nv = qlnv.GetNhanVien(ma);
			if(nv != null) {
				nvTam.add(nv);
				System.out.println("Them nhan vien hoan tat!");
			}
			else
				System.out.println("Khong tim thay nhan vien co ma "+ma);
			
			while(true) {
				System.out.println("Tiep tuc them nhan vien lap hop dong khong (y/n): ");
				chon = sc.nextLine();
				if(!chon.equalsIgnoreCase("y") && !chon.equalsIgnoreCase("n"))
					System.out.println("Vui long nhap lua chon hop le!");
				else
					break;
			}
			if(chon.equalsIgnoreCase("n"))
				break;
		}
		System.out.println("Lap hop dong thanh cong!");
		HopDong hd = new HopDong(mahd, kh, nvTam, cttspTam, ctddvTam, ngaylap, ngaythue, ngaytra, trangthai);
		this.DSHD.put(mahd, hd);
	}
	
	public void HienThiHopDong() {
		if(this.DSHD.isEmpty()) {
			System.out.println("Danh sach hop dong trong");
			return;
		}
		else {
			System.out.println("===== DANH SACH HOP DONG =====");
			for(HopDong hd : this.DSHD.values()) 
				System.out.println(hd);
		}
	}
	
	public void XoaHopDong() {
		if(this.DSHD.isEmpty()) {
			System.out.println("Danh sach hop dong trong");
			return;
		}
		else {
			System.out.println("===== DANH SACH HOP DONG =====");
			for(HopDong hd : this.DSHD.values()) 
				System.out.println(hd);
			System.out.println("Nhap ma hop dong can xoa: ");
			String ma = sc.nextLine();
			if(DSHD.containsKey(ma)) {
				HopDong hd = this.DSHD.get(ma);
				List<ChiTietThueSanPham> listSP = hd.getChiTietSanPham();
				if(listSP != null) {
					for (ChiTietThueSanPham ct : listSP) {
						SanPhamChoThue sp = ct.GetSP();
						sp.settrangThai("Trong kho");
						sp.SetsoLuong(-ct.getSoLuong());
					}
				}
				this.DSHD.remove(ma);
				System.out.println("Da xoa hop dong "+ma);
				}
			}
	}
	
	public void TimHopDong() {
		if(this.DSHD.isEmpty()) {
			System.out.println("Danh sach hop dong trong");
			return;
		}
		else {
			System.out.println("Nhap ma hop dong can tim: ");
			String ma = sc.nextLine();
			boolean found = false;
			for(HopDong hd : this.DSHD.values()) {
				if(hd.GetmaHopDong().equalsIgnoreCase(ma)) {
					System.out.println("Tim thay hop dong");
					System.out.println(hd);
					found = true;
					break;
				}
			}
			if(!found)
				System.out.println("Khong tim thay hop dong co ma "+ma);
		}
	}
	
	public void CapNhapMotThongTinHopDong() {
		if(this.DSHD.isEmpty()) {
			System.out.println("Danh sach hop dong trong");
			return;
		}
		else {
			System.out.println("Nhap ma hop dong can cap nhap: ");
			String ma = sc.nextLine();
			boolean found = false;
			for(HopDong hd : this.DSHD.values()) {
				if(hd.GetmaHopDong().equalsIgnoreCase(ma)) {
					System.out.println("1. Cap nhap ngay lap");
					System.out.println("2. Cap nhap ngay thue");
					System.out.println("3. Cap nhap ngay tra");
					System.out.println("4. Cap nhap trang thai");
					System.out.println("5. Cap nhap nhan vien phu trach hop dong");
					System.out.println("6. Cap nhap san pham thue");
					System.out.println("7. Cap nhap dich vu thue");
					int chon;
					while(true) {
						System.out.println("Nhap lua chon: ");
						String choice = sc.nextLine();
						try {
							chon = Integer.parseInt(choice);
							if(chon != 1 && chon != 2 && chon != 3 && chon != 4 && chon !=5 && chon != 6 && chon !=7)
								throw new Exception("Chi duoc chon cac lua chon cho phep");
							else
								break;
						} catch(NumberFormatException e) {
							System.out.println("Lua chon khong hop le!");
						} catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					
					LocalDate newngaylap = null;
					LocalDate newngaythue = null;
					LocalDate newngaytra = null;
					String newtrangthai = null;

					switch(chon) {
					case 1:{
						LocalDate ngayhientai = LocalDate.now();
						while(true) {
							System.out.println("Nhap moi ngay lap hop dong: ");
							String ngay = sc.nextLine();
							try {
								DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								newngaylap = LocalDate.parse(ngay, dtf);
								if(newngaylap.isAfter(ngayhientai))
									throw new Exception("Ngay lap phai truoc ngay hien tai: "+ngayhientai);
								else
									break;
							} catch(DateTimeParseException e) {
								System.out.println("Nhap sai dinh dang ngay thang!");
							} catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}
						hd.SetngayLap(newngaylap);
						System.out.println("Da cap nhap ngay lap cua hop dong "+ma+" thanh "+newngaylap);
						break;
					}
					
					case 2:{
						while(true) {
							System.out.println("Nhap moi ngay bat dau thue: ");
							String ngay = sc.nextLine();
							try {
								DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								newngaythue = LocalDate.parse(ngay, dtf);
								if(newngaythue.isBefore(hd.GetngayLap()))
									throw new Exception("Ngay bat dau thue phai sau ngay lap!");
								else
									break;
							} catch(DateTimeParseException e) {
								System.out.println("Nhap sai dinh dang ngay thang!");
							} catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}
						hd.SetngayThue(newngaythue);
						break;
					}
					
					case 3:{
						while(true) {
							System.out.println("Nhap moi ngay tra: ");
							String ngay = sc.nextLine();
							try {
								DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								newngaytra = LocalDate.parse(ngay, dtf);
								if(newngaytra.isBefore(hd.GetngayLap()))
									throw new Exception("Ngay tra phai sau ngay lap!");
								else if(newngaytra.isBefore(hd.GetngayThue()))
									throw new Exception("Ngay tra phai sau ngay thue!");
								else
									break;
							} catch(DateTimeParseException e) {
								System.out.println("Nhap sai dinh dang ngay thang!");
							} catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}
						hd.SetngayTra(newngaytra);
						System.out.println("Da cap nhap ngay tra cua hop dong "+ma+" thanh "+newngaytra);
						break;
					}
					
					case 4:{
						while(true) {
							System.out.println("Nhap moi trang thai (Moi tao/Cho thanh toan/Da thanh toan): ");
							newtrangthai = sc.nextLine();
							if(!(newtrangthai.equalsIgnoreCase("Moi tao") && newtrangthai.equalsIgnoreCase("Cho thanh toan") && newtrangthai.equalsIgnoreCase("Da thanh toan"))) 
								System.out.println("Trang thai khong hop le!");
							else
								break;
						}
						hd.SettrangThai(newtrangthai);
						System.out.println("Da cap nhap trang thai cua hop dong "+ma+" thanh "+newtrangthai);
						break;
					}
					
					case 5:{
						System.out.println("Nhap ma nhan vien cu phu trach hop dong: ");
						String macu = sc.nextLine();
						System.out.println("Nhap ma nhan vien thay the: ");
						String mamoi = sc.nextLine();
						NhanVien nvmoi = qlnv.GetNhanVien(mamoi);
						if(nvmoi == null) {
							System.out.println("Loi: Nhan vien moi co ma "+mamoi+" khong ton tai trong cong ty");
					        return;
						}
						boolean kq = hd.CapNhapMotNhanVienPhuTrach(macu, nvmoi);
						if(kq)
							System.out.println("Cap nhat nhan su thanh cong!");
						else
							System.out.println("Cap nhat khong thanh cong");
						break;
					}
					
					case 6:{
						System.out.println("Nhap ma san pham thue can cap nhap: ");
						String masp = sc.nextLine();
						int soluongmoi;
						while(true) {
							System.out.println("Nhap moi so luong: ");
							String sl = sc.nextLine();
							try {
								soluongmoi = Integer.parseInt(sl);
								if(soluongmoi <= 0)
									System.out.println("So luong san pham thue phai lon hon 0");
								else
									break;
							} catch(NumberFormatException e) {
								System.out.println("So luong khong hop le");
							} catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}
						int songaythuemoi;
						while(true) {
							System.out.println("Nhap moi so ngay thue: ");
							String songay = sc.nextLine();
							try {
								songaythuemoi = Integer.parseInt(songay);
								break;
							} catch(NumberFormatException e) {
								System.out.println("So ngay thue khong hop le");
							}
						}
						boolean kq = hd.CapNhapMotSanPham(masp, soluongmoi, songaythuemoi);
						if(kq)
							System.out.println("Cap nhat san pham thue thanh cong!");
						else
							System.out.println("Cap nhat khong thanh cong");
						break;
					}
					
					case 7:{
						System.out.println("Nhap ma dich vu can cap nhap: ");
					    String maDV = sc.nextLine();
					    int soLuongNVMoi;
					    while(true) {
					        System.out.println("Nhap so luong nhan vien moi: ");
					        String sl = sc.nextLine();
					        try {
					            soLuongNVMoi = Integer.parseInt(sl);
					            if(soLuongNVMoi <= 0)
					                System.out.println("So luong nhan vien phai lon hon 0");
					            else
					                break;
					        } catch(NumberFormatException e) {
					            System.out.println("So luong khong hop le");
					        }
					    }
					    
					    int soNgayThueMoi;
					    while(true) {
					        System.out.println("Nhap so ngay thue moi: ");
					        String sn = sc.nextLine();
					        try {
					            soNgayThueMoi = Integer.parseInt(sn);
					            if(soNgayThueMoi <= 0)
					                System.out.println("So ngay thue phai lon hon 0");
					            else
					                break;
					        } catch(NumberFormatException e) {
					            System.out.println("So ngay khong hop le");
					        }
					    }
					    
					    boolean kq = hd.CapNhapMotDichVu(maDV, soLuongNVMoi, soNgayThueMoi);
					    if(kq)
					        System.out.println("Cap nhat thong tin dich vu thanh cong!");
					    else
					        System.out.println("Cap nhat that bai!");
					    
					    break;
					}
					}
				}
				found = true;
				break;
			}
			if(!found)
				System.out.println("Khong tim thay hop dong co ma "+ma);
		}
	}
}
