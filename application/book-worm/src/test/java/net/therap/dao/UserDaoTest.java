package net.therap.dao;

/**
 * @author rifatul.islam
 * @since 8/17/14.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static junit.framework.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/mvc-core-config.xml", "classpath:spring/mvc-view-config.xml",
        "classpath:spring/datasource-config.xml"})
@Transactional
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final Logger log = LoggerFactory.getLogger(UserDaoTest.class);


    protected static String USER_EMAIL = "shovonis@yahoo.com";
    protected static String PASSWORD = "123456";

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    private UserDao userDao;

    @Before
    public void before() {
        entityManager.clear();
    }


    @Test
    public void test_userDaoNotNull() {
        assertNotNull(userDao);
    }


    @After
    public void after() {
        entityManager.clear();
    }
}
