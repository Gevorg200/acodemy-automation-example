import lv.acodemy.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    Calculator casio = new Calculator("Casio", "X1X");

    @Test
    public void testSum() {
        Assert.assertEquals(casio.sum(10, 5), 15);
    }

    @Test
    public void testSubtract() {
        Assert.assertEquals(casio.subtract(10, 5), 5);
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(casio.divide(10, 5), 2);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(casio.multiply(10, 5), 50);
    }

    @Test
    public void testSetters() {
        casio.setModel("Model");
        casio.setName("Name");

        Assert.assertEquals(casio.getModel(), "Model");
        Assert.assertEquals(casio.getName(), "Name");
    }
}
