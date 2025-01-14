package com.min.edu.ctrl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.dto.EmpDto;
import com.min.edu.dto.ProductInfoDto;
import com.min.edu.dto.StockDto;
import com.min.edu.service.IProductService;
import com.min.edu.service.IStockInService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StockInController {

	private final IStockInService stockInService;
	private final IProductService productService;

//	/stockInAllInfo.do
	@GetMapping("/stockInAllInfo.do") // 전체 조회
	public String stockInAllInfo(Model model, HttpSession session) {
		log.info("StockInController /stockInAllInfo.do GET 요청");
		EmpDto loginDto = (EmpDto) session.getAttribute("emp");
		List<StockDto> lists = stockInService.selectAll();
		model.addAttribute("StockInList", lists);
		return "stockAllInfo";
	}

//	/stockInInfo.do 
	@GetMapping("/stockInInfo.do")
	public String stockInInfo(Model model, int id, HttpSession session) {
		log.info("StockInController stockInInfo.do GET ");
		EmpDto loginDto = (EmpDto) session.getAttribute("emp");
		StockDto stock = stockInService.stockInDetail(id);
		ProductInfoDto product = productService.product_select2(stock.getProduct_id());

		model.addAttribute("stockIn", stock);
		model.addAttribute("product", product);
		return "stockInInfoServlet";
	}

	// stockInServlet.do
	@GetMapping("/stockInServlet.do")
	public String stockInServlet(Model model, HttpSession session) {
		EmpDto loginDto = (EmpDto) session.getAttribute("emp");
		log.info("StockInController stockInServlet.do GET");
		List<ProductInfoDto> lists = productService.product_select();
		model.addAttribute("productList", lists);
		return "stockInServlet";
	}

	@PostMapping("/stockInServlet.do")
	public String stockInInsert(int stock_amount, String product_id, Model model, HttpSession session) {
		EmpDto loginDto = (EmpDto) session.getAttribute("emp");
		int row;
		if (loginDto.getJob().equals("팀장")) {
			StockDto inDto = StockDto.builder().stock_amount(stock_amount).stock_mgr(loginDto.getEmpno())
					.is_accepted("Y").product_id(product_id).build();
			row = stockInService.insert(inDto);
		} else {
			StockDto inDto = StockDto.builder().stock_amount(stock_amount).stock_mgr(loginDto.getEmpno())
					.is_accepted("N").product_id(product_id).build();
			row = stockInService.insert(inDto);
		}
		if (row == 1) {
			return "redirect:/stockInAllInfo.do";
		} else {
			return "redirect:/stockInServlet.do";
		}
//		return "";
	}
	
	// 업데이트 폼
	@GetMapping("/stockInUpdate.do")
	public String stockInUpdateForm(int id, Model model) {
		StockDto dto = stockInService.selectById(id);
		model.addAttribute("stock", dto);
		return "stockInUpdate";
	}

	@PostMapping("/stockInUpdate.do")
	public String stockInUpdate(int id,int amount, Model model) {
		StockDto dto = stockInService.selectById(id);
		dto.setStock_amount(amount);
		int row = stockInService.updateStockInAmount(dto);
		if(row == 1) {
			return "redirect:/stockInInfo.do?id="+id;
		} else {
			return "redirect:/stockInUpdate.do?id="+id;
		}
		
	}
}
