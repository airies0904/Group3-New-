package thtuan6;

import java.util.ArrayList;

public class QuanLySach {
    private ArrayList<Sach> danhSach;

    // Hàm tạo
    public QuanLySach() {
        danhSach = new ArrayList<>();
    }

    // Thêm sách
    public void themSach(Sach s) {
        danhSach.add(s);
    }

    // Xóa sách theo mã
    public boolean xoaSach(String maSach) {
        for (Sach s : danhSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                danhSach.remove(s);
                return true;
            }
        }
        return false;
    }

    // Cập nhật sách theo mã
    public boolean capNhatSach(String maSach, Sach sachMoi) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaSach().equalsIgnoreCase(maSach)) {
                danhSach.set(i, sachMoi);
                return true;
            }
        }
        return false;
    }

    // Tìm kiếm sách theo mã
    public Sach timKiemTheoMa(String maSach) {
        for (Sach s : danhSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null;
    }

    // Hiển thị danh sách
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng!");
        } else {
            for (Sach s : danhSach) {
                System.out.println(s);
            }
        }
    }
}
