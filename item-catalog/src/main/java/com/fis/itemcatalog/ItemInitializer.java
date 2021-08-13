package com.fis.itemcatalog;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class ItemInitializer implements CommandLineRunner {

    private final ItemRepository ItemRepository;

    ItemInitializer(ItemRepository itemRepository) {
        this.ItemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Lining", "PUMA", "Bad Boy", "Air Jordan", "Nike", "Adidas", "Reebok")
                .forEach(item -> ItemRepository.save(new Item(item)));

        ItemRepository.findAll().forEach(System.out::println);
    }
}