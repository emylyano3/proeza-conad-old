package proeza.test.integration.sgs.persistence;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import proeza.test.integration.sgs.persistence.conad.ConsorcioDalTest;
import proeza.test.integration.sgs.persistence.conad.CuentaDalTest;
import proeza.test.integration.sgs.persistence.conad.ExpensaDalTest;
import proeza.test.integration.sgs.persistence.conad.InquilinoDalTest;
import proeza.test.integration.sgs.persistence.conad.PagoDalTest;
import proeza.test.integration.sgs.persistence.conad.PropietarioDalTest;
import proeza.test.integration.sgs.persistence.conad.UnidadFuncionalDalTest;
import proeza.test.integration.sgs.persistence.core.PersonaDalTest;
import proeza.test.integration.sgs.persistence.security.SeguridadDalTest;
import proeza.test.integration.sgs.persistence.sgs.NegocioDalTest;
import proeza.test.integration.sgs.persistence.system.SistemaDalTest;

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