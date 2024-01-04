package cn.yxswallow.protocols;

import cn.yxswallow.protocols.dto.request.Command;

public interface CommandExecuter<E extends Command> extends Executer{
    void execute(E command);
}