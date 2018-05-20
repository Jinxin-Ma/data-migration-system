package com.jd.batch.writer;

import com.jd.batch.domain.Order;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.List;


/**
 * @author majinxin1
 */
public class DelDataItem implements ItemWriter<Order> ,InitializingBean {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private String tableName;
    private int status ;


    /**
     * 执行sql写操作
     * @param list
     * @throws Exception
     */
    @Override
    public void write(List<? extends Order> list) throws Exception {
        if (CollectionUtils.isEmpty(list)){
            return;
        }
        String sql;
        for (Order order : list){
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
     * @param id
     * @return
     */
    private String buildUpdateSql(Long id) {
        if (StringUtils.isEmpty(tableName)){
            throw new IllegalArgumentException("MarkDataToArchive.buildUpdateSql error.tableName can not be null.");
        }
        StringBuffer sql = new StringBuffer();
        sql.append("delete from ");
        sql.append(tableName);
        sql.append("where ");
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
