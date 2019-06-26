package team.spring.aqs.util;

import java.util.List;

import team.spring.aqs.vo.PageObject;
public class PageUtil {
	
	/**
	 * 用户指定每页显示数量及当前页码数
	 * @param pageCurrent1 指定页码数
	 * @param pageSize1 每页显示数量
	 * @return
	 */
	public static int getStartIndex(Integer pageCurrent, Integer pageSize) {
		return (pageCurrent-1)*pageSize;
	}
	
	
	
	//对结果进行封装
	public static <T> PageObject<T> newPageObject(
			Integer pageCurrent, 
			int rowCount, 
			Integer pageSize,
			List<T> findPageObjects) {
		PageObject<T> po = new PageObject<T>();

		//设置页码数
		po.setPageCurrent(pageCurrent);
		//设置页面显示条数
		po.setPageSize(pageSize);
		//总行数
		po.setRowCount(rowCount);
		//总页码数
		po.setPageCount((rowCount-1)/pageSize+1);
		//记录数据
		po.setRecords(findPageObjects);
		
		return po;
	}
}
