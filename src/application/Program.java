package application;



import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		SellerDao sellerDao = DaoFactory.createSallerDao();
		Seller seller = sellerDao.findById(9);
		
		System.out.println(seller);

	}

}
