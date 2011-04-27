/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CSE4705_final.Tests.State;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import CSE4705_final.State.*;

/**
 *
 * @author Ethan
 */
public class PartitionBaseTest {

    private static NodeSet _ns;
    private static Partition _rootPart;

    public PartitionBaseTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        _ns = new NodeSet();
        _rootPart = _ns.getRootPartition();
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
    public void initialSanityCheck() {
        for (int i = 0; i <= 99; i++) {
            NodeState iState = _rootPart.getNodeState(i);
            switch (i) {
                case 03:
                case 06:
                case 30:
                case 39:
                    assertEquals(NodeState.BLACK, iState);
                    break;
                case 60:
                case 69:
                case 93:
                case 96:
                    assertEquals(NodeState.WHITE, iState);
                    break;
                default:
                    assertEquals(NodeState.EMPTY, iState);
            }
        }
    }

    @Test
    public void initialNormalizeSanityCheck() {
        Partition normPart = _rootPart.normalizePosition();
        int bcount = 0;
        int wcount = 0;
        for (int i = 0; i <= 99; i++) {
            NodeState iState = normPart.getNodeState(i);
            switch (i) {
                case 03:
                case 06:
                case 30:
                case 39:
                case 60:
                case 69:
                case 93:
                case 96:
                    assertTrue(iState == NodeState.WHITE || iState == NodeState.BLACK);
                    if (iState == NodeState.WHITE) {
                        wcount++;
                    }
                    if (iState == NodeState.BLACK) {
                        bcount++;
                    }
                    break;
                default:
                    assertEquals(NodeState.EMPTY, iState);
            }
        }
        assertEquals(4, bcount);
        assertEquals(4, wcount);
    }
}