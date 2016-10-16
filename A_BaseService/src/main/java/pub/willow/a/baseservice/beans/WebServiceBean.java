package pub.willow.a.baseservice.beans;

import pub.willow.a.baseservice.utils.StringUtil;

public class WebServiceBean {
	private String projectName;		//项目名称
	private int port=8080;		//调用端口
	private String ip;		//地址
	private String filterName="service";		//服务过滤名称
	private String serviceName;			//服务名称
	
	@Override
	public String toString() {
		return StringUtil.objToString(this);
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getFilterName() {
		return filterName;
	}
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
}
