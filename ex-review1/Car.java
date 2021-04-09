public class Car extends Vehicle{
    int numberOfSeat;
    boolean airConditionOn = false;
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
        setNumberOfSeat(numberOfSeat);
    }

    void setNumberOfSeat(int numberOfSeat){
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
    double costFor100Km(PetroleumPrice priceInfo) {
        return  100 * priceInfo.getGasolinePrice() / this.fuelConsumption;
    }

    @Override
    void setAirConON() {
        if(!airConditionOn){
            airConditionOn = true;
            fuelConsumption *= 0.85;
        }

    }

    @Override
    void setAirConOFF() {
        if(airConditionOn){
            airConditionOn = false;
            fuelConsumption /= 0.85;
        }
    }
}
