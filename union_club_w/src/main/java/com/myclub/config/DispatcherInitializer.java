package com.myclub.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// getRootConfigClasses() 의 경우에는 ContextLoaderListener가 생성한 어플리케이션 컨텍스트를 설정하는데 사용되고
// getServletConfigClasses()의 경우 DispatcherServlet 사용되는 빈들을 등록합니다.

public class DispatcherInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {
            DBConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { DBConfig.class, RepositoriesConfig.class, ServiceConfig.class, WebConfig.class, ControllerConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }


    // https://www.codota.com/code/java/methods/org.springframework.web.filter.CharacterEncodingFilter/setEncoding
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter cef = new CharacterEncodingFilter();
        cef.setEncoding("UTF-8");
        cef.setForceEncoding(true);
        return new Filter[] { cef };
    }
}
