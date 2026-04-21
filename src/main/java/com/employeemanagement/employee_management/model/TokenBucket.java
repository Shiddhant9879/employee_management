package com.employeemanagement.employee_management.model;

public class TokenBucket {

    private int token;
    private final int maxToken;
    private final int refillrate;
    private long lastRefillTime;

    public TokenBucket(int maxToken, int refillrate) {

        this.maxToken = maxToken;
        this.refillrate = refillrate;
        this.token = maxToken; // 🔥 FIX: start full
        this.lastRefillTime = System.currentTimeMillis();
    }

    public void refill() {

        long now = System.currentTimeMillis();
        long timePassed = (now - lastRefillTime) / 1000;

        if (timePassed > 0) {
            int tokensToAdd = (int) (timePassed * refillrate);
            token = Math.min(maxToken, token + tokensToAdd);
            lastRefillTime = now;
        }
    }

    public boolean consume() {

        refill();

        if (token > 0) {
            token--;
            return true;
        }
        return false;
    }
}