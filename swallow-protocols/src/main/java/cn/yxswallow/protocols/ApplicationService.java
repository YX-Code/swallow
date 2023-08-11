package cn.yxswallow.protocols;

/**
 * 标识服务类的作用为应用服务
 * <p>
 * Service如果没有多实现完全不需要有接口，但是SpringAOP代理机制需要有接口
 * 所以针对没有多实现的Service提供了这个接口标识类的作用
 *
 * @author yaoxing
 */
public interface ApplicationService {
}
