public class Truck extends Vehicle{
    int numberOfSeat;
    int power;
    boolean airConditionOn = false;
    Truck(
            String modelName,
            String company,
            String owner,
            String engineType,
            double tankSize,
            double fuelConsumption,
            int numberOfSeat,
            int power
    ){
        super(modelName, company, owner, engineType, tankSize, fuelConsumption);
        setNumberOfSeat(numberOfSeat);
        setPower(power);
    }

    @Override
    public String toString() {
        return String.format(
                "%s, NumberOfSeat: %d, HorsePower: %d",
                super.toString(),
                this.numberOfSeat,
                this.power
        );
    }

    public void setNumberOfSeat(int numerOfSeat){
        this.numberOfSeat = numerOfSeat;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    double costFor100Km(PetroleumPrice priceInfo) {
        return  100 * priceInfo.getDieselPrice() / this.fuelConsumption;
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