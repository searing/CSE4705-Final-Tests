package CSE4705_final.Tests.State;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import CSE4705_final.State.*;

import java.util.*;

/**
 *
 * @author Ethan Levine
 */
public class PartitionProfiling {
    
    private static NodeSet _ns;
    private static Partition _rootPart;
    
    public PartitionProfiling() {
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
    public void linearBlockedAdditionSpeedTest() {
        Random rand = new Random(9846549);
        List<Partition> parts = new LinkedList<Partition>();
        Partition curPart;
        SortedSet<Integer> partIndicies;
        List<Integer> partIndiciesList;
        List<Partition> newParts;
        for (int x = 0; x <= 1000; x++) {
            parts.add(_rootPart);
            while (parts.size() > 0) {
                curPart = parts.remove(0);
                partIndicies = curPart.getEnclosedSet();
                partIndiciesList = new ArrayList(partIndicies);
                int index = partIndiciesList.get(rand.nextInt(partIndiciesList.size()));
                newParts = curPart.forkNode(index, NodeState.BLOCKED);
                for (Partition p : newParts) {
                    parts.add(p);
                }
            }
        }
    }
}
