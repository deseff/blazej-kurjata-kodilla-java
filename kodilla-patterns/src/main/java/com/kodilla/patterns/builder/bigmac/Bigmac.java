package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {
    private final String bun;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigmacBuilder {
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {
            if ("plain".equals(bun) || "sesame".equals(bun)) {
                this.bun = bun;
                return this;
            } else {
                throw new IllegalStateException("The bun you have chosen is not available");
            }
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if ("standard".equals(sauce) || "1000 island".equals(sauce) || "barbecue".equals(sauce)) {
                this.sauce = sauce;
                return this;
            } else {
                throw new IllegalStateException("The sauce you have chosen is not available");
            }
        }

        public BigmacBuilder ingredient(String ingredient) {
            if ("salad".equals(ingredient) || "onion".equals(ingredient) || "bacon".equals(ingredient) ||
                    "cucumber".equals(ingredient) || "chili peppers".equals(ingredient) || "mushrooms".equals(ingredient) ||
                    "shrimps".equals(ingredient) || "cheese".equals(ingredient)) {
                ingredients.add(ingredient);
                return this;
            } else {
                throw new IllegalStateException("The ingredient you have chosen is not available");
            }
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    private Bigmac(final String bun, final int burgers, final String sauce, final List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
