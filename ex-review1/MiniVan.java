public class MiniVan extends Vehicle{
    int numberOfSeat;
    boolean hasAutoDoor;
    boolean airConditionOn = false;
    MiniVan(
            String modelName,
            String company,
            String owner,
            String engineType,
            double tankSize,
            double fuelConsumption,
            int numberOfSeat,
            boolean hasAutoDoor
    ){
        super(modelName, company, owner, engineType, tankSize, fuelConsumption);
        setNumberOfSeat(numberOfSeat);
        setHasAutoDoor(hasAutoDoor);
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public void setHasAutoDoor(boolean hasAutoDoor){
        this.hasAutoDoor = hasAutoDoor;
    }

    @Override
    public String toString() {
        return String.format(
                "%s, NumberOfSeat: %d, HasAutoDoor: %b",
                super.toString(),
                this.numberOfSeat,
                this.hasAutoDoor
        );
    }

    @Override
    double costFor100Km(PetroleumPrice priceInfo) {
        return switch (this.engineType) {
            case "Gasoline" -> 100 * priceInfo.getGasolinePrice() / this.fuelConsumption;
            case "Diesel" -> 100 * priceInfo.getDieselPrice() / this.fuelConsumption;
            default -> 0.0;
        };
    }

    @Override
    void setAirConON() {
        if(!airConditionOn){
            airConditionOn = true;
            fuelConsumption *= 0.75;
        }

    }

    @Override
    void setAirConOFF() {
        if(airConditionOn){
            airConditionOn = false;
            fuelConsumption /= 0.75;
        }
    }
}

