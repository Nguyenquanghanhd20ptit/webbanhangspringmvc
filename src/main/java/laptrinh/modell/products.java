package laptrinh.modell;

import java.sql.Date;

public class products {
		private int id_product;
		private int id_category;
		private String size;
		private String ten;
		private double price;
		private double sale;
		private String title;
		private boolean highlight;
		private boolean new_product;
		private String detail;
		private int id_color;
		private String name_color;
		private String code_color;
		private String img;
		private Date date_create;
		private Date date_update;
		
		public products(int id_product, int id_category, String size, String ten, double price, double sale,
				String title, boolean highlight, boolean new_product, String detail, int id_color, String name_color,
				String code_color, String img, Date date_create, Date date_update) {
			super();
			this.id_product = id_product;
			this.id_category = id_category;
			this.size = size;
			this.ten = ten;
			this.price = price;
			this.sale = sale;
			this.title = title;
			this.highlight = highlight;
			this.new_product = new_product;
			this.detail = detail;
			this.id_color = id_color;
			this.name_color = name_color;
			this.code_color = code_color;
			this.img = img;
			this.date_create = date_create;
			this.date_update = date_update;
		}
		
		public products() {
			super();
		}

		public int getId_product() {
			return id_product;
		}
		public void setId_product(int id_product) {
			this.id_product = id_product;
		}
		public int getId_category() {
			return id_category;
		}
		public void setId_category(int id_category) {
			this.id_category = id_category;
		}
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
	    
		public String getTen() {
			return ten;
		}
		public void setTen(String ten) {
			this.ten = ten;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public double getSale() {
			return sale;
		}
		public void setSale(double sale) {
			this.sale = sale;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public boolean isHighlight() {
			return highlight;
		}
		public void setHighlight(boolean highlight) {
			this.highlight = highlight;
		}
		public boolean isNew_product() {
			return new_product;
		}
		public void setNew_product(boolean new_product) {
			this.new_product = new_product;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		public int getId_color() {
			return id_color;
		}
		public void setId_color(int id_color) {
			this.id_color = id_color;
		}
		public String getName_color() {
			return name_color;
		}
		public void setName_color(String name_color) {
			this.name_color = name_color;
		}
		public String getCode_color() {
			return code_color;
		}
		public void setCode_color(String code_color) {
			this.code_color = code_color;
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
		public Date getDate_create() {
			return date_create;
		}
		public void setDate_create(Date date_create) {
			this.date_create = date_create;
		}
		public Date getDate_update() {
			return date_update;
		}
		public void setDate_update(Date date_update) {
			this.date_update = date_update;
		}
		
}
