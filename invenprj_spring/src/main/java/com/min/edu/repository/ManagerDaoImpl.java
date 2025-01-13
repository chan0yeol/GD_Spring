package com.min.edu.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.ProductInfoDto;
import com.min.edu.dto.StockDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ManagerDaoImpl implements IManagerDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS ="com.min.edu.repository.ManagerDaoImpl.";
	@Override
	public List<ProductInfoDto> selectProductList() {
		return sqlSession.selectList(NS+"selectProductList");
	}

	@Override
	public int updateProductRequest(ProductInfoDto dto) {
		return sqlSession.update(NS+"updateProductRequest", dto);
	}

	@Override
	public List<StockDto> selectStockInList() {
		return sqlSession.selectList(NS+"selectStockInList");
	}

	@Override
	public int updateStockInRequest(StockDto dto) {
		return sqlSession.update(NS+"updateStockInRequest",dto);
	}

	@Override
	public List<StockDto> selectStockOutList() {
		return sqlSession.selectList(NS+"selectStockOutList");
	}

	@Override
	public int updateStockOutRequest(StockDto dto) {
		return sqlSession.update(NS+"updateStockRequest",dto);
	}

	@Override
	public StockDto findByStockId(String id) {
		return sqlSession.selectOne(NS+"findByStockId",id);
	}

}
