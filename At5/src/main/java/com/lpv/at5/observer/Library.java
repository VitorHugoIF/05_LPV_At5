/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpv.at5.observer;

import java.util.Observable;

/**
 *
 * @author vitor.marcelino
 */
public class Library extends Observable {
    private String name;
    private String address;

    public Library(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    public void notifyLibraryUser() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Biblioteca {Nome="+name+", Endereco="+address+"}";
    }
}
