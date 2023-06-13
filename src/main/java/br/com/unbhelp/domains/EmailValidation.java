package br.com.unbhelp.domains;

import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailValidation{

    private static String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static Pattern pattern = Pattern.compile(regex);

    public static void validate(String email){
        if(email == null)
            throw new InvalidParameterException("E-mail inválido.");

        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches())
            throw new InvalidParameterException("E-mail inválido.");

    }
}
