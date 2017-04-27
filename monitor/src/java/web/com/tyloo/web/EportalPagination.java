package com.tyloo.web;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * description： pagination for Eportal
 * @author    jiangtao
 * @version   TML V100R002 2012-7-27
 * @see       
 * @since     TML V100R002
 */
public class EportalPagination
{
    private int pageSize;
    private int totalPageNum;
    private int currentPageNum;
    private int startRowNum;
    private int startPageNum; 
    private int endPageNum;
    private int clickNum = -1;//可以点击的页数
    private List<Integer> pages = new ArrayList<Integer>();
    
    public EportalPagination(int totalRowCount, int startRowNum, int pageSize )
    {
        if(clickNum==-1)
        {
            clickNum = 6;
        }
        this.pageSize = pageSize;
        this.startRowNum = startRowNum;
        this.totalPageNum = (totalRowCount - 1) / pageSize + 1;
       
        currentPageNum = (startRowNum / pageSize) + 1;
        currentPageNum = (currentPageNum <= 0) ? 1 : currentPageNum;
        currentPageNum = (currentPageNum > totalPageNum) ? totalPageNum : currentPageNum;
        
        this.startPageNum = currentPageNum-2>0?currentPageNum-2:1;
        
        this.endPageNum = (startPageNum + clickNum) > totalPageNum ? totalPageNum : startPageNum + clickNum;
        
        pages = getPageNumArray(startPageNum, endPageNum);
        System.out.println(pages);
    }
    
    public EportalPagination(int totalRowCount, int startRowNum, int pageSize, int clickNum)
    {
        if(clickNum==-1)
        {
            clickNum = 6;
        }
        this.pageSize = pageSize;
        this.startRowNum = startRowNum;
        this.totalPageNum = (totalRowCount - 1) / pageSize + 1;
       
        currentPageNum = (startRowNum / pageSize) + 1;
        currentPageNum = (currentPageNum <= 0) ? 1 : currentPageNum;
        currentPageNum = (currentPageNum > totalPageNum) ? totalPageNum : currentPageNum;
        
       
        this.startPageNum = currentPageNum-clickNum/2>0?currentPageNum-clickNum/2:1;
        
        this.endPageNum = (startPageNum + clickNum) > totalPageNum ? totalPageNum : startPageNum + clickNum;
        
        pages = getPageNumArray(startPageNum, endPageNum);
        System.out.println(pages);
    }
    
    /**
     * 
     * description: fix the page number 
     * @param startPageNum
     * @param endPageNum
     * @return
     */
    private List<Integer> getPageNumArray(int startPageNum, int endPageNum)
    {
        for(int i=startPageNum; i<=endPageNum; i++)
        {
            pages.add(new Integer(i));
        }
        return pages;
    }
    
    public int getPageSize()
    {
        return pageSize;
    }
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
    public int getCurrentPageNum()
    {
        return currentPageNum;
    }
    public void setCurrentPageNum(int currentPageNum)
    {
        this.currentPageNum = currentPageNum;
    }
    public int getStartRowNum()
    {
        return startRowNum;
    }
    public void setStartRowNum(int startRowNum)
    {
        this.startRowNum = startRowNum;
    }
    public int getStartPageNum()
    {
        return startPageNum;
    }
    public void setStartPageNum(int startPageNum)
    {
        this.startPageNum = startPageNum;
    }
    public int getEndPageNum()
    {
        return endPageNum;
    }
    public void setEndPageNum(int endPageNum)
    {
        this.endPageNum = endPageNum;
    }

    public int getTotalPageNum()
    {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum)
    {
        this.totalPageNum = totalPageNum;
    }

    public List<Integer> getPages()
    {
        return pages;
    }

    public void setPages(List<Integer> pages)
    {
        this.pages = pages;
    }

    public int getClickNum()
    {
        return clickNum;
    }

    public void setClickNum(int clickNum)
    {
        this.clickNum = clickNum;
    }
    
    
}
