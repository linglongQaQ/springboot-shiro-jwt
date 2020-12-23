package com.qc.online.diagnosis.common.exception;

/**自定义异常
 * @author qc_he
 */

public class MyException extends RuntimeException {
    /**
     * 无参构造函数
     */
    public MyException(){
        super();
    }

    /**
     * 用详细信息指定一个异常
     */
    public MyException(String message){
        super(message);
    }

    /**
     * 用指定的详细信息和原因构造一个新的异常
     */
    public MyException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     * 用指定原因构造一个新的异常
     */
    public MyException(Throwable cause) {
        super(cause);
    }

}