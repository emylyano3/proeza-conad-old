package proeza.test.integration.persistence;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import proeza.test.integration.persistence.conad.ConsorcioDalTest;
import proeza.test.integration.persistence.conad.CuentaDalTest;
import proeza.test.integration.persistence.conad.ExpensaDalTest;
import proeza.test.integration.persistence.conad.InquilinoDalTest;
import proeza.test.integration.persistence.conad.PagoDalTest;
import proeza.test.integration.persistence.conad.PropietarioDalTest;
import proeza.test.integration.persistence.conad.UnidadFuncionalDalTest;
import proeza.test.integration.persistence.core.PersonaDalTest;
import proeza.test.integration.persistence.security.SeguridadDalTest;
import proeza.test.integration.persistence.sgs.NegocioDalTest;
import proeza.test.integration.persistence.system.SistemaDalTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	PersonaDalTest.class,
	ConsorcioDalTest.class,
	CuentaDalTest.class,
	PagoDalTest.class,
	ExpensaDalTest.class,
	UnidadFuncionalDalTest.class,
	InquilinoDalTest.class,
	PropietarioDalTest.class,
	NegocioDalTest.class,
	SistemaDalTest.class,
	SeguridadDalTest.class
})
public class DalTestSuite {
}