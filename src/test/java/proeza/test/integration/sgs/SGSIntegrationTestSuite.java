package proeza.test.integration.sgs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import proeza.test.integration.sgs.mail.MailTestSuite;
import proeza.test.integration.sgs.persistence.DalTestSuite;
import proeza.test.integration.sgs.persistence.conad.ConsorcioDalTest;
import proeza.test.integration.sgs.tracking.TrackingTest;
import proeza.test.integration.sgs.web.rest.ArticuloRestTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    DalTestSuite.class,
    MailTestSuite.class,
    TrackingTest.class,
    ArticuloRestTest.class,
    ConsorcioDalTest.class
})
public class SGSIntegrationTestSuite {
}