public class Person {

    private String name;
    private int id;
    private Book owned;

    public Person(String name, int id){
        this.setName(name);
        this.setId(id);
        this.setOwned(null);
    }

    public Person() {
        this.setOwned(null);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Book getBook(){
        return owned;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwned(Book owned) {
        this.owned = owned;
    }

}
