package cn.nihility.registrar;

import org.springframework.context.annotation.Import;

//@Configuration
@Import(MyImportBeanDefinitionRegistrar.class)
@MapperScan({"cn.nihility.registrar.mapper"})
public class RegistrarConfiguration {

    /**
     * 方式一： 直接以 Bean 的形式注册
     */
    /*@Bean
    public UserMapper userMapper() {
        return MapperProxy.getProxyUserMapper();
    }*/

}
