import org.junit.Before;
import org.junit.Test;

import Accounts.Account;
import Accounts.Critic;
import Accounts.User;

import static org.junit.Assert.*;

public class AccountTests {
	Account testAccount;
	Critic criticAccount;

	String testEmail = "abd@gmail.com";
	String testPassword = "123Test123.";
	
	@Before
	public void setUp() throws Exception {
		testAccount = new User(testEmail, testPassword);
		criticAccount = new Critic(testEmail, testPassword, "Official critic");
	}
	
	@Test
	public void setEmailTest() {
		assertThrows(IllegalArgumentException.class, () -> testAccount.setEmail(""));
		assertThrows(IllegalArgumentException.class, () -> testAccount.setEmail("   "));
		assertThrows(IllegalArgumentException.class, () -> testAccount.setEmail(null));
	}

	@Test
	public void setPasswordTest() {
		assertThrows(IllegalArgumentException.class, () -> testAccount.setPassword(""));
		assertThrows(IllegalArgumentException.class, () -> testAccount.setPassword("   "));
		assertThrows(IllegalArgumentException.class, () -> testAccount.setPassword(null));

		// no change in password if invalid password
		testAccount.setPassword("012345678");
		assertEquals(testPassword, testAccount.getPassword());
		// no uppercase
		testAccount.setPassword("asdfdasdaf");
		assertEquals(testPassword, testAccount.getPassword());
		// no lowercase
		testAccount.setPassword("ASDFA123@DAD");
		assertEquals(testPassword, testAccount.getPassword());
		// no number
		testAccount.setPassword("ASDASDfasfda#");
		assertEquals(testPassword, testAccount.getPassword());
		// no special symbols
		testAccount.setPassword("0123asdASDW");
		assertEquals(testPassword, testAccount.getPassword());
		// less than 8 symbols
		testAccount.setPassword("13dD.@");
		assertEquals(testPassword, testAccount.getPassword());
		// white space not allowed
		testAccount.setPassword("13dD. 1ASDd@");
		assertEquals(testPassword, testAccount.getPassword());

		testAccount.setPassword("0123asdASDW@");
		assertNotEquals(testPassword, testAccount.getPassword());
	}

	@Test
	public void setCredentials() {
		assertThrows(IllegalArgumentException.class, () -> criticAccount.setCredentials(""));
		assertThrows(IllegalArgumentException.class, () -> criticAccount.setCredentials("   "));
		assertThrows(IllegalArgumentException.class, () -> criticAccount.setCredentials(null));

		String newCredentials = "New credentials";
		criticAccount.setCredentials(newCredentials);
        assertEquals(newCredentials, criticAccount.getCredentials());
	}
}
