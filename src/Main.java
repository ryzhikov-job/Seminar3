import pharmacy.Medicine;
import pharmacy.Medicine2;
import pharmacy.Medicine3;
import pharmacy.MedicineComponent;
import pharmacy.impl.Asitromin;
import pharmacy.impl.H2_O;
import pharmacy.impl.Penicilinium;
import pharmacy.impl.Vetbicid;

import java.lang.constant.ModuleDesc;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        ArrayList<MedicineComponent> medList = new ArrayList<>();
        ArrayList<Medicine3> MedicationsList = new ArrayList<>();
        Asitromin asitr = new Asitromin("Asitro", 50, 25);
        Penicilinium penicilinium = new Penicilinium("Penicil", 30, 50);
        Vetbicid vetbic = new Vetbicid("Vetbic", 40, 30);
        H2_O h2_o = new H2_O("Water", 100, 100);
        Medicine3 medicine1 = new Medicine3();
        medicine1.addComponent(asitr).addComponent(penicilinium).addComponent(vetbic);
        Medicine3 medicine2 = new Medicine3();
        medicine2.addComponent(asitr).addComponent(penicilinium);
        Medicine3 medicine3 = new Medicine3();
        medicine3.addComponent(asitr).addComponent(penicilinium).addComponent(vetbic).addComponent(h2_o);
        Medicine3 medicine4= new Medicine3();
        medicine4.addComponent(asitr);
        MedicationsList.add(medicine1);
        MedicationsList.add(medicine2);
        MedicationsList.add(medicine3);
        MedicationsList.add(medicine4);
        System.out.println("Неотсортированные лекарства:");
        for (Medicine3 medicine : MedicationsList) {
            System.out.println(medicine);
        }

        Collections.sort(MedicationsList, Comparator.comparingDouble(medicine ->
                medicine.components.stream().mapToDouble(MedicineComponent::getWeight).sum()));
        System.out.println("Сортировка по весу компонентов:");
        for (Medicine3 medicine : MedicationsList) {
            System.out.println(medicine);
        }

        Collections.sort(MedicationsList, Comparator.comparingInt(medicine ->
                medicine.components.stream().mapToInt(MedicineComponent::getPower).sum()));
        System.out.println("Сортировка по силе компонентов:");
        for (Medicine3 medicine : MedicationsList) {
            System.out.println(medicine);
        }

        Collections.sort(MedicationsList, Comparator.comparingInt(medicine ->
                medicine.components.size()));
        System.out.println("Сортировка по количеству компонентов:");
        for (Medicine3 medicine : MedicationsList) {
            System.out.println(medicine);
        }

//        Iterator<MedicineComponent> med = medicine1;
//        while (med.hasNext()) {
//            System.out.println(med.next());
//        }
//        for (MedicineComponent component : medicine1) {
//            System.out.println(component);
//        }

//        medList.add(asitr);
//        medList.add(penicilinium);
//        medList.add(vetbic);
//        System.out.println(medList);
//        Collections.sort(medList);
//        System.out.println(medList);
////        Collections.sort(medList, Comparator.reverseOrder()); обратная сортировка
//        Collections.sort(medList, (comp1, comp2) -> (int)(comp1.getWeight() - comp2.getWeight()));
//        System.out.println(medList);
    }
}