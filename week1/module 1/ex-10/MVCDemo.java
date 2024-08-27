public class MVCDemo {

    // Model Class
    public static class Learner {
        private String fullName;
        private String studentID;
        private String gradeLevel;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getStudentID() {
            return studentID;
        }

        public void setStudentID(String studentID) {
            this.studentID = studentID;
        }

        public String getGradeLevel() {
            return gradeLevel;
        }

        public void setGradeLevel(String gradeLevel) {
            this.gradeLevel = gradeLevel;
        }
    }

    // View Class
    public static class LearnerView {
        public void showLearnerDetails(String name, String id, String grade) {
            System.out.println("Learner Details:");
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Grade: " + grade);
        }
    }

    // Controller Class
    public static class LearnerController {
        private Learner model;
        private LearnerView view;

        public LearnerController(Learner model, LearnerView view) {
            this.model = model;
            this.view = view;
        }

        public void setLearnerName(String name) {
            model.setFullName(name);
        }

        public String getLearnerName() {
            return model.getFullName();
        }

        public void setLearnerID(String id) {
            model.setStudentID(id);
        }

        public String getLearnerID() {
            return model.getStudentID();
        }

        public void setLearnerGrade(String grade) {
            model.setGradeLevel(grade);
        }

        public String getLearnerGrade() {
            return model.getGradeLevel();
        }

        public void refreshView() {
            view.showLearnerDetails(model.getFullName(), model.getStudentID(), model.getGradeLevel());
        }
    }

    // Test the MVC Implementation
    public static void main(String[] args) {
        Learner model = new Learner();
        model.setFullName("John Doe");
        model.setStudentID("12345");
        model.setGradeLevel("A");

        LearnerView view = new LearnerView();

        LearnerController controller = new LearnerController(model, view);
        controller.refreshView();

        controller.setLearnerName("Jane Doe");
        controller.refreshView();
    }
}
