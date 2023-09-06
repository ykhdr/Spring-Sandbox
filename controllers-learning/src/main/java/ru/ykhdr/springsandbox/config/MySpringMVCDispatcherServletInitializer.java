package ru.ykhdr.springsandbox.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // локация спринг конфигурации
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {MySpringConfig.class};
    }

    // url pattern
    @NotNull
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/hello-world"};
    }
}
