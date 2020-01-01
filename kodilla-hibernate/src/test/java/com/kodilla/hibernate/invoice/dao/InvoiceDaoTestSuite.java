package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product pen = new Product("Pen");
        Product pencil = new Product("Pencil");
        Product marker = new Product("Marker");
        Product copybook = new Product("Copybook");

        Item item1 = new Item(pen, new BigDecimal(10), 1);
        Item item2 = new Item(pencil, new BigDecimal(5), 3);
        Item item3 = new Item(marker, new BigDecimal(15), 2);
        Item item4 = new Item(copybook, new BigDecimal(20), 1);

        Invoice invoice = new Invoice("01/12/2009");

        item1.setProduct(pen);
        item2.setProduct(pencil);
        item3.setProduct(marker);
        item4.setProduct(copybook);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        Assert.assertNotEquals(0, invoiceId);
        Assert.assertEquals(4, invoice.getItems().size());

        //CleanUp
        invoiceDao.deleteById(invoiceId);
    }
}
