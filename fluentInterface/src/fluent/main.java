package fluent;

import java.io.File;
import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {

        String helloWorld = "hello world";
        String helloEveryone = helloWorld.replace("world", "everyone");
        String helloEveryoneUpperCase = helloEveryone.toUpperCase();
        String helloUpperCase = helloEveryoneUpperCase.split(" ")[0];

        System.out.println(helloUpperCase);

        String fluentHello = "hello world..."
                .replace("world", "everyone")
                .toUpperCase()
                .split(" ")[0];

        System.out.println(fluentHello);



        // this code is likely to throw an IOException!
        new Image(new File("src/fluent/img.png"), Image.IMAGE_FORMAT.PNG)
                .convert(Image.IMAGE_FORMAT.JPEG)
                .rotate(45)
                .filter(bufferedImage -> { /* blur filter*/ })
                .filter(bufferedImage -> { /* another filter*/ })
                .save();



        Schedule schedule = new Schedule()
                .add()
                    .from("11:00")
                    .to("12:30")
                    .description("reading ")
                    .priority("high")
                    .submit()
                .add()
                    .from("13:00")
                    .to("15:00")
                    .submit();

        schedule.print();



        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("dlrow")
                .reverse()
                .insert(0, "hello ")
                .replace(6, 11, "everyone");
        System.out.println(stringBuilder.toString());



        Hero h = new Hero.HeroBuilder()
                .strength(2)
                .agility(5)
                .stamina(10)
                .create();

        User user1 = new User();
        User user2 = user1.name("new");
        User user3 = user2.age(18);
        System.out.println("hash user1: " + user1.hashCode() +
                "\nhash user2: " + user2.hashCode() +
                "\nhash user3: " + user3.hashCode());


        ImmutableUser imUser1 = new ImmutableUser();
        ImmutableUser imUser2 = imUser1.name("new");
        ImmutableUser imUser3 = imUser2.age(18);
        System.out.println("hash imUser1: " + imUser1.hashCode() +
                "\nhash imUser2: " + imUser2.hashCode() +
                "\nhash imUser3: " + imUser3.hashCode());




    }




}
