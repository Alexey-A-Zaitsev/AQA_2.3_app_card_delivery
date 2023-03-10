package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        var cities = new String[]{
                "Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Белгород", "Биробиджан",
                "Благовещенск", "Брянск", "ВеликийНовгород", "Владивосток", "Владикавказ", "Владимир",
                "Волгоград", "Вологда", "Воронеж", "Грозный", "Донецк", "Екатеринбург", "Иваново",
                "Ижевск", "Иркутск", "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Кемерово",
                "Киров", "Кострома", "Красногорск", "Краснодар", "Красноярск", "Курган", "Курск",
                "Кызыл", "Липецк", "Магадан", "Магас", "Майкоп", "Махачкала",
                "Мелитополь", "Москва", "Мурманск", "Нальчик", "Нарьян-Мар", "НижнийНовгород",
                "Новосибирск", "Омск", "Орёл", "Оренбург", "Пенза", "Пермь", "Петрозаводск",
                "Петропавловск-Камчатский", "Псков", "Ростов-на-Дону", "Рязань", "Салехард", "Самара",
                "Санкт-Петербург", "Саранск", "Саратов", "Севастополь", "Симферополь", "Смоленск",
                "Ставрополь", "Сыктывкар", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень",
                "Улан-Удэ", "Ульяновск", "Уфа", "Хабаровск", "Ханты-Мансийск", "Херсон", "Чебоксары",
                "Челябинск", "Черкесск", "Чита", "Элиста", "Южно-Сахалинск", "Якутск", "Ярославль",
                "Гатчина", "Санкт-Петербург", "Горно-Алтайск",
        };
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать Faker
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
     }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}