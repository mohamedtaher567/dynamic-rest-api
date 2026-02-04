package application.services;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import application.config.DynamicInvoker;
import application.model.RouteDefinition;

@Service
public class RouteRegistrationService {

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    @Autowired
    private ApplicationContext context;
    
	public void registerRoute(RouteDefinition route, String service) throws NoSuchMethodException, SecurityException {
		Object bean = context.getBean(service);

        Method serviceMethod = bean.getClass()
                .getMethod(route.getAction());

        DynamicInvoker invoker =
                new DynamicInvoker(bean, serviceMethod);

        Method wrapperMethod = DynamicInvoker.class
                .getMethod("invoke");

        RequestMappingInfo info = RequestMappingInfo
                .paths(route.getPath())
                .methods(RequestMethod.valueOf(route.getMethod()))
                .build();

        handlerMapping.registerMapping(info, invoker, wrapperMethod);		
	}

}
