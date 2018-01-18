import org.testng.annotations.Test;

public class TestNgTests {

    @Test(enabled = false)
    public void runMyTest() {
        System.out.println("run!");
    }

    @Test(enabled = true)
    public void runMyTestGo() {
        System.out.println("run!");
    }
}
