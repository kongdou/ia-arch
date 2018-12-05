package ia.demo.po;

import java.io.Serializable;
import java.util.Date;


public class Sub implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1282478334946171815L;
	private long id;
	private long userId;
	private long bookId;
	private Date datetime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}


}
