package baitaptuan8;
import baitaptuan8.IQuanLySach;
import java.util.ArrayList;
import java.util.List;

public class QuanLySachImpl implements IQuanLySach {
    private ArrayList<Sach> danhSachSach = new ArrayList<>();

    public void themSach(Sach s) {
        danhSachSach.add(s);
        System.out.println("Da them sach: " + s.getTieuDe());
    }

    public Sach timKiemSachTheoMa(String maSach) {
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach))
                return s;
        }
        return null;
    }

    public boolean xoaSachTheoMa(String maSach) {
        Sach s = timKiemSachTheoMa(maSach);
        if (s != null) {
            danhSachSach.remove(s);
            System.out.println("Da xoa sach co ma: " + maSach);
            return true;
        }
        System.out.println("Khong tim thay sach");
        return false;
    }

    public List<Sach> hienThiDanhSach() {
        System.out.println("\n===== DANH SACH SACH =====");
        for (Sach s : danhSachSach)
            System.out.println(s);
        System.out.println("==========================\n");
        return danhSachSach;
    }
}
