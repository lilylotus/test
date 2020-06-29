package cn.nihility.starter;

import cn.nihility.registrar.RegistrarConfiguration;
import cn.nihility.registrar.User;
import cn.nihility.registrar.UserMapper;
import cn.nihility.registrar.mapper.UserMapper01;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRegistryStart {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(RegistrarConfiguration.class);
        ctx.refresh();

        UserMapper01 mapper = ctx.getBean(UserMapper01.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);

        /*Object myBean = ctx.getBean("&myFactoryBean");
        System.out.println(myBean);*/

        ctx.registerShutdownHook();
    }

}
