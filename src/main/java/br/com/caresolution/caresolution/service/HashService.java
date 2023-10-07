package br.com.caresolution.caresolution.service;



//import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class HashService {

    public String extrairValoresDoXML(String xml) {
        // Use uma expressão regular para encontrar o conteúdo entre as tags
        String regex = "<([^>]*)>([^<]*)</[^>]*>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(xml);

        StringBuilder valores = new StringBuilder();

        // Encontre todas as correspondências e adicione o conteúdo entre as tags à string de valores
        while (matcher.find()) {
            if(!matcher.group(1).equals("hash")){
                valores.append(matcher.group(2).trim());
            }

        }

        return valores.toString();
    }

    public String calcularHashMD5(String texto) {
        // Calcula o hash MD5 do texto fornecido
//        return DigestUtils.md5Hex(texto);
        return texto;
    }


}
