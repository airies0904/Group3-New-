
/**
 * Lớp Test chứa hàm main để chạy chương trình quản lý sách.
 * Tại đây, chúng ta sẽ tạo đối tượng QuanLySach và gọi các chức năng của nó.
 */
public class Test {

    public static void main(String[] args) {
        // 1. Tạo đối tượng quản lý sách
        // Đây là "trái tim" của chương trình, nơi lưu trữ và xử lý mọi thứ.
        QuanLySach quanLy = new QuanLySach();
        /*
        // Vi du minh hoa "EP KIEU"
        Sach sach1 = new SachGiaoTrinh("SGT01", "Toan cao cap A1", "Nguyen Van A", 2022, 50, 40000,"vi tri 1", "Toan hoc", "Dai hoc");
        Sach sach2 = new SachTieuThuyet("STT01", "Tri tue nhan tao 1", "Jane Smith", 2023, 30, 60000,"vi tri 2", "Trinh tham", true);
        */
        
        // Vi du minh hoa "KHONG EP KIEU"
        SachGiaoTrinh sach1 = new SachGiaoTrinh("SGT01", "Toan cao cap A1", "Nguyen Van A", 2022, 50, 40000,"vi tri 1", "Toan hoc", "Dai hoc");
        SachTieuThuyet sach2 = new SachTieuThuyet("STT01", "Tri tue nhan tao 1", "Jane Smith", 2023, 30, 60000,"vi tri 2", "Trinh tham", true);
        
        quanLy.them(sach1);
        quanLy.them(sach2);
        
        // 3. HIỂN THỊ: In toàn bộ danh sách sách hiện có
        System.out.println("\n## THUC HIEN CHUC NANG HIEN THI DANH SACH ##");
        quanLy.hienThiDanhSachSach();

        // 4. Thực hiện kiểm tra giao diện
        // Cần ép kiểu (cast) tường minh từ 'Sach' sang 'IkiemKe'.
        // Lý do: Biến 'sach1' đang được khai báo với kiểu dữ liệu là 'Sach'.
        // Lớp 'Sach' không triển khai giao diện 'IkiemKe', nên trình biên dịch không biết
        // 'sach1' có các phương thức như kiemTraTonKho().
        // Việc ép kiểu (IkiemKe) sach1 là để khẳng định với trình biên dịch rằng:
        // "Tôi biết chắc đối tượng mà 'sach1' đang giữ thực sự là một đối tượng có khả năng Kiểm Kê".
        // đối tượng thực tế mà kiemKe đang trỏ tới trong bộ nhớ là một đối tượng SachGiaoTrinh.
        System.out.println("\n## THUC HIEN KIEM TRA GIAO DIEN ##");
        /* IkiemKe kiemKe = (IkiemKe) sach1; */
        IkiemKe kiemKe = sach1;

        boolean kiemTraTonKho = kiemKe.kiemTraTonKho(100);
        if (kiemTraTonKho) {
            System.out.println("Sach '" + sach1.getTieuDe() + "': Con du hang.");
        } else {
            System.out.println("Sach '" + sach1.getTieuDe() + "': Khong con du hang.");
        }

        // Cập nhật vị trí
        System.out.println("\nDang cap nhat vi tri moi cho sach KIEM KE");
        kiemKe.capNhatViTri("Kho A1-Ke 5");

        // 6. HIỂN THỊ danh sách sách sau KIEM KE
        System.out.println("\n## SACH SAU KIEM KE ##");
        System.out.println(kiemKe); // Thực chất tương đương với: System.out.println(kiemKe.toString());
    }
}
