package br.com.unbhelp.domains;

import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserValidation {

    private static String regexEmail = "^(1[0-9]|9[0-9])((00|01|10))[0-9]{5}@aluno\\.unb\\.br$";
    private static Pattern patternEmail = Pattern.compile(regexEmail);
    private static String regexPassword = "^(?=.*\\d.*\\d.*\\d)(?=.*[a-z].*[a-z].*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$";
    private static Pattern patternPassword = Pattern.compile(regexPassword);
    private static String regexRegister = "^(1[0-9]|9[0-9])((00|01|10))[0-9]{5}$";
    private static Pattern patternRegister = Pattern.compile(regexRegister);

    public static void emailValidate(String email){
        if(email == null)
            throw new InvalidParameterException("E-mail não pode ser nulo.");

        Matcher matcher = patternEmail.matcher(email);
        if(!matcher.matches())
            throw new InvalidParameterException("E-mail inválido.");

    }

    public static void passwordValidate(String password){
        if(password == null)
            throw new InvalidParameterException("Senha não pode ser nula.");

        Matcher matcher = patternPassword.matcher(password);
        if(!matcher.matches())
            throw new InvalidParameterException("Senha inválida.");
    }

    public static void registerValidate(String register){
        if(register == null)
            throw new InvalidParameterException("Matrícula não pode ser nula.");

        Matcher matcher = patternRegister.matcher(register);
        if(!matcher.matches())
            throw new InvalidParameterException("Matrícula inválida.");
    }
}
