package team.spring.aqs.config;/**
 * @Auther: GongCJ
 * @Introduce:
 * @Date: 2019/08/27
 * @Description: team.spring.aqs.config
 * @version: 1.0
 */

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：GongCJ
 * @date ：Created in 2019/08/27 15:36
 * @description：Shiro配置文件
 * @modified By：
 * @version: $
 */


/**
 * 告诉spring容器 交给spring管理，且是一个配置类
 *
 * @author Gongcj
 */
@Configuration
public class SpringShiroConfig {
	/*
		第一步：
		创建Shiro核心SecurityManager对象，并交给Spring容器管理
	 */
	@Bean("securityManager")
	public SecurityManager newSecurityManager(
			//指定Realm，自己编写的AuthorizingRealm
			@Autowired
			@Qualifier("shiroUserRealm")
					Realm realm,

			//指定缓存管理
			@Autowired
			@Qualifier("shiroCacheManager")
					CacheManager cacheManager,

			//指定记住我
			@Autowired
			@Qualifier("shiroRememberMeManager")
					RememberMeManager rememberMeManager,

			//设置会话管理
			@Autowired
			@Qualifier("shiroSessionManager")
					SessionManager sessionManager
	) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(realm);
		securityManager.setCacheManager(cacheManager);
		securityManager.setRememberMeManager(rememberMeManager);
		securityManager.setSessionManager(sessionManager);
		return securityManager;
	}

	/*
		第二步：
		创建一个ShiroFilterFactoryBean（资源过滤工厂。如：成功、失败、未授权界面。及需要认证的界面或者放行的界面），并且交给spring容器管理
	 */
	@Bean("shiroFilterFactoryBean")
	public ShiroFilterFactoryBean newShiroFilterFactoryBean(
			@Autowired
			@Qualifier("securityManager")
					SecurityManager securityManager
	) {
		//创建一个ShiroFilterFactoryBean（资源过滤工厂）
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//配置资源所需权限
		Map<String, String> map = new LinkedHashMap<>();
		map.put("/bower_components/**", "anon");
		map.put("/build/**", "anon");
		map.put("/dist/**", "anon");
		map.put("/plugins/**", "anon");
		map.put("/index", "anon");
		map.put("/**", "anon");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		shiroFilterFactoryBean.setLoginUrl("/index");
		return shiroFilterFactoryBean;
	}


	/*
		第三步：
		创建FilterRegistrationBean对象，构建注册过滤对象。
	 */
	@Bean("filterRegistrationBean")
	public FilterRegistrationBean newFilterRegistrationBean() {
		//构建注册过滤器对象
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

		//注册过滤器对象
		/*
		 * 1) DelegatingFilterProxy(targetBeanName) 名字由DelegatingFilterProxy对象底层设置并读取。
		 * 2) targetBeanName名字要与ShiroFilterFactoryBean配置的id相同。
		 */
		DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy("shiroFilterFactoryBean");
		filterRegistrationBean.setFilter(delegatingFilterProxy);

		//进行过滤器配置
		//配置过滤器的生命周期管理由（可选）ServletContext管理
		filterRegistrationBean.setEnabled(true);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}

	/*
		第四步：
		配置授权管理
	 */
	//配置bean对象的生命周期管理
	@Bean("lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor newLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
	//配置代理创建器对象(通过此配置要为目标业务对象创建代理对象)
	@Bean("defaultAdvisorAutoProxyCreator")
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator newDefaultAdvisorAutoProxyCreator() {
		return new DefaultAdvisorAutoProxyCreator();
	}
	//授权属性的Advisor配置
	@Bean("authorizationAttributeSourceAdvisor")
	public AuthorizationAttributeSourceAdvisor newAuthorizationAttributeSourceAdvisor(
			@Autowired
			@Qualifier("securityManager")
					SecurityManager securityManager
	) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}


	/*
		第五步：
		配置记住我
	 */
	//配置cookie对象(负责记住用户信息)
	@Bean("shiroRememberMeCookie")
	public SimpleCookie newSimpleCookie() {
		//设置cookie名字
		SimpleCookie sc = new SimpleCookie("rememberMe");

		//设置有效时间
		sc.setMaxAge(60 * 60 * 12 * 10);
		return sc;
	}
	//记住我设置
	@Bean("shiroRememberMeManager")
	public CookieRememberMeManager newCookieRememberMeManager
	(
			@Autowired
			@Qualifier("shiroRememberMeCookie")
					SimpleCookie rememberMeCookie
	) {
		CookieRememberMeManager crmm = new CookieRememberMeManager();
		crmm.setCookie(rememberMeCookie);
		return crmm;
	}


	/*
		第六步：
		配置缓存管理器
	 */
	@Bean("shiroCacheManager")
	public MemoryConstrainedCacheManager newMemoryConstrainedCacheManager() {
		MemoryConstrainedCacheManager mccm = new MemoryConstrainedCacheManager();
		return mccm;
	}


	/*
		第七步：
		配置会话管理
	 */
	@Bean("shiroSessionManager")
	public DefaultWebSessionManager newDefaultWebSessionManager() {
		DefaultWebSessionManager dsm = new DefaultWebSessionManager();
		//设置全局会话超时时间，默认30分钟，即如果30分钟内没有访问会话将过期 1800000
		dsm.setGlobalSessionTimeout(60000);
		//删除失效的session
		dsm.setDeleteInvalidSessions(true);
		//是否开启会话验证器，默认是开启的
		dsm.setSessionValidationSchedulerEnabled(true);
		return dsm;
	}
}
