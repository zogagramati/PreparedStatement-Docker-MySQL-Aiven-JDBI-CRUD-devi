package Odevler;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface PersonDao {

    @SqlUpdate("""
        CREATE TABLE IF NOT EXISTS deniz_yazici (
            id INT AUTO_INCREMENT PRIMARY KEY,
            ad VARCHAR(50) NOT NULL,
            soyad VARCHAR(50) NOT NULL,
            pozisyon VARCHAR(50),
            maas DECIMAL(10,2),
            kayit_tarihi TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        )
        """)
    void createTable();

    @SqlUpdate("""
        INSERT INTO deniz_yazici (ad, soyad, pozisyon, maas)
        VALUES (:ad, :soyad, :pozisyon, :maas)
        """)
    @GetGeneratedKeys
    int insert(@BindBean Person person);

    @SqlQuery("SELECT * FROM deniz_yazici")
    @RegisterBeanMapper(Person.class)
    List<Person> findAll();

    @SqlUpdate("""
        UPDATE deniz_yazici
        SET pozisyon = :pozisyon, maas = :maas
        WHERE id = :id
        """)
    void update(@BindBean Person person);

    @SqlUpdate("DELETE FROM deniz_yazici WHERE id = :id")
    void delete(@Bind("id") int id);
}
