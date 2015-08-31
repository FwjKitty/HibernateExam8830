package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("-------interceptor()-------");
		Map session = invocation.getInvocationContext().getSession();
		if(session.get("un") != null){
			return invocation.invoke();
		}else{
			return "login";
		}
	}
}