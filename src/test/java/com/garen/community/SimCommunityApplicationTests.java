package com.garen.community;

import com.garen.community.dao.AlphaDao;
import com.garen.community.service.AlphaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SimCommunityApplication.class)
public class SimCommunityApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@Test
	public void testApplicationContext() {
		System.out.println(applicationContext);
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class); //get Bean which primary
		System.out.println(alphaDao.select());
		alphaDao = applicationContext.getBean("alphaHibernate",AlphaDao.class); //by name get Bean
		System.out.println(alphaDao.select());
	}
	
	@Test
	public void testBeanManage(){
		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
		
		alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}
}
