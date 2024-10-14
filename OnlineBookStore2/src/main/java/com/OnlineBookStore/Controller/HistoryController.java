package com.OnlineBookStore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HistoryController {	
	
	@RequestMapping("/history")
	public String getHistory() {
		return "history";
	}
	
//	@RequestMapping(value = "/order")
//	public String getOrders() {
//		return "order"; 
//	}
}
