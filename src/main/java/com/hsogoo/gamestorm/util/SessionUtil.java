package com.hsogoo.gamestorm.util;

import com.hsogoo.gamestorm.constant.NormalConstant;
import com.hsogoo.gamestorm.vo.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangsaigang
 * @time 15-12-30 上午10:10
 */
public class SessionUtil {

    /** * 保存变量的ThreadLocal，保持在同一线程中同步数据. */
    private static final ThreadLocal SESSION_MAP = new ThreadLocal();

    /** * 工具类的protected构造方法. */
    protected SessionUtil() {
    }

    /**
     * 获得线程中保存的属性.
     *
     * @param attribute
     *            属性名称
     * @return 属性值
     */
    public static Object get(String attribute) {
        Map map = (Map) SESSION_MAP.get();
        if(map != null){
            return map.get(attribute);
        }
        return null;
    }

    /**
     * 获得线程中保存的属性，使用指定类型进行转型.
     *
     * @param attribute
     *            属性名称
     * @param clazz
     *            类型
     * @param <T>
     *            自动转型
     * @return 属性值
     */
    public static <T> T get(String attribute, Class<T> clazz) {
        return (T) get(attribute);
    }

    /**
     * 设置制定属性名的值.
     *
     * @param attribute
     *            属性名称
     * @param value
     *            属性值
     */
    public static void set(String attribute, Object value) {
        Map map = (Map) SESSION_MAP.get();

        if (map == null) {
            map = new HashMap();
            SESSION_MAP.set(map);
        }

        map.put(attribute, value);
    }

    /**防止获取线程池中原来被使用过的线程*/
    public static void clear(){
        SESSION_MAP.set(null);
    }

    /**所有的判断登录通过获取userId来判断，如果userId为空则未登录*/
    public static Long getUserId(){
        Map map = (Map) SESSION_MAP.get();

        if (map != null) {
            HttpSession httpSession = (HttpSession)map.get(NormalConstant.USER_SESSION_KEY);
            if(httpSession != null ){
                User user = (User)httpSession.getAttribute(NormalConstant.USER_LOGIN_KEY);
                if(user != null){
                    return user.getId();
                }
            }
        }
        return null;
    }

    public static User getSessionUser(){
        Map map = (Map) SESSION_MAP.get();

        if (map != null) {
            HttpSession httpSession = (HttpSession)map.get(NormalConstant.USER_SESSION_KEY);
            if(httpSession != null ){
                User user = (User)httpSession.getAttribute(NormalConstant.USER_LOGIN_KEY);
                return user;
            }
        }
        return null;
    }

}
