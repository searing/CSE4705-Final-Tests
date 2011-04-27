package CSE4705_final.Tests.State;

import CSE4705_final.State.*;

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
public class NodeTest {

    public NodeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
    public void getIndexExhaustiveTest() {
        assertEquals(0, Node.getIndex(0, 0));
        assertEquals(1, Node.getIndex(0, 1));
        assertEquals(2, Node.getIndex(0, 2));
        assertEquals(3, Node.getIndex(0, 3));
        assertEquals(4, Node.getIndex(0, 4));
        assertEquals(5, Node.getIndex(0, 5));
        assertEquals(6, Node.getIndex(0, 6));
        assertEquals(7, Node.getIndex(0, 7));
        assertEquals(8, Node.getIndex(0, 8));
        assertEquals(9, Node.getIndex(0, 9));
        assertEquals(10, Node.getIndex(1, 0));
        assertEquals(11, Node.getIndex(1, 1));
        assertEquals(12, Node.getIndex(1, 2));
        assertEquals(13, Node.getIndex(1, 3));
        assertEquals(14, Node.getIndex(1, 4));
        assertEquals(15, Node.getIndex(1, 5));
        assertEquals(16, Node.getIndex(1, 6));
        assertEquals(17, Node.getIndex(1, 7));
        assertEquals(18, Node.getIndex(1, 8));
        assertEquals(19, Node.getIndex(1, 9));
        assertEquals(20, Node.getIndex(2, 0));
        assertEquals(21, Node.getIndex(2, 1));
        assertEquals(22, Node.getIndex(2, 2));
        assertEquals(23, Node.getIndex(2, 3));
        assertEquals(24, Node.getIndex(2, 4));
        assertEquals(25, Node.getIndex(2, 5));
        assertEquals(26, Node.getIndex(2, 6));
        assertEquals(27, Node.getIndex(2, 7));
        assertEquals(28, Node.getIndex(2, 8));
        assertEquals(29, Node.getIndex(2, 9));
        assertEquals(30, Node.getIndex(3, 0));
        assertEquals(31, Node.getIndex(3, 1));
        assertEquals(32, Node.getIndex(3, 2));
        assertEquals(33, Node.getIndex(3, 3));
        assertEquals(34, Node.getIndex(3, 4));
        assertEquals(35, Node.getIndex(3, 5));
        assertEquals(36, Node.getIndex(3, 6));
        assertEquals(37, Node.getIndex(3, 7));
        assertEquals(38, Node.getIndex(3, 8));
        assertEquals(39, Node.getIndex(3, 9));
        assertEquals(40, Node.getIndex(4, 0));
        assertEquals(41, Node.getIndex(4, 1));
        assertEquals(42, Node.getIndex(4, 2));
        assertEquals(43, Node.getIndex(4, 3));
        assertEquals(44, Node.getIndex(4, 4));
        assertEquals(45, Node.getIndex(4, 5));
        assertEquals(46, Node.getIndex(4, 6));
        assertEquals(47, Node.getIndex(4, 7));
        assertEquals(48, Node.getIndex(4, 8));
        assertEquals(49, Node.getIndex(4, 9));
        assertEquals(50, Node.getIndex(5, 0));
        assertEquals(51, Node.getIndex(5, 1));
        assertEquals(52, Node.getIndex(5, 2));
        assertEquals(53, Node.getIndex(5, 3));
        assertEquals(54, Node.getIndex(5, 4));
        assertEquals(55, Node.getIndex(5, 5));
        assertEquals(56, Node.getIndex(5, 6));
        assertEquals(57, Node.getIndex(5, 7));
        assertEquals(58, Node.getIndex(5, 8));
        assertEquals(59, Node.getIndex(5, 9));
        assertEquals(60, Node.getIndex(6, 0));
        assertEquals(61, Node.getIndex(6, 1));
        assertEquals(62, Node.getIndex(6, 2));
        assertEquals(63, Node.getIndex(6, 3));
        assertEquals(64, Node.getIndex(6, 4));
        assertEquals(65, Node.getIndex(6, 5));
        assertEquals(66, Node.getIndex(6, 6));
        assertEquals(67, Node.getIndex(6, 7));
        assertEquals(68, Node.getIndex(6, 8));
        assertEquals(69, Node.getIndex(6, 9));
        assertEquals(70, Node.getIndex(7, 0));
        assertEquals(71, Node.getIndex(7, 1));
        assertEquals(72, Node.getIndex(7, 2));
        assertEquals(73, Node.getIndex(7, 3));
        assertEquals(74, Node.getIndex(7, 4));
        assertEquals(75, Node.getIndex(7, 5));
        assertEquals(76, Node.getIndex(7, 6));
        assertEquals(77, Node.getIndex(7, 7));
        assertEquals(78, Node.getIndex(7, 8));
        assertEquals(79, Node.getIndex(7, 9));
        assertEquals(80, Node.getIndex(8, 0));
        assertEquals(81, Node.getIndex(8, 1));
        assertEquals(82, Node.getIndex(8, 2));
        assertEquals(83, Node.getIndex(8, 3));
        assertEquals(84, Node.getIndex(8, 4));
        assertEquals(85, Node.getIndex(8, 5));
        assertEquals(86, Node.getIndex(8, 6));
        assertEquals(87, Node.getIndex(8, 7));
        assertEquals(88, Node.getIndex(8, 8));
        assertEquals(89, Node.getIndex(8, 9));
        assertEquals(90, Node.getIndex(9, 0));
        assertEquals(91, Node.getIndex(9, 1));
        assertEquals(92, Node.getIndex(9, 2));
        assertEquals(93, Node.getIndex(9, 3));
        assertEquals(94, Node.getIndex(9, 4));
        assertEquals(95, Node.getIndex(9, 5));
        assertEquals(96, Node.getIndex(9, 6));
        assertEquals(97, Node.getIndex(9, 7));
        assertEquals(98, Node.getIndex(9, 8));
        assertEquals(99, Node.getIndex(9, 9));
    }

    @Test
    public void stateToCharExhaustiveTest() {
        assertEquals('B', Node.stateToChar(NodeState.BLACK));
        assertEquals('W', Node.stateToChar(NodeState.WHITE));
        assertEquals('X', Node.stateToChar(NodeState.BLOCKED));
        assertEquals(' ', Node.stateToChar(NodeState.EMPTY));
    }

    @Test
    public void basicNodeConsistencyTest() {
        Node a = new Node(4,2,NodeState.EMPTY,0);
        Node b = new Node(7,4,NodeState.WHITE,513);
        Node c = a.forkState(NodeState.BLACK);

        assertEquals(0,a.getGen());
        assertEquals(513,b.getGen());
        assertEquals(0,c.getGen());

        assertEquals(4,a.getRow());
        assertEquals(7,b.getRow());
        assertEquals(4,c.getRow());

        assertEquals(2,a.getCol());
        assertEquals(4,b.getCol());
        assertEquals(2,c.getCol());

        assertEquals(NodeState.EMPTY, a.getState());
        assertEquals(NodeState.WHITE, b.getState());
        assertEquals(NodeState.BLACK, c.getState());
    }
}