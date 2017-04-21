package com.journaldev.spring;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.journaldev.spring.model.User;
import com.journaldev.spring.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService ps){
		this.userService = ps;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "users";
	}
	
	//For add and update user both
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User p){
		
		if(p.getId() == 0){
			//new user, add it
			this.userService.addUser(p);
		}else{
			//existing user, call update
			this.userService.updateUser(p);
		}
		
		return "redirect:/users";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
		
        this.userService.removeUser(id);
        return "redirect:/users";
    }
 
    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listusers", this.userService.listUsers());
        return "user";
    }
    
    Map<Integer, User> empData = new HashMap<Integer, User>();
    @RequestMapping(value = UserRestURIConstants.DUMMY_USER, method = RequestMethod.GET)
	public @ResponseBody User getDummyUser() {

		//logger.info("Start getDummyUser");
		List<User> emp = new ArrayList<User>();
		emp = this.userService.listUsers();
//		emp.setId(9999);
//		emp.setEmployeeName("Dummy");
//		emp.setCreatedDate(new Date());
		

		return emp.get(0);

	}
	
    
	@RequestMapping(value = UserRestURIConstants.REGISTER_USER, method = RequestMethod.POST)
	public @ResponseBody User createUser(@PathVariable(value="eventId") String eventid, String inputData) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User emp = mapper.readValue(inputData, User.class);
		emp.setEventId(eventid);
		addUser(emp);
		return emp;
	}
	
	
}
