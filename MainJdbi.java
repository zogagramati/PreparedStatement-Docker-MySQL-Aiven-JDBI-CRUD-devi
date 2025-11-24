package Odevler;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.util.List;

public class MainJdbi {
    public static void main(String[] args) {

        String host = "deniz-yazici-mysql-denizyazici89-fba5.h.aivencloud.com";
        int port = 13185;
        String database = "defaultdb";
        String username = "avnadmin";
        String password = "AVNS_8g9Md-geFR3xs1qgUTH";

        String url = String.format(
                "jdbc:mysql://%s:%d/%s?sslMode=REQUIRED&trustServerCertificate=true",
                host, port, database
        );

        Jdbi jdbi = Jdbi.create(url, username, password);
        jdbi.installPlugin(new SqlObjectPlugin());

        jdbi.useExtension(PersonDao.class, dao -> {
            // TABLO
            dao.createTable();
            System.out.println("Tablo oluşturuldu: deniz_yazici");

            // CREATE
            int id1 = dao.insert(new Person("Ahmet", "Yılmaz", "Yazılım Geliştirici", 15000));
            int id2 = dao.insert(new Person("Ayşe", "Kaya", "Test Uzmanı", 12000));
            int id3 = dao.insert(new Person("Mehmet", "Demir", "Proje Yöneticisi", 20000));
            System.out.println("3 kayıt eklendi. ID'ler: " + id1 + ", " + id2 + ", " + id3);

            // READ
            System.out.println("\n--- Tüm kayıtlar ---");
            List<Person> list = dao.findAll();
            list.forEach(System.out::println);

            // UPDATE
            Person updated = new Person(id2, "Ayşe", "Kaya",
                    "Kıdemli Test Uzmanı", 14000);
            dao.update(updated);
            System.out.println("\nAyşe güncellendi.");

            // DELETE
            dao.delete(id3);
            System.out.println("Mehmet silindi. (id = " + id3 + ")");

            // Son durum
            System.out.println("\n--- Son durum ---");
            dao.findAll().forEach(System.out::println);
        });

        System.out.println("\nJDBI CRUD işlemleri tamamlandı.");
    }
}
