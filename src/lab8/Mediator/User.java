package lab8.Mediator;

public class User {
    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }
    public void sendMessage(String message){
        System.out.println(name + " отправил сообщение " + message);
        mediator.sendMessage(this, message);
    }
    public void receiveMessage(String senderName, String message){
        System.out.println(name + " получил сообщение от "+ senderName + ": " + message);
    }
}
