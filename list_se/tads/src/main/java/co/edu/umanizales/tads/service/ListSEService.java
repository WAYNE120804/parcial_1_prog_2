package co.edu.umanizales.tads.service;

import co.edu.umanizales.tads.model.Kid;
import co.edu.umanizales.tads.model.ListSE;
import co.edu.umanizales.tads.model.Node;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ListSEService {
    private ListSE kids;



    public Node getKids() {
        return kids.getHead();
    }

    public void createKid(Kid kid) {
        this.kids.add(kid);
    }

    public void deleteKidAge(Kid kid){this.kids.deleteKidbyAge(null, kid.getAge());}

}

