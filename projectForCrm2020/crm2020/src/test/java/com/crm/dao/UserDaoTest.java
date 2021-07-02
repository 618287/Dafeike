package com.crm.dao;


import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.mapper.UserMapper;
import com.crm.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest extends BaseTest {


	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testSelectUserById(){

	}

	@Test
	public void testSelectUserByNameAndPassword(){

	}

	@Test
	public void testAllUser(){

	}
}
