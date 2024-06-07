
/*
 * Test Driver file
 *
 * You can change this file in any way you like. We will not use this file
 * for grading. You are also not asked to submit this file. 
 */
public class DriverForSet extends Set{

    public static void main(String [] args) {
        
        System.out.println("\nUnit Test for Set: note that your answers, when they are");
        System.out.println("  sets, could be in a different order (since order does");
        System.out.println("  not matter), this is the meaning of \"same set as...\"\n");
        
        Set A = new Set();
        Set B = new Set( new int[] { 5 } );
        Set C = new Set( new int[] { 5, 3, 7, 4, 1 } );
        Set D = new Set( new int[] { 4, 3, -3, 10, 8 } );
        Set E = new Set( new int[] { 8, 4, 10 } );
        Set F = new Set( new int[] { 10, 8, 4 } );
        
        System.out.println("Test 01: Should be\n[]");
        System.out.println(A);
        System.out.println(); 
        
        System.out.println("Test 02: Should be\n[5]");
        System.out.println(B);
        System.out.println(); 
        
        System.out.println("Test 03: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C);
        System.out.println(); 
        
        System.out.println("Test 04: Should be\n[]");
        System.out.println(A.clone());
        System.out.println(); 
        
        System.out.println("Test 05: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C.clone());
        System.out.println(); 
        
        System.out.println("Test 06: Should be\n0");
        System.out.println(A.cardinality());
        System.out.println(); 
        
        System.out.println("Test 07: Should be\n5");
        System.out.println(D.cardinality());
        System.out.println(); 
        
        System.out.println("Test 08: Should be\ntrue");
        System.out.println(A.isEmpty());
        System.out.println(); 
        
        System.out.println("Test 09: Should be\nfalse");
        System.out.println(F.isEmpty());
        System.out.println(); 
        
        System.out.println("Test 10: Should be\nfalse");
        System.out.println(A.member(4));
        System.out.println();
        
        System.out.println("Test 11: Should be\ntrue");
        System.out.println(C.member(1));
        System.out.println();       
        
        System.out.println("Test 12: Should be\nfalse");
        System.out.println(D.member(1));
        System.out.println();
        
        System.out.println("Test 13: Should be\ntrue");
        System.out.println(A.subset(D));
        System.out.println();
        
        System.out.println("Test 14: Should be\nfalse");
        System.out.println(D.subset(C));
        System.out.println();       
        
        System.out.println("Test 15: Should be\ntrue");
        System.out.println(E.subset(D));
        System.out.println();
        
        System.out.println("Test 16: Should be\nfalse");
        System.out.println(D.subset(E));
        System.out.println();
        
        System.out.println("Test 17: Should be\nfalse");
        System.out.println(D.equal(E));
        System.out.println();       
        
        System.out.println("Test 18: Should be\ntrue");
        System.out.println(E.equal(F));
        System.out.println();
        
        System.out.println("Test 19: Should be\ntrue");
        System.out.println(F.equal(E));
        System.out.println();
        
        System.out.println("Test 20: Should be\ntrue");
        System.out.println(A.equal(A));
        System.out.println();       
        
        System.out.println("Test 21: Should be same set as\n[4,6]");
        Set A1 = A.clone(); 
        A1.insert(4);
        A1.insert(6);
        A1.insert(4);
        System.out.println(A1);
        System.out.println();
        
        System.out.println("Test 22: Should be same set as\n[10,8,4,5]");
        Set F1 = F.clone(); 
        F1.insert(5);
        F1.insert(4);
        System.out.println(F1);
        System.out.println();       
        
        System.out.println("Test 23: Should be same set as\n[8,4,10]");
        Set E1 = E.clone(); 
        E1.insert(10);
        System.out.println(E1);
        System.out.println();
        
        System.out.println("Test 24: Should be\n[]");
        A1 = A.clone(); 
        A1.delete(5);
        System.out.println(A1);
        System.out.println();       
        
        System.out.println("Test 25: Should be\n[]");
        Set B1 = B.clone(); 
        B1.delete(5);
        System.out.println(B1);
        System.out.println();  
        
        System.out.println("Test 26: Should be same set as\n[8,4,10]");
        E1 = E.clone(); 
        E1.delete(5);
        System.out.println(E1);
        System.out.println(); 
        
        System.out.println("Test 27: Should be same set as\n[4,10]");
        E1 = E.clone(); 
        E1.delete(8);
        System.out.println(E1);
        System.out.println();
        
        System.out.println("Test 28: Should be same set as\n[3,4]");
        System.out.println(C.intersection(D));
        System.out.println();
        
        System.out.println("Test 29: Should be\n[8,4,10]");
        System.out.println(E.intersection(F));
        System.out.println();       
        
        System.out.println("Test 30: Should be same set as\n[]");
        System.out.println(A.intersection(F));
        System.out.println();
        
        System.out.println("Test 31: Should be same set as\n[]");
        System.out.println(B.intersection(F));
        System.out.println();
        
        System.out.println("Test 32: Should be same set as\n[4,3,-3,10,8,5,7,1]");
        System.out.println(C.union(D));
        System.out.println();
        
        System.out.println("Test 33: Should be same set as\n[10,8,4]");
        System.out.println(E.union(F));
        System.out.println();       
        
        System.out.println("Test 34: Should be same set as\n[10,8,4]");
        System.out.println(A.union(F));
        System.out.println();
        
        System.out.println("Test 35: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C.union(B));
        System.out.println();
        
        System.out.println("Test 36: Should be same set as\n[5,7,1]");
        System.out.println(C.setdifference(D));
        System.out.println();       
        
        System.out.println("Test 37: Should be same set as\n[]");
        System.out.println(E.setdifference(F));
        System.out.println();
        
        System.out.println("Test 38: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C.setdifference(A));
        System.out.println();
        
        System.out.println("Test 39: Should be same set as\n[]");
        System.out.println(C.setdifference(C));
        System.out.println();
        
        System.out.println("Test 40: Should be same set as\n[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31]");
        Set G = new Set();
        for(int i = 0; i < 32; ++i) {
            G.insert(i);
        }
        System.out.println(G);
        System.out.println();
    } // main()  

} // class()