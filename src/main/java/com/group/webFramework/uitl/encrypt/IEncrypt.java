package com.group.webFramework.uitl.encrypt;

public interface IEncrypt {

    String encodePassword(String rawPass, Object salt);
    
    boolean isPasswordValid(String encPass, String rawPass, Object salt);

    String decodePassword(String rawPass, Object salt);
}
