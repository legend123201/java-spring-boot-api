package com.example.demo.restfulapi.model.extra;

import java.time.LocalDateTime;

// must have "get" word if you are going to use this interface for @Query
public interface BillAndPrice {
	 Long getbillId();
	 LocalDateTime getdatetime();
	 Long getbillPrice();
}
