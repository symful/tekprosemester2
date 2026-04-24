package com.p2p.service;

import static org.junit.jupiter.api.Assertions.*;

import com.p2p.domain.*;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanServiceTest {
    private static final Logger logger = LogManager.getLogger(LoanServiceTest.class);

    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {
        logger.info("TC-01: Testing unverified borrower rejection");
        Borrower borrower = new Borrower(false, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> loanService.createLoan(borrower, amount)
        );

        assertEquals("Borrower not verified", exception.getMessage());
    }

    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {
        logger.info("TC-02: Testing amount validation (zero/negative)");
        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.ZERO);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.valueOf(-100));
        });
    }

    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {
        logger.info("TC-03: Testing high credit score approval");
        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);
        Loan loan = loanService.createLoan(borrower, amount);

        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    @Test
    void shouldRejectLoanWhenCreditScoreLow() {
        logger.info("TC-04: Testing low credit score rejection");
        Borrower borrower = new Borrower(true, 500);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);
        Loan loan = loanService.createLoan(borrower, amount);

        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }
}
