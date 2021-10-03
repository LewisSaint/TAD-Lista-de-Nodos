package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import source.NodePositionList;
import source.Position;

public class NodePositionListTest {
    @Test
    void test() {
        NodePositionList<Integer> l = new NodePositionList<Integer>();
        assertEquals("[]", l.toString(), "[]");
        l.addFirst(8);
        assertEquals("[8]", l.toString(), "[8]");

        Position<Integer> p1 = l.first();
        assertEquals(8, p1.element(), "8");
        assertEquals("[8]", l.toString(), "[8]");

        l.addAfter(p1, 5);
        assertEquals("[8, 5]", l.toString(), "[8, 5]");
        Position<Integer> p2 = l.next(p1);
        assertEquals(5, p2.element(), "5");
        assertEquals("[8, 5]", l.toString(), "[8, 5]");

        l.addBefore(p2, 3);
        assertEquals("[8, 3, 5]", l.toString(), "[8, 3, 5]");
        Position<Integer> p3 = l.prev(p2);
        assertEquals(3, p3.element(), "3");
        assertEquals("[8, 3, 5]", l.toString(), "[8, 3, 5]");
        l.addFirst(9);
        assertEquals("[9, 8, 3, 5]", l.toString(), "[9, 8, 3, 5]");
        p2 = l.last();

        assertEquals(5, p2.element(), "5");
        assertEquals("[9, 8, 3, 5]", l.toString(), "[9, 8, 3, 5]");

        assertEquals(9, l.remove(l.first()), "9");
        assertEquals("[8, 3, 5]", l.toString(), "[8, 3, 5]");

        assertEquals(3, l.set(p3, 7), "3");
        assertEquals("[8, 7, 5]", l.toString(), "[8, 7, 5]");

        l.addAfter(l.first(), 2);
        assertEquals("[8, 2, 7, 5]", l.toString(), "[8, 2, 7, 5]");
    }


    @Test
    void TestMakeFirst() {

        NodePositionList<Integer> l = new NodePositionList<Integer>();

        l.addFirst(9);
        l.addLast(8);
        l.addLast(3);
        l.addLast(5);

        Position<Integer> pos = l.last();


        System.out.println(l);

        l.makeFirst(pos);
        System.out.println(l);

        //assertEquals("[9, 8, 3, 5]", l.toString(), "[3, 9, 8, 5");





    }


    @Test
    void testAddAfterTest() {
        NodePositionList<Integer> l = new NodePositionList<Integer>();

        l.addFirst(9);
        l.addLast(8);
        l.addLast(3);


        Position<Integer> p1 = l.last();
        System.out.println(p1);
        l.addAfter(p1, 2);

        assertEquals("[9,8,3,2]",l.toString());


    }

}