package day_08_单例设计模式;


class Superman{
    private String name;

    private static Superman man = new Superman("Clark");
    private Superman(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public static Superman getInstance() {
        return man;
    }

}


public class Main {
    public static void main (String[] args) {
        Superman s1 = Superman.getInstance();
        System.out.println(s1.getName());
    }
}
