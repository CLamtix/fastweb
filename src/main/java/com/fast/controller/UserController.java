package com.fast.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fast.entity.User;
import com.fast.service.IUserService;
import com.fast.util.MD5Util;
import com.fast.util.StringUtil;
import com.fast.util.TransferObject;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService<User> userService;
	
	@RequestMapping("/login")
	public ModelAndView login(User user,HttpServletRequest req){
		System.out.println("进入login方法,接收到的参数user="+user.toString());
		ModelAndView mav = new ModelAndView();
		//如果user为null,或者密码为空,或者(登录名与邮箱)都为空-->直接返回login页面
		if(user==null || StringUtil.isSpaceString(user.getPassword()) ||StringUtil.isSpaceString(user.getLoginName()) ){
			mav.setViewName("user/login");
			return mav;
		}
		
		User dbUser = userService.findByHql("from User where loginName = ?",user.getLoginName());
		
		if(checkuserPassword(user,dbUser,mav)){
			req.getSession().setAttribute("sessionId", getSessionId(user));
			mav.setViewName("index");
		}
		
		return mav;
		
	}

	@RequestMapping("/rgst")
	public ModelAndView rgst(User user,HttpServletRequest req){
		System.out.println("进入rgst方法,接收到的参数user="+user.toString());
		ModelAndView mav = new ModelAndView();
		//如果user为null,或者密码为空,或者(登录名与邮箱)都为空-->直接返回login页面
		if(user==null || StringUtil.isSpaceString(user.getPassword()) ||StringUtil.isSpaceString(user.getLoginName()) ){
			mav.setViewName("user/rgst");
			return mav;
		}
		User user_db = this.userService.findByHql("from User u where u.loginName=?", user.getLoginName());
		if(user_db!=null && user_db.getId()>0){
			System.out.println("此用户名已被注册");
			mav.setViewName("user/rgst");
			return mav;
		}
		
		String password_md5 = MD5Util.MD5(user.getPassword());
		user.setPassword(password_md5);
		this.userService.save(user);
		mav.setViewName("index");
		return mav;
		
	}
	
	
	private boolean checkuserPassword(User user, User dbUser, ModelAndView mav) {
		boolean flag = false;
		if(dbUser == null ){
			setErrorPageInfo(mav);
		}else if(!dbUser.getPassword().equals(MD5Util.MD5(user.getPassword()))){
			setErrorPasswordInfo(mav);
		}
		
		return flag;
	}
	
	
	private Object getSessionId(User user) {
		
		return null;
	}
	
	private void setErrorPasswordInfo(ModelAndView mav) {
		TransferObject tfo = new TransferObject();
		tfo.setCode(-1);
		tfo.setMessage("密码错误!");
		mav.addObject("transferObject", tfo);
	}
	
	private void setErrorPageInfo(ModelAndView mav) {
		mav.setViewName("error");
	}

}
