package SWEhwq3;

public class Course {
    private String courseName;
    private Instructor instructor;
    private Textbook textbook;

    public Course(String courseName,Instructor instructor,Textbook textbook){
        this.courseName = courseName;
        this.instructor = instructor;
        this.textbook = textbook;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setTextbook(Textbook textbook) {
        this.textbook = textbook;
    }

    public Textbook getTextbook() {
        return textbook;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void print(){
        System.out.println("The course name is:" +this.courseName);
        System.out.println("The instructor is:" +this.instructor.getFirstName() +" "+this.instructor.getLastName());
        System.out.println("The textbook is:" +this.textbook.getTitle());
        System.out.println("The author is:" +this.textbook.getAuthor());
    }
}
