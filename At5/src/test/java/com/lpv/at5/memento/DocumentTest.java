/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpv.at5.memento;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vitor.marcelino
 */
public class DocumentTest {
    
    @Test
    public void testSaveStates() {
        Document doc = new Document();
        doc.setState(DocumentStateDraft.getInstance());
        doc.setState(DocumentStateModeration.getInstance());
        doc.setState(DocumentStatePublication.getInstance());
        
        assertEquals(3, doc.getStates().size());
    }
    
    @Test
    public void testGetInicialState() {
        Document doc = new Document();
        doc.setState(DocumentStateDraft.getInstance());
        doc.setState(DocumentStateModeration.getInstance());
        doc.setState(DocumentStatePublication.getInstance());
        
        doc.resetState(0);
        
        assertEquals(DocumentStateDraft.getInstance(), doc.getState());
    }
    
    @Test
    public void testGetPrevState() {
        Document doc = new Document();
        doc.setState(DocumentStateDraft.getInstance());
        doc.setState(DocumentStateModeration.getInstance());
        doc.setState(DocumentStatePublication.getInstance());
        
        doc.resetState(1);
        
        assertEquals(DocumentStateModeration.getInstance(), doc.getState());
    }
    
    @Test
    public void testGetException() {
        try {
            Document doc = new Document();
            doc.resetState(0);
            fail();
            
        } catch (Exception e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }
}
