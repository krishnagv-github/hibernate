package trng.samp.hibernate.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import trng.samp.hibernate.dao.*;
import trng.samp.hibernate.pojo.*;
import trng.samp.hibernate.utils.*;

public class CustomerApp {

	static Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void addCustomer() throws IOException {
		System.out.println("Please enter the details");
		System.out.println("Please enter the first name");
		String fName = br.readLine();
		System.out.println("Please enter the middle name");
		String mName = br.readLine();
		System.out.println("Please enter the last name");
		String lName = br.readLine();
		System.out.println("Please enter the email");
		String email = br.readLine();
		System.out.println("Please enter the company");
		String company = br.readLine();
		System.out.println("Please enter the address");
		String address = br.readLine();
		System.out.println("Please enter the zip code");
		int zipCode = sc.nextInt();
		System.out.println("Please enter the city");
		String city = br.readLine();
		System.out.println("Please enter the state");
		String state = br.readLine();

		Customers cust = new Customers(fName, mName, lName, email, company, address, zipCode, city, state);

		CustDaoImpl cdi = new CustDaoImpl();
		cdi.addCustomer(cust);
	}

	public void deleteCustomer() {

		System.out.println("Please enter the id of the Customer you wish to delete.");
		Long custId = sc.nextLong();
		CustDaoImpl cdi = new CustDaoImpl();
		cdi.deleteCustomerByHql(custId);
	}

	public void loadCustomer() {
		System.out.println("Please enter the id of the Customer you wish to view.");
		Long custId = sc.nextLong();
		CustDaoImpl cdi = new CustDaoImpl();
		cdi.loadCustomer(custId);
	}

	public void updateCustomer() throws IOException {
		System.out.println("Please enter the id of the customer you wish to update.");
		Long custID = sc.nextLong();
		System.out.println("Please enter the details");
		System.out.println("Please enter the first name");
		String fName = br.readLine();
		System.out.println("Please enter the middle name");
		String mName = br.readLine();
		System.out.println("Please enter the last name");
		String lName = br.readLine();
		System.out.println("Please enter the email");
		String email = br.readLine();
		System.out.println("Please enter the company");
		String company = br.readLine();
		System.out.println("Please enter the address");
		String address = br.readLine();
		System.out.println("Please enter the zip code");
		int zipCode = sc.nextInt();
		System.out.println("Please enter the city");
		String city = br.readLine();
		System.out.println("Please enter the state");
		String state = br.readLine();

		Customers cust = new Customers(custID, fName, mName, lName, email, company, address, zipCode, city, state);

		CustDaoImpl cdi = new CustDaoImpl();
		cdi.updateCustomer(cust);
	}

	public void getList() {
		System.out.println("Please enter the Zip Code by which you wish to display the customers.");
		int zipCode = sc.nextInt();
		CustDaoImpl cdi = new CustDaoImpl();
		List<Customers> cList = new ArrayList<Customers>();
		cList = cdi.getZipCustomers(zipCode);
		System.out.println(cList);
	}

	public static int displayOptions() {
		System.out.println("Please enter the option you wish to select");
		System.out.println("1) for adding a Customer");
		System.out.println("2) for viewing a Customer by their ID");
		System.out.println("3) for updating a Customer details");
		System.out.println("4) for deleting a Customer by ID");
		System.out.println("5) for displaying the list of customers by zip code");
		int temp = sc.nextInt();
		return temp;
	}

	public static void main(String[] args) throws IOException {

		CustomerApp cApp = new CustomerApp();
		while (true) {
			switch (displayOptions()) {
			case 1:
				cApp.addCustomer();
				break;
			case 2:
				cApp.loadCustomer();
				break;
			case 3:
				cApp.updateCustomer();
				break;
			case 4:
				cApp.deleteCustomer();
				break;
			case 5:
				cApp.getList();
				break;
			}

		}

	}

}
