package SWEhwq3;

import java.util.ArrayList;
import java.util.List;

public class CourseModified {

    private String courseName;
    private List<Instructor> instructors;
    private List<Textbook> textbooks;

    public CourseModified(String courseName){
        instructors = new ArrayList<>();
        textbooks = new ArrayList<>();
        this.courseName = courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public  void addInstructor(Instructor instructor) throws Exception{
        if(instructors.size()==2){
            throw new Exception("Cannot add more than 2 instructors per course!");
        }
        if(instructor==null){
            throw new Exception("Null value is passed.");

        }
        instructors.add(instructor);
    }

    public  void addTextbook(Textbook textbook) throws Exception{
        if(textbooks.size()==2){
            throw new Exception("No more textbooks allowed!");
        }
        if(textbook==null){
            throw new Exception("Null value is passed.");
        }
        textbooks.add(textbook);

    }

    public void updateTextbookByIndex(Textbook textbook,int indexTobeUpdated) throws Exception{
        if(textbooks.isEmpty()){
            throw new Exception("List is empty, add to it.");
        }
        if(indexTobeUpdated>=textbooks.size()){
            throw new Exception("Cannot add more");
        }
        textbooks.get(indexTobeUpdated).setAuthor(textbook.getAuthor());
        textbooks.get(indexTobeUpdated).setTitle(textbook.getTitle());
        textbooks.get(indexTobeUpdated).setPublisher(textbook.getPublisher());
    }

    public void updateInstructorByIndex(Instructor instructor,int indexToBeUpdated) throws Exception{
        if(instructors.isEmpty()){
            throw new Exception("List is empty, add please.");
        }
        if(indexToBeUpdated>=instructors.size()){
            throw new Exception("Cannot add more");
        }
        instructors.get(indexToBeUpdated).setFirstName(instructor.getFirstName());
        instructors.get(indexToBeUpdated).setLastName(instructor.getLastName());
        instructors.get(indexToBeUpdated).setOfficeNo(instructor.getOfficeNo());

    }

    public void setInstructors(List<Instructor> instructors){
        this.instructors = instructors;
    }

    public void setTextbooks(List<Textbook> textbooks) {
        this.textbooks = textbooks;
    }

    public void removeTextBooksByIndex(int indexToBeDeleted) throws Exception {
        if (textbooks.isEmpty()){
            throw new Exception("List is empty, add it please!");
        }
        if (indexToBeDeleted >= textbooks.size()){
            throw new Exception("Invalid index!");
        }
        textbooks.remove(indexToBeDeleted);
    }

    public void removeInstructorByIndex(int indexToBeDeleted) throws Exception {
        if (instructors.isEmpty()){
            throw new Exception("List is empty, add it please!");
        }
        if (indexToBeDeleted >= instructors.size()){
            throw new Exception("Invalid index!");
        }
        instructors.remove(indexToBeDeleted);
    }
    public void print(){
        System.out.println("Course Name : " + this.courseName);

        instructors.forEach(instructor -> System.out.println("Instructor : " + instructor.getFirstName() + ", " + instructor.getLastName()));
        textbooks.forEach(textBook -> {
            System.out.println("TextBook Title : " + textBook.getTitle());
            System.out.println("TextBook Author : " + textBook.getAuthor());
        });
    }


}
