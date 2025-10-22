public interface IkiemKe {

    /**
     * Kiểm tra xem số lượng sách trong kho có đạt mức tối thiểu yêu cầu hay không.
     * soLuongToiThieu Số lượng tối thiểu cần kiểm tra.
     * true nếu số lượng hiện tại >= số lượng tối thiểu, ngược lại là false.
     */
    boolean kiemTraTonKho(int soLuongToiThieu);

    /**
     * Cập nhật thông tin vị trí lưu trữ của cuốn sách.
     * viTriMoi Vị trí mới (ví dụ: "Kệ A1", "Kho B2").
     */
    void capNhatViTri(String viTriMoi);
}