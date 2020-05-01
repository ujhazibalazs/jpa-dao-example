package book;

import book.model.Book;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class BookGenerator {
    private static Faker faker = new Faker(new Locale("en"));

    public static Book createBook() {
        Date date = faker.date().birthday();
        LocalDate pubDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Book book = Book.builder()
                .isbn13(faker.code().isbn13())
                .author(faker.book().author())
                .title(faker.book().title())
                .format(faker.options().option(Book.Format.class))
                .publisher(faker.book().publisher())
                .publicationDate(pubDate)
                .pages(faker.number().numberBetween(1, 500))
                .available(faker.bool().bool())
                .build();
        return book;
    }
}
