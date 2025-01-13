package com.min.edu.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.ProductInfoDto;
import com.min.edu.dto.StockDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class StockOutDaoImpl implements IStockOutDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.min.edu.repository.StockOutDaoImpl.";
	
	@Override
	public int insertStockOut(StockDto dto) {
		return sqlSession.insert(NS+"insertStockOut",dto);
	}

	@Override
	public List<StockDto> selectStockOutAll() {
		return sqlSession.selectList(NS+"selectStockOutAll");
	}

	@Override
	public List<StockDto> selectOutDateRange(Map<String, Object> map) {
		return sqlSession.selectList(NS+"selectOutDateRange",map);
	}

	@Override
	public List<StockDto> selectStockOutByMgr(int i) {
		return sqlSession.selectList(NS+"selectStockOutByMgr",i);
	}

	@Override
	public int updateStockOutAmount(StockDto dto) {
		return sqlSession.update(NS+"updateStockOutAmount",dto);
	}

	@Override
	public int updateStockOutDelivery(StockDto dto) {
		return sqlSession.update(NS+"updateStockOutDelivery",dto);
	}

	@Override
	public List<StockDto> selectStockInventory() {
		return sqlSession.selectList(NS+"selectStockInventory");
	}

	@Override
	public List<ProductInfoDto> selectStockAmount() {
		return sqlSession.selectList(NS+"selectStockAmount");
		
	}

	@Override
	public List<ProductInfoDto> selectStockSales() {
		return sqlSession.selectList(NS+"selectStockSales");
	}

	@Override
	public StockDto selectStockOutDetail(int stock_id) {
		return sqlSession.selectOne(NS+"stockOutDetail",stock_id);
	}

}
