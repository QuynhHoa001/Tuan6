package Tuan6;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main_KH {
    public static void main(String[] args) {
        List<KhachHang> dsKhachHang = new ArrayList<>();
        dsKhachHang.add(new KHVietNam("VN01", "Nguyen Van A", LocalDate.of(2018, 9, 10), 100, 1500, "Sinh hoạt", 50));
        dsKhachHang.add(new KHVietNam("VN02", "Tran Thi B", LocalDate.of(2018, 10, 5), 220, 2000, "Kinh doanh", 100));
        dsKhachHang.add(new KHVietNam("VN03", "Le Van C", LocalDate.of(2019, 1, 20), 80, 1800, "Sản xuất", 60));
        dsKhachHang.add(new KHnuocngoai("NN01", "John Smith", LocalDate.of(2018, 9, 25), 150, 2500, "My"));
        dsKhachHang.add(new KHnuocngoai("NN02", "Yuki Tanaka", LocalDate.of(2018, 8, 15), 120, 3000, "Nhat"));
        dsKhachHang.add(new KHnuocngoai("NN03", "Kim Min Su", LocalDate.of(2019, 3, 8), 90, 2800, "Han"));
        System.out.println("=== DANH SÁCH HÓA ĐƠN ===");
        for (KhachHang kh : dsKhachHang) {
            System.out.println(kh);
        }
        int tongSoLuongVN = 0;
        int tongSoLuongNN = 0;
        double tongThanhTienNN = 0;

        for (KhachHang kh : dsKhachHang) {
            if (kh instanceof KHVietNam) {
                tongSoLuongVN++;
            } else if (kh instanceof KHnuocngoai) {
                tongSoLuongNN++;
                tongThanhTienNN += kh.thanhTien();
            }
        }
        System.out.println("\n=== THỐNG KÊ ===");
        System.out.println("Tổng số lượng khách hàng Việt Nam: " + tongSoLuongVN);
        System.out.println("Tổng số lượng khách hàng Nước Ngoài: " + tongSoLuongNN);
        if (tongSoLuongNN > 0) {
            double trungBinhTTNN = tongThanhTienNN / tongSoLuongNN;
            System.out.printf("Trung bình thành tiền của khách hàng Nước Ngoài: %,.0f\n", trungBinhTTNN);
        } else {
            System.out.println("Không có khách hàng nước ngoài nào.");
        System.out.println("\n=== HÓA ĐƠN THÁNG 09/2013 ===");
        for (KhachHang kh : dsKhachHang) {
            LocalDate ngay = kh.getNgayLapHD();
            if (ngay.getYear() == 2013 && ngay.getMonthValue() == 9) {
                System.out.println(kh);
            }
        }
    }
    }
  }