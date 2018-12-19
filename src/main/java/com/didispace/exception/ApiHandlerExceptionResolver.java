package com.didispace.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;

/**
 * 全局异常类
 */
@Service
public class ApiHandlerExceptionResolver extends ExceptionHandlerExceptionResolver
{
	private final Logger LOG = Logger.getLogger(ApiHandlerExceptionResolver.class);
	
	public ApiHandlerExceptionResolver ()
	{
		this.setOrder(Integer.MIN_VALUE);
	}
	
	/**
	 * 系统运行过程中产生异常时，自动进入此方法
	 */
	@Override
	public @ResponseBody ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
	{
		response.setStatus(500);	// 设置服务器响应状态为500
        
        Map<String, Object> map = new HashMap<String, Object>();
        
        if (e instanceof ApiException)
        {
        	ApiException apiException = (ApiException) e;
        	map.put("errCode", apiException.getErrCode());
        	map.put("errMsg", apiException.getErrMsg());
        }
        else if (e instanceof MethodArgumentNotValidException)
        {
        	MethodArgumentNotValidException manve = (MethodArgumentNotValidException) e;
        	map.put("errCode", -1);
        	map.put("errMsg", manve.getBindingResult().getFieldError().getDefaultMessage());
        }
        else
        {
        	map.put("errCode", -1100);  
            map.put("errMsg", "系统内部异常");
        }
        
        this.LOG.warn(String.format("\n{uri:%s}，params:[%s]", request.getRequestURI(), request.getAttribute("params")), e);
        
        FastJsonJsonView fjjv = new FastJsonJsonView();	// 使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常
        fjjv.setAttributesMap(map);
        
        ModelAndView mav = new ModelAndView();
        mav.setView(fjjv);
        return mav;  
	}
}
