package tk.ddvudo.Shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class ShiroSample {
    public static void main(String... args) {
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
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
