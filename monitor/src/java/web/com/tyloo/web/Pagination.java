package com.tyloo.web;

import java.util.Vector;

@SuppressWarnings("unchecked")
public class Pagination {
	public static int SHOW_PAGE_NUM = 10;

	public static int getSHOW_PAGE_NUM() {
		return SHOW_PAGE_NUM;
	}

	public static void setSHOW_PAGE_NUM(int show_page_num) {
		SHOW_PAGE_NUM = show_page_num;
	}

	private int endPageIndex;
	
	private int total_page;

	private int current_page;

	private int total_row;

	private int start_row;

	private int end_row;

	private int start_page;

	private int end_page;

	private int previous_page = -1;

	private int next_page = -1;

	private Vector vPages = new Vector();

	private int showNum;

	private int end_rows;

	private Page prePage;

	private Page NPage;

	@SuppressWarnings("unchecked")
	public Pagination(int newTotalCount, int newStartRow, int newShowNum) {

		showNum = newShowNum;
		total_page = (newTotalCount - 1) / newShowNum + 1;

		current_page = (newStartRow / newShowNum) + 1;
		current_page = (current_page <= 0) ? 1 : current_page;
		current_page = (current_page > total_page) ? total_page : current_page;

		total_row = newTotalCount;
		start_row = (current_page - 1) * newShowNum + 1;
		end_row = start_row + newShowNum - 1;
		end_row = (end_row > newTotalCount) ? newTotalCount : end_row;

		end_rows = (total_page - 1) * showNum;

		this.endPageIndex = (this.total_page - 1) * this.SHOW_PAGE_NUM;
		if ((current_page - SHOW_PAGE_NUM) > 0) {
			start_page = current_page - SHOW_PAGE_NUM;
		} else {
			start_page = 1;
		}

		if ((current_page + SHOW_PAGE_NUM - 1) < total_page) {
			end_page = current_page + SHOW_PAGE_NUM - 1;
		} else {
			end_page = total_page;
		}

		end_page = (end_page > total_page) ? total_page : end_page;
		for (int i = start_page; i <= end_page; i++) {
			vPages.addElement(new Page(i));
		}

		if (current_page > 1) {
			previous_page = current_page - 1;
			prePage = new Page(previous_page);
		}

		if (current_page < total_page) {
			next_page = current_page + 1;
			NPage = new Page(next_page);
		}

	}

	public int getTotalPage() {
		return total_page;
	}

	public int getCurrentPage() {
		return current_page;
	}

	public int getTotalRow() {
		return total_row;
	}

	public int getStartRow() {
		return start_row;
	}

	public int getEndRow() {
		return end_row;
	}

	public int getStartPage() {
		return start_page;
	}

	public int getEndPage() {
		return end_page;
	}

	public int getPreviousPage() {
		return previous_page;
	}

	public int getNextPage() {
		return next_page;
	}

	public Vector getPages() {
		return vPages;
	}

	public class Page {
		private int page;

		private int startRow;

		public Page(int newPage) {
			page = newPage;
			startRow = (newPage - 1) * showNum;
		}

		public int getPage() {
			return page;
		}

		public int getStartRow() {
			return startRow;
		}

		public void setPage(int i) {
			page = i;
		}

		public void setStartRow(int i) {
			startRow = i;
		}

	}

	public Page getNPage() {
		return NPage;
	}

	public Page getPrePage() {
		return prePage;
	}

	public void setNPage(Page page) {
		NPage = page;
	}

	public void setPrePage(Page page) {
		prePage = page;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public int getEndRows() {
		return end_rows;
	}

}