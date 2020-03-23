package com.hp.dao;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface ItempDao {
	
	public boolean insertTempDate(List<Object> data);
	
	public boolean insertTempDateBatch(List<String> data);
	
	public Temp queryTemp();
}