package exercise;

import net.datafaker.Faker;
import exercise.model.Post;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

class Data {
    private static final int ITEMS_COUNT = 30;

    public static List<Post> getPosts() {
        Faker faker = new Faker();

        List<Integer> ids = IntStream
            .range(1, ITEMS_COUNT + 1)
            .boxed()
            .toList();

        List<Post> posts = new ArrayList<>();

        for (int i = 0; i < ITEMS_COUNT; i++) {
            var id = "post" + ids.get(i);
            var title = faker.gameOfThrones().house();
            var body = faker.gameOfThrones().quote();
            var post = new Post(id, title, body);
            posts.add(post);
        }

        return posts;
    }
}