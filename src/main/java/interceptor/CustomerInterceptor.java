package interceptor;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import model.Customer;

public class CustomerInterceptor extends EmptyInterceptor  {

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		if ( entity instanceof Customer ) {
	          System.out.println("Before save");
	          return true; 
	       }
	       return false;
	}
}