import java.sql.Date;
import java.sql.Timestamp;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import dao.AddressDaoI;
import dao.CustomerDaoI;
import model.Address;
import model.Customer;

public class App {
	
	@Autowired
	private static CustomerDaoI customerDao;
	@Autowired
	private static AddressDaoI addressDao;
	@Autowired
	private static SessionFactory sessionFactory;
    public static void main( String[] args ){
    	AbstractApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
    	customerDao = ac.getBean("customerDao",CustomerDaoI.class);
    	addressDao = ac.getBean("addressDao",AddressDaoI.class);
    	sessionFactory = ac.getBean("sessionFactory",SessionFactory.class);
    	//Session session = sessionFactory.openSession();
    	Customer customer = new Customer();
		Scanner sc = new Scanner(System.in);
		customer.setStore_id(1);
		System.out.println("请输入FirstName(first_name)：");
		customer.setFirst_name(sc.nextLine());
		System.out.println("请输入LastName(last_name)：");
		customer.setLast_name(sc.nextLine());
		System.out.println("请输入Email(email)：");
		customer.setEmail(sc.nextLine());
		System.out.println("请输入AddressID：");
		int address_id = sc.nextInt();
		while(null == addressDao.queryById(address_id)){
			System.out.println("你输入的AddressID不存在，请重新输入：");
			address_id = sc.nextInt();
		}
		customer.setAddress_id(address_id);
		customer.setCreate_date(new Date(System.currentTimeMillis()));
		customer.setLast_update(new Timestamp(System.currentTimeMillis()));
		customerDao.save(customer);
		
		customer = customerDao.query(customer);
		Address address = addressDao.queryById(customer.getAddress_id());
		
		System.out.println("Before save");
		System.out.println("已经保存的数据如下：");
		System.out.println("ID："+customer.getCustomer_id());
		System.out.println("FirstName："+customer.getFirst_name());
		System.out.println("LastName："+customer.getLast_name());
		System.out.println("Email："+customer.getEmail());
		System.out.println("Address："+address.getAddress());
		
		System.out.println("请输入要删除的Customer的ID：");
		
		int delID = sc.nextInt();
		int del = customerDao.delete(delID);
		
		while(del != 1){
			System.out.println("删除失败，请重新输入：");
			delID = sc.nextInt();
			del = customerDao.delete(delID);
		}
		System.out.println("你输入的ID为"+delID+"的Customer已经 删除。");
		sc.close();
    }
}