package com.tyloo.util.searchcontext;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class SearchContext {

	private ArrayList<SearchOption> searchOptions = new ArrayList<SearchOption>();

	private ArrayList<SearchContext> searchContexts = new ArrayList<SearchContext>();

	private Class searchClass;

	private SearchCondition.Condition condition;

	private String orderByField;

	private String orderBy;
	
	private String orderByField2;

	private String orderBy2;

	public String getOrderByField2() {
		return orderByField2;
	}

	public void setOrderByField2(String orderByField2) {
		this.orderByField2 = orderByField2;
	}

	public String getOrderBy2() {
		return orderBy2;
	}

	public void setOrderBy2(String orderBy2) {
		this.orderBy2 = orderBy2;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public SearchContext() {

	}

	public SearchContext(SearchCondition.Condition condition) {
		this.condition = condition;
	}

	public String getOrderByField() {
		return orderByField;
	}

	public void setOrderByField(String orderByField) {
		this.orderByField = orderByField;
	}

	public void addOption(SearchOption option) {
		searchOptions.add(option);
	}

	public SearchOption getSearchOption(int i) {
		return searchOptions.get(i);
	}

	public void addSearchContext(SearchContext context) {
		searchContexts.add(context);
	}

	public SearchContext getSearchContext(int i) {
		return searchContexts.get(i);
	}

	public int getSearchOptionSize() {
		return searchOptions.size();
	}

	public int getSearchContextSize() {
		return searchContexts.size();
	}

	public SearchCondition.Condition getCondition() {
		return condition;
	}

	public void setCondition(SearchCondition.Condition condition) {
		this.condition = condition;
	}

	public Class getSearchClass() {
		return searchClass;
	}

	public void setSearchClass(Class searchClass) {
		this.searchClass = searchClass;
	}
}
