package lab8.Mediator;

import java.util.ArrayList;

public class ConcreteChatMediator implements ChatMediator{
    private ArrayList<User> users;

    public ConcreteChatMediator() {
        this.users = new ArrayList<>();
    }
    public void addUser(User user){
        users.add(user);
    }

    @Override
    public void sendMessage(User sender, String message) {
        for(User user: users){
            if (!user.getName().equals(sender.getName())){
                user.receiveMessage(sender.getName(), message);
            }
        }
    }
}
