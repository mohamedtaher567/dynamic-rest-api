package application.model;

public class RoutesPayload {
	private String servicePath;
	private RouteDefinition[] routesDetails;
	
	public String getServicePath() {
		return servicePath;
	}
	public void setServicePath(String servicePath) {
		this.servicePath = servicePath;
	}
	public RouteDefinition[] getRoutesDetails() {
		return routesDetails;
	}
	public void setRoutesDetails(RouteDefinition[] routesDetails) {
		this.routesDetails = routesDetails;
	}
	
	
}
