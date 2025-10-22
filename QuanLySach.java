import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySach {
    private ArrayList<Sach1> danhSachSach;
    public QuanLySach() {
        danhSachSach = new ArrayList<>();
    }

    public void themSach() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ban muon them loai sach nao?");
        System.out.println("1. Sach Giao Trinh");
        System.out.println("2. Sach Tieu Thuyet");
        System.out.print("Lua chon cua ban: ");
        int choice = sc.nextInt();
        
        Sach1 sachMoi;
        if (choice == 1) {
            sachMoi = new SachGiaoTrinh();
        } else {
            sachMoi = new SachTieuThuyet();
        }

        System.out.println("--- NHAP THONG TIN SACH MOI ---");
        sachMoi.nhapThongTin();
        danhSachSach.add(sachMoi);
        System.out.println("Them sach moi thanh cong!");
    }
    public void themSach(Sach1 sach) {
    if (sach != null) {
        this.danhSachSach.add(sach);
        System.out.println("Da them Sach: " + sach.getTieuDe());
    } else {
        System.out.println("Loi: Khong the them sach null.");
    }
}
    public void hienThiDanhSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Chua co sach nao trong thu vien.");
            return;
        }
        System.out.println("\n--- DANH SACH TAT CA SACH ---");
        for (Sach1 sach : danhSachSach) {
            System.out.println(sach);
        }
        System.out.println("---------------------------------");
    }

    public Sach1 timKiemTheoMa(String maSach) {
        for (Sach1 sach : danhSachSach) { 
            if (sach.getMasach().equalsIgnoreCase(maSach)) {
                return sach;
            }
        }
        return null;
    }

    public void xoaSachTheoMa(String maSach) {
        Sach1 sachCanXoa = timKiemTheoMa(maSach);
        if (sachCanXoa != null) {
            danhSachSach.remove(sachCanXoa);
            System.out.println("Da xoa sach co ma '" + maSach + "' thanh cong.");
        } else {
            System.out.println("Khong tim thay sach co ma '" + maSach + "' de xoa.");
        }
    }
    
    public void capNhatSach(String maSach) {
        Sach1 sachCanCapNhat = timKiemTheoMa(maSach);
        if (sachCanCapNhat != null) {
            System.out.println("--- NHAP THONG TIN CAP NHAT ---");
            sachCanCapNhat.nhapThongTin();
            System.out.println("Cap nhat thanh cong!");
        } else {
            System.out.println("Khong tim thay sach co ma '" + maSach + "' de cap nhat.");
        }
    }
}