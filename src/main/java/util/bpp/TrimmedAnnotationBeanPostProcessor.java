package util.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import util.annotation.Trimmed;

public class TrimmedAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> type = bean.getClass();
        if (type.isAnnotationPresent(Trimmed.class)) {
            var enhancer = new Enhancer();
            enhancer.setSuperclass(type);
            enhancer.setInterfaces(type.getInterfaces());
            MethodInterceptor interceptor = (object, method, args, methodProxy) -> {
                for (int i = 0; i < args.length; i++) {
                    if (args[i].getClass() == String.class) {
                        args[i] = ((String) args[i]).trim();
                    }
                }
                var response = methodProxy.invokeSuper(object, args);
                if (response != null && response.getClass() == String.class) {
                    return ((String) response).trim();
                }
                return response;
            };
            enhancer.setCallback(interceptor);
            return type.cast(enhancer.create());
        }
        return bean;
    }
}
