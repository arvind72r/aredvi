package com.aredvi.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aredvi.dto.request.ReqLoginDTO;
import com.aredvi.dto.request.ReqUserProfileDTO;
import com.aredvi.dto.response.RespLoginDTO;
import com.aredvi.dto.response.RespUserProfileDTO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.exceptions.InvalidRequestException;
import com.aredvi.services.interfaces.UserService;
import com.aredvi.sqlentity.UserLogin;
import com.aredvi.utils.RequestFormatter;
import com.aredvi.utils.ResponseFormatter;

@RestController
@RequestMapping(value = "/user")
public class UserController extends AredviController{

	@Resource(name = "userService")
	private UserService usrService;
	
	@RequestMapping(value = "/createLogin", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody ResponseFormatter<RespLoginDTO> createLogin(@RequestBody ReqLoginDTO request) throws AredviException{
		if(null == request){
			 throw new InvalidRequestException("Credentials are missing.");
		}else if(!(request.getPassword()).equalsIgnoreCase(request.getConfirmPassword())){
			throw new InvalidRequestException("Password and Confirm password are not same.");
		}
		UserLogin userLogin = usrService.findByUserName(request.getUserName());
		if(null != userLogin){
			 throw new UsernameNotFoundException("User name already exist.");
		}
		RespLoginDTO respLoginDTO = usrService.createLogin(request);
		ResponseFormatter<RespLoginDTO> resp = new ResponseFormatter<RespLoginDTO>();
		resp.setResponseData(respLoginDTO);
		return resp;
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/updateLogin", method = RequestMethod.PUT, headers = "Accept=application/json", produces = "application/json")
	public ResponseFormatter<RespLoginDTO> updateLogin(@RequestBody ReqLoginDTO request) throws AredviException{
		if(null == request || request.getPassword() == null || request.getUserName()==null){
			 throw new InvalidRequestException("Credentials are missing.");
		}else if(!(request.getPassword()).equalsIgnoreCase(request.getConfirmPassword())){
			throw new InvalidRequestException("Password and Confirm password are not same.");
		}
		UserLogin userLogin = usrService.findByUserName(request.getUserName());
		if(null == userLogin){
			 throw new UsernameNotFoundException("User name does not exist.");
		}
		RespLoginDTO respLoginDTO = usrService.createLogin(request);
		ResponseFormatter<RespLoginDTO> resp = new ResponseFormatter<RespLoginDTO>();
		resp.setResponseData(respLoginDTO);
		return resp;
	}

	@RequestMapping(value = "/addprofile", method = RequestMethod.PUT, headers = "Accept=application/json", produces = "application/json")
	public ResponseFormatter<RespUserProfileDTO> addUserProfile(
			@RequestBody ReqUserProfileDTO request) throws AredviException {
		ResponseFormatter<RespUserProfileDTO> resp = new ResponseFormatter<RespUserProfileDTO>();
		if(null == request || request.getPassword() == null || request.getUserName()==null){
			 throw new InvalidRequestException("Credentials are missing.");
		}else if(!(request.getPassword()).equalsIgnoreCase(request.getConfirmPassword())){
			throw new InvalidRequestException("Password and Confirm password are not same.");
		}
		UserLogin userLogin = usrService.findByUserName(request.getUserName());
		if(null != userLogin){
			 throw new UsernameNotFoundException("User name already exist.");
		}
		/*ReqLoginDTO reqLogin = new ReqLoginDTO();
		reqLogin.setUserName(request.getUserName());
		reqLogin.setConfirmPassword(request.getConfirmPassword());
		reqLogin.setPassword(request.getPassword());
		RespLoginDTO respLoginDTO = usrService.createLogin(reqLogin);*/
		
		RespUserProfileDTO respUserProfileDTO = usrService.addUserProfile(request);
		resp.setResponseData(respUserProfileDTO);
		return resp;
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/updateprofile", method = RequestMethod.PUT, headers = "Accept=application/json", produces = "application/json")
	public ResponseFormatter<RespUserProfileDTO> updateUserProfile(
			@RequestBody RequestFormatter<ReqUserProfileDTO> request) throws AredviException {
		RespUserProfileDTO respUserProfileDTO = usrService.updateUserProfile(request.getRequestData());
		ResponseFormatter<RespUserProfileDTO> resp = new ResponseFormatter<RespUserProfileDTO>();
		resp.setResponseData(respUserProfileDTO);
		return resp;
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/findprofile", method = RequestMethod.GET, produces = "application/json")
	public ResponseFormatter<RespUserProfileDTO> getUserProfile(@RequestParam int usrId) throws AredviException {
		RespUserProfileDTO respUserProfileDTO = usrService.getUserProfile(usrId);
		ResponseFormatter<RespUserProfileDTO> resp = new ResponseFormatter<RespUserProfileDTO>();
		resp.setResponseData(respUserProfileDTO);
		return resp;
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/searchbyname", method = RequestMethod.GET, produces = "application/json")
	public ResponseFormatter<List<RespUserProfileDTO>> searchUserByName(@RequestParam String name)
			throws AredviException {
		List<RespUserProfileDTO> profiles = usrService.searchUserByName(name);
		ResponseFormatter<List<RespUserProfileDTO>> resp = new ResponseFormatter<List<RespUserProfileDTO>>();
		resp.setResponseData(profiles);
		return resp;
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/searchbytype", method = RequestMethod.GET, produces = "application/json")
	public ResponseFormatter<List<RespUserProfileDTO>> searchUserByType(@RequestParam String type)
			throws AredviException {
		List<RespUserProfileDTO> profiles = usrService.searchUserByType(type);
		ResponseFormatter<List<RespUserProfileDTO>> resp = new ResponseFormatter<List<RespUserProfileDTO>>();
		resp.setResponseData(profiles);
		return resp;
	}
	
}
