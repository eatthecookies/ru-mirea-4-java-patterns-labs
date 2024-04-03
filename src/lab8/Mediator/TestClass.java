package lab8.Mediator;

public class TestClass {
    public static void main(String[] args) {
        ConcreteChatMediator mediator = new ConcreteChatMediator();

        User user1 = new User("Пользователь 1", mediator);
        User user2 = new User("Пользователь 2", mediator);
        User user3 = new User("Пользователь 3", mediator);

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        user1.sendMessage("Привет, здесь есть кто-нибудь?");
        user2.sendMessage("Привет, Пользователь 1! Да, я здесь.");
        user3.sendMessage("Привет всем! Как дела?");
    }
}
