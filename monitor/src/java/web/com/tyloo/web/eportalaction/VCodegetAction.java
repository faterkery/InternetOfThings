package com.tyloo.web.eportalaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.tyloo.fw.waf.WebContext;
import com.tyloo.web.WebAction;

public class VCodegetAction extends WebAction
{
    @Override
    public String webProcess(WebContext context, Object member)
            throws ServletException
    {
        String returnCode = "";//used
        Object obj = context.getRequest().getSession().getAttribute("validateCode");
        if(obj!=null)
        {
            returnCode = obj.toString();
        }
        HttpServletResponse response = context.getResponse();
        response.setCharacterEncoding("utf-8");
        response.setHeader("Cache-Control", "no-cache");
        try
        {
            response.getWriter().write(returnCode);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
