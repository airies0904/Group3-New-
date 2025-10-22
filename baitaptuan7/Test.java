package baitaptuan7;

public class Test {
    public static void main(String[] args) {
        QuanLySach ql = new QuanLySach();

        SachGiaoTrinh sgk = new SachGiaoTrinh("GT01", "Lap Trinh Java", "Nguyen Van A", 2020, 50, 100000,
                "Cong Nghe Thong Tin", "Dai hoc");
        SachTieuThuyet stt = new SachTieuThuyet("TT01", "Doraemon", "Fujiko F. Fujio", 2015, 20, 80000,
                "Thieu nhi", true);

        ql.themSach(sgk);
        ql.themSach(stt);

        ql.hienThiDanhSach();

        // Kiem tra giao dien
        IKiemKe kiemKe = sgk;
        System.out.println("Kiem tra ton kho >= 100: " + kiemKe.kiemTraTonKho(100));
        kiemKe.capNhatViTri("Kho A1 - Ke 5");
    }
}

