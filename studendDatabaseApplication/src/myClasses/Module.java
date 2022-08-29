package myClasses;

public class Module {
    private String courseName;
    private double cost;

    public Module(String courseName, double cost) {
        this.courseName = courseName;
        this.cost = cost;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public int hashCode(){
        return  (this.courseName.hashCode() * 31);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj == null){
            return false;
        }

        if(this.getClass() != obj.getClass()){
            return false;
        }

        if(this.courseName == null){
            return false;
        }

        Module module = (Module) obj;
        return this.courseName.equals(module.getCourseName());
    }


    /* if class not intended for sublassing
    // approach of equals method override!!!!!
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj == null){
            return false;
        }

        if(this.getClass() != obj.getClass()){
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    //if expected inherited (extending) object is a different type of object use this
    // approach  of equals method override!!!!! to meet symmetric comparison with subclass, implement equals at parent
    //object and mark it final, so inherited subclass can't override it, as it will show opposite results
    //e.g. our labrador is a dog, but dog is not our labrador
    //    @Override
    //    public final boolean equals(Object obj){
    //        if(this != obj){
    //            return false;
    //        }
    //
    //        if(obj instanceof HeavenlyBody){
    //            String objName = ((HeavenlyBody) obj).getName();
    //            return this.name.equals(objName);
    //        }
    //
    //        return false;
    //    }
*/
}