package org.task.mint;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.task.mint.entity.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

/**
 * @author Christian
 */
@RestController
public class DBSetUpController {

    private static final Logger LOGGER = Logger.getLogger(DBSetUpController.class.getName());

    @RequestMapping("/setup-db")
    public String welcome() {

        Admin admin = null, admin2 = null;
        Brand brand = null, brand2 = null, brand3 = null;
        Category category = null, category2 = null, category3 = null;
        Product product = null, product2 = null, product3 = null, product4 = null;

        SessionFactory factory = null;

        Date creationDate = new GregorianCalendar().getTime();

        try {
            factory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Admin.class)
                    .addAnnotatedClass(Brand.class)
                    .addAnnotatedClass(Category.class)
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(OrderedProduct.class)
                    .buildSessionFactory();

            Session session = factory.getCurrentSession();

            LOGGER.info("Creating DB tables and inserting records into them");

            session.beginTransaction();

            // create admins
            admin = new Admin("Admin", "Admin", "admin@email.com", "admin", creationDate, true);
            session.save(admin);
            admin2 = new Admin("Christian", "Oliver", "obiekrix@email.com", "admin", creationDate, true);
            session.save(admin2);

            // create product brands
            brand = new Brand(1, "LG", creationDate, true, admin);
            session.save(brand);
            brand2 = new Brand(2, "SONY", creationDate, true, admin2);
            session.save(brand2);
            brand3 = new Brand(3, "Haier Thermocool", creationDate, true, admin2);
            session.save(brand3);

            // create product categories
            category = new Category(1, "TV", "Television for the home and comfort", creationDate, true, admin);
            session.save(category);
            category2 = new Category(2, "Air-Conditioner", "Good and quality cooling device", creationDate, true, admin2);
            session.save(category2);
            category3 = new Category(3, "Refrigerator", "Gives you the best preservation and freshness to your vegies", creationDate, true, admin);
            session.save(category3);

            // create products
            product = new Product(1, "SONY Bravia", "60 inches, 4k resolution", BigDecimal.valueOf(1800000), BigDecimal.valueOf(2200000), 0, null, 50, creationDate, true, admin, category, brand2);
            session.save(product);
            product2 = new Product(2, "LG InverterV", "1HP, can run on low power rating generator", BigDecimal.valueOf(180000), BigDecimal.valueOf(200000), 0, null, 50, creationDate, true, admin2, category2, brand2);
            session.save(product2);
            product3 = new Product(3, "HT GenCool", "1HP, can run on low power rating generator", BigDecimal.valueOf(170000), BigDecimal.valueOf(195000), 0, null, 50, creationDate, true, admin, category2, brand3);
            session.save(product3);
            product4 = new Product(4, "LG InstaView", "Door in Door, Steel color", BigDecimal.valueOf(1200000), BigDecimal.valueOf(1700000), 0, null, 50, creationDate, true, admin, category3, brand2);
            session.save(product4);

            session.getTransaction().commit();

            LOGGER.info("DB setup is complete");
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
        } finally {
            factory.close();
        }

        if (admin == null || factory == null) {
            return "Project setup was incomplete";
        }

        return "Project setup complete, DB and default administrator account has been created with details below<br/><br/>" + admin;
    }
}
