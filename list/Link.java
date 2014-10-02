package list;

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
	public int setData(T data) {
		this.data = data;
		return 0;
	}
	
	/**
	 * 
	 * @return the list 
	 */
	public Object getOwner() {
		return this.owner;
	}
	
	/**
	 * Return null for right now. We'll use it for testing stubs.
	 * @return null
	 */
	public T deleteData() {
		return null;
	}

}
