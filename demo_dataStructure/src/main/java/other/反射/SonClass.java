package other.反射;

public class SonClass extends FatherClass {
    private String sonName;
    protected Integer sonAge;
    public String sonBirthday;

    public void printSonMsg(){
        System.err.println("我是sonMethods...");
    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public Integer getSonAge() {
        return sonAge;
    }

    public void setSonAge(Integer sonAge) {
        this.sonAge = sonAge;
    }

    public String getSonBirthday() {
        return sonBirthday;
    }

    public void setSonBirthday(String sonBirthday) {
        this.sonBirthday = sonBirthday;
    }
}
