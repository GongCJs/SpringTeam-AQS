package team.spring.aqs.vo;

import java.io.Serializable;
import java.util.List;

public class PageObject<T> implements Serializable {
	private static final long serialVersionUID = -459771771033139992L;
	
	/**
	 * pageCurrent 页码数
	 * pageSize 页面显示条数
	 * rowCount 总行数
	 * pageCount 总页码数
	 * records 记录数据
	 */
	private Integer pageCurrent = 1;
	private Integer pageSize = 10;
	private Integer rowCount=0;
	private Integer pageCount=0;
    private List<T> records;
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	@Override
	public String toString() {
		return "PageObject [pageCurrent=" + pageCurrent + ", pageSize=" + pageSize + ", rowCount=" + rowCount
				+ ", pageCount=" + pageCount + ", records=" + records + "]";
	}
	public PageObject(Integer pageCurrent, Integer pageSize, Integer rowCount, Integer pageCount, List<T> records) {
		super();
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.pageCount = pageCount;
		this.records = records;
	}
	public PageObject() {
		super();
	}
    
}
