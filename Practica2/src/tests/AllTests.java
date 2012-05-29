package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCirculo.class, TestCriteriosSeleccion.class,
		TestPunto.class, TestRectangulo.class, TestSeleccionables.class })
public class AllTests {

}
