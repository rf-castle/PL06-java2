public class PetroleumPrice {
    double gasolinePrice;
    double dieselPrice;
    public PetroleumPrice(double gasolinePrice, double dieselPrice) {
        this.gasolinePrice = gasolinePrice;
        this.dieselPrice = dieselPrice;
    }

    public double getDieselPrice() {
        return dieselPrice;
    }

    public double getGasolinePrice() {
        return gasolinePrice;
    }
}
