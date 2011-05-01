/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE4705_final.Tests.AI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import CSE4705_final.State.*;
import CSE4705_final.AI.*;
import CSE4705_final.AI.Eval.*;

/**
 *
 * @author Ethan
 */
public class GenericSearchAITest {
    
    private GenericSearchAI _ai1;
    private GenericSearchAI _ai2;
    
    public GenericSearchAITest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        Evaluator eval = new Heuristic();
        _ai1 = new GenericSearchAI(false, eval, 2, 5, false);
        _ai2 = new GenericSearchAI(false, eval, 15, true);
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void terminationTest() {
        _ai1.getInterface().getMove(2);
    }
}
