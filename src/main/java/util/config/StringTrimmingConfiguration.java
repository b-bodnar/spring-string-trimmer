package util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import util.bpp.TrimmedAnnotationBeanPostProcessor;

@Configuration
public class StringTrimmingConfiguration {

    @Bean
    public TrimmedAnnotationBeanPostProcessor trimmedAnnotationBeanPostProcessor() {
        return new TrimmedAnnotationBeanPostProcessor();
    }
}
