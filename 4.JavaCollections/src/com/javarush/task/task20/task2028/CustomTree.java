package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;
    TreeSet<Entry<String>> tree = new TreeSet<>();

    public static void main(String[] args) {
        CustomTree list = new CustomTree();
        for (int i = 1; i < 18; i++) {
            list.add(String.valueOf(i));
        }
    }

    public CustomTree() {
        this.root = new Entry<String>("0", 0, 0);
        tree.add(root);
    }

    @Override
    public String toString() {
        return "CustomTree{" + tree.toString() + "}";
    }

    @Override
    public boolean add(String s) {

        int maxY = getMaxY();
        int previousY = 0;
        if (maxY > 0) {
            previousY = maxY - 1;
        }

        ArrayList<Entry<String>> listPreviousLineEntrys = getListEntrysFromLine(previousY);
        boolean creatingSucsess = false;
        for (Entry<String> lineEntry : listPreviousLineEntrys) {
            creatingSucsess = createNewKnot(lineEntry, s);
            if (creatingSucsess) {
                break;
            }
        }

        if (!creatingSucsess) {
            ArrayList<Entry<String>> listMaxLineEntrys = getListEntrysFromLine(maxY);
            for (Entry<String> lineEntry : listMaxLineEntrys) {
                creatingSucsess = createNewKnot(lineEntry, s);
                if (creatingSucsess) {
                    break;
                }
            }
        }

        return true;
    }

    private boolean createNewKnot(Entry<String> lineEntry, String newElementName) {

        boolean creatingSucsess = false;

        if (lineEntry.leftChild == null || lineEntry.rightChild == null) {

            Entry<String> newEntry = new Entry<String>(newElementName, lineEntry.yLevel + 1,
                    getNewXLevelFromLine(lineEntry.yLevel + 1));

            newEntry.parent = lineEntry;

            creatingSucsess = true;

            if (lineEntry.leftChild == null) {
                lineEntry.leftChild = newEntry;
            } else if (lineEntry.rightChild == null) {
                lineEntry.rightChild = newEntry;
            }

            lineEntry.checkChildren();
            newEntry.checkChildren();

            tree.add(newEntry);
        }

        return creatingSucsess;
    }

    private int getNewXLevelFromLine(int yLevel) {
        int newXLevel = -1;

        for (Entry<String> entry : tree) {
            if (entry.yLevel == yLevel && entry.xLevel > newXLevel) {
                newXLevel = entry.xLevel;
            }
        }

        return newXLevel + 1;
    }

    private ArrayList<Entry<String>> getListEntrysFromLine(int lineY) {
        ArrayList<Entry<String>> listLineEntrys = new ArrayList();
        for (Entry<String> entry : tree) {
            if (entry.yLevel == lineY) {
                listLineEntrys.add(entry);
            }
        }

        return listLineEntrys;
    }

    private int getMaxY() {
        int maxY = 0;
        for (Entry<String> entry : tree) {
            if (entry.yLevel > maxY) {
                maxY = entry.yLevel;
            }
        }
        return maxY;
    }

    public boolean remove(String s) {

        ArrayList<Entry<String>> listForRemove = new ArrayList<>();

        for (Entry<String> entry : tree) {
            if (entry.elementName.equals(s) && entry != root) {
                listForRemove.add(entry);
            }
        }

        for (Entry<String> entry : listForRemove) {

            tree.remove(entry);

            if (entry.parent != null) {
                if (entry.parent.leftChild == entry) {
                    entry.parent.rightChild = null;
                } else if (entry.parent.rightChild == entry) {
                    entry.parent.rightChild = null;
                }
            }

            removeChildsFromTree(entry);
        }

        return true;
    }
    public boolean remove(Object o) {
        return remove((String)o);
    }


    private void removeChildsFromTree(Entry<String> entry) {
        if (entry.leftChild != null) {
            tree.remove(entry.leftChild);
            removeChildsFromTree(entry.leftChild);
        }

        if (entry.rightChild != null) {
            tree.remove(entry.rightChild);
            removeChildsFromTree(entry.rightChild);
        }
    }

    public String getParent(String s) {
        for (Entry<String> entry : tree) {
            if (entry.elementName.equals(s)) {
                return entry.parent.elementName;
            }
        }
        return null;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return tree.size() - 1;
    }

    static class Entry<T> implements Serializable, Comparable {
        String elementName;
        int xLevel, yLevel;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        @Override
        public String toString() {
            return "Entry{name='" + elementName + '\'' +
                    ", y=" + yLevel +
                    ", x=" + xLevel +
                    '}';
        }

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public Entry (String elementName, int yLevel, int xLevel) {
            this.elementName = elementName;
            this.yLevel = yLevel;
            this.xLevel = xLevel;
        }

        public void checkChildren() {
            if (leftChild != null) {
                availableToAddLeftChildren = false;
            }

            if (rightChild != null) {
                availableToAddRightChildren = false;
            }
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        @Override
        public int compareTo(Object o) {
            if (o.getClass() != this.getClass()) {
                throw new UnsupportedOperationException();
            }
            Entry<String> that = (Entry<String>)o;
            int yRange = yLevel - that.yLevel;
            if (yRange == 0) {
                int xRange = xLevel - that.xLevel;
                if (xRange == 0) {
                    return that.elementName.compareTo(elementName);
                } else {
                    return xRange;
                }
            } else {
                return yRange;
            }
        }
    }
}


