package cn.yxswallow.protocols;

import cn.yxswallow.protocols.dto.Form;

import java.util.List;

public interface CrudExecuter<T extends Form> extends Executer {
    void doCreate(T t);
    void doDelete(Long id);
    void doUpdate(T t);
    T doRead(Long id);
    List<T> doReadAll();
}
