package com.example.demo.restfulapi.model.extra;

import java.time.LocalDateTime;

public interface ImportOrderForReport {
	Long getimportOrderId();

	LocalDateTime getdatetime();

	Long getimportOrderPrice();

	String getstaffName();
}
