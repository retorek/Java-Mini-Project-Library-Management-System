public class Book {

    private int id;
    private String title;
    private boolean availability;
    private double rate;
    private Person owner;

    public Book(){

    }

    public Book(String title, int id, double rate){
        this.setTitle(title);
        this.setId(id);
        this.setRate(rate);
        this.setAvailability(false);
        this.setOwner(null);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getRate() {
        return rate;
    }

    public boolean getAvailability(){
        return availability;
    }

    public Person getOwner() {
        return owner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String toString() {
        return "\n\tBook: " + title +
                "\n\tId: " + id +
                "\n\tAvailable: " + ((availability) ? "Yes":"No") +
                "\n\tRate: " + rate +
                "\n\tOwner: " + ((owner == null) ? "None": owner.getName() + ", " + owner.getId())
                ;
    }
}
