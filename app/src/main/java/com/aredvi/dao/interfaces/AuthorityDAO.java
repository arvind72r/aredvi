package com.aredvi.dao.interfaces;

import com.aredvi.sqlentity.Authority;

public interface AuthorityDAO {

	Authority finByRole(String role);

}
