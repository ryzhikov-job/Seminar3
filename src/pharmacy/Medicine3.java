package pharmacy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Medicine3 implements Iterable<MedicineComponent>, Comparable<Medicine3> {
    public List<MedicineComponent> components;
    private int index;

    public Medicine3() {
        this.components = new ArrayList<>();
        this.index = 0;
    }
    public Medicine3 addComponent(MedicineComponent component) {
        components.add(component);
        return this;
    }

    public String toString() {
        return "Medicine: " + components.toString();
    }

    @Override
    public Iterator<MedicineComponent> iterator() {
        return new Iterator<MedicineComponent>() {
            @Override
            public boolean hasNext() {
                return index < components.size();
            }

            @Override
            public MedicineComponent next() {
                return components.get(index++);
            }
        };
    }

    @Override
    public int compareTo(Medicine3 o) {
//        1. По весу
        float thisWeight = this.components.stream().map(MedicineComponent::getWeight).reduce(0f, Float::sum);
        float otherWeight = o.components.stream().map(MedicineComponent::getWeight).reduce(0f, Float::sum);
        int weightComparison = Float.compare(thisWeight, otherWeight);
        if (weightComparison != 0) {
            return weightComparison;
        }

//         2. По силе
        int thisPower = this.components.stream().mapToInt(MedicineComponent::getPower).sum();
        int otherPower = o.components.stream().mapToInt(MedicineComponent::getPower).sum();
        int powerComparison = Integer.compare(thisPower, otherPower);
        if (powerComparison != 0) {
            return powerComparison;
        }

//         3. По кол-ву
        return Integer.compare(this.components.size(), o.components.size());
    }

}
