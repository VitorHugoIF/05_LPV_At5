/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpv.at5.observer;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author vitor.marcelino
 */
public class LibraryUser implements Observer {
    private String name;
    private String lastNotification;

    public LibraryUser(String name) {
        this.name = name;
    }
    
    public String getLastNotification() {
        return this.lastNotification;
    }

    public void subscribe(Library library) {
        library.addObserver(this);
    }
    
    @Override
    public void update(Observable library, Object arg) {
        this.lastNotification = this.name + ", o livro solicitado chegou - " + library.toString();
    }
}
