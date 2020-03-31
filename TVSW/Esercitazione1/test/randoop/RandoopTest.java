package randoop;
import junit.framework.*;
import junit.textui.*;

public class RandoopTest extends TestCase {

  public static void main(String[] args) {
    TestRunner runner = new TestRunner();
    TestResult result = runner.doRun(suite(), false);
    if (! result.wasSuccessful()) {
      System.exit(1);
    }
  }

  public RandoopTest(String name) {
    super(name);
  }

  public static Test suite() {
    TestSuite result = new TestSuite();
    result.addTest(new TestSuite(RandoopTest0.class));
    result.addTest(new TestSuite(RandoopTest1.class));
    result.addTest(new TestSuite(RandoopTest2.class));
    result.addTest(new TestSuite(RandoopTest3.class));
    result.addTest(new TestSuite(RandoopTest4.class));
    result.addTest(new TestSuite(RandoopTest5.class));
    result.addTest(new TestSuite(RandoopTest6.class));
    result.addTest(new TestSuite(RandoopTest7.class));
    result.addTest(new TestSuite(RandoopTest8.class));
    result.addTest(new TestSuite(RandoopTest9.class));
    result.addTest(new TestSuite(RandoopTest10.class));
    result.addTest(new TestSuite(RandoopTest11.class));
    result.addTest(new TestSuite(RandoopTest12.class));
    result.addTest(new TestSuite(RandoopTest13.class));
    result.addTest(new TestSuite(RandoopTest14.class));
    result.addTest(new TestSuite(RandoopTest15.class));
    result.addTest(new TestSuite(RandoopTest16.class));
    result.addTest(new TestSuite(RandoopTest17.class));
    result.addTest(new TestSuite(RandoopTest18.class));
    result.addTest(new TestSuite(RandoopTest19.class));
    result.addTest(new TestSuite(RandoopTest20.class));
    result.addTest(new TestSuite(RandoopTest21.class));
    result.addTest(new TestSuite(RandoopTest22.class));
    result.addTest(new TestSuite(RandoopTest23.class));
    return result;
  }

}
