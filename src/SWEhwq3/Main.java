package SWEhwq3;

/*Driver class for the question*/

public class Main {
    public static void main(String args[]){
        Instructor inst = new Instructor("Nima","Davarpanah","3-2636");
        Textbook txtbk = new Textbook("Clean Code","Robert Martin","Pearson");
        Course course = new Course("Software Engineering",inst,txtbk);

        course.print();

        Instructor instructor1 = new Instructor("Satyabrata", "Paul", "01-2356");
        Instructor instructor2 = new Instructor("Prosenjit", "Mukherjee", "01-4590");

        Textbook textBook1 = new Textbook("Data Structures in C", "Seymour Lipschulz", "Boseman");
        Textbook textBook2 = new Textbook("C Programming", "Kanitkar", "Tata Mcgraw Hill");

        CourseModified course2 = new CourseModified("Data Structures and Algorithms");

        try{
            course2.addInstructor(instructor1);
            course2.addInstructor(instructor2);

            course2.addTextbook(textBook1);
            course2.addTextbook(textBook2);

            course2.print();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
