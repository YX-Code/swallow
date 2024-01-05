package cn.yxswallow.common.beetlsql;

import com.zaxxer.hikari.HikariDataSource;
import org.beetl.sql.core.ConnectionSource;
import org.beetl.sql.core.ConnectionSourceHelper;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.SQLManagerBuilder;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.core.page.DefaultPageResult;
import org.beetl.sql.ext.DebugInterceptor;

import javax.sql.DataSource;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static cn.yxswallow.protocols.constants.Database.MYSQL_8_DRIVER_NAME;

public class BeetlSqlHelper {
    
    /**
     * 创建一个新的SQLManager
     *
     * @return
     */
    public static SQLManager init(String jdbcUrl, String userName, String password, String driverClassName, DBStyle dbStyle) {
        DataSource dataSource = datasource(jdbcUrl, userName, password, driverClassName);
        ConnectionSource source = ConnectionSourceHelper.getSingle(dataSource);
        return new SQLManagerBuilder(source)
            .setNc(new UnderlinedNameConversion())
            .setInters(new Interceptor[]{new DebugInterceptor()})
            .setDbStyle(dbStyle)
            .build();
        
    }
    
    public static SQLManager initMySQL(String jdbcUrl, String userName, String password) {
        return init(jdbcUrl, userName, password, MYSQL_8_DRIVER_NAME, new MySqlStyle());
    }
    
    public static DataSource datasource(String jdbcUrl, String userName, String password, String driverClassName) {
        HikariDataSource dataSourceConfig = new HikariDataSource();
        dataSourceConfig.setJdbcUrl(jdbcUrl);
        dataSourceConfig.setUsername(userName);
        dataSourceConfig.setPassword(password);
        dataSourceConfig.setDriverClassName(driverClassName);
        return dataSourceConfig;
    }
    
    
    public static void initTable(DataSource dataSource, String file) {
        initData(dataSource, file);
    }
    
    public static void initData(DataSource ds, String file) {
        Connection conn = null;
        try {
            conn = ds.getConnection();
            String[] sqls = getSqlFromFile(file);
            for (String sql : sqls) {
                runSql(conn, sql);
            }
            
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqlException) {
                //ignore
            }
        }
    }
    
    private static String[] getSqlFromFile(String file) {
        try {
            InputStream ins = BeetlSqlHelper.class.getResourceAsStream(file);
            if (ins == null) {
                throw new IllegalArgumentException("无法加载文件 " + file);
            }
            int len = ins.available();
            byte[] bs = new byte[len];
            ins.read(bs);
            String str = new String(bs, StandardCharsets.UTF_8);
            String[] sql = str.split(";");
            return sql;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        
    }
    
    private static void runSql(Connection conn, String sql) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
    }
    
    public static void printResultSet(ResultSet rs) throws SQLException {
        /*打印列名*/
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        List<String> labels = new ArrayList<>(columnCount);
        for (int i = 1; i <= columnCount; i++) {
            String columnLabel = metaData.getColumnLabel(i);
            labels.add(columnLabel);
        }
        System.out.println(String.join("  |  ", labels));
        /*打印数据*/
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<String> values = new ArrayList<>();
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                int columnType = metaData.getColumnType(i);
                switch (columnType) {
                    case Types.DATE:
                        Date date = rs.getDate(i);
                        if (Objects.isNull(date)) {
                            values.add("null");
                        } else {
                            values.add(formatter.format(
                                date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));
                        }
                        break;
                    case Types.TIMESTAMP:
                        Timestamp timestamp = rs.getTimestamp(i);
                        if (Objects.isNull(timestamp)) {
                            values.add("null");
                        } else {
                            values.add(formatter.format(timestamp.toLocalDateTime()));
                        }
                        break;
                    default:
                        values.add(String.valueOf(rs.getObject(i)));
                        break;
                }
            }
            System.out.println(String.join("  |  ", values));
            values.clear();
        }
    }
    
    public static void printPageResult(DefaultPageResult pageResult) {
        System.out.println(pageResult.getPage());
        System.out.println(pageResult.getPageSize());
        System.out.println(pageResult.getTotalRow());
        System.out.println(pageResult.getTotalPage());
        System.out.println(pageResult.getList());
    }
}
