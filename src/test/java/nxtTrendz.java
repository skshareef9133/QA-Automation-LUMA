import org.testng.ITestContext;
import org.testng.TestListenerAdapter;
import org.testng.ITestResult;

public class nxtTrendz extends TestListenerAdapter {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("1 Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("2 Test Success: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("3 Test Failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("4 Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("5 Starting Test Suite");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("6 Finishing Test Suite");
    }


}