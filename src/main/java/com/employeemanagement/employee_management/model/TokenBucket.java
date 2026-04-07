package com.employeemanagement.employee_management.model;

public class TokenBucket {

    // variables

    private int token;
    private final int maxToken;
    private final int refillrate;
    private long LastRefillTime;

    // constructor

    public TokenBucket(int maxToken, int refillrate) {

        this.token = token;
        this.maxToken = maxToken;
        this.refillrate = refillrate;
        this.LastRefillTime = System.currentTimeMillis();
    }

    // Token refill based on time

    public void refill() {

        long now = System.currentTimeMillis();
        long timePassed = (now - LastRefillTime) / 1000; // conversion logic

        if (timePassed > 0) {

            int tokensToAdd = (int) (timePassed * refillrate);
            token = Math.min(token + tokensToAdd, maxToken);
            LastRefillTime = now;
        }
    }

    // method to consume token

    public boolean consume() {

        refill();

        if (token > 0) {

            token--;
            return true;
        }
        return false;
    }
}
