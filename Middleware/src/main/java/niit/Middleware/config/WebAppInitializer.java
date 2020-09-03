package niit.Middleware.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import niit.Middleware.filter.CorsFilter;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer 
{
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RestConfig.class};

	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}

	protected Filter[] getServletFilters() {
		Filter[] singleton =  { (Filter) new CorsFilter() };
		return singleton;
		}


}
