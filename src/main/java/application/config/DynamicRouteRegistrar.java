package application.config;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import application.model.RouteDefinition;
import application.services.RouteRegistrationService;
import jakarta.annotation.PostConstruct;

@Component
public class DynamicRouteRegistrar {
    
    @Autowired
    private RouteRegistrationService routeRegistrationService;

//    @PostConstruct
//    public void registerRoutes() throws NoSuchMethodException, SecurityException  {
//
//        List<RouteDefinition> routes = loadFromJson();
//
//        for (RouteDefinition route : routes) {
//
//            routeRegistrationService.registerRoute(route);
//
//            System.out.println("Registered: " +
//                    route.getMethod() + " " + route.getPath());
//        }
//
//    }

//	private List<RouteDefinition> loadFromJson() {
//		RouteDefinition route1 = new RouteDefinition();
//		route1.setService("UserService");
//		route1.setAction("getUsers");
//		route1.setMethod("GET");
//		route1.setPath("/users");
//		return Arrays.asList(route1);
//	}
}
