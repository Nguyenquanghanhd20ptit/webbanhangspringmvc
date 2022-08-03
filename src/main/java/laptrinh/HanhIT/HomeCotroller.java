package laptrinh.HanhIT;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.protobuf.Method;

import laptrinh.dao.impl.new_product_dao;
import laptrinh.modell.bill;
import laptrinh.modell.cart;
import laptrinh.modell.catecory;
import laptrinh.modell.menu;
import laptrinh.modell.paginates;
import laptrinh.modell.products;
import laptrinh.modell.slides;
import laptrinh.service.Home_service_interface;
import laptrinh.service.Paginates_interface;
import laptrinh.service.billService_interface;
import laptrinh.service.cart_interface;
import laptrinh.service.category_interface;
import laptrinh.service.user_interface;
import laptrinh.validator.UserValidator;
import laptrinh.validator.billValidator;
import net.bytebuddy.implementation.bind.MethodDelegationBinder.BindingResolver;
import laptrinh.modell.user;

@Controller
public class HomeCotroller {
	@Autowired
	Home_service_interface homeDao;
	@Autowired
	Paginates_interface paginatesDao;
	@Autowired
	category_interface categoryDao;
	@Autowired
	cart_interface cartDao;
	@Autowired
	user_interface userDao;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private billValidator billValidator;
	@Autowired
	billService_interface billDao;

	@RequestMapping(value = { "/", "home" }, method = RequestMethod.GET)
	public String Index(HttpServletRequest request , HttpSession session) {
		session.setAttribute("sessionMenu",1);
		List<slides> slides = homeDao.selectALL_slide();
		List<catecory> categories = homeDao.selectALL_category();
		List<menu> menus = homeDao.selectALL_menu();
		List<products> newProducts = homeDao.selectALL_newProduct();
		List<products> nbProducts = homeDao.selectALL_nbProduct();
		request.setAttribute("slides", slides);
		request.setAttribute("categories", categories);
		request.setAttribute("menus", menus);
		request.setAttribute("newProducts", newProducts);
		request.setAttribute("nbProducts", nbProducts);
		return "home";
	}

	@RequestMapping(value = { "/san_pham/{id}/{currentPage}" }, method = RequestMethod.GET)
	public String category(HttpServletRequest request, @PathVariable(name = "id") int id,
			@PathVariable(name = "currentPage") int currentPage) {
		List<menu> menus = homeDao.selectALL_menu();
		request.setAttribute("menus", menus);
		List<products> products_id = categoryDao.selectALL_byIdPaginates(id);
		paginates paginates = paginatesDao.getInfoPaginates(products_id.size(), 9, currentPage);
		List<products> productsPaginates = categoryDao.getPaginates(id, paginates.getStart(), paginates.getEnd());
		request.setAttribute("productsPaginates", productsPaginates);
		request.setAttribute("paginates", paginates);
		return "category";
	}

	@RequestMapping(value = { "/product/{id}" }, method = RequestMethod.GET)
	public String product(HttpServletRequest request, @PathVariable(name = "id") int id) {
		List<menu> menus = homeDao.selectALL_menu();
		request.setAttribute("menus", menus);
		List<catecory> categories = homeDao.selectALL_category();
		products product = homeDao.selectById_Product(id);
		List<products> productsLq = homeDao.selectALL_Productlq(product.getId_category());
		request.setAttribute("categories", categories);
		request.setAttribute("product", product);
		request.setAttribute("productsLq", productsLq);
		return "product";
	}

	@RequestMapping(value = { "/AddCart/{id}" }, method = RequestMethod.GET)
	public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable(name = "id") int id) {
		HashMap<Integer, cart> cart = (HashMap<Integer, cart>) session.getAttribute("Cart");

		if (cart == null) {
			cart = new HashMap<Integer, cart>();
		}
		cart = cartDao.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartDao.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartDao.totalPrice(cart));
		// tra lai ve dung trang cu
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = { "/listCart" }, method = RequestMethod.GET)
	public String listCart(HttpServletRequest request,HttpSession session) {
		session.setAttribute( "sessionMenu", 3);
		List<menu> menus = homeDao.selectALL_menu();
		request.setAttribute("menus", menus);
		return "cart";
	}

	@RequestMapping(value = { "/EditCart/{id}" }, method = RequestMethod.POST)
	public String EditCart(HttpServletRequest request, HttpSession session, @PathVariable(name = "id") int id) {
		List<menu> menus = homeDao.selectALL_menu();
		request.setAttribute("menus", menus);
		String quanty = request.getParameter("quantyProduct");
		HashMap<Integer, cart> cart = (HashMap<Integer, cart>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Integer, cart>();
		}
		cart = cartDao.EditCart(id, Integer.parseInt(quanty), cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartDao.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartDao.totalPrice(cart));
		return "cart";
	}

	@RequestMapping(value = { "/DeleteCart/{id}" }, method = RequestMethod.GET)
	public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable(name = "id") int id) {
		List<menu> menus = homeDao.selectALL_menu();
		request.setAttribute("menus", menus);
		HashMap<Integer, cart> cart = (HashMap<Integer, cart>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Integer, cart>();
		}
		cart = cartDao.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartDao.totalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartDao.totalPrice(cart));
		return "cart";
	}

	@RequestMapping(value = { "/dangki" }, method = RequestMethod.GET)
	public String dangki(HttpServletRequest request, HttpServletResponse response){
		String status = "Vui Lòng Nhâp Thông Tin";
		request.setAttribute("status", status);
		user user = new user();
		request.setAttribute("user", user);
		return "dangki";
	}

	@RequestMapping(value = { "/dangki" }, method = RequestMethod.POST)
	public String dangkitk(HttpServletRequest request, @ModelAttribute("user") user user, BindingResult bindingResult, HttpServletResponse response) throws UnsupportedEncodingException {
		response.setCharacterEncoding("utf-8");
		String status = "Vui Lòng Nhâp Thông Tin";
		userValidator.validate(user, bindingResult);
		user.setHoten(new String(user.getHoten().getBytes("ISO-8859-1"), "UTF-8"));  
		user.setDiachi(new String(user.getDiachi().getBytes("ISO-8859-1"), "UTF-8")); 
		System.out.print(user.getHoten());
		if (bindingResult.hasErrors()) {
			request.setAttribute("status", status);
			return "dangki";
		}
		String password = user.getPassword();
		System.out.println(password);
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		userDao.insertUser(user);
		status = "Đăng Kí Thành Công";
		user.setPassword(password);
		request.setAttribute("status", status);
		return "dangki";
	}
	@RequestMapping(value = { "/dangnhap" }, method = RequestMethod.GET)
	public String dangnhap(HttpServletRequest request) {
		String tbao = "Vui Lòng Đăng Nhập";
		request.setAttribute("tbao", tbao);
		return "dangnhap";
	}
	@RequestMapping(value = { "/dangnhap" }, method = RequestMethod.POST)
	public String login(HttpServletRequest request,HttpSession session){
		String taikhoan = request.getParameter("taikhoan");
		String matkhau  = request.getParameter("password");
	    user user =	userDao.selecttaikhoan(taikhoan);
	    System.out.println(matkhau);
		boolean check = false;
		if(ObjectUtils.isEmpty(userDao.selecttaikhoan(taikhoan)) == false) {
			if(BCrypt.checkpw(matkhau, user.getPassword())) {
				check  = true;
			}
			else  check  = false;
		}
		else check = false;
		
		if(check == false) {
			String tbao = "Vui Lòng Đăng Nhập";
			String status = "Sai tài khoản hoặc mật khẩu";
			request.setAttribute("tbao", tbao);
			request.setAttribute("status", status);
			return "dangnhap";
		}
		else {
			session.setAttribute("loginInfor", user);
			return "redirect: /hanhIT/";
		}
	}
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String dangnhap2(HttpServletRequest request, HttpSession session) {
		String taikhoan = request.getParameter("taikhoan");
		String matkhau  = request.getParameter("password");
	    user user =	userDao.selecttaikhoan(taikhoan);
	    System.out.println(matkhau);
		boolean check = false;
		if(ObjectUtils.isEmpty(userDao.selecttaikhoan(taikhoan)) == false) {
			if(BCrypt.checkpw(matkhau, user.getPassword())) {
				check  = true;
			}
			else  check  = false;
		}
		else check = false;
		
		if(check == false) {
			String status = "Sai tài khoản hoặc mật khẩu";
			session.setAttribute("tbao", status);
			return "redirect:" + request.getHeader("Referer");
		}
		else {
			session.setAttribute("loginInfor", user);
			return "redirect:" + request.getHeader("Referer");
		}
	}
	@RequestMapping(value = { "/dangxuat" }, method = RequestMethod.GET)
	public String dangxuat(HttpServletRequest request,HttpSession session) {
		session.setAttribute("loginInfor", null);
		return "redirect:" + request.getHeader("Referer");
	}
	@RequestMapping(value = { "/checkout" }, method = RequestMethod.GET)
	public String checkout(HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("loginInfor") == null) {
			String tbao = "Vui Lòng Đăng Nhập Trước Khi Thanh Toán";
			request.setAttribute("tbao", tbao);
			return "dangnhap";
		}
		else {
			String status = "Thông Tin Thanh Toán";
			request.setAttribute("status",status);
			user user =  (user) session.getAttribute("loginInfor");
			request.setAttribute("user", user);
			return "checkout";
		}
	}
	@RequestMapping(value = { "/checkout" }, method = RequestMethod.POST)
	public String checkout1(HttpServletRequest request,HttpSession session,
			@ModelAttribute("user") user user,  BindingResult bindingResult ) throws UnsupportedEncodingException {
		billValidator.validate(user, bindingResult);
		user.setHoten(new String(user.getHoten().getBytes("ISO-8859-1"), "UTF-8"));  
		user.setDiachi(new String(user.getDiachi().getBytes("ISO-8859-1"), "UTF-8")); 
		if(bindingResult.hasErrors()) {
			String status = "Thông Tin Thanh Toán";
			request.setAttribute("status",status);
			return "checkout";
		}
		double totalPrice = (double) session.getAttribute("TotalPriceCart");
		int quanty = (int) session.getAttribute("TotalQuantyCart");
		 String ghichu = request.getParameter("ghichu");
		 ghichu = new String(ghichu.getBytes("ISO-8859-1"), "UTF-8");
		 String status = "Đặt Hàng Thành Công";
		 request.setAttribute("status",status);
		bill bill = new bill();
		bill.setHoten(user.getHoten());
		bill.setEmail(user.getEmail());
		bill.setDiachi(user.getDiachi());
		bill.setSdt(user.getSdt());
		bill.setTotalPrice(totalPrice);
		bill.setQuanty(quanty);
		bill.setGhichu(ghichu);
		billDao.AddBills(bill);
		HashMap<Integer, cart> carts  = (HashMap<Integer, cart>) session.getAttribute("Cart");
		billDao.AddBilldetail(carts);
	    return "checkout";
	}
}
