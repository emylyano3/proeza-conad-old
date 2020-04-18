package proeza.test.unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import proeza.test.unit.service.ServiceUnitTestSuite;
import proeza.test.unit.settings.SettingsTest;
import proeza.test.unit.sgs.controller.ControllerTestSuite;
import proeza.test.unit.sgs.rest.RestControllerTestSuite;
import proeza.test.unit.util.DateUtilTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ControllerTestSuite.class,
    RestControllerTestSuite.class,
    ServiceUnitTestSuite.class,
    SettingsTest.class,
    DateUtilTest.class
})
public class UnitTestSuite {
}