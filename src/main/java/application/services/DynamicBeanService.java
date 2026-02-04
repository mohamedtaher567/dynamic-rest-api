package application.services;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class DynamicBeanService {

    @Autowired
    private ApplicationContext applicationContext;

    public Object loadAndRegisterBean(String classFilePath, String beanName) throws IOException {

        // 1. Load class dynamically
        DynamicClassLoader loader = new DynamicClassLoader();

        Class<?> clazz = loader.loadClassFromFile(classFilePath);

        // 2. Register it as Spring bean
        registerBean(clazz, beanName);

        // 3. Return the created bean instance
        return applicationContext.getBean(beanName);
    }

    private void registerBean(Class<?> clazz, String beanName) {

        BeanDefinitionRegistry registry =
                (BeanDefinitionRegistry) applicationContext.getAutowireCapableBeanFactory();

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(clazz);
        beanDefinition.setScope("singleton");

        registry.registerBeanDefinition(beanName, beanDefinition);
    }
}
