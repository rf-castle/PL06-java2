abstract class Vehicle {
    String modelName;
    String company;
    String owner;
    String engineType;
    int tankSize;
    public abstract String toString();
    abstract String movableDistance();
    abstract String costFor100Km(PetroleumPrice priceInfo);
    abstract void setAirConON();
    abstract void setAirConOFF();
}

class Car extends Vehicle{

    @Override
    public String toString() {
        return null;
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