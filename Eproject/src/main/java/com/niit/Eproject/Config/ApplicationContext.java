package com.niit.Eproject.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Eproject.Dao.AuthenticationDao;
import com.niit.Eproject.Dao.BillingDao;
import com.niit.Eproject.Dao.CardDao;
import com.niit.Eproject.Dao.CartDao;
import com.niit.Eproject.Dao.CartItemsDao;
import com.niit.Eproject.Dao.CategoryDao;
import com.niit.Eproject.Dao.OrderDao;
import com.niit.Eproject.Dao.OrderItemsDao;
import com.niit.Eproject.Dao.PayDao;
import com.niit.Eproject.Dao.ProductDao;
import com.niit.Eproject.Dao.ShippingDao;
import com.niit.Eproject.Dao.SupplierDao;
import com.niit.Eproject.Dao.UserDao;
import com.niit.Eproject.DaoImpl.AuthenticationDaoImpl;
import com.niit.Eproject.DaoImpl.BillingDaoImpl;
import com.niit.Eproject.DaoImpl.CardDaoImpl;
import com.niit.Eproject.DaoImpl.CartDaoImpl;
import com.niit.Eproject.DaoImpl.CartItemsDaoImpl;
import com.niit.Eproject.DaoImpl.CategoryDaoImpl;
import com.niit.Eproject.DaoImpl.OrderDaoImpl;
import com.niit.Eproject.DaoImpl.OrderItemsDaoImpl;
import com.niit.Eproject.DaoImpl.PayDaoImpl;
import com.niit.Eproject.DaoImpl.ProductDaoImpl;
import com.niit.Eproject.DaoImpl.ShippingDaoImpl;
import com.niit.Eproject.DaoImpl.SuppplierDaoImpl;
import com.niit.Eproject.DaoImpl.UserDaoImpl;
import com.niit.Eproject.Model.Authentication;
import com.niit.Eproject.Model.Billing;
import com.niit.Eproject.Model.Card;
import com.niit.Eproject.Model.Cart;
import com.niit.Eproject.Model.CartItems;
import com.niit.Eproject.Model.Category;
import com.niit.Eproject.Model.Order;
import com.niit.Eproject.Model.OrderItems;
import com.niit.Eproject.Model.Pay;
import com.niit.Eproject.Model.Product;
import com.niit.Eproject.Model.Shipping;
import com.niit.Eproject.Model.Supplier;
import com.niit.Eproject.Model.User;


@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContext 
{

	@Bean("dataSource")
	public DataSource getDataSource() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/eproj");
		dataSource.setUsername("admin");
		dataSource.setPassword("password");

		// Properties connectionProperties=new Properties();
		// connectionProperties.setProperty("hibernate.show_sql", "true");
		// connectionProperties.setProperty("hibernate.dialect",
		// "org.hibernate.dialect");
		return dataSource;
	}

	private Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}

	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) 
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Billing.class);
		sessionBuilder.addAnnotatedClass(Card.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(OrderItems.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(CartItems.class);
		sessionBuilder.addAnnotatedClass(Order.class);
		sessionBuilder.addAnnotatedClass(Pay.class);
	sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Shipping.class);

	return sessionBuilder.buildSessionFactory();
	}

	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		System.out.println("printing session factory here : "+sessionFactory);
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("printing transactionManager factory here : "+transactionManager);
		return transactionManager;
	}



   	@Autowired
   	@Bean("categoryDao")
   	public CategoryDao getCategoryDao(SessionFactory sessionFactory) 
   	{
   		return new CategoryDaoImpl(sessionFactory);
   	}
     
  	@Autowired
   	@Bean("productDao")
  	public ProductDao getProductDao(SessionFactory sessionFactory) 
   	{
  		return new ProductDaoImpl(sessionFactory);
  	}
  	
  	@Autowired
  	@Bean("supplierDao")
   	public SupplierDao getSupplierDao(SessionFactory sessionFactory) 
   	{
   		return new SuppplierDaoImpl(sessionFactory);
   	}
 
	@Autowired
  	@Bean("usersDao")
   	public UserDao getUsersDao(SessionFactory sessionFactory) 
  	{
   		return new UserDaoImpl(sessionFactory);
 	}

 	@Autowired
	@Bean("authenticationDao")
  	public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) 
   	{
  		return new AuthenticationDaoImpl(sessionFactory);
  	}
 
	@Autowired
	@Bean("billingDao")
	public BillingDao getbillingAddressDao(SessionFactory sessionFactory) {
		return new BillingDaoImpl(sessionFactory);
	}
	
  @Autowired
	@Bean("orderitemsDao")
public OrderItemsDao getorderitemsDao(SessionFactory sessionFactory) 
    {
    return new OrderItemsDaoImpl(sessionFactory);
}
    

	
	@Autowired
	@Bean("payDao")
	public PayDao getPaymentDao(SessionFactory sessionFactory) 
	{
	return new PayDaoImpl(sessionFactory);
	}
	
    @Autowired
	@Bean("shippingDao")
	public ShippingDao getshippingAddressDao(SessionFactory sessionFactory)
	{
		return new ShippingDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("cardDao")
	public CardDao getcardDao(SessionFactory sessionFactory) 
	{
		return new CardDaoImpl(sessionFactory);

	}
	
    @Autowired
    @Bean("orderDao")
	public OrderDao getorderDao(SessionFactory sessionFactory)
    {
	return new OrderDaoImpl(sessionFactory);
	}

    
	@Autowired
	@Bean("cartDao")
	public CartDao getCartItemDao(SessionFactory sessionFactory) 
	{
		return new CartDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("cartItemsDao")
	public CartItemsDao getCartItemsDao(SessionFactory sessionFactory)
	{
		return new CartItemsDaoImpl(sessionFactory);
	}
	
	
	
}

	
	
