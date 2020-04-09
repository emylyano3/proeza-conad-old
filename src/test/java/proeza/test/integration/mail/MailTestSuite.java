package proeza.test.integration.mail;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Ignore
@RunWith(Suite.class)
@Suite.SuiteClasses({
	MailSenderTest.class,
	MailServiceTest.class
})
public class MailTestSuite {
}