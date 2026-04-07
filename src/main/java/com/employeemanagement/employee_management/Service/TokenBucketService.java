package com.employeemanagement.employee_management.Service;

import com.employeemanagement.employee_management.model.TokenBucket;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenBucketService {

    private final int MAX_TOKENS = 5;
    private final int REFILL_RATE = 1; // tokens per second

    // 🔥 Stores buckets per user
    private final ConcurrentHashMap<String, TokenBucket> buckets = new ConcurrentHashMap<>();

    // 🎯 Main method to check request
    public boolean allowRequest(String userId) {

        // 1. Create bucket if not exists
        buckets.putIfAbsent(userId, new TokenBucket(MAX_TOKENS, REFILL_RATE));

        // 2. Get user's bucket
        TokenBucket bucket = buckets.get(userId);

        // 3. Try consuming token
        return bucket.consume();
    }
}