package team.spring.aqs.service.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import team.spring.aqs.entity.AqsUser;
import team.spring.aqs.mapper.aqsUserMapper;

@Service("shiroUserRealm")
public class ShiroUserRealm extends AuthorizingRealm {
	@Autowired
	aqsUserMapper userDao;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}


	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
		cMatcher.setHashAlgorithmName("MD5");
		cMatcher.setHashIterations(1);
		super.setCredentialsMatcher(cMatcher);
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		System.out.println("UserName:" + username);
		AqsUser user = userDao.doFindUserByUsername(username);
		System.out.println("user:" + user);
		if (user == null)
			throw new UnknownAccountException();
		if (Integer.parseInt(user.getUserValid()) == 0)
			throw new LockedAccountException();
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUserSale());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getUserPassword(), credentialsSalt, getName());
		return info;
	}

}
