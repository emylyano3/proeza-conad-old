package proeza.test.integration.persistence;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import proeza.test.integration.persistence.security.SeguridadDalTest;
import proeza.test.integration.persistence.sgs.NegocioDalTest;
import proeza.test.integration.persistence.system.SistemaDalTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    NegocioDalTest.class,
    SistemaDalTest.class,
    SeguridadDalTest.class
})
public class DalTestSuite {
}