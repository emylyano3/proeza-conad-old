package proeza.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import proeza.test.integration.sgs.SGSIntegrationTestSuite;
import proeza.test.unit.UnitTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    UnitTestSuite.class,
    SGSIntegrationTestSuite.class
})
public class ApplicationTestSuite {
}