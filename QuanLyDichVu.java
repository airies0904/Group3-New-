package TH_LTHDT_CK;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class QuanLyDichVu {
	private Map<String, DichVu> DSDichVu;
	private Scanner sc = new Scanner(System.in);
	private QuanLyNhanVien qlnv;
	
	public QuanLyDichVu(QuanLyNhanVien qlnv) {
		this.DSDichVu = new HashMap<>();
		this.qlnv = qlnv;
	}
	public DichVu GetDichVu(String ma) {
		return DSDichVu.get(ma);
	}
	public void ThemDichVuBanDau(DichVu dv) {
	    this.DSDichVu.put(dv.GetmaDV(), dv);
	}
	
	public void ThemDichVu() {
		String ma;
		while(true) {
			System.out.println("Nhap ma dich vu: ");
			ma = sc.nextLine();
			if(this.DSDichVu.containsKey(ma)) {
				System.out.println("Ma dich vu da ton tai");
			}
			else
				break;
		}
		System.out.println("Nhap ten dich vu: ");
		String ten = sc.nextLine();
		double tien;
		while(true) {
			System.out.println("Nhap gia tien: ");
			String gia = sc.nextLine();
			try {
				tien = Double.parseDouble(gia);
				if(tien <= 0)
					throw new Exception("Gia tien phai lon hon 0");
				else
					break;
			}catch(NumberFormatException e) {
				System.out.println("vui long nhap gia tien hop le!");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Nhap 1: Them dich vu chup anh \nNhap 2: Them dich vu trang diem \nNhap 3: Them dich vu trang tri");
		int luachon;
		while(true) {
			System.out.println("Lua chon: ");
			String chon = sc.nextLine();
			try {
				luachon = Integer.parseInt(chon);
				if(luachon != 1 && luachon != 2 && luachon !=3)
					throw new Exception("Chi duoc chon lua chon duoc cho phep");
				else
					break;
			} catch(NumberFormatException e) {
				System.out.println("Vui long nhap lua chon hop le!");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		DichVu dv = null;
		
		if(luachon == 1) {
			System.out.println("Nhap dia diem: ");
			String diadiem = sc.nextLine();
			int soluong;
			while(true) {
				System.out.println("Nhap so luong anh: ");
				String soluonganh = sc.nextLine();
				try {
					soluong = Integer.parseInt(soluonganh);
					if(soluong <= 0)
						throw new Exception("So luong anh phai lon hon 0");
					else
						break;
				} catch(NumberFormatException e) {
					System.out.println("Vui long nhap so luong anh hop le!");
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			dv = new DichVuChupAnh(ma, ten, tien, diadiem, soluong);
			this.DSDichVu.put(ma, dv);
		}
		if(luachon == 2) {
			System.out.println("Nhap phong cach: ");
			String phongcach = sc.nextLine();
			dv = new DichVuTrangDiem(ma, ten, tien, phongcach);
			this.DSDichVu.put(ma, dv);
		}
		if(luachon == 3) {
			System.out.println("Nhap Concept: ");
			String concept = sc.nextLine();
			System.out.println("Nhap dia diem: ");
			String diadiem = sc.nextLine();
			dv = new DichVuTrangTri(ma, ten, tien, concept, diadiem);
			this.DSDichVu.put(ma, dv);
		}
		
		if (dv != null) {
	        System.out.println("Ban co muon thiet lap Ekip nhan vien cho dich vu nay ngay khong? (y/n): ");
	        String confirm = sc.nextLine();
	        if (confirm.equalsIgnoreCase("y")) {
	            List<NhanVien> listNV = this.qlnv.getDanhSachNhanVienList();
	            dv.PhanCong(listNV);
	        }
		}
	}
	
	public void HienThiDichVu() {
		if(this.DSDichVu.isEmpty()) {
			System.out.println("Danh sach dich vu trong");
			return;
		}
		else {
			System.out.println("===== DANH SACH DICH VU =====");
			for(DichVu dv : this.DSDichVu.values())
				System.out.println(dv);
		}
	}
	
	public void XoaDichVu() {
		if(this.DSDichVu.isEmpty()) {
			System.out.println("Danh sach dich vu trong");
			return;
		}
		else {
			System.out.println("===== DANH SACH DICH VU =====");
			for(DichVu dv : this.DSDichVu.values())
				System.out.println(dv);
			System.out.println("Nhap ma dich vu can xoa: ");
			String ma = sc.nextLine();
			boolean found = false;
			for(DichVu dv : this.DSDichVu.values())
				if(dv.GetmaDV().equalsIgnoreCase(ma)) {
					this.DSDichVu.remove(ma);
					System.out.println("Da xoa dich vu "+ma+"");
					found = true;
					break;
				}
			if(!found)
				System.out.println("Khong tim thay dich vu co ma "+ma+"");
		}
	}
	
	public void TimDichVu() {
		if(this.DSDichVu.isEmpty()) {
			System.out.println("Danh sach dich vu trong");
			return;
		}
		else {
			boolean found = false;
			System.out.println("Nhap ma dich vu can tim: ");
			String ma = sc.nextLine();
			for(DichVu dv : this.DSDichVu.values())
				if(dv.GetmaDV().equalsIgnoreCase(ma)) {
					System.out.println("Tim thay dich vu co ma "+ma+"");
					System.out.println(dv);
					found = true;
				}
			if(!found)
				System.out.println("Khong tim thay dich vu co ma "+ma+"");
		}
	}
	
	public void CapNhapMotThongTinDichVu() {
		if(this.DSDichVu.isEmpty()) {
			System.out.println("Danh sach dich vu trong");
			return;
		}
		else {
			System.out.println("Nhap ma dich vu can cap nhap: ");
			String ma = sc.nextLine();
			boolean found = false;
			for(DichVu dv : this.DSDichVu.values()) {
				if(dv.GetmaDV().equalsIgnoreCase(ma)) { 
					System.out.println("1. Cap nhap ten dich vu");
					System.out.println("2. Cap nhap gia tien");
					if(dv instanceof DichVuChupAnh) {
						System.out.println("3. Cap nhap dia diem");
						System.out.println("4. Cap nhap so luong anh");
					}
					else if(dv instanceof DichVuTrangDiem)
						System.out.println("3. Cap nhap phong cach");
					else if(dv instanceof DichVuTrangTri) {
						System.out.println("3. Cap nhap Concept");
						System.out.println("4. Cap nhap dia diem");
					}
					int chon;
					while(true) {
						System.out.println("Nhap lua chon: ");
						String choice = sc.nextLine();
						try {
								chon = Integer.parseInt(choice);
								if(chon != 1 && chon != 2 && chon != 3 && chon != 4)
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
						System.out.println("Nhap ten dich vu moi: ");
						String ten = sc.nextLine();
						dv.SettenDV(ten);
						System.out.println("Da cap nhap ten cua dich vu "+ma+" thanh "+ten+"");
					}
					if(chon == 2) {
						double newgia;
						while(true) {
							System.out.println("Nhap gia tien moi: ");
							String gia = sc.nextLine();
							try {
								newgia = Double.parseDouble(gia);
								if(newgia <= 0)
									throw new Exception("Gia tien phai lon hon 0");
								else
									break;
							} catch(NumberFormatException e) {
								System.out.println("Vui long nhap gia tien hop le!");
							} catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}
						dv.SetgiaTien(newgia);
						System.out.println("Da cap nhap gia tien cua dich vu "+ma+" thanh "+newgia+"");
					}
					if(dv instanceof DichVuChupAnh) {
						if(chon == 3) {
							System.out.println("Nhap dia diem moi: ");
							String newdiadiem = sc.nextLine();
							((DichVuChupAnh) dv).SetdiaDiem(newdiadiem);
							System.out.println("Da cap nhap dia diem cua dich vu "+ma+" thanh "+newdiadiem+"");
						}
						else if(chon == 4) {
							int newsoluong;
							while(true) {
								System.out.println("Nhap so luong moi: ");
								String soluong = sc.nextLine();
								try {
									newsoluong = Integer.parseInt(soluong);
									if(newsoluong <= 0)
										throw new Exception("So luong anh khong duoc nho hon hoac bang 0");
									else
										break;
								} catch(NumberFormatException e) {
									System.out.println("Vui long nhap so luong anh hop le!");
								} catch(Exception e) {
									System.out.println(e.getMessage());
								}
							}
							((DichVuChupAnh) dv).SetsoLuongAnh(newsoluong);
							System.out.println("Da cap nhap so luong anh cua dich vu "+ma+" thanh "+newsoluong+"");
						}
					}
					else if(dv instanceof DichVuTrangDiem) {
						if(chon == 3) {
							System.out.println("Nhap phong cach moi: ");
							String newphongcach = sc.nextLine();
							((DichVuTrangDiem) dv).SetphongCach(newphongcach);
							System.out.println("Da cap nhap phong cach cua dich vu "+ma+" thanh "+newphongcach+"");
						}
					}
					else if(dv instanceof DichVuTrangTri) {
						if(chon == 3) {
							System.out.println("Nhap Concept moi: ");
							String newconcept = sc.nextLine();
							((DichVuTrangTri) dv).SetConcept(newconcept);
							System.out.println("Da cap nhap Concept cua dich vu "+ma+" thanh "+newconcept+"");
						}
						else if(chon == 4) {
							System.out.println("Nhap dia diem moi: ");
							String newdiadiem = sc.nextLine();
							((DichVuTrangTri) dv).SetdiaDiem(newdiadiem);
							System.out.println("Da cap nhap dia diem cua dich vu "+ma+" thanh "+newdiadiem+"");
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
	public void CapNhapTatCaThongTinDichVu() {
		if(this.DSDichVu.isEmpty()) {
			System.out.println("Danh sach dich vu trong");
			return;
		}
		else {
			System.out.println("Nhap ma dich vu can cap nhap: ");
			String ma = sc.nextLine();
			boolean found = false;
			for(DichVu dv : this.DSDichVu.values()) {
				if(dv.GetmaDV().equalsIgnoreCase(ma)) {
					System.out.println("Nhap ten dich vu moi: ");
					String ten = sc.nextLine();
					dv.SettenDV(ten);
					double newgia;
					while(true) {
						System.out.println("Nhap gia tien moi: ");
						String gia = sc.nextLine();
						try {
							newgia = Double.parseDouble(gia);
							if(newgia <= 0)
								throw new Exception("Gia tien phai lon hon 0");
							else
								break;
						} catch(NumberFormatException e) {
							System.out.println("Vui long nhap gia tien hop le!");
						} catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					dv.SetgiaTien(newgia);
					if(dv instanceof DichVuChupAnh) {
						System.out.println("Nhap dia diem moi: ");
						String newdiadiem = sc.nextLine();
						((DichVuChupAnh) dv).SetdiaDiem(newdiadiem);
						int newsoluong;
						while(true) {
							System.out.println("Nhap so luong moi: ");
							String soluong = sc.nextLine();
							try {
								newsoluong = Integer.parseInt(soluong);
								if(newsoluong <= 0)
									throw new Exception("So luong anh khong duoc nho hon hoac bang 0");
								else
									break;
							} catch(NumberFormatException e) {
								System.out.println("Vui long nhap so luong anh hop le!");
							} catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}
						((DichVuChupAnh) dv).SetsoLuongAnh(newsoluong);
					}
					else if(dv instanceof DichVuTrangDiem) {
						System.out.println("Nhap phong cach moi: ");
						String newphongcach = sc.nextLine();
						((DichVuTrangDiem) dv).SetphongCach(newphongcach);
					}
					else if(dv instanceof DichVuTrangTri) {
						System.out.println("Nhap Concept moi: ");
						String newconcept = sc.nextLine();
						((DichVuTrangTri) dv).SetConcept(newconcept);
						System.out.println("Nhap dia diem moi: ");
						String newdiadiem = sc.nextLine();
						((DichVuTrangTri) dv).SetdiaDiem(newdiadiem);
					}
					found = true;
					System.out.println("Cap nhap thong tin dich vu hoan tat!");
					break;
				}
			}
			if(!found)
				System.out.println("Khong tim thay dich vu "+ma+"");
		}
	}
}

