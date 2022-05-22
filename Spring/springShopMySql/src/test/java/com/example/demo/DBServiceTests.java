package com.example.demo;

import com.example.demo.db.service.api.CustomerService;
import com.example.demo.db.service.api.MerchantService;
import com.example.demo.db.service.api.ProductService;
import com.example.demo.db.service.api.request.UpdateProductRequest;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Merchant;
import com.example.demo.domain.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class DBServiceTests {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private MerchantService merchantService;

    private static Merchant merchant;

    @Autowired
    private ProductService productService;

    @Before
    public void createMerchant() {
        if (merchant == null) {
            merchant = new Merchant("name", "email", "address");
            Integer id = merchantService.addMerchant(merchant);
            assert id != null;
            merchant.setId(id);
        }
    }

    @Test
    public void customer(){
        Customer customer = new Customer("Jana", "Nováková", "novakova@novakova.cz", "U lesa ě, Praha 10", 34, "567788898");
        Integer id = customerService.addCustomer(customer);
        assert id!=null;
        customer.setId(id);

       Customer fromDb= customerService.getCustomer(id);
       Assert.assertEquals(customer, fromDb);

       List<Customer> customers = customerService.getCustomers();
       Assert.assertEquals(1,customers.size());
       Assert.assertEquals(customer, customers.get(0));
    }
    @Test
    public void merchant(){
//Pro otestování produktu potřebujeme tuto metodu posunout nahoru, aby se dělala jako první
/*
        Merchant merchant = new Merchant("Define", "define@define.cz","U stolu 5, Praha 6" );
        Integer id = merchantService.addMerchant(merchant);
        assert  id!=null;
        merchant.setId(id);

 */

        Merchant fromDB = merchantService.getM(merchant.getId());
        Assert.assertEquals(merchant, fromDB);

        List<Merchant> merchants = merchantService.getMerchants();
        Assert.assertEquals(1, merchants.size());
        Assert.assertEquals(merchant, merchants.get(0));
    }

    @Test
    public void product() {
        Product product = new Product(merchant.getId(), "name", "description", 5, 1);
        Integer id = productService.add(product);
        assert id != null;
        product.setId(id);

        Product fromDB = productService.get(id);
        Assert.assertEquals(product, fromDB);

        List<Product> products = productService.getProducts();
        Assert.assertEquals(1, products.size());
        Assert.assertEquals(product, products.get(0));

        product.setAvailable(10);
        UpdateProductRequest productRequest = new UpdateProductRequest(product.getName(), product.getDescription(), product.getPrice(), product.getAvailable());

        productService.update(id, productRequest);
        Product fromDBAfterUpdate = productService.get(id);
        Assert.assertEquals(product, fromDBAfterUpdate);
        Assert.assertNotEquals(fromDB, fromDBAfterUpdate);

        productService.delete(id);
        Assert.assertEquals(0, productService.getProducts().size());
    }
}
