package manytomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import util.HibernateUtil;

public class App {
  public static void main(String args[])
  {  System.out.println("starting");
	  Session ss = HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction();
       Stock s=new Stock();
     
       s.setStockCode("aa1");
       s.setStockName("nifty");
       Category c=new Category("aaa","bbb");
       Category c1=new Category("aaaaaa", "raja");
       Set<Category> categories =new HashSet<Category>();
        categories.add(c);
        categories.add(c1);
        s.setCategories(categories);
        ss.save(s);
        ss.getTransaction().commit();
        System.out.println("completed!");
         
	  
  }
}
