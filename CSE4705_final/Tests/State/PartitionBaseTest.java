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
import CSE4705_final.Client.*;

import java.util.*;

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
    
    private List<Integer> fromArray(int[] arr) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int e : arr) {
            ret.add(e);
        }
        return ret;
    }
    
    @Test
    public void initialReachableStates() {
        // Reachable states from 0,0.
        int[] correctStates00 = {01,02,10,20,11,22,33,44,55,66,77,88,99};
        assertTrue(_rootPart.getReachableIndicies(00).containsAll(fromArray(correctStates00)));
        assertTrue(fromArray(correctStates00).containsAll(_rootPart.getReachableIndicies(00)));
    }
    
    @Test
    public void partitionKittyCornerAllowed() {
        Partition runPart = _rootPart;
        List<Partition> runPartList;
        for (int i = 0; i <= 9; i++) {
            int index = i*11;
            runPartList = runPart.forkNode(index, NodeState.BLOCKED);
            assertEquals(1, runPartList.size());
            runPart = runPartList.get(0);
        }
        runPart = _rootPart;
        for (int i = 0; i <= 9; i++) {
            int index = Node.getIndex(9-i, i);
            runPartList = runPart.forkNode(index, NodeState.BLOCKED);
            assertEquals(1, runPartList.size());
            runPart = runPartList.get(0);
        }
    }
    
    @Test
    public void partitionBasicSplit() {
        Partition runPart = _rootPart;
        List<Partition> runPartList;
        for (int i = 0; i <= 8; i++) {
            int index = 50+i;
            runPartList = runPart.forkNode(index, NodeState.BLOCKED);
            assertEquals(1, runPartList.size());
            runPart = runPartList.get(0);
        }
        runPartList = runPart.forkNode(59, NodeState.BLOCKED);
        assertEquals(2, runPartList.size());
    }
    
    @Test
    public void oddSplittingBug() {
        List<Partition> _lp1 = _rootPart.forkNode(1, NodeState.BLOCKED);
        Partition _p1 = _lp1.get(0);
        List<Partition> _lp2 = _p1.forkNode(2, NodeState.BLOCKED);
        Partition _p2 = _lp2.get(0);
        List<Partition> _lp3 = _p2.forkNode(24, NodeState.BLOCKED);
        Partition _p3 = _lp3.get(0);
        List<Partition> _lp4 = _p3.forkMove(new ClientMove(3,0,2,1,1,1),true);
        Partition _p4 = _lp4.get(0);
        List<Partition> _lp5 = _p4.forkNode(20, NodeState.BLOCKED);
        Partition _p5 = _lp5.get(0);
        List<Partition> _lp6 = _p5.forkNode(30, NodeState.BLOCKED);
        Partition _p6 = _lp6.get(0);
        List<Partition> _lp7 = _p6.forkNode(31, NodeState.BLOCKED);
        Partition _p7 = _lp7.get(0);
        List<Partition> _lp8 = _p7.forkNode(22, NodeState.BLOCKED);
        Partition _p8 = _lp8.get(0);
        List<Partition> _lp9 = _p8.forkNode(32, NodeState.BLOCKED);
        Partition _p9 = _lp9.get(0);
        List<Partition> _lp10 = _p9.forkNode(3, NodeState.BLOCKED);
        Partition _p10 = _lp10.get(0);
        List<Partition> _lp11 = _p10.forkNode(13, NodeState.BLOCKED);
        Partition _p11 = _lp11.get(0);
        List<Partition> _lp12 = _p11.forkNode(23, NodeState.BLOCKED);
        Partition _p12 = _lp12.get(0);
        assertEquals(1, _lp1.size());
        assertEquals(1, _lp2.size());
        assertEquals(1, _lp3.size());
        assertEquals(1, _lp4.size());
        assertEquals(1, _lp5.size());
        assertEquals(1, _lp6.size());
        assertEquals(1, _lp7.size());
        assertEquals(1, _lp8.size());
        assertEquals(1, _lp9.size());
        assertEquals(1, _lp10.size());
        assertEquals(1, _lp11.size());
        assertEquals(2, _lp12.size());
        assertEquals(2, _p12.getReachableIndicies(21).size());
        assertEquals(3, _p12.getFreeStates());
    }
}