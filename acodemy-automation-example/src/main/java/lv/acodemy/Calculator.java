package lv.acodemy;

public class Calculator {

    private String name;
    private String model;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Calculator(String name, String model) {
        this.name = name;
        this.model = model;
    }

    public int sum(int x, int y) {
        return x + y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public int divide(int x, int y) {
        return x / y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }
}
