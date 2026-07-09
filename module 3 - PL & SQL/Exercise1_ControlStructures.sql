-- Exercise 1: Control Structures
-- This PL/SQL block determines an employee's bonus eligibility and award level
-- based on their years of service.

SET SERVEROUTPUT ON;

DECLARE
    v_hire_date DATE := TO_DATE('2018-05-15', 'YYYY-MM-DD');
    v_years_of_service NUMBER;
    v_bonus_level VARCHAR2(20);
    v_current_date DATE := SYSDATE;
BEGIN
    -- Calculate years of service
    v_years_of_service := TRUNC(MONTHS_BETWEEN(v_current_date, v_hire_date) / 12);

    -- Determine bonus level using IF-ELSIF-ELSE
    IF v_years_of_service >= 5 THEN
        v_bonus_level := 'Gold';
    ELSIF v_years_of_service >= 2 THEN
        v_bonus_level := 'Silver';
    ELSE
        v_bonus_level := 'Bronze';
    END IF;

    DBMS_OUTPUT.PUT_LINE('Employee with hire date ' || TO_CHAR(v_hire_date, 'YYYY-MM-DD') || ' has ' || v_years_of_service || ' years of service.');
    DBMS_OUTPUT.PUT_LINE('Bonus Level: ' || v_bonus_level);

    -- Use a simple LOOP to print a confirmation message
    FOR i IN 1..3 LOOP
        DBMS_OUTPUT.PUT_LINE('Processing bonus check ' || i || ' for level ' || v_bonus_level);
    END LOOP;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END;
/
