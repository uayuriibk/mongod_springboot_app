package com.yuriib.springboot.mongodapp.util;

import com.yuriib.springboot.mongodapp.model.*;
import com.yuriib.springboot.mongodapp.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

@AllArgsConstructor
@Service
public class DBFiller implements CommandLineRunner {

    private ItemRepository itemRepository;

    private MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) {

        itemRepository.deleteAll();
        mongoTemplate.dropCollection(PaymentOptions.class);

        //  Payment Options generation ans saving
        PaymentOptions creditCardPayment = new PaymentOptions(PaymentType.CreditCard, 0);
        PaymentOptions payPalPayment = new PaymentOptions(PaymentType.PayPal, 1);
        PaymentOptions cashPayment = new PaymentOptions(PaymentType.Cash, 10);

        mongoTemplate.insert(creditCardPayment);
        mongoTemplate.insert(payPalPayment);
        mongoTemplate.insert(cashPayment);

        // Items generation and saving
        Item item1 = new Item(
                "item1",
                ItemPriority.LOW,
                "group1",
                new DeliveryInfo(LocalDate.now().plusDays(1), 33, false),
                Arrays.asList(
                        new ItemReview("Jan", 4),
                        new ItemReview("Alex", 10),
                        new ItemReview("Joana", 8)
                ),
                creditCardPayment);

        Item item2 = new Item(
                "item2",
                ItemPriority.MEDIUM,
                "group1",
                new DeliveryInfo(LocalDate.now().plusDays(3), 53, true),
                Arrays.asList(
                        new ItemReview("Alex", 5),
                        new ItemReview("Greg", 8)
                ),
                creditCardPayment);

        Item item3 = new Item(
                "item3",
                ItemPriority.HIGH,
                "group2",
                new DeliveryInfo(LocalDate.now().plusDays(7), 73, true),
                Arrays.asList(
                        new ItemReview("Anton", 9),
                        new ItemReview("Kevin", 6)
                ),
                cashPayment);

        Item item4 = new Item(
                "item4",
                ItemPriority.URGENT,
                "group2",
                new DeliveryInfo(LocalDate.now().plusDays(10), 91, false),
                Arrays.asList(
                        new ItemReview("Jane", 10),
                        new ItemReview("Alex", 9),
                        new ItemReview("Jone", 8)
                ),
                payPalPayment);

        Collection<Item> initialProducts = Arrays.asList(item1, item2, item3, item4);

        itemRepository.insert(initialProducts);
    }
}
