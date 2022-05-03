package be.ehb.snackapi.model;

import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class SnackDataAccess {

    private HashSet<Snack> snacks = new HashSet<>();

    public SnackDataAccess(){
        Snack snack1 = new Snack(1,"baklava",3.30);
        Snack snack2 = new Snack(5,"balaklava",12.50);
        snacks.add(snack1);
        snacks.add(snack2);
    }

    public HashSet<Snack> getSnacks() {
        return snacks;
    }

    public void addSnack(Snack viaAPIDoorgegeven){
        snacks.add(viaAPIDoorgegeven);
    }

    public Snack searchById(int idWaarIkOpZoek){
        for (Snack nextElement : snacks){
            if(nextElement.getId() == idWaarIkOpZoek){
                return nextElement;
            }
        }
        return null;
    }
}
