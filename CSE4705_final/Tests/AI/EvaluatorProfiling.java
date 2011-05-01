package CSE4705_final.Tests.AI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import CSE4705_final.AI.*;
import CSE4705_final.AI.Eval.*;
import CSE4705_final.Client.*;
import CSE4705_final.State.*;

import java.util.*;

/**
 *
 * @author Ethan
 */
public class EvaluatorProfiling {
    private static Evaluator _primEval;
    private static Evaluator _blankEval;
    private static Evaluator _heurEval;
    private static PartitionSet _rootPartSet;
    private static PartitionSet _partSet1;
    
    public EvaluatorProfiling() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        _primEval = new PrimitiveEvaluator();
        final Random rand = new Random(53725);
        _blankEval = new Evaluator() {
            public int score(PartitionSet set) { return rand.nextInt(10); }
        };
        _heurEval = new Heuristic();
        _rootPartSet = new PartitionSet(new NodeSet().getRootPartition());
        PartitionSet wp = _rootPartSet;
        boolean isPlayerBlack = false;
        for (int i = 0; i < 20; i++) {
            List<ClientMove> possibleMoves = wp.getPossibleContestedMoves(isPlayerBlack);
            ClientMove move = possibleMoves.get(rand.nextInt(possibleMoves.size()));
            wp = wp.forkPartitionSet(move, isPlayerBlack);
            isPlayerBlack = !isPlayerBlack;
        }
        _partSet1 = wp;
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
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
    public void testPrimitiveEvalutator() {
        for (int i = 0; i < 100000; i++) {
            _primEval.score(_partSet1);
        }
    }
    
    // This appears to get optimized out...
    @Test
    public void testBlankEvaluator() {
        for (int i = 0; i < 100000; i++) {
            _blankEval.score(_partSet1);
        }
    }
    
    @Test
    public void testHeuristic() {
        for (int i = 0; i < 100000; i++) {
            _heurEval.score(_partSet1);
        }
    }
}
