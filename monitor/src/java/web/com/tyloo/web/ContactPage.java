package com.tyloo.web;

public class ContactPage {

	private int totalRow;

	private int startRow;

	private int endRow;

	private int previousPage = -1;

	private int nextPage = -1;

	private int showNum;

	private int preRow;

	private int nextRow;

	private int lastPageStartRow;

	public ContactPage(int newTotalCount, int newStartRow, int newShowNum) {
		totalRow=newTotalCount;
		showNum = newShowNum;
		startRow = newStartRow;
		endRow = startRow + newShowNum-1;
		endRow = (endRow > newTotalCount) ? newTotalCount : endRow;
		lastPageStartRow = newTotalCount - newShowNum+1;

		if (startRow > 1) {
			previousPage = 1;
			preRow = startRow - newShowNum;
			if(preRow<1)preRow=1;
		}
		if ((startRow+newShowNum) < newTotalCount) {
			nextPage = 1;
			nextRow = startRow + newShowNum;
			if(nextRow>lastPageStartRow)nextRow=lastPageStartRow;
		}
	}

	public int getEndRow() {
		return endRow;
	}

	public int getLastPageStartRow() {
		return lastPageStartRow;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getNextRow() {
		return nextRow;
	}

	public int getPreRow() {
		return preRow;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public int getShowNum() {
		return showNum;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getTotalRow() {
		return totalRow;
	}

}
