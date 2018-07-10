package com.fast.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fast.entity.UserDto;

@Controller
@RequestMapping("/fund")
public class FundController {
	
	private Logger log = LoggerFactory.getLogger(FundController.class);
	
	@RequestMapping("testJson")
	public @ResponseBody UserDto test(@RequestBody UserDto dto){
		log.info("接收的userdto:"+dto.toString());
		UserDto ud = new UserDto();
		ud.setName("jocho");
		ud.setAge(23);
		ud.setAvalibleFunds(100.34);
		ud.setFrozenFunds(3.00);
		log.info("返回的userdto:"+ud.toString());
		return ud;
	}
}
