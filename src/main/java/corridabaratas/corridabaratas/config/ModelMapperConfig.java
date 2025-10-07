package corridabaratas.corridabaratas.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();

        Converter<Integer, String> intToString = new Converter<>(){
            public String convert(MappingContext<Integer, String> ctx){
                Integer s = ctx.getSource();
                return s == null ? null : s.toString();
            }
        };
        Converter<String, Integer> stringToInt = new Converter<>(){
            public Integer convert(MappingContext<String, Integer> ctx){
                String s = ctx.getSource();
                return (s == null) ? null : Integer.parseInt(s);
            }
        };

        Converter<Date, LocalDateTime> dateToLocalDateTime = new Converter<>(){
            public LocalDateTime convert(MappingContext<Date, LocalDateTime> ctx){
                Date d = ctx.getSource();
                return d == null ? null : LocalDateTime.ofInstant(Instant.ofEpochMilli(d.getTime()), ZoneId.systemDefault());
            }
        };

        Converter<LocalDateTime, Date> localDateTimeToDate = new Converter<>(){
            public Date convert(MappingContext<LocalDateTime, Date> ctx){
                LocalDateTime l = ctx.getSource();
                return l == null ? null : Date.from(l.atZone(ZoneId.systemDefault()).toInstant());
            }
        };

        mapper.addConverter(intToString);
        mapper.addConverter(stringToInt);
        mapper.addConverter(dateToLocalDateTime);
        mapper.addConverter(localDateTimeToDate);

        return mapper;
    }
}
