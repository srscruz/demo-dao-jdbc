package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSallerDao();
		Seller seller = sellerDao.findById(9);
		System.out.println("=== Test 1 : FindById ===");
		System.out.println(seller);

		System.out.println("\n=== Test 2 : Seller FindByDepartment ===");

		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
	}
}
