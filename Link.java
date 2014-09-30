
public class Link<T> extends Linkable {
	private T data;
	
	public Link() {
		data = null;
	}
	
	public Link(T newData) {
		this.data = newData;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

}
