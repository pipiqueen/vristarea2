package daoImpl;

public class EcommerceDAOFactory {
	
	public EcommerceDAOJDBCImpl createEcommerceDAO(){
		return new EcommerceDAOJDBCImpl();
	}

}
