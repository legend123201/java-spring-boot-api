package com.example.demo.restfulapi.model.extra;

import java.time.LocalDateTime;

public interface BillForReport {
	Long getbillId();
	 LocalDateTime getdatetime();
	 Long getbillPrice();
	 String getstaffName();
	 String getuserName();
}
