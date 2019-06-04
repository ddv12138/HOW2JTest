package tk.ddvudo.Shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

public class ShiroSample {
    public static void main(String... args) {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealms(Arrays.asList((Realm) new MyRealm()));
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "admin");
        System.out.println(currentUser.isAuthenticated());
        currentUser.login(token);
        System.out.println(currentUser.isAuthenticated());
        System.out.println(currentUser.hasRole("Captains"));
        System.out.println(currentUser.isPermitted("2"));
        currentUser.logout();
        System.out.println(currentUser.isAuthenticated());
    }
}
