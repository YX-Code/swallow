package cn.yxswallow.protocols.dto.response;

/**
 * 增删改时的通用返回结果，返回影响行数
 *
 * @author yaoxing
 */
public class RowResponse extends Response {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 请求返回数据
     */
    private int rows;
    
    public int getRows() {
        return rows;
    }
    
    public void setRows(int rows) {
        this.rows = rows;
    }
    
    public static RowResponse row(int rows) {
        RowResponse response = new RowResponse();
        response.setSuccess(true);
        response.setRows(rows);
        return response;
    }
    
}
