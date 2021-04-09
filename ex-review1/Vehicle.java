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
                        "TankSize:%.2f, FuelConsumption:%.2f",
                modelName,
                company,
                owner,
                engineType,
                tankSize,
                fuelConsumption
        );
    };
    abstract String movableDistance();
    abstract String costFor100Km(PetroleumPrice priceInfo);
    abstract void setAirConON();
    abstract void setAirConOFF();
}

class Car extends Vehicle{
    int numberOfSeat;
    Car(
            String modelName,
            String company,
            String owner,
            String engineType,
            double tankSize,
            double fuelConsumption,
            int numberOfSeat
    ){
        super(modelName, company, owner, engineType, tankSize, fuelConsumption);
        this.numberOfSeat = numberOfSeat;
    }

    @Override
    public String toString() {
        return String.format(
                "%s, NumberOfSeat: %d",
                super.toString(),
                this.numberOfSeat
        );
    }

    @Override
    String movableDistance() {
        return null;
    }

    @Override
    String costFor100Km(PetroleumPrice priceInfo) {
        return null;
    }

    @Override
    void setAirConON() {

    }

    @Override
    void setAirConOFF() {

    }
}


class MiniVan extends Vehicle{

}