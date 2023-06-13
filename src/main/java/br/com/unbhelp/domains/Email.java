package br.com.unbhelp.domains;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email extends Exception{

    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    Pattern pattern = Pattern.compile(regex);

    public String validate(String email){
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()){
            return "Formato de e-mail inválido. Digite um novo e-mail.";
        }
        return email;
    }
}
