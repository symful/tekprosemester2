package com.p2p.domain;

public class Loan {
    public enum Status { PENDING, APPROVED, REJECTED, FUNDED }

    private Status status = Status.PENDING;

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public void approve() { this.status = Status.APPROVED; }
    public void reject() { this.status = Status.REJECTED; }
    public void fund() { this.status = Status.FUNDED; }
}