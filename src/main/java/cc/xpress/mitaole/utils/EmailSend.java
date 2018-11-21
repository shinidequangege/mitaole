package cc.xpress.mitaole.utils;

import cc.xpress.mitaole.config.Config;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author: Robben.Hu
 * @Description: sendEmail
 * @Date: Created in 2017-10-27 0:58
 */
public class EmailSend {
    public static String emailSend(String mailAdress) throws MessagingException{
        String code= CommonUtils.getCode(Config.CODE_LENGTH);
        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug","false");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth","true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host","smtp.qq.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol","smtp");
        // 设置环境信息
        Session session = Session.getInstance(props);
        // 创建邮件对象
        Message msg = new MimeMessage(session);
        // 创建邮件主题
        msg.setSubject("米淘乐注册验证邮件");
        // 设置邮件内容
        msg.setText("欢迎注册米淘乐，您的邮箱验证码是:"+code);
        // 设置发件人
        msg.setFrom(new InternetAddress("1115440210@qq.com"));

        Transport transport = session.getTransport();
        // 连接邮件服务器
        transport.connect("1115440210@qq.com", "hufan000");
        // 发送邮件
        transport.sendMessage(msg, new Address[] {new InternetAddress(mailAdress)});
        // 关闭连接
        transport.close();
        return code;
    }
}
