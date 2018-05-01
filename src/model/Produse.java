
package model;

/**
 *
 * @author CeachiBogdan
 */
public class Produse {
    
    private int id;
    private String nume;
    private double pret;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Produse{" + "id=" + id + ", nume=" + nume + ", pret=" + pret + '}';
    }
    
    
}
