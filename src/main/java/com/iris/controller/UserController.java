package com.iris.controller;

import com.alibaba.fastjson.JSONObject;
import com.iris.model.User;
import com.iris.service.MoneyService;
import com.iris.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
//@RequestMapping("/manage/user")
public class UserController extends BaseController{
	private static final Logger LOG = Logger.getLogger(UserController.class);


	//  下面两种@Resource只要使用一种即可,
//	@Resource(name="userService")
//	用@Resource后就不必使用@Autowired，可以降低耦合
//	用@Autowired
//	@Autowired
	private UserService userService;
	@Autowired
	private MoneyService moneyService;

	//最好是将@Resource放在setter方法上，因为这样更符合面向对象的思想，通过set、get去操作属性，而不是直接去操作属性。
	@Resource(name="userService")
	public void UserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 用户页
	 *
	 * @return
	 */
	@RequiresPermissions(value = { "/manage/user/user" })
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userManager(Model model) {
		return "user/showUser";
	}

	/**
	 * @Title: testAjax
	 * @Description: post请求（测试用）
	 * @param @param model
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/testAjax", method = RequestMethod.POST)
	@ResponseBody
	public Object test(Model model) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id","数据拿到123了");
		return renderSuccess(jsonObject.toJSONString());
	}
	/**
	 * @Title: testPOJO
	 * @param @param model
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/testPOJO", method = RequestMethod.GET)
	@ResponseBody
	public Object testPOJO(Model model) {
		String id = "1";
		User user = userService.getUser(id);
		return renderSuccess(user);
	}

	/**
	 * @Title:
	 * @param @param model
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/manager/getUserInfoById/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserInfoById(Model model,@PathVariable("id")Long id) {
//		User user = userService.findUserInfoById(id);
//		Integer start = 1;
//		Integer limit = 10;
//		List<User> list = userService.listAllUserInfoById(1,10);
		return new User();
	}

}