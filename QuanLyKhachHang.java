package TH_LTHDT_CK;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class QuanLyKhachHang{
	private Map<String, KhachHang> QLKH;
	private Scanner sc = new Scanner(System.in);
	private QuanLyHopDong ql;
	
	public QuanLyKhachHang(QuanLyHopDong qlhd) {
		this.QLKH = new HashMap<>();
		this.ql = qlhd;
	}
	public KhachHang GetKhachHang(String ma) {
		return QLKH.get(ma);
	}
	public void setQLHD(QuanLyHopDong qlhd) {
	    this.ql = qlhd;
	}
	
	public void ThemKhachHangBanDau(KhachHang kh) {
	    this.QLKH.put(kh.GetmaKH(), kh);
	}
	
	public void ThemKhachHang() {
		LocalDate date = null;
		String ngay = null;
		LocalDate ngayhientai = LocalDate.now();
		String ma;
		while(true) {
			System.out.println("Nhap ma khach hang: ");
			ma = sc.nextLine();
			if(this.QLKH.containsKey(ma)) {
				System.out.println("Ma khach hang da ton tai");
			}
			else
				break;
		}
		System.out.println("Nhap ten khach hang: ");
		String ten = sc.nextLine();
		System.out.println("Nhap dia chi khach hang: ");
		String diachi = sc.nextLine();
		while(true) {
			try {
				System.out.println("Nhap ngay sinh khach hang (dd/MM/yyyy): ");
				ngay = sc.nextLine();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				date = LocalDate.parse(ngay, dtf);
				if(date.isAfter(ngayhientai))
					throw new Exception("Ngay sinh phai nho hon "+ngayhientai);
				else
					break;
			}catch(DateTimeParseException e ) {
				System.out.println("Không thể chuyển đổi chuỗi: " +ngay);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		String sdt = null;
		while(true) {
			try {
				System.out.println("Nhap SDT khach hang :");
				sdt = sc.nextLine();
				if(sdt.length() < 1 || sdt.length() > 15)
					throw new Exception("SDT phai co tu 1 den 15 chu so!");
				if(!sdt.matches("\\d+"))
					throw new Exception("SDT khong duoc chua chu cai hoac ki tu dac biet!");
				break;
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Nhap Email khach hang: ");
		String email = sc.nextLine();
		KhachHang kh = new KhachHang(ma, ten, diachi, date, sdt, email);
		this.QLKH.put(ma, kh);
		System.out.println("Them khach hang thanh cong!");
	}
	
	public void HienThiKhachHang() {
		if(this.QLKH.isEmpty())
			System.out.println("Danh sach khach hang trong");
		else {
			System.out.println("===== DANH SACH DICH VU =====");
			for(KhachHang kh : this.QLKH.values())
				System.out.println(kh);
		}
	}
	
	public void TimKhachHang() {
		if(this.QLKH.isEmpty())
			System.out.println("Danh sach khach hang trong");
		else {
			boolean found = false;
			System.out.println("Nhap ma khach hang can tim: ");
			String ma = sc.nextLine();
			for(KhachHang kh : this.QLKH.values())
				if(kh.GetmaKH().equalsIgnoreCase(ma)) {
					System.out.println("Tim thay khach hang co ma "+ma+"");
					System.out.println(kh);
					found = true;
				}
			if(!found)
				System.out.println("Khong tim thay khach hang co ma "+ma+"");
		}
	}
	
	public void XoaKhachHang() {
		if(this.QLKH.isEmpty())
			System.out.println("Danh sach khach hang trong");
		else {
			boolean found = false;
			System.out.println("Nhap ma khach hang can xoa: ");
			String ma = sc.nextLine();
			for(KhachHang kh : this.QLKH.values())
				if(kh.GetmaKH().equalsIgnoreCase(ma)) {
					this.QLKH.remove(ma);
					System.out.println("Da xoa khach hang co ma: "+ma);
					found = true;
					break;
				}
			if(!found)
				System.out.println("Khong tim thay khach hang co ma "+ma+"");
		}
	}
	
	public void CapNhapMotThongTinKhachHang() {
		if(this.QLKH.isEmpty()) {
			System.out.println("Danh sach khach hang trong");
			return;
		}
		else {
			System.out.println("Nhap ma khach hang can cap nhap: ");
			String ma = sc.nextLine();
			boolean found = false;
			for(KhachHang kh : this.QLKH.values()) {
				if(kh.GetmaKH().equalsIgnoreCase(ma)) {
					System.out.println("1. Cap nhap ten khach hang");
					System.out.println("2. Cap nhap dia chi khach hang");
					System.out.println("3. Cap nhap ngay sinh khach hang");
					System.out.println("4. Cap nhap SDT khach hang");
					System.out.println("5. Cap nhap Email khach hang");
					System.out.println("Nhap lua chon: ");
					int chon;
					while(true) {
						try {
							String choice = sc.nextLine();
							chon = Integer.parseInt(choice);
							if(chon != 1 && chon != 2 && chon != 3 && chon != 4 && chon !=5)
								throw new Exception("Chi nhap cac lua chon duoc cho phep");
							else
								break;
						} catch(NumberFormatException e) {
							System.out.println("Vui long nhap lua chon hop le!");
						}
						catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					switch(chon){
					case 1:{
						System.out.println("Nhap ten moi: ");
						String newten = sc.nextLine();
						kh.SettenKH(newten);
						System.out.println("Da cap nhap ten cua khach hang "+ma+" thanh "+newten+"");
						break;
					}
					case 2:{
						System.out.println("Nhap dia chi moi:");
						String newdiachi = sc.nextLine();
						kh.SetdiaChi(newdiachi);
						System.out.println("Da cap nhap dia chi cua khach hang "+ma+" thanh "+newdiachi+"");
						break;
					}
					case 3:{
						String ngay = null;
						LocalDate newdate = null;
						LocalDate ngayhientai = LocalDate.now();
						while(true) {
							try {
								System.out.println("Nhap ngay sinh moi (dd/MM/yyyy): ");
								ngay = sc.nextLine();
								DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								newdate = LocalDate.parse(ngay, dtf);
								if(newdate.isAfter(ngayhientai))
									throw new Exception("Ngay sinh phai nho hon "+ngayhientai);
								else
									break;
							}catch(DateTimeParseException e ) {
								System.out.println("Ngay thang phai dung dinh dang : dd/MM/yyyy !");
							}
							 catch (Exception e) {
							    System.out.println(e.getMessage());
							}
						}
						kh.SetngaySinh(newdate);
						System.out.println("Da cap nhap ngay sinh cua khach hang "+ma+" thanh "+newdate+"");
						break;
					}
					case 4:{
						String newsdt = null;
						while(true) {
							try {
								System.out.println("Nhap SDT moi :");
								newsdt = sc.nextLine();
								if(newsdt.length() < 1 || newsdt.length() > 15)
									throw new Exception("SDT phai co tu 1 den 15 chu so!");
								if(!newsdt.matches("\\d+"))
									throw new Exception("SDT khong duoc chua chu cai hoac ki tu dac biet!");
								break;
							} catch(Exception e) {
								System.out.println(e.getMessage());
							}
						}
						kh.SetSDT(newsdt);
						System.out.println("Da cap nhap SDT cua khach hang "+ma+" thanh "+newsdt+"");
						break;
					}
					case 5:{
						System.out.println("Nhap Email moi: ");
						String newemail = sc.nextLine();
						kh.SetEmail(newemail);
						System.out.println("Da cap nhap Email cua khach hang "+ma+" thanh "+newemail+"");
						break;
					}
					}
					System.out.println("Cap nhap thong tin khach hang hoan tat!");
					found = true;
					break;
				}
			}
			if(!found)
				System.out.println("Khong tim thay khach hang co ma "+ma+"");
		}
	}
	
	public void CapNhapTatCaThongTinKhachHang() {
		if(this.QLKH.isEmpty()) {
			System.out.println("Danh sach khach hang trong");
			return;
		}
		else {
			System.out.println("Nhap ma khach hang can cap nhap: ");
			String ma = sc.nextLine();
			boolean found = false;
			for(KhachHang kh : this.QLKH.values()) {
				if(kh.GetmaKH().equalsIgnoreCase(ma)) {
					System.out.println("Nhap ten moi: ");
					String newten = sc.nextLine();
					kh.SettenKH(newten);
					
					System.out.println("Nhap dia chi moi:");
					String newdiachi = sc.nextLine();
					kh.SetdiaChi(newdiachi);
					
					String ngay = null;
					LocalDate newdate = null;
					LocalDate ngayhientai = LocalDate.now();
					while(true) {
						try {
							System.out.println("Nhap ngay sinh moi (dd/MM/yyyy): ");
							ngay = sc.nextLine();
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							newdate = LocalDate.parse(ngay, dtf);
							if(newdate.isAfter(ngayhientai))
								throw new Exception("Ngay sinh phai nho hon "+ngayhientai);
							else
								break;
						}catch(DateTimeParseException e ) {
							System.out.println("Ngay thang phai dung dinh dang : dd/MM/yyyy !");
						}
						 catch (Exception e) {
						    System.out.println(e.getMessage());
						}
					}
					kh.SetngaySinh(newdate);
					
					String newsdt = null;
					while(true) {
						try {
							System.out.println("Nhap SDT moi :");
							newsdt = sc.nextLine();
							if(newsdt.length() < 1 || newsdt.length() > 15)
								throw new Exception("SDT phai co tu 1 den 15 chu so!");
							if(!newsdt.matches("\\d+"))
								throw new Exception("SDT khong duoc chua chu cai hoac ki tu dac biet!");
							break;
						} catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					kh.SetSDT(newsdt);
					
					System.out.println("Nhap Email moi: ");
					String newemail = sc.nextLine();
					kh.SetEmail(newemail);
					System.out.println("Cap nhap thong tin khach hang hoan tat!");
					found = true;
					break;
				}
			}
			if(!found)
				System.out.println("Khong tim thay khach hang voi ma "+ma);
		}
	}
	
	public void XemLichSuHopDong() {
		if(this.QLKH.isEmpty()) {
			System.out.println("Danh sach khach hang trong");
			return;
		}
		else {
			System.out.println("Danh sach khach hang");
			this.HienThiKhachHang();
			int choice;
			do {
			System.out.println("Nhap 1 de hien thi 1 khach hang, 0 de hien thi tat ca: ");
			choice = sc.nextInt();
			sc.nextLine();
			}while (choice != 1 && choice != 0);
			if(choice == 1) 
				HienThiMotKhachHang();
			else if(choice == 0)
				HienThiTatCa();
		}
	}
	
	public void HienThiMotKhachHang() {
		System.out.println("Nhap ma khach hang can xem lich su: ");
		String makh = sc.nextLine();
		if(this.QLKH.containsKey(makh)) {
			KhachHang kh = this.QLKH.get(makh);
			System.out.println("Thong tin khach hang");
			System.out.println(kh);
			
			System.out.println("Lich su hop dong");
			boolean found = false;
			Map<String, HopDong> dshd = this.ql.GetDSHD();
			if(dshd != null) {
				for(HopDong hd : dshd.values()) {
					if(hd.GetkhachHang() != null && hd.GetkhachHang().GetmaKH().equalsIgnoreCase(makh)) {
						System.out.println(hd); 
	                    found = true;
					}
				}
			}
			if(!found) {
				System.out.println("Khach hang nay chua co hop dong nao");
			}
		}
		else
			System.out.println("Khong tim thay khach hang co ma "+makh);
	}
	
	public void HienThiTatCa() {
		if (this.QLKH.isEmpty()) {
	        System.out.println("Danh sach khach hang trong.");
	        return;
	    }
		System.out.println(" DANH SACH TONG HOP ");
	    Map<String, HopDong> dshd = this.ql.GetDSHD();

	    for (KhachHang kh : this.QLKH.values()) {
	        String maKH = kh.GetmaKH();
	        System.out.println("Khach hang: "+kh.GettenKH()+" (Ma: "+maKH+")");
	        
	        boolean found = false;
	        if (dshd != null) {
	            for (HopDong hd : dshd.values()) {
	                if (hd.GetkhachHang() != null && hd.GetkhachHang().GetmaKH().equalsIgnoreCase(maKH)) {
	                    System.out.println(hd); 
	                    found = true;
	                }
	            }
	        }
	        
	        if (!found) {
	            System.out.println("Chua co giao dich)");
	        }
	    }
	}
}
