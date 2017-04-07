package com.aredvi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/datas")
public class CreateDataController extends AredviController {/*
	@Autowired
	private CassandraOperations cassandraOperations;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public void createTables() throws AredviException {
		cassandraOperations.execute(CreateTables.AUTHORITY);
		cassandraOperations.execute(CreateTables.USER);
		cassandraOperations.execute(CreateTables.USER_LOGIN);
		cassandraOperations.execute(CreateTables.DOCTOR);
		cassandraOperations.execute(CreateTables.INVENTORY);
	}
	
	@RequestMapping(value = "/createindex", method = RequestMethod.GET)
	public void createIndex(){
		cassandraOperations.execute(Createindexes.INVENTORY_FULL_NAME);
	}
	
	@RequestMapping(value = "/insertvalues", method = RequestMethod.GET)
	public void insertValues() throws AredviException {
		List<String> autorities = new ArrayList<String>(); 
		autorities.add("ROLE_USER_PERM_PERMITALL");
		
		Authority authority = new Authority("ROLE_USER",autorities);
		cassandraOperations.insert(authority);
		
		List<String> roles = new ArrayList<String>(); 
		roles.add("ROLE_USER");
		
		UserLogin userLogin = new UserLogin("vishnu","5270c8cea4f7b2382dc0e31ebff02bf3","123",
				new Date(),new Date(),false,true,"aredvi",roles);
		
		cassandraOperations.insert(userLogin);
		
		UserRole userRole = new UserRole(userLogin.getId(),"ROLE_USER");
		cassandraOperations.insert(userRole);
	}
*/}
