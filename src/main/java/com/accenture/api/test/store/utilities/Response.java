/**
 * 
 */
package com.accenture.api.test.store.utilities;

/**
 * @author Alejo Hurtado
 *
 */
public class Response<T> {

    /** Indica el estado de la transaccion */
    private int status;
    /** Mensaje informativo para el usuario */
    private String userMessage;
    /** Mensaje informativo para los desarrolladores */
    private String developerMessage;
    /** Codigo de error dentro del sistema */
    private String errorCode;
    /** Url para consultar mas informacion acerca del error */
    private String moreInfo;
    /** Objeto con la respuesta de la transaccion */
    private T data;
    /**
     * Metodo constructor
     */
    public Response() {
        // Empty constructor
    }
    public Response(int status, String userMessage, String developerMessage, String errorCode, String moreInfo, T data) {
        this.status = status;
        this.userMessage = userMessage;
        this.developerMessage = developerMessage;
        this.errorCode = errorCode;
        this.moreInfo = moreInfo;
        this.data = data;
    }
    public Response(int status, String userMessage, String developerMessage, String errorCode, String moreInfo) {
        this.status = status;
        this.userMessage = userMessage;
        this.developerMessage = developerMessage;
        this.errorCode = errorCode;
        this.moreInfo = moreInfo;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getUserMessage() {
        return userMessage;
    }
    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
    public String getDeveloperMessage() {
        return developerMessage;
    }
    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getMoreInfo() {
        return moreInfo;
    }
    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "Response [status=" + status + ", userMessage=" + userMessage + ", developerMessage=" + developerMessage + ", moreInfo="
                + moreInfo + ", data=" + (data != null ? data.toString() : "") + "]";
    }

}

