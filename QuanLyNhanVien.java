package TH_LTHDT_CK;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class QuanLyNhanVien {
	private Map<String, NhanVien> QLNV;
	private Scanner sc = new Scanner(System.in);
	
	public QuanLyNhanVien() {
		this.QLNV = new HashMap<>();
	}
	public NhanVien GetNhanVien(String ma) {
		return QLNV.get(ma);
	}
	public List<NhanVien> getDanhSachNhanVienList() {
	    return new ArrayList<>(this.QLNV.values());
	}
	
	public void ThemNhanVienBanDau(NhanVien nv) {
	    this.QLNV.put(nv.GetmaNV(), nv);
	}
	
	public void ThemNhanVien() {
		String ma;
        while (true) {
            System.out.println("Nhap ma NV: ");
            ma = sc.nextLine();
            if (this.QLNV.containsKey(ma)) {
                System.out.println("Ma nhan vien da ton tai! Vui long nhap ma khac.");
            } else {
                break;
            }
        }

        System.out.println("Nhap ten NV: ");
        String ten = sc.nextLine();

        String sdt = null;
        while(true) {
            try {
                System.out.println("Nhap SDT NV: ");
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
        String chucvu;
        while(true) {
        	System.out.println("Nhap chuc vu NV (Quan ly/Chup anh/Trang tri/Trang diem): ");
        	chucvu = sc.nextLine();
        	if(!chucvu.equalsIgnoreCase("Quan ly") && !chucvu.equalsIgnoreCase("Chup anh") && !chucvu.equalsIgnoreCase("Trang tri") && !chucvu.equalsIgnoreCase("Trang diem")) {
        		System.out.println("Chi nhap cac chuc vu duoc cho phep");
        	}
        	else
        		break;
        }
        double luongcb;
        while (true) {
            System.out.println("Nhap luong co ban: ");
            String luongInput = sc.nextLine();
            try {
                luongcb = Double.parseDouble(luongInput);
                if (luongcb <= 0)
                    throw new Exception("Luong phai lon hon 0!");
                else
                    break;
            } catch (NumberFormatException e) {
                System.out.println("Luong phai la mot so hop le!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        NhanVien nv = new NhanVien(ma, ten, sdt, chucvu, luongcb);
        this.QLNV.put(ma, nv);
        System.out.println("Them nhan vien thanh cong!");
	}
	
	public void HienThiNhanVien() {
		if (this.QLNV.isEmpty()) {
            System.out.println("Danh sach nhan vien trong");
        } else {
            System.out.println("===== DANH SACH NHAN VIEN =====");
            for (NhanVien nv : this.QLNV.values())
                System.out.println(nv);
        }
	}
	
	public void TimNhanVien() {
		if (this.QLNV.isEmpty()) {
            System.out.println("Danh sach nhan vien trong");
            return;
        }
        System.out.println("Nhap ma NV can tim: ");
        String ma = sc.nextLine();
        if (this.QLNV.containsKey(ma)) {
            System.out.println("Tim thay nhan vien:");
            System.out.println(this.QLNV.get(ma));
        } else {
            System.out.println("Khong tim thay nhan vien co ma " + ma);
        }
	}
	
	public void XoaNhanVien() {
		if(this.QLNV.isEmpty())
			System.out.println("DS nhan vien trong");
		else {
			this.HienThiNhanVien();
	        System.out.println("Nhap ma NV can xoa: ");
	        String ma = sc.nextLine();
	        if (this.QLNV.containsKey(ma)) {
	            this.QLNV.remove(ma);
	            System.out.println("Da xoa NV co ma: " + ma);
	        } else {
	            System.out.println("Khong tim thay nhan vien co ma " + ma);
	        }
		}
	}
	
	public void CapNhatMotThongTinNhanVien() {
	    if (this.QLNV.isEmpty()) {
	        System.out.println("Danh sach nhan vien trong");
	        return;
	    }

	    System.out.println("Nhap ma nhan vien can cap nhat mot thong tin: ");
	    String ma = sc.nextLine();
	    if (this.QLNV.containsKey(ma)) {
	        NhanVien nv = this.QLNV.get(ma);
	        System.out.println("Tim thay nhan vien: " + nv.GetTenNV());
	        System.out.println("1. Cap nhat Ten nhan vien");
	        System.out.println("2. Cap nhat So dien thoai");
	        System.out.println("3. Cap nhat Chuc vu");
	        System.out.println("4. Cap nhat Luong co ban");

	        int chon;
	        while (true) {
	            System.out.println("Nhap lua chon cua ban: ");
	            String choice = sc.nextLine();
	            try {
	                chon = Integer.parseInt(choice);
	                if (chon < 1 || chon > 4)
	                    throw new Exception("Vui long chon tu 1 den 4");
	                else
	                    break;
	            } catch (NumberFormatException e) {
	                System.out.println("Lua chon khong hop le!");
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
	        }

	        switch (chon) {
	            case 1: {
	                System.out.println("Nhap ten moi: ");
	                String tenMoi = sc.nextLine();
	                nv.SetTenNV(tenMoi);
	                System.out.println("Da cap nhat ten thanh cong!");
	                break;
	            }
	            case 2: {
	                String sdtMoi = null;
	                while (true) {
	                    try {
	                        System.out.println("Nhap SDT moi: ");
	                        sdtMoi = sc.nextLine();
	                        if (sdtMoi.length() < 1 || sdtMoi.length() > 15)
	                            throw new Exception("SDT phai co tu 1 den 15 chu so!");
	                        if (!sdtMoi.matches("\\d+"))
	                            throw new Exception("SDT khong duoc chua chu cai hoac ki tu dac biet!");
	                        break;
	                    } catch (Exception e) {
	                        System.out.println(e.getMessage());
	                    }
	                }
	                nv.SetSDT(sdtMoi);
	                System.out.println("Da cap nhat SDT thanh cong!");
	                break;
	            }
	            case 3: { 
	            	String chucVuMoi;
	                while(true) {
	                	System.out.println("Nhap moi chuc vu NV (Quan ly/Chup anh/Trang tri/Trang diem): ");
	                	chucVuMoi = sc.nextLine();
	                	if(!chucVuMoi.equalsIgnoreCase("Quan ly") && !chucVuMoi.equalsIgnoreCase("Chup anh") && !chucVuMoi.equalsIgnoreCase("Trang tri") && !chucVuMoi.equalsIgnoreCase("Trang diem")) {
	                		System.out.println("Chi nhap cac chuc vu duoc cho phep");
	                	}
	                	else
	                		break;
	                }
	                nv.SetChucVu(chucVuMoi);
	                System.out.println("Da cap nhat chuc vu thanh cong!");
	                break;
	            }
	            case 4: {
	                double luongMoi;
	                while (true) {
	                    System.out.println("Nhap luong moi: ");
	                    String l = sc.nextLine();
	                    try {
	                        luongMoi = Double.parseDouble(l);
	                        if (luongMoi <= 0)
	                            throw new Exception("Luong phai lon hon 0!");
	                        else
	                            break;
	                    } catch (NumberFormatException e) {
	                        System.out.println("Nhap so khong hop le!");
	                    } catch (Exception e) {
	                        System.out.println(e.getMessage());
	                    }
	                }
	                nv.SetLuongCoBan(luongMoi);
	                System.out.println("Da cap nhat luong thanh cong!");
	                break;
	            }
	        }
	    } else {
	        System.out.println("Khong tim thay nhan vien co ma " + ma);
	    }
	}
	
	public void CapNhatTatCaThongTinNhanVien() {
	    if (this.QLNV.isEmpty()) {
	        System.out.println("Danh sach nhan vien trong");
	        return;
	    }

	    System.out.println("Nhap ma nhan vien can cap nhat tat ca thong tin: ");
	    String ma = sc.nextLine();
	    if (this.QLNV.containsKey(ma)) {
	        NhanVien nv = this.QLNV.get(ma);
	        System.out.println("Tim thay nhan vien: " + nv.GetTenNV());

	        System.out.println("Nhap ten moi: ");
	        String tenMoi = sc.nextLine();
	        nv.SetTenNV(tenMoi);

	        String sdtMoi = null;
	        while (true) {
	            try {
	                System.out.println("Nhap SDT moi: ");
	                sdtMoi = sc.nextLine();
	                if (sdtMoi.length() < 1 || sdtMoi.length() > 15)
	                    throw new Exception("SDT phai co tu 1 den 15 chu so!");
	                if (!sdtMoi.matches("\\d+"))
	                    throw new Exception("SDT khong duoc chua chu cai hoac ki tu dac biet!");
	                break;
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
	        }
	        nv.SetSDT(sdtMoi);

	        String chucVuMoi;
            while(true) {
            	System.out.println("Nhap moi chuc vu NV (Quan ly/Chup anh/Trang tri/Trang diem): ");
            	chucVuMoi = sc.nextLine();
            	if(!chucVuMoi.equalsIgnoreCase("Quan ly") && !chucVuMoi.equalsIgnoreCase("Chup anh") && !chucVuMoi.equalsIgnoreCase("Trang tri") && !chucVuMoi.equalsIgnoreCase("Trang diem")) {
            		System.out.println("Chi nhap cac chuc vu duoc cho phep");
            	}
            	else
            		break;
            }
	        nv.SetChucVu(chucVuMoi);

	        double luongMoi;
	        while (true) {
	            System.out.println("Nhap luong co ban moi: ");
	            String l = sc.nextLine();
	            try {
	                luongMoi = Double.parseDouble(l);
	                if (luongMoi <= 0)
	                    throw new Exception("Luong phai lon hon 0!");
	                else
	                    break;
	            } catch (NumberFormatException e) {
	                System.out.println("Nhap so khong hop le!");
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
	        }
	        nv.SetLuongCoBan(luongMoi);

	        System.out.println("Da cap nhat TOAN BO thong tin cho nhan vien " + ma);

	    } else {
	        System.out.println("Khong tim thay nhan vien co ma " + ma);
	    }
	}
}
