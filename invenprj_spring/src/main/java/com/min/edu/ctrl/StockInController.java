package com.min.edu.ctrl;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.min.edu.dto.StockDto;
import com.min.edu.service.IStockInService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StockInController {
	
	private final IStockInService service;
	
//	/stockInAllInfo.do
	@GetMapping("/stockInAllInfo.do") // 전체 조회
	public String stockInAllInfo(Model model) {
		log.info("StockInController /stockInAllInfo.do GET 요청");
		List<StockDto> lists = service.selectAll();
		model.addAttribute("StockInList",lists);
		return "stockInAllInfo";
	}
	
//	/stockInInfo.do 
	@GetMapping("/stockInInfo.do")
	public String stockInInfo(Model model, int id) {
		log.info("StockInController stockInInfo.do GET "); 
		StockDto stock = service.stockInDetail(id);
		
		model.addAttribute("stockIn", stock);
		return "stockInInfo";
	}
}
