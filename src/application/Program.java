package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department obj = new Department(1, "Books");

		Seller seller = new Seller(21, "Andre", "andre@gmail.com", new Date(), 3000.00, obj);

		// O programa não conhece a implentação, apenas a interface
		// forma de fazer injeção de dependência sem explicitar a implementação
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println(seller);
	}

}
