package tk.ddvudo.Shiro;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import tk.ddvudo.Mybatis.JavaBeans.*;
import tk.ddvudo.Mybatis.UseAnnotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class MyRealm extends AuthorizingRealm {

    String resourcePath = "mybatis-config.xml";
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        try {
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resourcePath));
            SqlSession session = ssf.openSession();
            UsertableDao mapper = session.getMapper(UsertableDao.class);
            UsertableExample example = new UsertableExample();
            example.createCriteria().andNameEqualTo(username);
            List<Usertable> users = mapper.selectByExample(example);
            Usertable user = Optional.ofNullable(users).get().get(0);
            UserRoleMapDao userRoleMapper = session.getMapper(UserRoleMapDao.class);
            UserRoleMapExample userRoleExample = new UserRoleMapExample();
            userRoleExample.createCriteria().andUseridEqualTo(user.getId());
            List<UserRoleMap> userrolemaps = userRoleMapper.selectByExample(userRoleExample);


            RoletableDao roleMapper = session.getMapper(RoletableDao.class);
            RoletableExample roleExample = new RoletableExample();
            roleExample.createCriteria().andIdIn(Optional.ofNullable(userrolemaps).get().stream().map(UserRoleMap::getRoleid).collect(Collectors.toList()));
            List<Roletable> roles = roleMapper.selectByExample(roleExample);
            authorizationInfo.addRoles(roles.stream().map(Roletable::getName).collect(toList()));

            RoleResMapDao roleResMapDao = session.getMapper(RoleResMapDao.class);
            RoleResMapExample roleResMapExample = new RoleResMapExample();
            roleResMapExample.createCriteria().andRoleidIn(Optional.ofNullable(roles).get().stream().map(Roletable::getId).collect(Collectors.toList()));
            List<RoleResMap> roleResMaps = roleResMapDao.selectByExample(roleResMapExample);

            ResourcetableDao resourcetableDao = session.getMapper(ResourcetableDao.class);
            ResourcetableExample resourcetableExample = new ResourcetableExample();
            resourcetableExample.createCriteria().andIdIn(Optional.ofNullable(roleResMaps).filter(m -> {
                return m.size() > 0;
            }).get().stream().map(RoleResMap::getResid).collect(Collectors.toList()));
            List<Resourcetable> ress = resourcetableDao.selectByExample(resourcetableExample);

            authorizationInfo.addStringPermissions(ress.stream().map(Resourcetable -> Resourcetable.getId() + "").collect(Collectors.toList()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authorizationInfo;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        try {
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resourcePath));
            SqlSession session = ssf.openSession();
            String username = (String) token.getPrincipal();
            UsertableDao mapper = session.getMapper(UsertableDao.class);
            UsertableExample example = new UsertableExample();
            example.createCriteria().andNameEqualTo(username);
            List<Usertable> users = mapper.selectByExample(example);
            if (null == users || users.size() == 0) {
                throw new UnknownAccountException();
            }
            Usertable user = users.get(0);
            authenticationInfo = new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authenticationInfo;
    }
}
