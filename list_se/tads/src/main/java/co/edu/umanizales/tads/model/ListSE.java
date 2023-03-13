package co.edu.umanizales.tads.model;

import lombok.Data;

@Data
public class ListSE {
    private Node head;

    public void add(Kid kid) {
        if (head != null) {
            Node temp = head;
            while (temp.getNext() != null) {

                temp = temp.getNext();
            }
            // para en el ultimo
            Node newNode = new Node(kid);
            temp.setNext(newNode);
        } else {
            head = new Node(kid);
        }
    }

    public void addToStart(Kid kid) {
        if (head != null) {
            Node newNode = new Node(kid);
            newNode.setNext(head);
            head = newNode;
        } else {
            head = new Node(kid);
        }


    }

    //metodo para añadir nuevo nodo y nuevo niño en un posicion
    public void addInpos(Kid kid, int pos) {
        Node temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.getNext();
        }
        Node newNode = new Node(kid);
        temp.setNext(newNode);
    }

    //metodo para eliminar niños recibiendo el id
    public void deleteKid(String id) {
        Node temp = head;
        while (!temp.getNext().getData().getId().equals(id)) {
            temp = temp.getNext();
        }
        temp.getNext().setData(null);
    }

    //adelantar en posicion
    public void advanceInpos(Kid kid, int pos) {
        Node temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.getNext();
        }
        Node newNode = new Node(kid);
        temp.setNext(newNode);
    }


    // ejercicios 4
    //elimina un niño que tenga una edad determinda
    public void deleteKidbyAge(Node head, byte age) {
        Node act = head;
        Node ant = null;

        //buscamos el nodo del niño con la edad pedida
        while (act != null && act.getData().getAge() != age) {
            head = act.getNext();
            act = head;
        }
        //eliminar el nodo y establecer el siguiente como nueva cabeza
        while (act != null) {
            while (act != null && act.getData().getAge() != age) {
                ant = act;
                act = act.getNext();
            }
            if (act == null) {
                return;
            }
            ant.setNext(act.getNext());
            act = ant.getNext();
        }
    }

    //ejercio 7

    //metodo para hacer que el costal de un niño adelante posiciones con una posiciones dadas
    public void MoveKid(String id, int pos) {
        Node act = head;
        Node ant = null;
        Node objetive = null;
        int cont = 0;
        while (act != null) {
            if (act.getData().equals(id)) {
                objetive = act;
                break;
            }
            ant = act;
            act = act.getNext();
        }
        if (objetive == null) {
            System.out.print("el niño con este id no esta en la lista ");
            return;
        }
        //encontrar el niño con la posicion deseada
        act = head;
        while (cont < pos - 1 && act != null) {
            objetive = act;
            act = act.getNext();
            cont++;
        }
        if (cont < pos - 1) {
            System.out.print("la posision buscada esta mas alla de el final de la lista ");
            return;
        }
        //encontrar el niño buscado con la posicion buscada
        objetive.setNext(act);
        if (objetive == head) {
            head = act;
        }
    }

}




