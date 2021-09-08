package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.model.User;

public class LoginDaoImpl implements LoginDao {

	@Override
	public User createUser(User user) {
		 StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("com/config/hibernate.cfg.xml").build();  
	        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
	          
	        SessionFactory factory=meta.getSessionFactoryBuilder().build();  
	        Session session=factory.openSession();  
	          
	        Transaction t=session.beginTransaction();    
	        User user1 = new User(user.getUserId(),user.getUserName(),user.getPassword());
	        user=user1;
	        session.save(user1);
	        t.commit();
		return user;
	}

	@Override
	public User readUser(User user) {
		 StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("com/config/hibernate.cfg.xml").build();  
	        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
	          
	        SessionFactory factory=meta.getSessionFactoryBuilder().build();  
	        Session session=factory.openSession();  
	        User details = null;
	        details = session.load(User.class, user.getUserId());
		return details;
	}

	@Override
	public User updateUser(User user) {
		 StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("com/config/hibernate.cfg.xml").build(); 
		 //System.out.println("dao in update"+user.getUserName());
	        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
	          
	        SessionFactory factory=meta.getSessionFactoryBuilder().build();  
	        Session session=factory.openSession();  
	       
	        User details = session.get(User.class,user.getUserId());
	       
	        details.setUserName(user.getUserName());
	        	
	        Transaction transaction = session.beginTransaction();
	        session.update(details);
	        session.getTransaction();
	        transaction.commit();
	        //System.out.println(details.getUserName());
	       
		return details;
	}

	@Override
	public User deleteUser(User user) {
		 StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("com/config/hibernate.cfg.xml").build();  
	        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
	          
	        SessionFactory factory=meta.getSessionFactoryBuilder().build();  
	        Session session=factory.openSession();  
	        User details=session.get(User.class,user.getUserId());
	        if(details!=null)
	        {
	        	Transaction transaction = session.beginTransaction();
	        	session.delete(details);
	        	transaction.commit();
	        }
	        user = details;
	        return user;
	}

}
