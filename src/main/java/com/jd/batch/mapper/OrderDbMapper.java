package com.jd.batch.mapper;


import com.jd.batch.domain.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by majinxin1 on 2017/8/27.
 */
public class OrderDbMapper implements RowMapper {
	/**
	 * order表结构映射
	 * @param rs
	 * @param i
	 * @return
	 * @throws SQLException
     */
	@Override
	public Object mapRow(ResultSet rs, int i) throws SQLException {
		Order order = new Order();
        order.setId(rs.getLong("id"));
        order.setOrderNumber(rs.getString("order_number"));
        order.setUid(rs.getLong("uid"));
        order.setPayPrice(rs.getDouble("pay_price"));
        order.setIsPay(rs.getInt("is_pay"));
        order.setPayTime(rs.getDate("pay_time"));
        order.setIsShip(rs.getInt("is_ship"));
        order.setShipTime(rs.getDate("ship_time"));
        order.setIsReceipt(rs.getInt("is_receipt"));
        order.setReceiptTime(rs.getDate("receipt_time"));
        order.setShipNumber(rs.getString("ship_nmber"));
        order.setStatus(rs.getInt("status"));
        order.setCreated(rs.getDate("created"));
        order.setModified(rs.getDate("modified"));
        return order;
	}

}
