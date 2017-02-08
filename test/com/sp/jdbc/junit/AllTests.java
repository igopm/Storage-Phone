package com.sp.jdbc.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ PhoneDAOTest.class, MySqlConnectionTest.class })
public class AllTests {

}