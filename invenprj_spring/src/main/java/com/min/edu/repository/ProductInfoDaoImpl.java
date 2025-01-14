package com.min.edu.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.min.edu.dto.ProductInfoDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductInfoDaoImpl implements IProductDao {
	private final SqlSessionTemplate session;
	private final String NS = "com.min.edu.repository.ProductInfoDaoImpl.";
	@Override
	public int product_insert(ProductInfoDto dao) {
		
		return session.insert(NS+"product_insert",dao);
	}

	@Override
	public int product_insert2(ProductInfoDto dao) {
		return session.insert(NS+"product_insert2",dao);
	}

	@Override
	public List<ProductInfoDto> product_select() {
		return session.selectList(NS+"product_select");
	}

	@Override
	public ProductInfoDto product_select2(String string) {
		// TODO Auto-generated method stub
		return session.selectOne(NS+"product_select2",string);
	}

	@Override
	public List<ProductInfoDto> product_select3(String string) {
		return session.selectList(NS+"product_select3",string);
	}

	@Override
	public List<ProductInfoDto> product_select4(String string) {
		return session.selectList(NS+"product_select4",string);
	}

}
