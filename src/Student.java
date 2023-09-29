public class Student extends Person{
    private int grade;

    public Student(){
        super();
    }
    public Student(String name, int id, int grade){
        super(name, id);
        this.setGrade(grade);
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "\n\tStudent: " + this.getName() +
                "\n\tId: " + this.getId() +
                "\n\tGrade: " + this.getGrade() +
                "\n\tBook: " + ((this.getBook() != null) ? this.getBook().getTitle() + ", " + this.getBook().getId() : "None");
    }
}
