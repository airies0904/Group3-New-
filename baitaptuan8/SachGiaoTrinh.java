package baitaptuan8;

import java.time.Year;

public class SachGiaoTrinh extends Sach {
    private String monHoc;
    private String capDo;

    public SachGiaoTrinh(String maSach, String tieuDe, String tacGia,
                         int namXuatBan, int soLuong, double giaCoBan,
                         String monHoc, String capDo) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan);
        this.monHoc = monHoc;
        this.capDo = capDo;
    }

    @Override
    public double tinhGiaBan() {
        int year = Year.now().getValue();
        int soNam = year - getNamXuatBan();
        if (soNam < 0) soNam = 0;
        return getGiaCoBan() + soNam * 5000;
    }

    @Override
    public String toString() {
        return "Sach Giao Trinh {" + super.toString() +
               ", Mon hoc: " + monHoc +
               ", Cap do: " + capDo +
               ", Gia ban uoc tinh: " + tinhGiaBan() + " VND }";
    }
}

