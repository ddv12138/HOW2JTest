package tk.ddvudo.MailTest;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Optional;

public class MailTest {
    public static void main(String... args) throws EmailException, UnknownHostException {
        HtmlEmail email = new HtmlEmail();//创建电子邮件对象
        email.setSSLOnConnect(true);
        email.setDebug(true);
        email.setHostName("SMTP.qq.com");//设置发送电子邮件使用的服务器主机名
        email.setSmtpPort(587);//设置发送电子邮件使用的邮件服务器的TCP端口地址
        Optional<String> username = Optional.empty();
        Optional<String> authcode = Optional.empty();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("输入用户名");
            username = Optional.of(br.readLine());
            System.out.println("输入鉴权码");
            authcode = Optional.of(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        email.setAuthenticator(new DefaultAuthenticator(username.get(), authcode.get()));//邮件服务器身份验证
        email.setFrom(username.get() + "@qq.com");//设置发信人邮箱
        email.setSubject(new Date().toString());//设置邮件主题
        email.setMsg(InetAddress.getLocalHost().getHostAddress());
        email.addTo("644077730@qq.com");//设置收件人
        email.send();//发送邮件
    }
}
