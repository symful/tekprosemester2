package com.p2p.service;

import com.p2p.domain.*;
import java.math.BigDecimal;

public class FundingService {
    public void fundLoan(Lender lender, Loan loan, BigDecimal amount) {
        if (loan.getStatus() != Loan.Status.APPROVED) {
            throw new IllegalArgumentException("Loan must be approved");
        }
        if (!lender.canFundLoan()) {
            throw new IllegalArgumentException("Lender cannot fund");
        }
        loan.fund();
    }
}