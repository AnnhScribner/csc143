import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    //-----------------------------------------------------------------------------------
    //                         HAPPY PATH TESTS
    //-----------------------------------------------------------------------------------

    @Test
    void constructorAndGets() {
        // ARRANGE
        // ACT
        // ASSERT

        // instantiating the class and storing the reference to it
        BankAccount testAccount = new BankAccount("Joe", "123456", 350.00);
        assertEquals("Joe", testAccount.getOwner());
        assertEquals("123456", testAccount.getAccountId());
        // floating points are stored as approximation, so we need three parameter
        // the third one is basically "how far away is close enough"
        // in this case, it's by a penny
        assertEquals(350.00, testAccount.getBalance(), 0.001);

    }

    @Test
    void setOwner() {
        // ARRANGE
        // ACT
        // ASSERT

        BankAccount testAccount = new BankAccount("Joe", "123456", 350.00);
        testAccount.setOwner("Anna");
        assertEquals("Anna", testAccount.getOwner());
    }

    @Test
    void depositAndWithdraw() {
        // ARRANGE
        // ACT
        // ASSERT
        BankAccount testAccount = new BankAccount("Joe", "123456", 350.00);
        assertEquals(350.00 + 123.45, testAccount.deposit(123.45), 0.001);
        assertEquals(350.00 + 123.45, testAccount.getBalance(), 0.001);
        assertEquals(350.00 + 123.45 - 49.27, testAccount.withdraw(49.27), 0.001);
        assertEquals(350.00 + 123.45 - 49.27, testAccount.getBalance(), 0.001);
    }

    @Test
    void testToString() {
        // make sure it is not empty ot the Java default
        BankAccount testAccount = new BankAccount("Joe", "123456", 350.00);
        assertFalse(testAccount.toString().isEmpty()); // testing if it is not an empty string
        // TODO : test not Java default (BankAccount@34245)
    }

    //-----------------------------------------------------------------------------------
    //                         EXCEPTION TESTS
    //-----------------------------------------------------------------------------------
    @Test
    void constructorPreconditions() {
        // Arrange
        // Act
        // Assert

        // I don't need to save the reference because it is supose to blow up anyway
        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount("XXX XXX", null, 999.99));

        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount("XXX XXX", "XXXXXXX", -0.01));

        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount(null, "XXXXXXX", 999.99));

        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount("", "XXXXXXX", 999.99));


    }
}