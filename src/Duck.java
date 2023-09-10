 abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }
    abstract void display();

    public String swim()
        {
            return "Todos los patos nadan, menos los decoy  ";
        }
        
}