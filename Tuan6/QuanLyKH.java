package Tuan6;
import java.util.List;
import java.util.Map;
public interface QuanLyKH<KH> {
	void them (KH kh);
	boolean xoa(String ma);
	boolean sua(String ma, KhachHang KHmoi);
	List<KhachHang> timKiemTheoten(String ten);
	List<KH> timKiemTheoMa(String prefix);
	List<KH> sapXepTheoLuong();
	List<KH> sapXepTheoTen();
	Map<String,Double> thongKeTheoLoai();
	Map<String,Double> groupByLoai();
	Map<String,Double> groupByPhongBan();
	List<KH> locLuongTren(double mucLuong);
	List<KH> timTheoChucVu();
}