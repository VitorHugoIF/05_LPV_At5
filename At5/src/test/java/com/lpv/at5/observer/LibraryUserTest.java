/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpv.at5.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vitor.marcelino
 */
public class LibraryUserTest {
    
    @Test
    public void testNotifyLibraryUser() {
        String name = "José";
        String libraryName = "Biblioteca central";
        String libraryAddress = "Rua A, numero 99";
                
        Library library = new Library(libraryName, libraryAddress);
        LibraryUser libraryUser = new LibraryUser(name);
        libraryUser.subscribe(library);
        library.notifyLibraryUser();
        
        String result = name + ", o livro solicitado chegou - " + "Biblioteca {Nome="+libraryName+", Endereco="+libraryAddress+"}";
        assertEquals(result, libraryUser.getLastNotification());
    }
    
    @Test
    public void testNotifyLibraryUsers() {
        String nameA = "José";
        String nameB = "Maria";
        String libraryName = "Biblioteca central";
        String libraryAddress = "Rua A, numero 99";
        
        Library library = new Library(libraryName, libraryAddress);
        LibraryUser libraryUserA = new LibraryUser(nameA);
        LibraryUser libraryUserB = new LibraryUser(nameB);
        
        libraryUserA.subscribe(library);
        libraryUserB.subscribe(library);
        library.notifyLibraryUser();
        
        String result = nameA + ", o livro solicitado chegou - " + "Biblioteca {Nome="+libraryName+", Endereco="+libraryAddress+"}";
        String result2 = nameB + ", o livro solicitado chegou - " + "Biblioteca {Nome="+libraryName+", Endereco="+libraryAddress+"}";
        
        assertEquals(result, libraryUserA.getLastNotification());
        assertEquals(result2, libraryUserB.getLastNotification());
    }
    
    @Test
    public void TestNoNotifyLibraryUser() {
        String name = "José";
        String libraryName = "Biblioteca central";
        String libraryAddress = "Rua A, numero 99";
                
        Library library = new Library(libraryName, libraryAddress);
        LibraryUser libraryUser = new LibraryUser(name);

        library.notifyLibraryUser();
        
        assertEquals(null, libraryUser.getLastNotification());
    }
    
    @Test
    public void testNotifyLibraryUserLibraryA() {
        String nameA = "José";
        String nameB = "Maria";
        String libraryNameA = "Biblioteca central";
        String libraryAddressA = "Rua A, numero 99";
        String libraryNameB = "Biblioteca IFET";
        String libraryAddressB = "Rua 10, numero 285";
        
        Library libraryA = new Library(libraryNameA, libraryAddressA);
        Library libraryB = new Library(libraryNameB, libraryAddressB);
        LibraryUser libraryUserA = new LibraryUser(nameA);
        LibraryUser libraryUserB = new LibraryUser(nameB);
        
        libraryUserA.subscribe(libraryA);
        libraryUserB.subscribe(libraryB);
        
        libraryA.notifyLibraryUser();
        
        String result = nameA + ", o livro solicitado chegou - " + "Biblioteca {Nome="+libraryNameA+", Endereco="+libraryAddressA+"}";
        
        assertEquals(result, libraryUserA.getLastNotification());
        assertEquals(null, libraryUserB.getLastNotification());
    }
}
