public class Main {
    public static void main(String[] args) {

        QuanLyNhanVien ql = new QuanLyNhanVien();

        NhanVienToanThoiGian a = new NhanVienToanThoiGian("NV01","Nguyễn Văn A","Kế Toán",5000000, 1000000, 10);
        NhanVienBanThoiGian b = new NhanVienBanThoiGian("NV02","Trần Thị B","Bán Hàng",50000, 40);

        ql.themNhanVien(a);
        ql.themNhanVien(b);

        ql.InDanhSach();
    }
}