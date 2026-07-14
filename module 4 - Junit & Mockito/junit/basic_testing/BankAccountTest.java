package junit.basic_testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account; // Test fixture

    @BeforeEach
    void setUp() {
        // Arrange: Initialize a fresh account before each test
        account = new BankAccount(100.0);
        System.out.println("Setting up a new BankAccount with initial balance: " + account.getBalance());
    }

    @AfterEach
    void tearDown() {
        // Teardown: Clean up resources after each test (optional for simple objects)
        account = null; // Dereference the object
        System.out.println("Tearing down BankAccount.");
    }

    @Test
    void testDeposit() {
        // Arrange (already done in @BeforeEach)
        double depositAmount = 50.0;
        double expectedBalance = 150.0;

        // Act
        account.deposit(depositAmount);

        // Assert
        assertEquals(expectedBalance, account.getBalance(), "Balance after deposit should be " + expectedBalance);
        System.out.println("Test Deposit: Balance is " + account.getBalance());
    }

    @Test
    void testWithdraw() {
        // Arrange (already done in @BeforeEach)
        double withdrawAmount = 30.0;
        double expectedBalance = 70.0;

        // Act
        account.withdraw(withdrawAmount);

        // Assert
        assertEquals(expectedBalance, account.getBalance(), "Balance after withdrawal should be " + expectedBalance);
        System.out.println("Test Withdraw: Balance is " + account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        // Arrange (already done in @BeforeEach)
        double withdrawAmount = 200.0; // More than initial 100

        // Act & Assert
        // Expect an exception for insufficient funds
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(withdrawAmount);
        });
        assertEquals("Insufficient funds.", exception.getMessage());
        System.out.println("Test Withdraw Insufficient Funds: Caught expected exception.");
    }
}
