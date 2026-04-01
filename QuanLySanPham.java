package TH_LTHDT_CK;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class QuanLySanPham {
	private Map<String, SanPhamChoThue> DSSanPham;
	private Scanner sc = new Scanner(System.in);
	
	public QuanLySanPham() {
		this.DSSanPham = new HashMap<>();
	}
	public SanPhamChoThue GetSanPham(String ma) {
		return DSSanPham.get(ma);
	}
	public void ThemSanPhamBanDau(SanPhamChoThue sp) {
	    this.DSSanPham.put(sp.getmaSP(), sp);
	}
	
	public void themSanPham() {
		System.out.println("Nhap san pham can them");
		System.out.println("1. Vay cuoi");
		System.out.println("2. Vest");
		System.out.println("3. Phu kien");
		
		int chon;
		while(true) {
			System.out.println("Nhap lua chon: ");
			String choice = sc.nextLine();
			try {
				chon = Integer.parseInt(choice);
				if(chon != 1 && chon != 2 && chon != 3)
					throw new Exception("Chi duoc nhap cac lua chon duoc cho phep!");
				else
					break;
			} catch(NumberFormatException e) {
				System.out.println("Lua chon khong hop le");
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		String ma;
		while(true) {
			System.out.println("Nhap ma san pham: ");
			ma = sc.nextLine();
			if(this.DSSanPham.containsKey(ma))
				System.out.println("Ma san pham da ton tai");
			else
				break;
		}
		System.out.println("Nhap ten san pham: ");
		String ten = sc.nextLine();
		
		double gia;
		while(true) {
			System.out.println("Nhap gia cho thue: ");
			String Gia = sc.nextLine();
			try {
				gia = Double.parseDouble(Gia);
				if(gia <= 0)
					throw new Exception("Gia thue khong duoc nho hon hoac bang 0");
				else
					break;
			} catch(NumberFormatException e) {
				System.out.println("Gia khong hop le");
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		int soLuong;
		while(true) {
			System.out.println("Nhap so luong: ");
			String soluong = sc.nextLine();
			try {
				soLuong = Integer.parseInt(soluong);
				if(soLuong <= 0)
					throw new Exception("So luong khong duoc nho hon hoac bang 0");
				else
					break;
			}catch(NumberFormatException e) {
				System.out.println("So luong khong hop le");
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		String trangthai;
		while(true) {
			System.out.println("Nhap trang thai (Moi / Trong kho / Tot / Hong): ");
			trangthai = sc.nextLine();
			if(!trangthai.equalsIgnoreCase("Trong kho") && !trangthai.equalsIgnoreCase("Moi") && !trangthai.equalsIgnoreCase("Tot") && !trangthai.equalsIgnoreCase("Hong"))
				System.out.println("Trang thai khong hop le");
			else 
				break;
		}
		
		if(chon == 1) {
			String kichco;
			while(true) {
				System.out.println("Nhap kich co vay cuoi: ");
				kichco = sc.nextLine();
				if(!kichco.equalsIgnoreCase("M") && !kichco.equalsIgnoreCase("L") && !kichco.equalsIgnoreCase("S") && !kichco.equalsIgnoreCase("XL") && !kichco.equalsIgnoreCase("2XL"))
					System.out.println("Kich co khong hop le!");
				else
					break;
			}
			System.out.println("Nhap mau sac vay cuoi: ");
			String mau = sc.nextLine();
			System.out.println("Nhap kieu dang vay cuoi: ");
			String kieu = sc.nextLine();
			System.out.println("Nhap chat lieu vay cuoi: ");
			String chatlieu = sc.nextLine();
			SanPhamChoThue sp = new VayCuoi(ma, ten, gia, soLuong, trangthai, kichco, mau, kieu, chatlieu);
			this.DSSanPham.put(ma, sp);
		}
		if(chon == 2) {
			String kichco;
			while(true) {
				System.out.println("Nhap kich co ao vest: ");
				kichco = sc.nextLine();
				if(!kichco.equalsIgnoreCase("M") && !kichco.equalsIgnoreCase("L") && !kichco.equalsIgnoreCase("S") && !kichco.equalsIgnoreCase("XL") && !kichco.equalsIgnoreCase("2XL"))
					System.out.println("Kich co khong hop le!");
				else
					break;
			}
			System.out.println("Nhap mau sac ao vest: ");
			String mau = sc.nextLine();
			System.out.println("Nhap kieu dang ao vest: ");
			String kieu = sc.nextLine();
			System.out.println("Nhap chat lieu ao vest: ");
			String chatlieu = sc.nextLine();
			SanPhamChoThue sp = new Vest(ma, ten, gia, soLuong, trangthai, kichco, mau, kieu, chatlieu);
			this.DSSanPham.put(ma, sp);
		}
		if(chon == 3) {
			System.out.println("Nhap ma phu kien: ");
			String maphukien = sc.nextLine();
			System.out.println("Nhap ten phu kien: ");
			String tenphukien = sc.nextLine();
			SanPhamChoThue sp = new PhuKien(ma, ten, gia, soLuong, trangthai, maphukien, tenphukien);
			this.DSSanPham.put(ma, sp);
		}
		System.out.println("Them san pham hoan tat!");
	}
	
	public void hienThiSanPham() {
		if(this.DSSanPham.isEmpty()) {
			System.out.println("Danh sach trong");
			return;
		}
		else {
			for(SanPhamChoThue sp : this.DSSanPham.values())
				System.out.println(sp);
		}
	}
	
	public void xoaSanPham() {
		if(this.DSSanPham.isEmpty()) {
			System.out.println("Danh sach trong");
			return;
		}
		else {
			boolean found = false;
			System.out.println("Nhap ma san pham can xoa: ");
			String ma = sc.nextLine();
			for(SanPhamChoThue sp : this.DSSanPham.values()) {
				if(sp.getmaSP().equals(ma)) {
					this.DSSanPham.remove(ma);
					System.out.println("Da xoa san pham "+ma);
					found = true;
					break;
				}
			}
			if(!found)
				System.out.println("Khong tim thay san pham "+ma);
		}
	}
	
	public void timSanPham() {
		if(this.DSSanPham.isEmpty()) {
			System.out.println("Danh sach trong");
			return;
		}
		else {
			boolean found = false;
			System.out.println("Nhap ma san pham can tim: ");
			String ma = sc.nextLine();
			for(SanPhamChoThue sp : this.DSSanPham.values()) {
				if(sp.getmaSP().equals(ma)) {
					System.out.println("Tim thay san pham: "+sp.toString());
					found = true;
					break;
				}
			}
			if(!found)
				System.out.println("Khong tim thay san pham "+ma);
		}
	}
	
	public void CapNhapMotThongTinSanPham() {
		if(this.DSSanPham.isEmpty()) {
			System.out.println("Danh sach trong");
			return;
		}
		else {
			System.out.println("Nhap ma san pham can cap nhap: ");
			String ma = sc.nextLine();
			boolean found = false;
			for(SanPhamChoThue sp : this.DSSanPham.values()) {
				if(sp.getmaSP().equalsIgnoreCase(ma)) { 
					System.out.println("1. Cap nhap ten san pham");
					System.out.println("2. Cap nhap gia thue");
					System.out.println("3. Cap nhap so luong");
					System.out.println("4. Cap nhap trang thai");
					if(sp instanceof PhuKien) {
						System.out.println("5. Cap nhap ma phu kien");
						System.out.println("6. Cap nhap ten phu kien");
					}
					else {
						System.out.println("5. Cap nhap kich co");
						System.out.println("6. Cap nhap mau sac");
						System.out.println("7. Cap nhap kieu dang");
						System.out.println("8. Cap nhap chat lieu");
					}
					int chon;
					while(true) {
						System.out.println("Nhap lua chon: ");
						String choice = sc.nextLine();
						try {
								chon = Integer.parseInt(choice);
								if(chon != 1 && chon != 2 && chon != 3 && chon != 4 && chon !=5 && chon != 6 && chon != 7 && chon != 8)
									throw new Exception("Chi nhap cac lua chon duoc cho phep");
								else
									break;
							} catch(NumberFormatException e) {
								System.out.println("Vui long nhap lua chon hop le!");
							} catch(Exception e) {
								System.out.println(e.getMessage());
							}
					}

					if(chon == 1) {
						System.out.println("Nhap moi ten san pham: ");
						String newten = sc.nextLine();
						sp.SettenSP(newten);
						System.out.println("Da cap nhap ten cua san pham "+ma+" thanh "+newten+"");
					}
					if(chon == 2) {
						double newgia;
						while(true) {
							System.out.println("Nhap moi gia thue: ");
							String gia = sc.nextLine();
							try {
								newgia = Double.parseDouble(gia);
								if(newgia <= 0)
									throw new Exception("Gia thue phai lon hon 0");
								else
									break;
							} catch(NumberFormatException e) {
								System.out.println("Vui long nhap gia thue hop le!");
							} catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}
						sp.SetgiaThue(newgia);
						System.out.println("Da cap nhap gia thue cua san pham "+ma+" thanh "+newgia+"");
					}
					if(chon == 3) {
						int newsoluong;
						while(true) {
							System.out.println("Nhap moi so luong: ");
							String soluong = sc.nextLine();
							try {
								newsoluong = Integer.parseInt(soluong);
								if(newsoluong <= 0)
									throw new Exception("So luong khong duoc nho hon hoac bang 0");
								else
									break;
							} catch(NumberFormatException e) {
								System.out.println("Vui long nhap so luong hop le!");
							} catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}
						sp.SetsoLuongNhap(newsoluong);
						System.out.println("Da cap nhap so luong cua san pham "+ma+" thanh "+newsoluong+"");
					}
					if(chon == 4) {
						String newtrangthai;
						while(true) {
							System.out.println("Nhap moi trang thai (Moi / Trong kho / Tot / Hong): ");
							newtrangthai = sc.nextLine();
							if(!newtrangthai.equalsIgnoreCase("Trong kho") && !newtrangthai.equalsIgnoreCase("Moi") && !newtrangthai.equalsIgnoreCase("Tot") && !newtrangthai.equalsIgnoreCase("Hong"))
								System.out.println("Trang thai khong hop le!");
							else
								break;
						}
						sp.settrangThai(newtrangthai);
						System.out.println("Da cap nhap trang thai cua san pham "+ma+" thanh "+newtrangthai+"");
					}
					
					if(sp instanceof PhuKien) {
						if(chon == 5) {
							System.out.println("Nhap moi ma phu kien: ");
							String newmaphukien = sc.nextLine();
							((PhuKien) sp).SetmaPhuKien(newmaphukien);
							System.out.println("Da cap nhap ma phu kien cua phu kien "+ma+" thanh "+newmaphukien+"");
						}
						if(chon == 6) {
							System.out.println("Nhap moi ten phu kien: ");
							String newtenphukien = sc.nextLine();
							((PhuKien) sp).Settenpk(newtenphukien);
							System.out.println("Da cap nhap ten phu kien cua phu kien "+ma+" thanh "+newtenphukien+"");
						}
					}
					if(sp instanceof VayCuoi) {
						if(chon == 5) {
							String newkichco;
							while(true) {
								System.out.println("Nhap kich co vay cuoi: ");
								newkichco = sc.nextLine();
								if(!newkichco.equalsIgnoreCase("M") && !newkichco.equalsIgnoreCase("L") && !newkichco.equalsIgnoreCase("S") && !newkichco.equalsIgnoreCase("XL") && !newkichco.equalsIgnoreCase("2XL"))
									System.out.println("Kich co khong hop le!");
								else
									break;
							}
							((VayCuoi) sp).SetkichCo(newkichco);
							System.out.println("Da cap nhap kich co cua vay cuoi "+ma+" thanh "+newkichco);
						}
						if(chon == 6) {
							System.out.println("Nhap moi mau sac vay cuoi: ");
							String newmausac = sc.nextLine();
							((VayCuoi) sp).SetmauSac(newmausac);
							System.out.println("Da cap nhau mau sac cua vay cuoi "+ma+" thanh "+newmausac);
						}
						if(chon == 7) {
							System.out.println("Nhap moi kieu dang: ");
							String newkieudang = sc.nextLine();
							((VayCuoi) sp).SetkieuDang(newkieudang);
							System.out.println("Da cap nhau kieu dang cua vay cuoi "+ma+" thanh "+newkieudang);
						}
						if(chon == 8) {
							System.out.println("Nhap moi chat lieu vay cuoi: ");
							String newchatlieu = sc.nextLine();
							((VayCuoi) sp).SetchatLieu(newchatlieu);
							System.out.println("Da cap nhau chat lieu cua vay cuoi "+ma+" thanh "+newchatlieu);
						}
					}
					
					if(sp instanceof Vest) {
						if(chon == 5) {
							String newkichco;
							while(true) {
								System.out.println("Nhap moi kich co ao vest: ");
								newkichco = sc.nextLine();
								if(!newkichco.equalsIgnoreCase("M") && !newkichco.equalsIgnoreCase("L") && !newkichco.equalsIgnoreCase("S") && !newkichco.equalsIgnoreCase("XL") && !newkichco.equalsIgnoreCase("2XL"))
									System.out.println("Kich co khong hop le!");
								else
									break;
							}
							((Vest) sp).SetkichCo(newkichco);
							System.out.println("Da cap nhap kich co cua ao vest "+ma+" thanh "+newkichco);
						}
						if(chon == 6) {
							System.out.println("Nhap moi mau sac ao vest: ");
							String newmausac = sc.nextLine();
							((Vest) sp).SetmauSac(newmausac);
							System.out.println("Da cap nhau mau sac cua ao vest "+ma+" thanh "+newmausac);
						}
						if(chon == 7) {
							System.out.println("Nhap moi kieu dang: ");
							String newkieudang = sc.nextLine();
							((Vest) sp).SetkieuDang(newkieudang);
							System.out.println("Da cap nhau kieu dang cua ao vest "+ma+" thanh "+newkieudang);
						}
						if(chon == 8) {
							System.out.println("Nhap moi chat lieu ao vest: ");
							String newchatlieu = sc.nextLine();
							((Vest) sp).SetchatLieu(newchatlieu);
							System.out.println("Da cap nhau chat lieu cua ao vest "+ma+" thanh "+newchatlieu);
						}
					}
					
					System.out.println("Cap nhap hoan tat!");
					found = true;
					break;
				}
			}
			if(!found)
				System.out.println("Khong tim thay dich vu voi ma "+ma+"");
		}
	}
	
	public void CapNhapTatCaThongTinSanPham() {
		if(this.DSSanPham.isEmpty()) {
			System.out.println("Danh sach trong");
			return;
		}
		else {
			System.out.println("Nhap ma san pham can cap nhap: ");
			String ma = sc.nextLine();
			boolean found = false;
			for(SanPhamChoThue sp : this.DSSanPham.values()) {
				if(sp.getmaSP().equalsIgnoreCase(ma)) {
					System.out.println("Nhap moi ten san pham: ");
					String newten = sc.nextLine();
					sp.SettenSP(newten);
					
					double newgia;
					while(true) {
						System.out.println("Nhap moi gia thue: ");
						String gia = sc.nextLine();
						try {
							newgia = Double.parseDouble(gia);
							if(newgia <= 0)
								throw new Exception("Gia thue phai lon hon 0");
							else
								break;
						} catch(NumberFormatException e) {
							System.out.println("Vui long nhap gia thue hop le!");
						} catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					sp.SetgiaThue(newgia);
					
					int newsoluong;
					while(true) {
						System.out.println("Nhap moi so luong: ");
						String soluong = sc.nextLine();
						try {
							newsoluong = Integer.parseInt(soluong);
							if(newsoluong <= 0)
								throw new Exception("So luong khong duoc nho hon hoac bang 0");
							else
								break;
						} catch(NumberFormatException e) {
							System.out.println("Vui long nhap so luong hop le!");
						} catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					sp.SetsoLuongNhap(newsoluong);
					
					String newtrangthai;
					while(true) {
						System.out.println("Nhap moi trang thai (Moi / Trong kho / Tot / Hong): ");
						newtrangthai = sc.nextLine();
						if(!newtrangthai.equalsIgnoreCase("Trong kho") && !newtrangthai.equalsIgnoreCase("Moi") && !newtrangthai.equalsIgnoreCase("Tot") && !newtrangthai.equalsIgnoreCase("Hong"))
							System.out.println("Trang thai khong hop le!");
						else
							break;
					}
					sp.settrangThai(newtrangthai);
					
					if(sp instanceof VayCuoi) {
						String newkichco;
						while(true) {
							System.out.println("Nhap kich co vay cuoi: ");
							newkichco = sc.nextLine();
							if(!newkichco.equalsIgnoreCase("M") && !newkichco.equalsIgnoreCase("L") && !newkichco.equalsIgnoreCase("S") && !newkichco.equalsIgnoreCase("XL") && !newkichco.equalsIgnoreCase("2XL"))
								System.out.println("Kich co khong hop le!");
							else
								break;
						}
						((VayCuoi) sp).SetkichCo(newkichco);
						
						System.out.println("Nhap moi mau sac vay cuoi: ");
						String newmausac = sc.nextLine();
						((VayCuoi) sp).SetmauSac(newmausac);
						System.out.println("Nhap moi kieu dang vay cuoi: ");
						String newkieudang = sc.nextLine();
						((VayCuoi) sp).SetkieuDang(newkieudang);
						System.out.println("Nhap moi chat lieu vay cuoi: ");
						String newchatlieu = sc.nextLine();
						((VayCuoi) sp).SetchatLieu(newchatlieu);
					}
					
					if(sp instanceof Vest) {
						String newkichco;
						while(true) {
							System.out.println("Nhap kich co ao vest: ");
							newkichco = sc.nextLine();
							if(!newkichco.equalsIgnoreCase("M") && !newkichco.equalsIgnoreCase("L") && !newkichco.equalsIgnoreCase("S") && !newkichco.equalsIgnoreCase("XL") && !newkichco.equalsIgnoreCase("2XL"))
								System.out.println("Kich co khong hop le!");
							else
								break;
						}
						((Vest) sp).SetkichCo(newkichco);
						
						System.out.println("Nhap moi mau sac ao vest: ");
						String newmausac = sc.nextLine();
						((Vest) sp).SetmauSac(newmausac);
						System.out.println("Nhap moi kieu dang ao vest: ");
						String newkieudang = sc.nextLine();
						((Vest) sp).SetkieuDang(newkieudang);
						System.out.println("Nhap moi chat lieu ao vest: ");
						String newchatlieu = sc.nextLine();
						((Vest) sp).SetchatLieu(newchatlieu);
					}
					
					if(sp instanceof PhuKien) {
						System.out.println("Nhap moi ma phu kien: ");
						String newmaphukien = sc.nextLine();
						((PhuKien) sp).SetmaPhuKien(newmaphukien);
						System.out.println("Nhap moi ten phu kien: ");
						String newtenphukien = sc.nextLine();
						((PhuKien) sp).Settenpk(newtenphukien);
					}
					System.out.println("Cap nhap hoan tat!");
					found = true;
					break;
				}
			}
			if(!found)
				System.out.println("Khong tim thay dich vu voi ma "+ma+"");
		}
	}
	
	public void BaoTriSanPham() {
		System.out.println("Nhap ma san pham can bao tri: ");
		String ma = sc.nextLine();
		SanPhamChoThue sp = this.DSSanPham.get(ma);
		if(sp != null)
			sp.thucHienBaoTri();
	}
}

