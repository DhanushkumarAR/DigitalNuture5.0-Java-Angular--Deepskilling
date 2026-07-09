-- Exercise 3: Stored Procedures
-- This script creates a stored procedure to deactivate customer accounts
-- that have not had any activity in a specified number of years.

-- First, let's imagine a simple CUSTOMERS table.
-- We will assume it has the following structure:
-- CREATE TABLE Customers (
--     customer_id NUMBER PRIMARY KEY,
--     customer_name VARCHAR2(100),
--     last_login_date DATE,
--     is_active CHAR(1) -- 'Y' for active, 'N' for inactive
-- );

CREATE OR REPLACE PROCEDURE DeactivateInactiveCustomers (
    p_years_inactive IN NUMBER
)
IS
    v_cutoff_date DATE;
    v_deactivated_count NUMBER := 0;
BEGIN
    -- Determine the cutoff date for inactivity
    v_cutoff_date := ADD_MONTHS(SYSDATE, -12 * p_years_inactive);

    -- Update the status of customers who have been inactive since the cutoff date
    -- and are still marked as active.
    UPDATE Customers
    SET is_active = 'N'
    WHERE last_login_date < v_cutoff_date
      AND is_active = 'Y';

    -- Get the number of rows affected
    v_deactivated_count := SQL%ROWCOUNT;

    -- Output a summary of the operation
    DBMS_OUTPUT.PUT_LINE('Deactivation process complete.');
    DBMS_OUTPUT.PUT_LINE('Cutoff date for inactivity: ' || TO_CHAR(v_cutoff_date, 'YYYY-MM-DD'));
    DBMS_OUTPUT.PUT_LINE('Number of customers deactivated: ' || v_deactivated_count);

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error occurred during deactivation: ' || SQLERRM);
        ROLLBACK; -- Rollback any changes if an error occurs
END DeactivateInactiveCustomers;
/

-- Example of how to execute the stored procedure:
-- SET SERVEROUTPUT ON;
-- BEGIN
--     -- Deactivate customers who have been inactive for more than 3 years
--     DeactivateInactiveCustomers(p_years_inactive => 3);
-- END;
-- /
