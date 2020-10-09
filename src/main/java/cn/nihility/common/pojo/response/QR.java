package cn.nihility.common.pojo.response;

/**
 * 响应信息主体，同{@link QueryDataResponse}
 *
 * @param <T>

 * @see QueryDataResponse
 */
public class QR<T> extends QueryDataResponse<T> {

	public QR() {
		super();
	}

	public QR(QueryData<T> data) {
		super(data);
	}

	@Override
	public String toString() {
		return "QR{" +
				"data=" + data +
				", code=" + code +
				", message='" + message + '\'' +
				'}';
	}
}
