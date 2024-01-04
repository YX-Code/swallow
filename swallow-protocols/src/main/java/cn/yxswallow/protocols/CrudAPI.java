package cn.yxswallow.protocols;

import cn.yxswallow.protocols.dto.Form;
import cn.yxswallow.protocols.dto.response.MultiResponse;
import cn.yxswallow.protocols.dto.response.Response;
import cn.yxswallow.protocols.dto.response.SingleResponse;

public interface CrudAPI<T extends Form> extends API{
    Response create(T t);
    Response delete(Long id);
    Response update(T t);
    SingleResponse<T> read(Long id);
    MultiResponse<T> readAll();
}
