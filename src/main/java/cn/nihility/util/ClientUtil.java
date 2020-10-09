package cn.nihility.util;

import cn.nihility.common.constant.enums.CommonResponseEnum;
import cn.nihility.common.pojo.response.QR;
import cn.nihility.common.pojo.response.QueryData;
import cn.nihility.common.pojo.response.R;

import java.util.function.Supplier;

/**
 * <pre>
 *  远程调用工具类
 * </pre>
 *

 */
public class ClientUtil {

    /**
     * 封装远程调用, 只返回关心的内容
     * @param supplier 远程调用真正逻辑, 返回内容为: {@link R<T>}
     * @param <T> 关心的内容类型
     * @return 关心的内容
     */
    public static <T> T execute(Supplier<R<T>> supplier) {
        R<T> r = supplier.get();
        CommonResponseEnum.assertSuccess(r);
        return r.getData();
    }

    /**
     * 封装远程调用, 只返回关心的内容
     * @param supplier 程调用真正逻辑, 返回内容为: {@link QR<T>}
     * @param <T> 关心的内容类型
     * @return 关心的内容
     */
    public static <T> QueryData<T> executePage(Supplier<QR<T>> supplier) {
        QR<T> qr = supplier.get();
        CommonResponseEnum.assertSuccess(qr);
        return qr.getData();
    }

}
