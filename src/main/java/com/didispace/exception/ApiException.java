package com.didispace.exception;

/**
 * 自定义异常类
 */
public class ApiException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	private Integer errCode;
	private String errMsg;

	public ApiException(Integer errCode, String errMsg)
	{
		super("errCode: " + errCode + " errMsg: " + errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public Integer getErrCode()
	{
		return errCode;
	}

	public void setErrCode(Integer errCode)
	{
		this.errCode = errCode;
	}

	public String getErrMsg()
	{
		return errMsg;
	}

	public void setErrMsg(String errMsg)
	{
		this.errMsg = errMsg;
	}
}
