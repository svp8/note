package com.vlad.note;

import org.springframework.security.crypto.password.PasswordEncoder;
//Простой шифратор паролей, который не шифрует :)
public class SimplePasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }
}
