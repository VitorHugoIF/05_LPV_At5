/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpv.at5.memento;

/**
 *
 * @author vitor.marcelino
 */
public interface IDocumentState {
    String getState();
    
    String toDraft(Document doc);
    
    String toModerate(Document doc);
    
    String toPublish(Document doc);
}
