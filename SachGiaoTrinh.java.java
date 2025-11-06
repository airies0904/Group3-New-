package thtuan6;

public class SachGiaoTrinh extends Sach {
    private String monHoc;
    private String capDo;

    // Hàm tạo đầy đủ tham số (bao gồm cả lớp cha)
    public SachGiaoTrinh(String maSach, String tenSach, String tacGia, double giaBan,
                         String monHoc, String capDo) {
        super(maSach, tenSach, tacGia, giaBan); // gọi constructor của lớp cha
        this.monHoc = monHoc;
        this.capDo = capDo;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Môn học: " + monHoc +
               ", Cấp độ: " + capDo;
    }
}

