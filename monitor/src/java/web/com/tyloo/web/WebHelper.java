package com.tyloo.web;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.tyloo.fw.ServiceLocator;
import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.ServiceManager;
import com.tyloo.modules.member.MemberService;
import com.tyloo.modules.service.ShopUserService;
import com.tyloo.po.Member;
import com.tyloo.po.ShopUser;

/**
 * 
 * 
 * Title:
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2006
 * 
 * @author luoxn
 * @created 2006-6-6 15:40:34
 * @version $Id: WebHelper.java,v 1.2 2008/01/23 01:36:57 luoxn Exp $
 */
public class WebHelper
{
    
    protected static final int INT_HAVE_NO_VALUE = -999;
    
    private static final VMUtils v = (VMUtils) ServiceLocator
            .getService("vMUtils");
    
    private static final MemberService memberService = ServiceManager
            .getMemberService();
    private static final ShopUserService shopUserService = ServiceManager.getShopUserService();
    
    public static void putCommonValues(WebContext context)
    {
        context.put("now", new Date());
        context.put("vMUtils", v);
        //add by jiangtao
        context.put("shopUser", getShopUserContext(context));
        context.put("shopUserId", context.getTempClientValue("shopUserId"));
        //end
        context.put("member", getMemberContext(context));
        context.put("memberId", getMemberIdContext(context));
        context.put("name", getUserContext(context));
        HttpServletRequest request = context.getRequest();
        String refUrl = request.getHeader("Referer");
        context.put("refUrl", refUrl);
        String curUrl = getCurUrl(request);
        context.put("curUrl", curUrl);
        
    }
    
    /**
     * 
     * 功能描述: 获得当前登录的后台用户
     * 
     * @param context
     * @return
     */
    public static Member getMemberContext(WebContext context)
    {
        String u = context.getTempClientValue("memberId");
        int userId = 0;
        if (!StringUtils.isEmpty(u))
        {
            userId = Integer.parseInt(u);
        }
        return memberService.getMemberById(userId);
    }
    
    /**
     * 
     * 功能描述:获得当前登录的前台用户
     * @param context
     * @return
     */
    public static ShopUser getShopUserContext(WebContext context)
    {
        String f = context.getTempClientValue("shopUserId");
        int userId = 0;
        if (!StringUtils.isEmpty(f))
        {
            userId = Integer.parseInt(f);
        }
        return shopUserService.getShopUserById(userId);
    }
    
    public static String getUserContext(WebContext context)
    {
        String u = context.getTempClientValue("name");
        
        return u;
    }
    
    public static boolean isSigned(WebContext context)
    {
        return true;
    }
    
    private static String getCurUrl(HttpServletRequest request)
    {
        String queryString = request.getQueryString();
        String curUrl = request.getRequestURI();
        if (!StringUtils.isEmpty(queryString))
        {
            if (queryString.indexOf("&pageSize=") > 0)
            {
                queryString = queryString.substring(0, queryString
                        .indexOf("&pageSize="));
            }
            curUrl += "?" + queryString;
        }
        return curUrl;
    }
    
    public static int getMemberIdContext(WebContext context)
    {
        int memberId = context.getCookieMemberId();
        if (memberId > 0)
        {
            return memberId;
        }
        return 0;
    }
    
    public static int getStartRow(WebContext context)
    {
        int startRow = context.getIntParameter("start");
        
        if (startRow < 0)
        {
            startRow = 0;
        }
        return startRow;
    }
    
    public static int getStartRow(WebContext context, int totalCount)
    {
        int startRow = getStartRow(context);
        if (startRow >= totalCount)
        {
            startRow = 0;
        }
        return startRow;
    }
    
    public static String decode(String source)
    {
        if (StringUtils.isEmpty(source))
        {
            return source;
        }
        try
        {
            return URLDecoder.decode(source, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public static String encode(String source)
    {
        if (StringUtils.isEmpty(source))
        {
            return source;
        }
        try
        {
            return URLEncoder.encode(source, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String writeUploadFile2Server(String fileName, FormFile file)
            throws FileNotFoundException, IOException
    {
        InputStream stream = file.getInputStream();// 把文件读入
        
        OutputStream bos = new FileOutputStream(fileName);// 建立一个上传文件的输出流
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = stream.read(buffer, 0, 8192)) != -1)
        {
            bos.write(buffer, 0, bytesRead);// 将文件写入服务器
        }
        bos.close();
        stream.close();
        return fileName;
    }
    
    /**
     * 对搜索条件做处理
     * 
     * @param context
     * @param optionName
     * @return
     */
    public static String delSearchOption(WebContext context, String optionName)
    {
        String optionValue = context.getParameter(optionName);
        
        context.put(optionName, optionValue);
        return optionValue;
    }
    
    public static int delIntSearchOption(WebContext context, String optionName)
    {
        String optionValue = delSearchOption(context, optionName);
        if (!StringUtils.isEmpty(optionValue)
                && StringUtils.isNumeric(optionValue))
        {
            return Integer.parseInt(optionValue);
        }
        else
        {
            return INT_HAVE_NO_VALUE;
        }
    }
    
    public static double delDoubleSearchOption(WebContext context,
            String optionName)
    {
        String optionValue = delSearchOption(context, optionName);
        double d = INT_HAVE_NO_VALUE;
        
        if (!StringUtils.isEmpty(optionValue))
        {
            try
            {
                d = Double.parseDouble(optionValue);
            }
            catch (NumberFormatException e)
            {
                e.printStackTrace();
            }
        }
        return d;
    }
}