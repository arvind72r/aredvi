package com.aredvi.repository;

public class CreateTables {
	public static final String AUTHORITY = "CREATE TABLE authority(id uuid, role text, authorities list<text>, "
			+ "PRIMARY KEY(id, role)) with CLUSTERING ORDER BY (role DESC);";
	
	public static final String USER = "CREATE TABLE user(id uuid, user_id uuid, parent_id uuid,"
			+ " f_name text, l_name text, dob date, mobile_number text, email text, "
			+ "city text, gender text, type text, allergies list<text>, profile_delted boolean, "
			+ "family_physician list<text>, PRIMARY KEY(id));";
	
	public static final String USER_LOGIN = "CREATE TABLE userlogin(id uuid,  user_name text, password text,"
			+ " roles list<text>, auth_id text, auth_provider text, created_on timestamp, "
			+ "updated_on timestamp, is_verified boolean, is_lock boolean, "
			+ "PRIMARY KEY(id, user_name))with CLUSTERING ORDER BY (user_name DESC);";
	
	public static final String DOCTOR = "CREATE TABLE doctor(id uuid, f_name text, l_name text, dob date, mobile_number text, "
			+ "email text, profile text, photo text, city text, gender text,mp_lic_authority text, mp_lic_no text, calendar text, "
			+ "mp_lic_date_of_issue date, varified boolean, profile_delted boolean, specialities list<text>, "
			+ "phone list<text>, documents map<String,String>, lat text, longs text, PRIMARY KEY(id));";
	
	
}
