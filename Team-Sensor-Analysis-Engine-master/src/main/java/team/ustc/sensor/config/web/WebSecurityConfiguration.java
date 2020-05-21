package team.ustc.sensor.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 配置：收到访问时检查登录状态
 *
 * @auther MrJoker
 */
@Configuration
public class WebSecurityConfiguration extends WebMvcConfigurerAdapter {


        //路径映射，已在Controller中配置
        /*@Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/").setViewName("login");
            registry.addViewController("/index.html").setViewName("login");
            registry.addViewController("/main.html").setViewName("success");
            registry.addResourceHandler("/webjars/**") .addResourceLocations("classpath:/META-INF/resources/webjars/");
        }*/


        //session key
        public final static String SESSION_KEY = "user";

        //装载拦截器
        @Bean
        public SecurityInterceptor getSecurityInterceptor() {
            return new SecurityInterceptor();
        }

        //配置拦截器
        public void addInterceptors(InterceptorRegistry registry) {
            InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

            // 排除配置
            addInterceptor.excludePathPatterns("/error","/login","/user/login");
            addInterceptor.excludePathPatterns("/asserts/**");
            addInterceptor.excludePathPatterns("/webjars/**");
            addInterceptor.excludePathPatterns("/public/**");

            // 拦截配置
            addInterceptor.excludePathPatterns("/**");
//            addInterceptor.addPathPatterns("/**");
        }
        //定义拦截器
        private class SecurityInterceptor extends HandlerInterceptorAdapter {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                    throws Exception {
                HttpSession session = request.getSession();
                if (session.getAttribute(SESSION_KEY) != null) return true;
                // 跳转登录
                request.setAttribute("message","登录失败，请先输入用户名和密码。");
                // 请求转发请求转发是一个请求一次响应，而重定向是两次请求两次响应。请求转发地址不变化，而重定向会显示后一个请求的地址
                request.getRequestDispatcher("login").forward(request,response);
                return false;
            }
        }
    }
