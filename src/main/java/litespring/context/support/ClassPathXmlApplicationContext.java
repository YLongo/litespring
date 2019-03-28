package litespring.context.support;

import litespring.beans.core.io.ClassPathResource;
import litespring.beans.core.io.Resource;
import litespring.beans.factory.support.DefaultBeanFactory;
import litespring.beans.factory.xml.XMLBeanDefinitionReader;
import litespring.context.ApplicationContext;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    DefaultBeanFactory factory;

    public ClassPathXmlApplicationContext(String path) {
        factory = new DefaultBeanFactory();
        XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(factory);
        Resource resource = new ClassPathResource(path);
        reader.loadBeanDefinition(resource);
    }

    @Override
    public Object getBean(String beanId) {
        return factory.getBean(beanId);
    }
}