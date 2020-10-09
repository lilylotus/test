package cn.nihility.common.pojo.response;

/**
 * <p>查询数据集返回结果</p>
 *

 */
public class QueryDataResponse<T> extends CommonResponse<QueryData<T>> {
    public QueryDataResponse() {
    }

    public QueryDataResponse(QueryData<T> data) {
        super(data);
    }
}
