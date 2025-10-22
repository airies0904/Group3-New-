package thtuan6;

public class Test {
    public static void main(String[] args) {
        QuanLySach ql = new QuanLySach();

        // ===== Thêm sách giáo trình =====
        SachGiaoTrinh gt1 = new SachGiaoTrinh("GT01", "Giải tích 1", "Nguyễn Văn A", 45000, "Toán học", "Đại học");
        SachGiaoTrinh gt2 = new SachGiaoTrinh("GT02", "Vật lý đại cương", "Trần Văn B", 55000, "Vật lý", "Đại học");

        // ===== Thêm sách tiểu thuyết =====
        SachTieuThuyet tt1 = new SachTieuThuyet("TT01", "Harry Potter", "J.K. Rowling", 120000, "Phiêu lưu", true);
        SachTieuThuyet tt2 = new SachTieuThuyet("TT02", "Dế Mèn Phiêu Lưu Ký", "Tô Hoài", 60000, "Thiếu nhi", false);

        // ===== Thêm vào danh sách =====
        ql.themSach(gt1);
        ql.themSach(gt2);
        ql.themSach(tt1);
        ql.themSach(tt2);

        // ===== Hiển thị danh sách =====
        System.out.println("=== Danh sách sách ===");
        ql.hienThiDanhSach();

        // ===== Tìm kiếm sách =====
        System.out.println("\n=== Tìm kiếm mã TT01 ===");
        Sach tim = ql.timKiemTheoMa("TT01");
        if (tim != null)
            System.out.println(tim);
        else
            System.out.println("Không tìm thấy sách!");

        // ===== Cập nhật sách =====
        System.out.println("\n=== Cập nhật sách mã GT02 ===");
        SachGiaoTrinh gt2moi = new SachGiaoTrinh("GT02", "Vật lý nâng cao", "Trần Văn B", 70000, "Vật lý", "Đại học");
        ql.capNhatSach("GT02", gt2moi);
        ql.hienThiDanhSach();

        // ===== Xóa sách =====
        System.out.println("\n=== Xóa sách có mã TT02 ===");
        ql.xoaSach("TT02");
        ql.hienThiDanhSach();
    }
}
