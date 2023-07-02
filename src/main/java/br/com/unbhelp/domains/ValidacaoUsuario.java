package br.com.unbhelp.domains;

import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidacaoUsuario {

    private static String regexEmail = "^[A-Za-z0-9]+@aluno\\.unb\\.br$";
    private static Pattern patternEmail = Pattern.compile(regexEmail);
    private static String regexPassword = "^(?=.*\\d.*\\d.*\\d)(?=.*[a-z].*[a-z].*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$";
    private static Pattern patternPassword = Pattern.compile(regexPassword);
    private static String regexRegister = "^\\d{9}$";
    private static Pattern patternRegister = Pattern.compile(regexRegister);

    public static void validacaoEmail(String email){
        if(email == null)
            throw new InvalidParameterException("E-mail não pode ser nulo.");

        Matcher matcher = patternEmail.matcher(email);
        if(!matcher.matches())
            throw new InvalidParameterException("E-mail inválido.");

    }

    public static void validacaoSenha(String password){
        if(password == null)
            throw new InvalidParameterException("Senha não pode ser nula.");

//        Matcher matcher = patternPassword.matcher(password);
//        if(!matcher.matches())
//            throw new InvalidParameterException("Senha inválida.");
    }

    public static void validacaoMatricula(String register){
        if(register == null)
            throw new InvalidParameterException("Matrícula não pode ser nula.");

        Matcher matcher = patternRegister.matcher(register);
        if(!matcher.matches())
            throw new InvalidParameterException("Matrícula inválida.");
    }
}
