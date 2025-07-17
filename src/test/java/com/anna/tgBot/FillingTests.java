package com.anna.tgBot;

import com.anna.tgBot.model.Category;
import com.anna.tgBot.model.Client;
import com.anna.tgBot.model.Product;
import com.anna.tgBot.repository.*;
import com.anna.tgBot.yaml.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import java.io.InputStream;


@SpringBootTest
public class FillingTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private ClientOrderRepository clientOrderRepository;

    @Autowired
    private ClientRepository clientRepository;
    

   /* @BeforeEach
    void cleanDatabase() {
        orderProductRepository.deleteAll();
        clientOrderRepository.deleteAll();
        productRepository.deleteAll();
        clientRepository.deleteAll();
        categoryRepository.deleteAll();
    }*/

    @Test
    void fillFromYaml() throws Exception {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        InputStream input = getClass().getClassLoader().getResourceAsStream("data.yml");
        DataWrapper data = mapper.readValue(input, DataWrapper.class);

        for (ClientData clientData : data.getClients()) {
            clientRepository.save(
                    new Client(
                            clientData.getExternalId(),
                            clientData.getAddress(),
                            clientData.getFullName(),
                            clientData.getPhoneNumber()
                    )
            );
        }


        for (CategoryData catData : data.getCategories()) {
            Category parent = categoryRepository.save(new Category(catData.getName(), null));

            for (SubcategoryData sub : catData.getSubcategories()) {
                Category subCat = categoryRepository.save(new Category(sub.getName(), parent));

                for (ProductData prod : sub.getProducts()) {
                    productRepository.save(new Product(prod.getName(), prod.getDescription(), prod.getPrice(), subCat));
                }
            }
        }
    }
}

