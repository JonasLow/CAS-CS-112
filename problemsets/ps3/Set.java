/*
 * Student First Name: Jonas
 * Student Last Name: Low
 * Student BU Number: U3005390
 * Purpose: this program creates a Set class, object and methods associated with the mathametical logical operations in set theory.
 */

public class Set {
    private static final int SIZE = 10;   // default (inital) size of set
    private int[] set;            // array holding the set
    private int size;             // current physcal size of set
    private int next;             // index of the next available slot in set

    public Set() {
        this.set = new int[SIZE];
        this.size = SIZE;
        this.next = 0;
    }

    public Set(int[] arr) {
        this.set = new int[arr.length];
        System.arraycopy(arr, 0, this.set, 0, arr.length);
        this.size = arr.length;
        this.next = arr.length;
    }

    @Override
    public Set clone() {
        Set clonedSet = new Set();
        for (int i = 0; i < next; i++) {
            clonedSet.insert(this.set[i]);
        }
        return clonedSet;
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < this.next; i++) {
            str += set[i];
            if (i < next - 1) {
                str += ",";
            }
        }
        str += "]";
        return str.toString();
    }

    public int cardinality() {
        return this.next;
    }

    public boolean isEmpty() {
        return (this.set == null || this.next== 0);
    }

    public boolean member(int n) {
        for (int i = 0; i < this.next; i++) {
            if (this.set[i] == n) {
                return true;
            }
        }
        return false;
    }

    public boolean subset(Set s) {
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0; i < next; i++) {
            if (!s.member(this.set[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean equal(Set s) {
        return (this.subset(s) && s.subset(this));
    }

    public void insert(int k) {
        if (!member(k)) {
            if (next >= size) {
                int[] newArr = new int[this.size + 1];
                System.arraycopy(this.set, 0, newArr, 0, this.size);
                this.set = newArr;
                this.size += 1;
            }
            this.set[next] = k;
            next++;
        }
    }

    public void delete(int k) {
        for (int i = 0; i < this.size; i++) {
            if (this.set[i] == k) {
                for (int j = i; j < next - 1; j++) {
                    this.set[j] = this.set[j + 1];
                }
                this.next--;
                this.size--;
                int[] newArr = new int[next];
                System.arraycopy(this.set, 0, newArr, 0, next);
                this.set = newArr;
                break;
            }
        }
    }

    public Set union(Set s) {
        Set unionSet = new Set();
        for (int i = 0; i < s.next; i++) {
            unionSet.insert(s.set[i]);
        }
        for (int j = 0; j < this.next; j++) {
            unionSet.insert(this.set[j]);            
        }
        return unionSet;
    }

    public Set intersection(Set s) {
        Set interSet = new Set();
        for (int i = 0; i < next; i++) {
            if (s.member(this.set[i])) {
                interSet.insert(this.set[i]);
            }
        }
        return interSet;
    }

    public Set setdifference(Set s) {
        Set diffSet = new Set();
        for (int element: this.set) {
            if (!s.member(element)) {
                diffSet.insert(element);
            }
        }
        return diffSet;
    }
}
