package hibernate.rememberMyName;

import persistance.tp.rememberMyName.RememberMyName;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@Entity
@Table(name = "userTable")
class MyName
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userNum")
	private int num;

	@Column(name = "userField")
	private String name;

	public String getName()
	{
		return name;
	}

	public MyName()
	{
	}

	public MyName(String name)
	{
		this.name = name;
	}
}

public class Hibernate extends RememberMyName
{
	public static final String FIELD = "userField", TABLE = "userTable",
			CONF_FILE = "hibernate/rememberMyName/Hibernate.cfg.xml";

	private static Session getSession() throws HibernateException
	{
		Configuration configuration = new Configuration().configure(CONF_FILE);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);
		return sessionFactory.openSession();
	}

	@Override
	public String getNameFromSupport() throws ReadException
	{
		Session s = getSession();
		Query query = s.createQuery("from MyName");
		@SuppressWarnings("unchecked")
		List<MyName> list = query.list();
		s.close();
		if (list.size() != 0)
		{
			MyName myName = list.get(0);
			return myName.getName();
		}
		else
			throw new ReadException(null);
	}

	@Override
	public void writeNameToSupport(String name) throws WriteException
	{
		Session s = getSession();
		MyName myName = new MyName(name);
		Transaction tx = s.beginTransaction();
		s.save(myName);
		tx.commit();
		s.close();
	}

	public static void main(String[] args)
	{
		RememberMyName rmn = new Hibernate();
		rmn.printName();
	}
}
