package com.jd.batch.writer;

import com.jd.batch.domain.Order;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.List;


/**
 * Created by majinxin1 on 2017/8/27.
 */
public class ArchiveMarkData implements ItemWriter<Order> ,InitializingBean {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private String tableName;
    private int status ;


    /**
     * 执行sql写操作,先将数据迁移到新表当中，再将数据标记为已迁移
     * 事物保证迁移成功后再标记
     * @param list
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void write(List<? extends Order> list) throws Exception {
        if (CollectionUtils.isEmpty(list)){
            return;
        }
        String sql;
        for (Order order : list){
            sql = buildInsertSql(order);
            jdbcTemplate.update(sql);
            sql = buildUpdateSql(order.getId());
            jdbcTemplate.update(sql);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null){
            throw new IllegalArgumentException("dataSource can not be null.");
        }
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     *  构建sql语句
     * @param order
     * @return
     */
    private String buildInsertSql(Order order) {
        if (StringUtils.isEmpty(tableName)){
            throw new IllegalArgumentException("tableName can not be null.");
        }
        StringBuffer sql = new StringBuffer();
        sql.append("insert into ");
        sql.append(tableName);
        sql.append("(");
        sql.append(this.buildColum());
        sql.append(")");
        sql.append("values");
        sql.append("(");
        sql.append(this.buildColum());
        sql.append(")");
        System.out.println(sql.toString());
        return sql.toString();
    }

    private String buildColum(){
        StringBuffer colum = new StringBuffer();
        colum.append("id");
        colum.append(",order_number");
        colum.append(",uid");
        colum.append(",pay_price");
        colum.append(",is_pay");
        colum.append(",pay_time");
        colum.append(",is_ship");
        colum.append(",ship_time");
        colum.append(",is_receipt");
        colum.append(",receipt_time");
        colum.append(",ship_nmber");
        colum.append(",status");
        colum.append(",created");
        colum.append(",modified");
        return colum.toString();
    }

    private String buildValues(Order order){
        StringBuffer values = new StringBuffer();
        values.append(order.getId());
        values.append(",");
        values.append(order.getOrderNumber());
        values.append(",");
        values.append(order.getUid());
        values.append(",");
        values.append(order.getPayPrice());
        values.append(",");
        values.append(order.getIsPay());
        values.append(",");
        values.append(order.getPayTime());
        values.append(",");
        values.append(order.getIsShip());
        values.append(",");
        values.append(order.getShipTime());
        values.append(",");
        values.append(order.getIsReceipt());
        values.append(",");
        values.append(order.getReceiptTime());
        values.append(",");
        values.append(order.getShipNumber());
        values.append(",");
        values.append(order.getStatus());
        values.append(",");
        values.append(order.getCreated());
        values.append(",");
        values.append("now()");
        return values.toString();
    }

    private String buildUpdateSql(Long id) {
        if (StringUtils.isEmpty(tableName)){
            throw new IllegalArgumentException("tableName can not be null.");
        }
        StringBuffer sql = new StringBuffer();
        sql.append("update ");
        sql.append(tableName);
        sql.append(" set status = ");
        sql.append(",modified = now()");
        sql.append(status);
        sql.append(" where ");
        sql.append("id");
        sql.append(" = ");
        sql.append(id);
        System.out.println(sql.toString());
        return sql.toString();
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
