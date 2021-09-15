package transport.comparator;

import transport.Truck;
import java.util.Comparator;

public class TruckComparatorCargo implements Comparator<Truck> {
    @Override
    public int compare(Truck o1, Truck o2) {
        return Integer.compare(o1.getVolume_of_transported_cargo(), o2.getVolume_of_transported_cargo());
    }
}
