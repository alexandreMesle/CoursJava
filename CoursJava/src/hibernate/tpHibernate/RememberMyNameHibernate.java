package hibernate.tpHibernate;

import persistance.RememberMyName;

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
import org.hibernate.cfg.AnnotationConfiguration;

@Entity
@Table(name="userTable")
class MyName
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userNum")
	private int num;
	
	@Column(name="userField")
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

public class RememberMyNameHibernate extends RememberMyName
{
	public static final String FIELD = "userField",
			TABLE = "userTable",
			CONF_FILE = "hibernate/tpHibernate/hibernateRememberMyName.cfg.xml";

	private static Session getSession() throws HibernateException
	{
		SessionFactory sf = null;
			sf = new AnnotationConfiguration().
					configure(CONF_FILE).buildSessionFactory();
		return sf.openSession();
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
		RememberMyName rmn = new RememberMyNameHibernate();
		rmn.printName();
	}
}
