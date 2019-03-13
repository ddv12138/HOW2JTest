package tk.ddvudo.Reflection;

public class TestClass {
    public String name;
    String age;
    String desc;
    String sex;
    String address;

    public TestClass() {
    }

    public TestClass(String name, String age, String desc, String sex, String address) {
        this.name = name;
        this.age = age;
        this.desc = desc;
        this.sex = sex;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", desc='" + desc + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
