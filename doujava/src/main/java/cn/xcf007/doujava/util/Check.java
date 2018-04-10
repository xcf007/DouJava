package cn.xcf007.doujava.util;

import java.util.regex.Pattern;

public class Check {
    /**
     * 判断用户名是否规范
     * @param userName
     * @return 如果规范返回true, 否则false
     */
    public static boolean isUserName(String userName){
        String pattern = "^[a-zA-Z]{1}([0-9a-zA-Z]|[._]){3,19}$";
        return Pattern.matches(pattern, userName);
    }

    /**
     * 判断密码是否规范
     * @param password
     * @return 如果规范返回true, 否则false
     */
    public static boolean isPassword(String password){
        String pattern = "^.{6,}$";
        return Pattern.matches(pattern, password);
    }
}
