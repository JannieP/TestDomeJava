package fakethemometer;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@Import({WeatherForecastService.class})
class Config {

    public static void main(String[] args) {
        SpringApplication.run(Config.class, args);
    }

    @Bean
    public TemperatureMeasurementCallback callback() {
        return (temperature) -> System.out.println(temperature);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public FakeThermometer getThermo() {
        return new FakeThermometer();
    }
}




