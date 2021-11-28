package com.bobocode.trimmer.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import util.annotation.Trimmed;

@Trimmed
@Service
public class TrimService {

     public void trimParam(String massage) {
         System.out.println(massage);
    }

    public String trimReturnValue(){
        return "  Return value!  ";
    }
}
