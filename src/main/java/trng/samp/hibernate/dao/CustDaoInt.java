package trng.samp.hibernate.dao;

import trng.samp.hibernate.pojo.Customers;
import trng.samp.hibernate.pojo.OrderItems;
import trng.samp.hibernate.pojo.Orders;

public interface CustDaoInt {
	
	public boolean addCustomer(Customers cust);
	public boolean deleteCustomerByHql(Long custID);
	public boolean deleteCustomer(Long custID);
	public boolean updateCustomer(Customers cust);
	public Customers loadCustomer(Long custID);

}
