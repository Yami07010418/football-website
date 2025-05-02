package com.ch.personmis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@MapperScan(basePackages={"com.ch.personmis.repository"})
public class PersonmisApplication {
//    启动类加跨域设置
    public static void main(String[] args) {
        SpringApplication.run(PersonmisApplication.class, args);
    }
    //前后端口号不一致要跨域设置
    private CorsConfiguration corsConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许跨域请求的域名
        corsConfiguration.addAllowedOrigin("*");
        //允许发送的内容类型
        corsConfiguration.addAllowedHeader("*");
        //跨域请求允许的请求方式
        corsConfiguration.addAllowedMethod("*");
        /**服务器端通过在响应 header 中设置 Access-Control-Allow-Credentials = true 来运行客户端携带证书式访问。
         通过对 Credentials 参数的设置，就可以保持跨域Ajax时的Cookie。这里需要注意的是：
         服务器端 Access-Control-Allow-Credentials = true时，参数Access-Control-Allow-Origin 的值不能为 '*' 。*/
        //corsConfiguration.setAllowCredentials(true);
         /**浏览器的同源策略，就是出于安全考虑，浏览器会限制从脚本发起的跨域HTTP请求
        （比如异步请求GET, POST, PUT, DELETE, OPTIONS等等），所以浏览器会向所请求的服务器发起两次请求，
        第一次是浏览器使用OPTIONS方法发起一个预检请求，第二次才是真正的异步请求，
        第一次的预检请求获知服务器是否允许该跨域请求：如果允许，才发起第二次真实的请求；如果不允许，
        则拦截第二次请求。Access-Control-Max-Age用来指定本次预检请求的有效期，单位为秒，，
        在此期间不用发出另一条预检请求。例如：response.addHeader("Access-Control-Max-Age", "0")，
        表示每次异步请求都发起预检请求，也就是说，发送两次请求。 response.addHeader("Access-Control-Max-Age", "1800")，
        表示隔30分钟才发起预检请求。也就是说，发送两次请求*/
        corsConfiguration.setMaxAge(3600L);
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig());
       return new CorsFilter(source);
    }
}
