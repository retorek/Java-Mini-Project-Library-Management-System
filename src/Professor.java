public class Professor extends Person{
    private String course;

    public Professor(){
        super();
    }
    public Professor(String name, int id, String course){
        super(name, id);
        this.setCourse(course);
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String toString() {
        return "\n\tProfessor " + this.getName() +
                "\n\tId: " + this.getId() +
                "\n\tCourse: " + course +
                "\n\tBook: " + ((this.getBook() != null) ? this.getBook().getTitle() + ", " + this.getBook().getId() : "None");
    }
}
