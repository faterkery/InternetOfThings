package com.tyloo.fw.dao;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

public class TransactionSupport {
    public static void rollback() {
        TransactionStatus status = TransactionAspectSupport
                .currentTransactionStatus();
        if (null == status) {
            throw new IllegalStateException(
                    "Rollback must be called in transaction context.");
        }
        status.setRollbackOnly();
    }
}
