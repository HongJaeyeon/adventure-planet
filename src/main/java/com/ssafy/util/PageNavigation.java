package com.ssafy.util;

public class PageNavigation {

	private boolean startRange; // 현재 페이지가 이전이 눌려지지않는 범위의 페이지인지 체크
	private boolean endRange; // 현재 페이지가 다음이 눌려지지않는 범위의 페이지인지 체크
	private int totalCount;	// 총 게시글 갯수
	private int totalPageCount; // 총 페이지 갯수 
	private int currentPage; // 현재 페이지 번호
	private int naviSize; // 한번에 보일 페이지 갯수
	private int countPerPage; // 페이지당 글 갯수

	public boolean isStartRange() {
		return startRange;
	}

	public void setStartRange(boolean startRange) {
		this.startRange = startRange;
	}

	public boolean isEndRange() {
		return endRange;
	}

	public void setEndRange(boolean endRange) {
		this.endRange = endRange;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNaviSize() {
		return naviSize;
	}

	public void setNaviSize(int naviSize) {
		this.naviSize = naviSize;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

//	public void makeNavigator() {
//		int startPage = (currentPage - 1) / naviSize * naviSize + 1;//6 11
//		int endPage = startPage + naviSize - 1;//10 15
//		if(totalPageCount < endPage)
//			endPage = totalPageCount;//11
//		
//		StringBuilder buffer = new StringBuilder();
//		buffer.append("		<ul class=\"pagination\"> \n");
//		buffer.append("			<li class=\"page-item\"> \n");
//		buffer.append("				<a href=\"#\"id=\"first-page\" class=\"page-link\" move-pg=\"1\">최신</a> \n");
//		buffer.append("			</li> \n");
//		buffer.append("			<li class=\"page-item\"> \n");
//		buffer.append("				<a href=\"#\" class=\"page-link\" move-pg=\"" + (this.startRange ? 1 : (startPage - 1)) + "\">이전</a> \n");
//		buffer.append("			</li> \n");
//		for(int i=startPage;i<=endPage;i++) {
//			buffer.append("			<li class=\"" + (currentPage == i ? "page-item active" : "page-item") + "\"><a href=\"#\" class=\"page-link\" move-pg=\"" + i + "\">" + i + "</a></li> \n");
//		}
//		buffer.append("			<li class=\"page-item\"> \n");
//		buffer.append("				<a href=\"#\" class=\"page-link\" move-pg=\"" + (this.endRange ? endPage : (endPage + 1)) + "\">다음</a> \n");
//		buffer.append("			</li> \n");
//		buffer.append("			<li class=\"page-item\"> \n");
//		buffer.append("				<a href=\"#\" class=\"page-link\" move-pg=\"" + totalPageCount + "\">마지막</a> \n");
//		buffer.append("			</li> \n");
//		buffer.append("		</ul> \n");
//		this.navigator = buffer.toString();
//	}
}
