package com.example.demo.restfulapi.model.extra;

import java.time.LocalDateTime;

//must have "get" word if you are going to use this interface for @Query
public interface UserBills {
	Long getbillId();
	LocalDateTime getdatetime();
	Long getstaffId();
	Long gettotal();
	Integer getisApproved();
}
