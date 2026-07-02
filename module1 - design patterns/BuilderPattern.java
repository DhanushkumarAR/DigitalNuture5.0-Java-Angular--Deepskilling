// BuilderPattern.java

// Product class
class Car {
    private String engine;
    private int wheels;
    private int airbags;

    public Car(String engine, int wheels, int airbags) {
        this.engine = engine;
        this.wheels = wheels;
        this.airbags = airbags;
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", wheels=" + wheels + ", airbags=" + airbags + "]";
    }
}

// Builder interface
interface CarBuilder {
    CarBuilder setEngine(String engine);
    CarBuilder setWheels(int wheels);
    CarBuilder setAirbags(int airbags);
    Car build();
}

// Concrete Builder
class CarBuilderImpl implements CarBuilder {
    private String engine;
    private int wheels;
    private int airbags;

    @Override
    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public CarBuilder setWheels(int wheels) {
        this.wheels = wheels;
        return this;
    }

    @Override
    public CarBuilder setAirbags(int airbags) {
        this.airbags = airbags;
        return this;
    }

    @Override
    public Car build() {
        return new Car(engine, wheels, airbags);
    }
}

// Director
class CarDirector {
    public Car constructSportsCar(CarBuilder builder) {
        return builder.setEngine("V8").setWheels(4).setAirbags(2).build();
    }
}


public class BuilderPattern {
    public static void main(String[] args) {
        CarBuilder builder = new CarBuilderImpl();
        CarDirector director = new CarDirector();

        Car sportsCar = director.constructSportsCar(builder);
        System.out.println("Sports Car built: " + sportsCar);

        Car manualCar = builder.setEngine("V4").setWheels(4).setAirbags(4).build();
        System.out.println("Manual Car built: " + manualCar);
    }
}
