package sk.fei.stuba.zadanie3;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@EnableWebMvc
public class DateConfiguration implements WebMvcConfigurer {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //noinspection Convert2Lambda
        registry.addConverter(new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String dateTimeString) {
                return LocalDateTime.parse(dateTimeString, formatter);
            }
        });
    }
}