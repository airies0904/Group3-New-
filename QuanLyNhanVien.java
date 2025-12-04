

import java.util.ArrayList;

public class QuanLyNhanVien {
    
    // Đảm bảo tên biến là listNhanVien (như trong code của bạn)
    private ArrayList<NhanVien> listNhanVien;

    // Sửa lỗi NullPointerException: PHẢI KHỞI TẠO DANH SÁCH
    public QuanLyNhanVien() {
        this.listNhanVien = new ArrayList<>();
    }

    public void themNhanVien(NhanVien nv) {
        this.listNhanVien.add(nv);
    }

    public void InDanhSach() {
        System.out.println("--- DANH SÁCH NHÂN VIÊN ---");
        // Sửa lỗi tham chiếu và đảm bảo lặp qua listNhanVien
        for (NhanVien nv : listNhanVien) {
            System.out.println("Ho Ten: " + nv.gethoTen() + " | Luong: " + nv.tinhLuong());
        }
        System.out.println("---------------------------");
    }
}