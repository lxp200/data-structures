public class Car {
    String makeModel;
    double engineSizeL;
    int prodYear;

    Car(String makeModel, double engineSizeL, int prodYear) {
        this.makeModel = makeModel;
        this.engineSizeL = engineSizeL;
        this.prodYear = prodYear;
    }

    public String getMakeModel() {
        return this.makeModel;
    }

    public int getProdYear() {
        return this.prodYear;
    }

    @Override
    public String toString() {
        return "Car { " +
                "makeModel = '" + makeModel + '\'' +
                ", engineSizeL = " + engineSizeL +
                ", prodYear = " + prodYear +
                " }";
    }
}
