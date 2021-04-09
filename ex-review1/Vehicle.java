abstract class Vehicle {
    String modelName;
    String company;
    String owner;
    String engineType;
    double tankSize;
    double fuelConsumption;
    Vehicle(
            String modelName,
            String company,
            String owner,
            String engineType,
            double tankSize,
            double fuelConsumption
    ){
        this.modelName = modelName;
        this.company = company;
        this.owner = owner;
        this.engineType = engineType;
        this.tankSize = tankSize;
        this.fuelConsumption = fuelConsumption;
    }
    public String toString(){
        return String.format(
                "ModelName: %s, Company: %s, Owner: %s, EngineType:%s, " +
                        "TankSize: %.2f, FuelConsumption: %.2f",
                modelName,
                company,
                owner,
                engineType,
                tankSize,
                fuelConsumption
        );
    }
    double movableDistance(){
        return this.tankSize * this.fuelConsumption;
    }
    abstract double costFor100Km(PetroleumPrice priceInfo);
    abstract void setAirConON();
    abstract void setAirConOFF();
}

