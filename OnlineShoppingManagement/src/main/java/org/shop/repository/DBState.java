package org.shop.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBState {
	DBconfig config=DBconfig.getInstance();
	protected Connection conn=config.getConn();
	protected PreparedStatement stmt=config.getStatement();
	protected ResultSet rs=config.getResult();
	protected CallableStatement cstmt=config.getCallable();
}
