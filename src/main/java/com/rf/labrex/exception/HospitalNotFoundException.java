package com.rf.labrex.exception;

public class HospitalNotFoundException extends RuntimeException{
   public HospitalNotFoundException(){
        super("Hastane bulunamadi. Tekrar Dene ...");
    }
}
