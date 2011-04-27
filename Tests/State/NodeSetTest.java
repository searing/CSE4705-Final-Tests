package CSE4705_final.Tests.State;

import CSE4705_final.State.*;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ethan Levine
 */
public class NodeSetTest {

    private static NodeSet nsa;
    

    public NodeSetTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        nsa = new NodeSet();
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

    @Test
    public void initialSetupTest() {
        for (int i = 0; i <= 99; i++) {
            switch (i) {
                case 30:
                case 03:
                case 06:
                case 39:
                    assertEquals(NodeState.BLACK, nsa.getNodeState(i, 0, false));
                    break;
                case 60:
                case 93:
                case 96:
                case 69:
                    assertEquals(NodeState.WHITE, nsa.getNodeState(i, 0, false));
                    break;
                default:
                    assertEquals(NodeState.EMPTY, nsa.getNodeState(i, 0, false));
            }
        }
    }

    @Test
    public void divergenceTest() {
        int g1 = nsa.forkNode(5, 5, 0, NodeState.BLACK);
        int g2 = nsa.forkNode(6, 5, g1, NodeState.WHITE);
        int g3 = nsa.forkNode(5, 5, g2, NodeState.BLOCKED);
        int g4 = nsa.forkNode(6, 5, g1, NodeState.BLACK);

        assertEquals(NodeState.BLACK, nsa.getNodeState(5, 5, g1, false));
        assertEquals(NodeState.BLACK, nsa.getNodeState(5, 5, g2, false));
        assertEquals(NodeState.WHITE, nsa.getNodeState(6, 5, g2, false));
        assertEquals(NodeState.EMPTY, nsa.getNodeState(6, 5, g1, false));
        assertEquals(NodeState.BLACK, nsa.getNodeState(6, 5, g4, false));
        assertEquals(NodeState.BLOCKED, nsa.getNodeState(5, 5, g3, false));
    }

    private static NodeState randomNodeState(Random r) {
        int val = r.nextInt(4);
        switch (val) {
            case 0:
                return NodeState.BLACK;
            case 1:
                return NodeState.WHITE;
            case 2:
                return NodeState.EMPTY;
            default:
                return NodeState.BLOCKED;
        }
    }
}