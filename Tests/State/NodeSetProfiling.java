/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CSE4705_final.Tests.State;

import java.util.Random;
import CSE4705_final.State.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ethan
 */
public class NodeSetProfiling {
    private static NodeSet nsc;
    private static NodeSet nsd;
    private static NodeSet nse;
    private static NodeSet nsf;

    private static int gen00;
    private static int gen01;
    
    private NodeSet nsb;

    public NodeSetProfiling() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

        nsc = new NodeSet(false);
        nse = new NodeSet(false);
        int cg = 0;
        Random rand = new Random(58594);
        final int threshold = 50000;
        for (int c = 0; c <= threshold; c++) {
            cg = nsc.forkNode(rand.nextInt(10), rand.nextInt(10), rand.nextInt(cg+1), randomNodeState(rand));
            nse.forkNode(rand.nextInt(10), rand.nextInt(10), rand.nextInt(cg), randomNodeState(rand));
        }
        gen00 = cg;

        int cg2 = 0;
        nsd = new NodeSet(false);
        nsf = new NodeSet(false);
        rand = new Random(58594);
        for (int c = 0; c <= threshold; c++) {
            cg2 = nsd.forkNode(rand.nextInt(10), rand.nextInt(10), cg2, randomNodeState(rand));
            nsf.forkNode(rand.nextInt(10), rand.nextInt(10), cg2-1, randomNodeState(rand));
        }
        gen01 = cg2;
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
    public void insertionLinearSpeedTest() {
        nsb = new NodeSet(false);
        int cg = 0;
        Random rand = new Random(53466);
        final int threshold = 1000000;
        for (int c = 0; c <= threshold; c++) {
            cg = nsb.forkNode(rand.nextInt(10), rand.nextInt(10), cg, randomNodeState(rand));
        }
    }

    @Test
    public void insertionRandomSpeedTest() {
        nsb = new NodeSet(false);
        int cg = 0;
        Random rand = new Random(58594);
        final int threshold = 1000000;
        for (int c = 0; c <= threshold; c++) {
            cg = nsb.forkNode(rand.nextInt(10), rand.nextInt(10), rand.nextInt(cg+1), randomNodeState(rand));
        }
    }

    @Test
    public void insertionRandomSpeedTestThreaded() {
        nsb = new NodeSet(false);
        final int threshold = 250000;
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(58594);
                for (int c = 0; c <= threshold; c++) {
                    cg = nsb.forkNode(rand.nextInt(10), rand.nextInt(10), rand.nextInt(cg+1), randomNodeState(rand));
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(12354);
                for (int c = 0; c <= threshold; c++) {
                    cg = nsb.forkNode(rand.nextInt(10), rand.nextInt(10), rand.nextInt(cg+1), randomNodeState(rand));
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(7894536);
                for (int c = 0; c <= threshold; c++) {
                    cg = nsb.forkNode(rand.nextInt(10), rand.nextInt(10), rand.nextInt(cg+1), randomNodeState(rand));
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(45213);
                for (int c = 0; c <= threshold; c++) {
                    cg = nsb.forkNode(rand.nextInt(10), rand.nextInt(10), rand.nextInt(cg+1), randomNodeState(rand));
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            fail();
        }
    }

    @Test
    public void isolationRandomSpeedTest() {
        nsc.isolateGen(gen00);
    }

    @Test
    public void isolationLinearSpeedTest() {
        nsd.isolateGen(gen00);
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

    @Test
    public void queryRandomSpeedTest() {
        final int threshold = 1000000;
        Random rand = new Random(5324);
        for (int c = 0; c <= threshold; c++) {
            nsd.getNodeState(rand.nextInt(100), rand.nextInt(gen01+1), false);
        }
    }

    @Test
    public void queryRandomSpeedTestThreaded() {
        final int threshold = 250000;
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(58594);
                for (int c = 0; c <= threshold; c++) {
                    nsd.getNodeState(rand.nextInt(100), rand.nextInt(gen01+1), false);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(56478);
                for (int c = 0; c <= threshold; c++) {
                    nsd.getNodeState(rand.nextInt(100), rand.nextInt(gen01+1), false);
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(984152);
                for (int c = 0; c <= threshold; c++) {
                    nsd.getNodeState(rand.nextInt(100), rand.nextInt(gen01+1), false);
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(79842);
                for (int c = 0; c <= threshold; c++) {
                    nsd.getNodeState(rand.nextInt(100), rand.nextInt(gen01+1), false);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            fail();
        }
    }

    @Test
    public void queryLinearSpeedTest() {
        final int threshold = 1000000;
        Random rand = new Random(5324);
        for (int c = 0; c <= threshold; c++) {
            nsc.getNodeState(rand.nextInt(100), rand.nextInt(gen00+1), false);
        }
    }

    @Test
    public void queryLinearSpeedTestThreaded() {
        final int threshold = 250000;
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(58594);
                for (int c = 0; c <= threshold; c++) {
                    nsc.getNodeState(rand.nextInt(100), rand.nextInt(gen00+1), false);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(56478);
                for (int c = 0; c <= threshold; c++) {
                    nsc.getNodeState(rand.nextInt(100), rand.nextInt(gen00+1), false);
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(984152);
                for (int c = 0; c <= threshold; c++) {
                    nsc.getNodeState(rand.nextInt(100), rand.nextInt(gen00+1), false);
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(79842);
                for (int c = 0; c <= threshold; c++) {
                    nsc.getNodeState(rand.nextInt(100), rand.nextInt(gen00+1), false);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            fail();
        }
    }

    @Test
    public void queryRandomSpeedTestCached() {
        final int threshold = 1000000;
        Random rand = new Random(5324);
        for (int c = 0; c <= threshold; c++) {
            nsd.getNodeState(rand.nextInt(100), rand.nextInt(gen01+1), true);
        }
    }

    @Test
    public void queryRandomSpeedTestThreadedCached() {
        final int threshold = 250000;
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(58594);
                for (int c = 0; c <= threshold; c++) {
                    nsf.getNodeState(rand.nextInt(100), rand.nextInt(gen01+1), true);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(56478);
                for (int c = 0; c <= threshold; c++) {
                    nsf.getNodeState(rand.nextInt(100), rand.nextInt(gen01+1), true);
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(984152);
                for (int c = 0; c <= threshold; c++) {
                    nsf.getNodeState(rand.nextInt(100), rand.nextInt(gen01+1), true);
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(79842);
                for (int c = 0; c <= threshold; c++) {
                    nsf.getNodeState(rand.nextInt(100), rand.nextInt(gen01+1), true);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            fail();
        }
    }

    @Test
    public void queryLinearSpeedTestCached() {
        final int threshold = 1000000;
        Random rand = new Random(5324);
        for (int c = 0; c <= threshold; c++) {
            nsc.getNodeState(rand.nextInt(100), rand.nextInt(gen00+1), true);
        }
    }

    @Test
    public void queryLinearSpeedTestThreadedCached() {
        final int threshold = 250000;
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(58594);
                for (int c = 0; c <= threshold; c++) {
                    nse.getNodeState(rand.nextInt(100), rand.nextInt(gen00+1), true);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(56478);
                for (int c = 0; c <= threshold; c++) {
                    nse.getNodeState(rand.nextInt(100), rand.nextInt(gen00+1), true);
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(984152);
                for (int c = 0; c <= threshold; c++) {
                    nse.getNodeState(rand.nextInt(100), rand.nextInt(gen00+1), true);
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            public void run() {
                int cg = 0;
                Random rand = new Random(79842);
                for (int c = 0; c <= threshold; c++) {
                    nse.getNodeState(rand.nextInt(100), rand.nextInt(gen00+1), true);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            fail();
        }
    }
}