package ryan.personobject;

/*
Meghan Ryan
12/2/2021
This program a person object is to be created.
 */
public class person {
    
    private String name;
    private int age;
    private double height;
    private String job;
    private double weight;
    
    public person(){
        name="";
        age=0;
        height=0;
        job="";
        weight=0;
    }
    
    public person(String n,int a,double h,String j,double w){
        setName(n);
        setAge(a);
        setHeight(h);
        setJob(j);
        setWeight(w);
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public double getHeight(){
        return height;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public String getJob(){
        return job;
    }
    
    public void setName(String n){
        name=n;
    } 
    public void setAge(int a){
        age=a;
    } 
    public void setHeight(double h){
        height=h;
    } 
    public void setJob(String j){
        job=j;
    } 
    public void setWeight(double w){
        weight=w;
    } 
    
    
    
}
