package clases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CuentaTestIngresar.class, CuentaTestRetirar.class })
public class AllTests {

}
