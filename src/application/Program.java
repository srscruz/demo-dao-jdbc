package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSallerDao();
		Seller seller = sellerDao.findById(9);
		System.out.println("=== Test 1 : Seller FindById ===");
		System.out.println(seller);

		System.out.println("\n=== Test 2 : Seller FindByDepartment ===");

		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== Test 3 : Seller FindAllBy ===");

		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n=== Test 4 : Seller Insert ===");
		Seller newSeller = new Seller(null, "Patricia Santos", "paty.santos@gmail.com",new Date(), 3000.0, department );
		sellerDao.insert(newSeller);
		System.out.println("Inserted new Seller, new Id:" + newSeller.getId());

		System.out.println("\n=== Test 5 : Seller Update ===");
		seller = sellerDao.findById(16);
		seller.setName("Joice Cruz");
		sellerDao.update(seller);
		System.out.println("Updated complete!");
		
		System.out.println("\n=== Test 6 : Seller Delete ===");
		System.out.println("Entre com o Id:");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Exclusão realizada com o sucesso!");
		sc.close();
	}
}	
