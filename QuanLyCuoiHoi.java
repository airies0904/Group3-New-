package TH_LTHDT_CK;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class QuanLyCuoiHoi{
	private QuanLyNhanVien qlnv;
    private QuanLyKhachHang qlkh;
    private QuanLySanPham qlsp;
    private QuanLyDichVu qldv;
    private QuanLyHopDong qlhd;
    
    private Scanner sc;
    
    public QuanLyCuoiHoi() {
    	this.sc = new Scanner(System.in);
    	this.qlnv = new QuanLyNhanVien();
        this.qlsp = new QuanLySanPham();
        this.qldv = new QuanLyDichVu(this.qlnv);
        this.qlkh = new QuanLyKhachHang(null);
        this.qlhd = new QuanLyHopDong(this.qlkh, this.qlnv, this.qlsp, this.qldv);
        this.qlkh.setQLHD(this.qlhd);
        TaoDuLieuBanDau();
    }
    
    public void run() {
    	while (true) {
            System.out.println("\n========== HE THONG QUAN LY TIEM CUOI ==========");
            System.out.println("1. Quan ly Nhan Vien");
            System.out.println("2. Quan ly Khach Hang");
            System.out.println("3. Quan ly San Pham (Kho)");
            System.out.println("4. Quan ly Dich Vu");
            System.out.println("5. Quan ly Hop Dong (Giao dich)");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Nhap lua chon cua ban: ");
            
            int chon;
            while(true) {
	            try {
	                chon = Integer.parseInt(sc.nextLine());
	                if(!(chon >= 0 && chon <= 5))
	                	throw new Exception("Lua chon khong chinh xac");
	                else
	                	break;
	            } catch (Exception e) {
	                System.out.println("Lua chon khong hop le!");
	            }
            }

            switch (chon) {
                case 1:
                    menuNhanVien();
                    break;
                case 2:
                    menuKhachHang();
                    break;
                case 3:
                    menuSanPham();
                    break;
                case 4:
                    menuDichVu();
                    break;
                case 5:
                    menuHopDong();
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    return;
                default:
                    System.out.println("Chuc nang khong ton tai!");
            }
        }
    }
    
    private void menuNhanVien() {
        while(true) {
            System.out.println("\n--- QUAN LY NHAN VIEN ---");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim kiem nhan vien");
            System.out.println("4. Xoa nhan vien");
            System.out.println("5. Cap nhat mot thong tin");
            System.out.println("6. Cap nhat tat ca thong tin");
            System.out.println("0. Quay lai menu chinh");
            
            int c = Integer.parseInt(sc.nextLine()); 
            
            if(c == 0) break;
            switch(c) {
                case 1: qlnv.ThemNhanVien(); break;
                case 2: qlnv.HienThiNhanVien(); break;
                case 3: qlnv.TimNhanVien(); break;
                case 4: qlnv.XoaNhanVien(); break;
                case 5: qlnv.CapNhatMotThongTinNhanVien(); break;
                case 6: qlnv.CapNhatTatCaThongTinNhanVien(); break;
            }
        }
    }
    
    private void menuSanPham() {
        while(true) {
            System.out.println("\n--- QUAN LY SAN PHAM ---");
            System.out.println("1. Them san pham");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim kiem san pham");
            System.out.println("4. Xoa san pham");
            System.out.println("5. Cap nhat mot thong tin");
            System.out.println("6. Cap nhat tat ca thong tin");
            System.out.println("7. Bao tri san pham");
            System.out.println("0. Quay lai menu chinh");
            
            int c = Integer.parseInt(sc.nextLine()); 
            
            if(c == 0) break;
            switch(c) {
                case 1: qlsp.themSanPham(); break;
                case 2: qlsp.hienThiSanPham(); break;
                case 3: qlsp.timSanPham(); break;
                case 4: qlsp.xoaSanPham(); break;
                case 5: qlsp.CapNhapMotThongTinSanPham(); break;
                case 6: qlsp.CapNhapTatCaThongTinSanPham(); break;
                case 7: qlsp.BaoTriSanPham(); break;
            }
        }
    }
    
    private void menuDichVu() {
        while(true) {
            System.out.println("\n--- QUAN LY DICH VU ---");
            System.out.println("1. Them dich vu");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim kiem dich vu");
            System.out.println("4. Xoa dich vu");
            System.out.println("5. Cap nhat mot thong tin");
            System.out.println("6. Cap nhat tat ca thong tin");
            System.out.println("0. Quay lai menu chinh");
            
            int c = Integer.parseInt(sc.nextLine()); 
            
            if(c == 0) break;
            switch(c) {
                case 1: qldv.ThemDichVu(); break;
                case 2: qldv.HienThiDichVu(); break;
                case 3: qldv.TimDichVu(); break;
                case 4: qldv.XoaDichVu(); break;
                case 5: qldv.CapNhapMotThongTinDichVu(); break;
                case 6: qldv.CapNhapTatCaThongTinDichVu(); break;
            }
        }
    }
    
    private void menuKhachHang() {
        while(true) {
            System.out.println("\n--- QUAN LY KHACH HANG ---");
            System.out.println("1. Them khach hang");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim kiem khach hang");
            System.out.println("4. Xoa khach hang");
            System.out.println("5. Cap nhat mot thong tin");
            System.out.println("6. Cap nhat tat ca thong tin");
            System.out.println("7. Hien thi lich su hop dong mot khach hang");
            System.out.println("8. Hien thi tat ca lich su hop dong");
            System.out.println("0. Quay lai menu chinh");
            
            int c = Integer.parseInt(sc.nextLine()); 
            
            if(c == 0) break;
            switch(c) {
                case 1: qlkh.ThemKhachHang(); break;
                case 2: qlkh.HienThiKhachHang(); break;
                case 3: qlkh.TimKhachHang(); break;
                case 4: qlkh.XoaKhachHang(); break;
                case 5: qlkh.CapNhapMotThongTinKhachHang(); break;
                case 6: qlkh.CapNhapTatCaThongTinKhachHang(); break;
                case 7: qlkh.HienThiMotKhachHang(); break;
                case 8: qlkh.HienThiTatCa(); break;
            }
        }
    }
    
    private void menuHopDong() {
        while(true) {
            System.out.println("\n--- QUAN LY HOP DONG ---");
            System.out.println("1. Tao hop dong");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim kiem hop dong");
            System.out.println("4. Xoa hop dong");
            System.out.println("5. Cap nhat thong tin hop dong");
            System.out.println("0. Quay lai menu chinh");
            
            int c = Integer.parseInt(sc.nextLine()); 
            
            if(c == 0) break;
            switch(c) {
                case 1: qlhd.ThemHopDong(); break;
                case 2: qlhd.HienThiHopDong(); break;
                case 3: qlhd.TimHopDong(); break;
                case 4: qlhd.XoaHopDong(); break;
                case 5: qlhd.CapNhapMotThongTinHopDong(); break;
            }
        }
    }
    
    private void TaoDuLieuBanDau() {
    	// Tao 4 nhan vien
    	NhanVien nv1 = new NhanVien("NV01", "Vo Minh Huy", "0763612967", "Trang diem", 50000);
    	NhanVien nv2 = new NhanVien("NV02", "Nguyen Van A", "0764234167", "Chup anh", 70000);
    	NhanVien nv3 = new NhanVien("NV03", "Ha Van B", "0763612212", "Chup anh", 40000);
    	NhanVien nv4 = new NhanVien("NV04", "Doan Van C", "0123612967", "Trang tri", 50000);
    	
    	qlnv.ThemNhanVienBanDau(nv1);
    	qlnv.ThemNhanVienBanDau(nv2);
    	qlnv.ThemNhanVienBanDau(nv3);
    	qlnv.ThemNhanVienBanDau(nv4);
    	
    	// Tao 4 khach hang
    	KhachHang kh1 = new KhachHang("KH01", "Hoang Van E", "Ha Noi", LocalDate.of(1995, 5, 10), "0911111111", "e@gmail.com");
        KhachHang kh2 = new KhachHang("KH02", "Ngo Thi F", "TP HCM", LocalDate.of(1998, 8, 20), "0922222222", "f@gmail.com");
        KhachHang kh3 = new KhachHang("KH03", "Dang Van G", "Da Nang", LocalDate.of(1990, 1, 15), "0933333333", "g@gmail.com");
        KhachHang kh4 = new KhachHang("KH04", "Bui Thi H", "Can Tho", LocalDate.of(1996, 12, 5), "0944444444", "h@gmail.com");
        
        qlkh.ThemKhachHangBanDau(kh1);
        qlkh.ThemKhachHangBanDau(kh2);
        qlkh.ThemKhachHangBanDau(kh3);
        qlkh.ThemKhachHangBanDau(kh4);
        
        // Tao 4 san pham
        SanPhamChoThue sp1 = new VayCuoi("SP01", "Vay Cuoi Cong Chua", 2000000, 5, "Tot", "M", "Trang", "Xoe", "Ren");
        SanPhamChoThue sp2 = new Vest("SP02", "Vest Den Lich Lam", 1500000, 10, "Trong kho", "L", "Den", "Han Quoc", "Vai Au");
        SanPhamChoThue sp3 = new PhuKien("SP03", "Vuong Mien", 500000, 20, "Tot", "PK01", "Vuong Mien Dinh Da");
        SanPhamChoThue sp4 = new VayCuoi("SP04", "Vay Duoi Ca Sexy", 2500000, 3, "Tot", "S", "Do", "Duoi Ca", "Lua");

        qlsp.ThemSanPhamBanDau(sp1);
        qlsp.ThemSanPhamBanDau(sp2);
        qlsp.ThemSanPhamBanDau(sp3);
        qlsp.ThemSanPhamBanDau(sp4);
        
        // Tao 4 dich vu
        DichVuChupAnh dv1 = new DichVuChupAnh("DV01", "Chup Pre-wedding", 5000000, "Phim truong", 200);
        dv1.themNhanVienVaoEkip(nv2);
        dv1.themNhanVienVaoEkip(nv3);

        DichVuTrangDiem dv2 = new DichVuTrangDiem("DV02", "Trang diem Co dau", 1500000, "Tu nhien");
        dv2.themNhanVienVaoEkip(nv1);

        DichVuTrangTri dv3 = new DichVuTrangTri("DV03", "Trang tri Gia tien", 8000000, "Co dien", "Tai nha");
        dv2.themNhanVienVaoEkip(nv4); 

        DichVuChupAnh dv4 = new DichVuChupAnh("DV04", "Chup Phong su Cuoi", 6000000, "Nha hang", 500);
        dv2.themNhanVienVaoEkip(nv1);

        qldv.ThemDichVuBanDau(dv1);
        qldv.ThemDichVuBanDau(dv2);
        qldv.ThemDichVuBanDau(dv3);
        qldv.ThemDichVuBanDau(dv4);
        
        // Tao 2 hop dong
        
        List<ChiTietThueSanPham> listSP1 = new ArrayList<>();
        listSP1.add(new ChiTietThueSanPham(sp1, 1, 2));
        List<ChiTietDatDichVu> listDV1 = new ArrayList<>();
        listDV1.add(new ChiTietDatDichVu(dv1, 2, 1));
        List<NhanVien> listNV_HD1 = new ArrayList<>();
        listNV_HD1.add(nv1); // NV01
        listNV_HD1.add(nv2); // NV02
        
        HopDong hd1 = new HopDong("HD01", kh1, listNV_HD1, listSP1, listDV1, LocalDate.now(), LocalDate.now().plusDays(1), LocalDate.now().plusDays(3), "Moi tao");
        qlhd.ThemHopDongBanDau(hd1);
        
        List<ChiTietThueSanPham> listSP2 = new ArrayList<>();
        listSP2.add(new ChiTietThueSanPham(sp2, 1, 3));
        List<ChiTietDatDichVu> listDV2 = new ArrayList<>();
        listDV2.add(new ChiTietDatDichVu(dv2, 1, 1));
        List<NhanVien> listNV_HD2 = new ArrayList<>();
        listNV_HD2.add(nv3); // NV03
        
        HopDong hd2 = new HopDong("HD02", kh2, listNV_HD2, listSP2, listDV2, LocalDate.now().minusDays(5), LocalDate.now().minusDays(2), LocalDate.now(), "Da thanh toan");
        qlhd.ThemHopDongBanDau(hd2);
    }	
}

