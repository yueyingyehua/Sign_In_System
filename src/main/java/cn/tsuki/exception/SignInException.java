package cn.tsuki.exception;

/**
 * Created by tsuki on 2017/4/9.
 */
public class SignInException extends RuntimeException {
    //提供一个无参数的构造器
    public SignInException()
    {

    }
    //提供一个待字符串参数的构造器
    public SignInException(String message)
    {
        super(message);
    }
}
