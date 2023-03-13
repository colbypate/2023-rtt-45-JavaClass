package hibernate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

//@RunWith(JUnitPlatform.class)
//@SuiteDisplayName("JUnit 5 Test Suite") // Optional
//@SelectPackages("hibernate")
public class CustomerDAOTest {

	private static CustomerDAO customerDao;

	@BeforeAll
	public static void setUp() {
		customerDao = new CustomerDAO();
	}

	@Test
	public void findByIdTest() {


		// given
		Customer expected = new Customer();
		expected.setCustomerName("Atelier graphique");
		expected.setContactFirstname("Carine");
		expected.setContactLastname("Schmitt");

		// when
		Customer actual = customerDao.findById(103);

		// then
		Assertions.assertEquals(expected.getCustomerName(), actual.getCustomerName());
		Assertions.assertEquals(expected.getContactFirstname(), actual.getContactFirstname());
		Assertions.assertEquals(expected.getContactLastname(), actual.getContactLastname());

		
	}
	
	@ParameterizedTest
	@CsvSource({
		"103,Atelier graphique,Carine,Schmitt",
		"112,Signal Gift Stores,Jean,King"
		})
	public void findByIdParameterizedTest(ArgumentsAccessor args) {


		// given
		Customer expected = new Customer();
		expected.setCustomerName(args.getString(1));
		expected.setContactFirstname(args.getString(2));
		expected.setContactLastname(args.getString(3));

		// when
		Customer actual = customerDao.findById(args.getInteger(0));

		// then
		Assertions.assertEquals(expected.getCustomerName(), actual.getCustomerName());
		Assertions.assertEquals(expected.getContactFirstname(), actual.getContactFirstname());
		Assertions.assertEquals(expected.getContactLastname(), actual.getContactLastname());

		
	}
}
