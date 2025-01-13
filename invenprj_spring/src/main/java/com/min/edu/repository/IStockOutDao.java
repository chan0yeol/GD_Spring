package com.min.edu.repository;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.ProductInfoDto;
import com.min.edu.dto.StockDto;

public interface IStockOutDao {
	public int insertStockOut(StockDto dto);

	public List<StockDto> selectStockOutAll();
	public List<StockDto> selectStockOutByMgr(int mgr);

	public List<StockDto> selectOutDateRange(Map<String, Object> map);

	public int updateStockOutAmount(StockDto dto);
	public int updateStockOutDelivery(StockDto dto);
	
	// 입출고 재고조회
	public List<StockDto> selectStockInventory();
	
	// 출고수량 순 목록조회
//	public List<StockDto> selectStockAmount();
	public List<ProductInfoDto> selectStockAmount();
	
	// 매출액 순 목록조회
	public List<ProductInfoDto> selectStockSales();
	
	//출고 상세정보
	public StockDto selectStockOutDetail(int stock_id);
}
