package postman.apipost.convert.postman2apipost.adapter;

/**
 * 适配器基类
 *
 * @author MH
 */
public abstract class AbstractBaseAdapter<S, T> {

    /**
     * 原始类转换到目标类
     *
     * @param source 原始类
     * @return 目标类
     */
    abstract public T sourceToTarget(S source);


    /**
     * 目标类转换到原始类
     *
     * @param target 目标类
     * @return 原始类
     */
    abstract public S targetToSource(T target);
}
