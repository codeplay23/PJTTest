package com.model2.mvc.common;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.lf5.Log4JLogRecord;

public class ListTypeHandler extends BaseTypeHandler<List<String>> {

	public ListTypeHandler() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public List<String> getNullableResult(ResultSet rs, String columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		String str = rs.getString(columnIndex);
		System.out.println(str);
		
		if(str != null) {
		List<String> files = new ArrayList<String>();
		String[] strArr = str.split(",");
		for(String file : strArr) {
			files.add(file);
		}
		System.out.println(files);
		
		return files;
		} else {
			return null;
		}
	}

	@Override
	public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		String str = rs.getString(columnIndex);
		
		if(str != null) {
			List<String> files = new ArrayList<String>();
			String[] strArr = str.split(",");
			for(String file : strArr) {
				files.add(file);
			}
			System.out.println(files);
			
			return files;
			} else {
				return null;
			}
	}

	@Override
	public List<String> getNullableResult(CallableStatement cStmt, int parameterIndex) throws SQLException {
		// TODO Auto-generated method stub
		String str = cStmt.getString(parameterIndex);
		
		if(str != null) {
			List<String> files = new ArrayList<String>();
			String[] strArr = str.split(",");
			for(String file : strArr) {
				files.add(file);
			}
			System.out.println(files);
			
			return files;
			} else {
				return null;
			}
	}
	
	
	@Override
	public void setNonNullParameter(PreparedStatement pStmt, int i, List<String> parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
		//fileName�� �Ķ���͸� List�� casting
		System.out.println("===========================================");
		System.out.println("setNonNullParameter : pStmt = "+pStmt+", i = "+i+", parameter = "+parameter);
		StringBuffer buffer = new StringBuffer(parameter.toString());
		System.out.println("String buffer : "+buffer.toString());
		
		pStmt.setString(i, buffer.substring(1, buffer.length()-1));
		System.out.println("===========================================");
	}
//
	@Override
	public void setParameter(PreparedStatement pStmt, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("===========================================");
		System.out.println("setNonNullParameter : pStmt = "+pStmt+", i = "+i+", parameter = "+parameter);
		if(parameter != null) {
		StringBuffer buffer = new StringBuffer(parameter.toString());
		System.out.println("String buffer : "+buffer.toString());
		
		super.setParameter(pStmt, i, parameter, jdbcType);
		pStmt.setString(i, buffer.substring(1, buffer.length()-1));
		} else {
			super.setParameter(pStmt, i, parameter, jdbcType);
			pStmt.setString(i, null);
		}
		System.out.println("===========================================");
	}


}
