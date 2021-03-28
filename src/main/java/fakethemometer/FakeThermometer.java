package fakethemometer;

import org.springframework.stereotype.Component;

//@Scope("prototype")
@Component
class FakeThermometer implements Thermometer {

    private int currentTemperature = 21;

    @Override
    public int measure() { return currentTemperature++; }
}
