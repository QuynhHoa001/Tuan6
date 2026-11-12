package Tuan6;
import java.time.LocalDate;
public class HangThucPham {
	private int id;
	private String maHang,tenHang;
	private LocalDate ngaySanXuat, ngayHetHan;
	private double gia;
	
	private static int demSoLuong = 0;
	
	

	public HangThucPham() {
		this.id = ++demSoLuong;
		this.maHang = "MAC_DINH";
		this.tenHang = "Hàng mặc định";
		this.ngaySanXuat = LocalDate.now();
		this.ngayHetHan = LocalDate.now().plusDays(7);
		this.gia = 1.0f;
	}
	public HangThucPham(String maHang, String tenHang, LocalDate ngaySanXuat, LocalDate ngayHetHan, float gia) throws IllegalAccessException {
	    this.id = ++demSoLuong;
	    if (maHang == null || maHang.trim().isEmpty()) {
	        throw new IllegalAccessException("Mã hàng không được để trống!");
	    }
	    if (tenHang == null || tenHang.trim().isEmpty()) {
	        throw new IllegalAccessException("Tên hàng không được để trống!");
	    }
	    if (gia <= 0) {
	        throw new IllegalAccessException("Giá phải lớn hơn 0!");
	    }
	    if (!kiemtraNgaySanXuat(ngaySanXuat)) {
	        throw new IllegalAccessException("Ngày SX không được là tuong lai!");
	    }
	    if (!kiemtraNgayHetHan(ngaySanXuat, ngayHetHan)) {
	        throw new IllegalAccessException("Ngày HH phải sau ngày SX!");
	    }
	    this.maHang = maHang;
	    this.tenHang = tenHang;
	    this.ngaySanXuat = ngaySanXuat;
	    this.ngayHetHan = ngayHetHan;
	    this.gia = gia;
	}
	private boolean kiemtraNgaySanXuat(LocalDate ngaySX) {
		return ngaySX != null && !ngaySX.isAfter(LocalDate.now());	
	}
	private boolean kiemtraNgayHetHan(LocalDate ngaySX,LocalDate ngayHH) {
		return ngaySX != null && ngayHH != null && ngayHH.isAfter(ngaySX);	
	}
	public HangThucPham(int id) {
		
	}

	public int getId() {
		return id;
	}
	public String getMaHang() {
		return maHang;
	}
	public String getTenHang() {
		return tenHang;
	}
	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}
	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}
	public double getGia() {
		return gia;
	}
	public static int getDemSoLuong() {
		return demSoLuong;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}


	public void setMaHang(String maHAng) {
		this.maHang = maHAng;
	}

	

	public void setTenHang(String tenHang) throws IllegalAccessException {
		if (tenHang==null||tenHang.trim().isEmpty()) {
			throw new IllegalAccessException("Tên hàng không được để trống!");
		}
		this.tenHang = tenHang;
	}

	

	public void setNgaySanXuat(LocalDate ngaySanXuat) throws IllegalAccessException {
		if (!kiemtraNgaySanXuat(ngaySanXuat)) {
			throw new IllegalAccessException("Ngày SX không được là tuong lai!");
		}
		if (this.ngayHetHan != null && !kiemtraNgayHetHan(ngaySanXuat,this.ngayHetHan )) {
			throw new IllegalAccessException("Ngày SX phải trước ngày HH!");
		}
		this.ngaySanXuat = ngaySanXuat;
	}

	

	public void setNgayHetHan(LocalDate ngayHetHan) throws IllegalAccessException {
		if (this.ngaySanXuat == null) {
			throw new IllegalAccessException("Chưa có ngày SX!");
		}
		if (!kiemtraNgayHetHan(this.ngaySanXuat,ngayHetHan)) {
			throw new IllegalAccessException("Ngày HH phải sau ngày SX!");
		}
		this.ngayHetHan = ngayHetHan;
	}

	

	public void setGia(float gia) throws IllegalAccessException {
		if (gia<=0) {
			throw new IllegalAccessException("Giá phải lớn hơn 0!");
		}
		this.gia = gia;
	}
	public boolean kiemTraHetHan() {
		return LocalDate.now().isAfter(this.ngayHetHan);
	}
	public String trangThaiChiTiet() {
		LocalDate homNay = LocalDate.now();
		if (homNay.isBefore(ngaySanXuat)) {
			return "Chưa sản xuất ";
		}
		if (homNay.isAfter(ngayHetHan)) {
			return "Hết hạn";
		}
		if (homNay.isEqual(ngayHetHan)) {
			return "Hết hạn hôm nay";
		}
		long con = ngayHetHan.toEpochDay()-homNay.toEpochDay();
		return "Còn"+con+"ngày";
	}
	public static void setDemSoLuong(int demSoLuong) {
		HangThucPham.demSoLuong = demSoLuong;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Không thể sao chép HangThucPham!");
	}
	public int compareTo(HangThucPham o) {
		return Integer.compare(this.id, o.id);
	}
	@Override
	public String toString() {
		return String.format("| %-4d | %-10s | %-18s | %-12s | %-12s | %-10.0f |",
				id,maHang,tenHang,ngaySanXuat,ngayHetHan,gia);
	}
}