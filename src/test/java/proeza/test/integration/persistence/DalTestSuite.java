package proeza.test.integration.persistence;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import proeza.test.integration.persistence.conad.ConsorcioDalTest;
import proeza.test.integration.persistence.conad.UnidadFuncionalDalTest;
import proeza.test.integration.persistence.core.PersonaDalTest;
import proeza.test.integration.persistence.security.SeguridadDalTest;
import proeza.test.integration.persistence.sgs.NegocioDalTest;
import proeza.test.integration.persistence.system.SistemaDalTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	PersonaDalTest.class,
	ConsorcioDalTest.class,
	UnidadFuncionalDalTest.class,
	NegocioDalTest.class,
	SistemaDalTest.class,
	SeguridadDalTest.class
})
public class DalTestSuite {
}