package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("===== TEST 01: seller findById =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n===== TEST 02: seller findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);

		System.out.println("\n===== TEST 03: seller findByAll =====");
		list = sellerDao.findAll();
		list.forEach(System.out::println);

		System.out.println("\n===== TEST 04: seller insert =====");
		Seller newSeller = new Seller(null, "Marco", "marco@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println("\n===== TEST 05: seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Gold Roger");
		sellerDao.update(seller);
		System.out.println("Update completed!");
	}

}
