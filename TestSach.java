package baitap7;

public class TestSach {
    public static void main(String[] args) {
        QuanLySach ql = new QuanLySach();

        SachGiaoTrinh gt = new SachGiaoTrinh("Lập trình Java", "Nguyễn Văn A", 2022, 80000, 150, "Kho A1");
        SachTieuThuyet tt = new SachTieuThuyet("Harry Potter", "J.K. Rowling", 2020, 120000, 80, "Kho B3", true);

        ql.themSach(gt);
        ql.themSach(tt);

        ql.hienThiDanhSachSach();

        System.out.println("\n=== KIEM TRA GIAO DIEN IKiemKe ===");
        IKiemKe kiemKe = gt;
        System.out.println("Còn đủ tồn kho 100? " + kiemKe.kiemTraTonKho(100));
        kiemKe.capNhatViTri("Kho A1-Kệ 5");
    }
}
