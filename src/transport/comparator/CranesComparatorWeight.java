package transport.comparator;

import transport.Cranes;

import java.util.Comparator;

public class CranesComparatorWeight implements Comparator<Cranes> {

    @Override
    public int compare(Cranes o1, Cranes o2) {
        return Integer.compare(o1.getWeight_of_lifted_loads(), o2.getWeight_of_lifted_loads());
    }
}