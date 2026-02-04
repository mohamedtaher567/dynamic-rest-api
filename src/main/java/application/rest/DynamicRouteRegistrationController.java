package application.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import application.model.RouteDefinition;
import application.model.RoutesPayload;
import application.services.DynamicBeanService;
import application.services.RouteRegistrationService;
import application.utils.Utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class DynamicRouteRegistrationController {

    @Autowired
    private RouteRegistrationService routeRegistrationService;
    
    @Autowired
    private DynamicBeanService dynamicBeanService;

    @PostMapping("/registerRoutes")
    public ResponseEntity<?> registerRoutes(@RequestBody RoutesPayload payload) throws IOException {
    	String classPath = payload.getServicePath();
    	String serviceName = Utils.extractServiceName(classPath);
    	dynamicBeanService.loadAndRegisterBean(classPath, serviceName);
    	Arrays.asList(payload.getRoutesDetails()).forEach(route -> {    		
    		try {
				routeRegistrationService.registerRoute(route, serviceName);
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
    	});

        return ResponseEntity.ok("Routes registered successfully: " + serviceName);
    }

}
