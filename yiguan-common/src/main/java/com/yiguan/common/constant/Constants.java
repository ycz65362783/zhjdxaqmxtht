package com.yiguan.common.constant;

/**
 * 通用常量信息
 * 
 * @author ycz
 */
public class Constants
{
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";
    
    /**
     * 防重提交 redis key
     */
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * 验证码有效期（分钟）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 令牌前缀
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * 用户ID
     */
    public static final String JWT_USERID = "userid";

    /**
     * 用户名称
     */
    public static final String JWT_USERNAME = "sub";

    /**
     * 用户头像
     */
    public static final String JWT_AVATAR = "avatar";

    /**
     * 创建时间
     */
    public static final String JWT_CREATED = "created";

    /**
     * 用户权限
     */
    public static final String JWT_AUTHORITIES = "authorities";

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * 是否删除
      */
    public static final class IS_DELETED {
        /**
         * 已删除
         */
        public static final String YES = "1";
        /**
         * 未删除
         */
        public static final String NO = "0";
    }

    public static  final  class  YES_OR_NO {

        public static final String YES= "Y";

        public static final String NO = "N";
    }

    public static  final  class  CWTING_INFO {

        public static final String APP_KEY= "pEkFAjvrdh4";

        public static final String APP_SECRET = "nbHwqyy40h";

        public static final String MASTER_KEY="2ebedfdd8c4b42a791e7a451c4f300a0";

        public static final String PRODUCT_ID="15019367";
    }

    public static  final  class  CWTING_EVENT_TYPE {

        public static final String OFFLINE = "0";

        public static final String ONLINE ="1";

    }

    public static final class DICT_TYPE{

        public static final String GROUND_LEAD_TYPE = "ground_lead_type";

        public static final String ONLINE_STATUS = "online_status";

        public static final String SCHOOL_RECORD_TYPE= "school_record_type";

        public static final String MAP_INFO_TYPE = "map_info_type";
    }

}
